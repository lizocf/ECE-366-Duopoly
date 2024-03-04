package jdbc.player_util;

import jdbc.jdbc_util.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class PlayerDAO extends DataAccessObject<PlayerUtil>
{
        public PlayerDAO(Connection connection) {
            super(connection);
        }

    private static final String GET_ONE = "SELECT game_id, user_id, cash, current_direction, current_position, jail, afk, dead " +
            "FROM player_in_game WHERE game_id=? AND user_id=?";

    private static final String INSERT = "INSERT INTO player_in_game(game_id, user_id)"
            + " VALUES (?,?)";

    private static final String UPDATE = "UPDATE player_in_game " + "SET ? = ? " + "WHERE  game_id = ? AND user_id = ?";


    private static final String DELETE = "DELETE FROM player_in_game " + " WHERE (game_id, user_id) = (?,?)";

    @Override
    public PlayerUtil findById(PlayerUtil dto) {
        PlayerUtil player = new PlayerUtil();
        try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE);)
        {
            statement.setInt(1, dto.getGameId());
            statement.setInt(2, dto.getUserId());
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                player.setGameId(rs.getInt("game_id"));
                player.setUserId(rs.getInt("user_id")); // need userId as another search parameter instead
                player.setCash(rs.getInt("cash"));
                player.setCurrentDirection(rs.getString("current_direction"));
                player.setCurrentPosition(rs.getInt("current_position"));
                player.setJail(rs.getBoolean("jail"));
                player.setAfk(rs.getBoolean("afk"));
                player.setDead(rs.getBoolean("dead"));
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return player;
    }

    @Override
    public PlayerUtil createInstance(PlayerUtil dto) {
        try(PreparedStatement statement = this.connection.prepareStatement(INSERT);)
        {
            statement.setInt(1, dto.getGameId());
            statement.setInt(2, dto.getUserId());
            statement.execute();
            return this.findById(dto);
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(PlayerUtil dto) {


    }

    public void updateCash(PlayerUtil dto,int newAmount,int withdrawOrDeposit)
    {

        try(PreparedStatement statement = this.connection.prepareStatement(UPDATE);)
        {
            statement.setString(1,"cash");
            statement.setInt(2,(dto.getCash() + (newAmount*withdrawOrDeposit))); // can I get the current value then just add 50?
            statement.setInt(3,dto.getGameId());
            statement.setInt(4,dto.getUserId());
            statement.execute();

        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(PlayerUtil dto)
    {
        try(PreparedStatement statement = this.connection.prepareStatement(DELETE);)
        {
            statement.setInt(1,dto.getGameId());
            statement.setInt(2,dto.getUserId()); // can I get the current value then just add 50?
            statement.execute();
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
