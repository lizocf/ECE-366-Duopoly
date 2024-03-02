package jdbc.account_util;

import jdbc.jdbc_util.DataAccessObject;
import jdbc.player_util.PlayerUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO extends DataAccessObject<AccountUtil>
{
    public AccountDAO(Connection connection){
        super(connection);
    }

    private static final String GET_ONE = "SELECT user_name, num_wins, num_losses, duo_points " +
            "FROM accounts WHERE user_id=?";

    private static final String INSERT = "INSERT INTO accounts (user_name)" + " VALUES (?)";

    private static final String UPDATE = "UPDATE accounts" + "SET ? = ? " + "WHERE user_id = ?";

    private static final String DELETE = "DELETE FROM accounts" + " WHERE user_id = ?";

    @Override
    public AccountUtil findById(int id) {
        AccountUtil account = new AccountUtil();
        try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE);)
        {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                account.setUserName(rs.getString("user_name"));
                account.setNumWins(rs.getInt("num_wins"));
                account.setNumLosses(rs.getInt("num_losses"));
                // account.setEloRating(rs.getString("elo_rating"));
                account.setDuoPoints(rs.getInt("duo_points"));
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return account;
    }

    @Override
    public AccountUtil createInstance(AccountUtil dto) {
        try(PreparedStatement statement = this.connection.prepareStatement(INSERT);) {
            statement.setString(1, dto.getUserName());
            // statement.setString(2, dto.getPassword());
            // statement.setInt(3, dto.getWins());
            statement.execute();
            return this.findById(3);    // need user_id sequence
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(AccountUtil dto)
    {
        if (true)
        {

        }

    }

    @Override
    public void  delete(AccountUtil dto) {

    }
}

