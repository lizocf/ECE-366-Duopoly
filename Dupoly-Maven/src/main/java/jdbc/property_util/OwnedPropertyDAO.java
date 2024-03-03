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

    // might need to be gameid and userid
    private static final String GET_ONE = "SELECT game_id " +
            "FROM owned_property WHERE game_id=?";

    private static final String INSERT = "INSERT INTO owned_property(game_id, user_id, set_name, property_name)"
            + " VALUES (?,?,?,?)";

    private static final String UPDATE = "UPDATE owned_property " + "SET ? = ? " + "WHERE  game_id = ? AND user_id = ? AND property_name = ?";

    private static final String DELETE = "DELETE FROM owned_property " + " WHERE (game_id, property_name) = (?,?)";

    // Not sure how to go about this. Property needs to take in two ids. but the findbyId only has one.
    @Override
    public OwnedPropertyUtil findById(OwnedPropertyUtil dto) {
        OwnedPropertyUtil property = new OwnedPropertyUtil();
        try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE);)
        {
            statement.setInt(1, dto.getUserId());
            ResultSet rs = statement.executeQuery();

            // Not sure what this should be
            while(rs.next()) {
                property.setGameId(rs.getInt("game_id"));
                property.setUserId(rs.getInt("game_code"));
                property.setPropertyName(rs.getString("property_name"));
                property.setSetName(rs.getString("set_name"));
                property.setNumOfHotels(rs.getInt("num_hotels"));
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);

        }
        return property;
    }



    // for when a user buys property
    @Override
    public OwnedPropertyUtil createInstance(OwnedPropertyUtil dto) {
        try(PreparedStatement statement = this.connection.prepareStatement(INSERT);) {
            statement.setInt(1, dto.getGameId());
            statement.setInt(2, dto.getUserId());
            statement.setString(3, dto.getSetName());
            statement.setString(4,dto.getPropertyName());
            statement.execute();
            return this.findById(dto);
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    // what else would we have to update besides num of hotels. Maybe the owner?
    // do we need to return anything
    @Override
    public void update(OwnedPropertyUtil dto) {
        try(PreparedStatement statement = this.connection.prepareStatement(UPDATE);)
        {
            statement.setString(1,"");
            statement.setInt(2,(dto.getDebtPot() + 50)); // can I get the current value then just add 50?
            statement.setInt(3,dto.getGameId());
            statement.execute();

        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }


    public void updateNumHotel(OwnedPropertyUtil dto) {
        try(PreparedStatement statement = this.connection.prepareStatement(UPDATE);)
        {
            statement.setString(1,"num_hotels");
            statement.setInt(2,(dto.getNumOfHotels() + 1)); // can I get the current value then just add 50?
            statement.setInt(3,dto.getGameId());
            statement.setInt(4,dto.getUserId());
            statement.setString(5,dto.getPropertyName());
            statement.execute();
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(OwnedPropertyUtil dto) {
        try(PreparedStatement statement = this.connection.prepareStatement(DELETE);)
        {
            statement.setInt(1,dto.getGameId());
            statement.setString(2,dto.getPropertyName()); // can I get the current value then just add 50?
            statement.execute();
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
