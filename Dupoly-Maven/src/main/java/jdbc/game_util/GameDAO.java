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
    public GameUtil findById(int id) {
        GameUtil game = new GameUtil();
        try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE);)
        {

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                game.setGameId(rs.getInt("game_id"));
                game.setGameCode(rs.getString("game_code"));
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

            int id = this.getLastVal(PLAYER_SEQUENCE); // find where getLastVal comes from
            return this.findById(id);

        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public GameUtil update(GameUtil dto) {
        try(PreparedStatement statement = this.connection.prepareStatement(UPDATE);)
        {


            ResultSet rs = statement.executeQuery();
            //what about ?

        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);

        }
    }

    @Override
    public GameUtil delete(GameUtil dto) {
        try(PreparedStatement statement = this.connection.prepareStatement(DELETE);){
            ResultSet rs = statement.executeQuery();

        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}


@Override
public Player create(Player dto) {
    try(PreparedStatement statement = this.connection.prepareStatement(INSERT);) {
        // counts from 1!!
        statement.setString(1, dto.getUserName());
        statement.setString(2, dto.getPassword());
        statement.execute();
        int id = this.getLastVal(PLAYER_SEQUENCE);
        return this.findById(id);
    } catch(SQLException e) {
        e.printStackTrace();
        throw new RuntimeException(e);
    }
}

@Override
public Player findById(long id) {
    Player player = new Player();
    try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE);)

    {
        statement.setLong(1, id);
        ResultSet rs = statement.executeQuery();
        while(rs.next()) {
            player.setPlayerId(rs.getLong("player_id"));
            player.setUserName(rs.getString("user_name"));
            player.setPassword(rs.getString("password"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
        throw new RuntimeException(e);
    }
    return player;
}