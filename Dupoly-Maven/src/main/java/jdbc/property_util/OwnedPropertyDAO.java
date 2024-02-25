package jdbc.property_util;

import jdbc.game_util.GameUtil;
import jdbc.jdbc_util.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OwnedPropertyDAO extends DataAccessObject<OwnedPropertyUtil>
{


    public OwnedPropertyDAO(Connection connection) {
        super(connection);
    }

    private static final String GET_ONE = "SELECT game_id, user_id " +
            " FROM owned_property WHERE game_id=?";

    private static final String INSERT = "INSERT INTO owned_property(game_id, user_id, set_name, property_name)"
            + " VALUES (?,?,?,?)";

    private static final String UPDATE = "UPDATE owned_property " + "WHERE game_id = ? AND user_id = ? AND property_name = ?";

    private static final String DELETE = "DELETE FROM owned_property " + "WHERE game_id = ? AND user_id = ? AND property_name = ?";


    @Override
    public OwnedPropertyUtil findById(int id) {
        OwnedPropertyUtil property = new OwnedPropertyUtil();
        try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE);)
        {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            // Not sure what this should be
            while(rs.next()) {
                property.setGameId(rs.getInt("game_id"));
                property.setGameCode(rs.getString("game_code"));
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);

        }
        return property;
    }

    @Override
    public OwnedPropertyUtil createInstance(OwnedPropertyUtil dto) {
        return null;
    }

    @Override
    public OwnedPropertyUtil update(OwnedPropertyUtil dto) {
        return null;
    }

    @Override
    public OwnedPropertyUtil delete(OwnedPropertyUtil dto) {
        return null;
    }
}
