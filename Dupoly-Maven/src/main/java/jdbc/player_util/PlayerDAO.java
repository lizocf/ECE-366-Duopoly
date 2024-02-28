package jdbc.player_util;

import jdbc.jdbc_util.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class PlayerDAO extends DataAccessObject<PlayerUtil> {

        public PlayerDAO(Connection connection) {
            super(connection);
        }

    private static final String GET_ONE = "SELECT ? " +
            "FROM player_in_game WHERE game_id=? AND user_id=?";

    private static final String INSERT = "INSERT INTO player_in_game(game_id, user_id)"
            + " VALUES (?,?)";

    private static final String UPDATE = "UPDATE player_in_game " + "SET ? = ? " + "WHERE  game_id = ? AND user_id = ?";

    private static final String DELETE = "DELETE FROM player_in_game " + " WHERE (game_id, user_id) = (?,?)";

    // Same conceptual issue as OwnedPropertyDao's findById
    // The primary keys for  table are both id's -- need to take in both userId and gameId
    @Override
    public PlayerUtil findById(int id) {
        PlayerUtil player = new PlayerUtil();
        try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE);)
        {

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
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
        return null;
    }

    @Override
    public PlayerUtil update(PlayerUtil dto) {
        return null;
    }

    @Override
    public PlayerUtil delete(PlayerUtil dto) {
        return null;
    }
}
