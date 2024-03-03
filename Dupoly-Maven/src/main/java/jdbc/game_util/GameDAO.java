package jdbc.game_util;
import jdbc.jdbc_util.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GameDAO extends DataAccessObject<GameUtil>
{
    public GameDAO(Connection connection) {
        super(connection);
    }

    private static final String GET_ONE = "SELECT game_id, game_code " +
            " FROM game_meta WHERE game_id=?";

    private static final String INSERT = "INSERT INTO game_meta (game_id, game_code) " +
            " VALUES (?, ?)";

    private static final String UPDATE = "UPDATE game_meta " + "SET ? = ? " + " WHERE ? ";

    private static final String DELETE = "DELETE FROM game_meta " + " WHERE ?";

    @Override
    public GameUtil findById(GameUtil dto) {
        GameUtil game = new GameUtil();
        try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE);)
        {

            statement.setInt(1, dto.getGameId());
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                game.setGameId(rs.getInt("game_id"));
                game.setGameCode(rs.getString("game_code"));
//                game.setNumOfPlayers(rs.getInt("num_players"));
//                game.setDebtPot(rs.getInt("debt_pot"));
//                game.setPlayerTurn(rs.getInt("which_player_turn"));
//                game.setJoinable(rs.getBoolean("joinable"));
            }

        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return game;
    }

    @Override
    public GameUtil createInstance(GameUtil dto) {
        try(PreparedStatement statement = this.connection.prepareStatement(INSERT);)
        {
            statement.setInt(1, dto.getGameId());
            statement.setString(2, dto.getGameCode());
            statement.execute();
            return this.findById(dto);

        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //what else in a game updates besides the joinability and debtPot?
    @Override
    public void update(GameUtil dto) {
        try(PreparedStatement statement = this.connection.prepareStatement(UPDATE);)
        {
            //ResultSet rs = statement.executeQuery();
            //what about ?
            statement.setString(1,"debt_pot");
            statement.setInt(2,(dto.getDebtPot() + 50)); // can I get the current value then just add 50?
            statement.setInt(3,dto.getGameId());
            statement.execute();

        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    public void updateDebtPot(GameUtil dto) {
        try(PreparedStatement statement = this.connection.prepareStatement(UPDATE);)
        {
            statement.setString(1,"debt_pot");
            statement.setInt(2,(dto.getDebtPot() + 50)); // can I get the current value then just add 50?
            statement.setInt(3,dto.getGameId());
            statement.execute();

        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void updateJoinable(GameUtil dto) {
        try(PreparedStatement statement = this.connection.prepareStatement(UPDATE);)
        {
            statement.setString(1,"joinable");
            statement.setBoolean(2,false); // can I get the current value then just add 50?
            statement.setInt(3,dto.getGameId());
            statement.execute();

        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    // might need to pass in a player dto
    public void updatePlayerTurn(GameUtil dto) {
        try(PreparedStatement statement = this.connection.prepareStatement(UPDATE);)
        {
            statement.setString(1,"which_player_turn");
            statement.setInt(2,dto.getId()); // this needs to be an actual player id.
            statement.setInt(3,dto.getGameId());
            statement.execute();

        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    // idk what to return here. Maybe it should be void.
    @Override
    public void delete(GameUtil dto) {
        try(PreparedStatement statement = this.connection.prepareStatement(DELETE);){
            statement.setInt(1,dto.getGameId());
            statement.execute();
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

