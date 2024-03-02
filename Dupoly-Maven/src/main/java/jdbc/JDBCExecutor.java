package jdbc;

import game.*;
import jdbc.*;
import jdbc.account_util.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExecutor
{

    public static void main(String... args) {
        // DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost",
                // "duopoly", "postgres", "password");
        // need to change localhost to db to work with docker. also, make "duopoly" database beforehand (see issue 1)
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
                "duopoly", "postgres", "password"); 


        try {
            Connection connection = dcm.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM player_in_game");
            while(resultSet.next()){
                System.out.println(resultSet.getInt(1));
            }
        
        // robbed from MainToyGame.java
        AccountDAO accountDAO = new AccountDAO(connection);

        AccountUtil account = accountDAO.findById(1);
        System.out.println(account.getUserId() + " " + account.getUserName());


        // Intailize Player account information
        AccountUtil account1 = new AccountUtil();
        
        //// createInstance for accounts works
        account1.setUserName("Spicless");
        account1 = accountDAO.createInstance(account1);
        
        // set up which account we want to update
        account1 = accountDAO.findById(4);

        // update dp of account1 to 300 (NOT ADD 300)
        accountDAO.update_dp(account1, 300);
        
        // update wins = wins + 1, we might not want to keep it this way
        accountDAO.update(account1);

        // update loss = loss + 1
        accountDAO.update_loss(account1);

        // update elo from iron to bronze
        accountDAO.update_elo(account1, "Bronze");

        System.out.println(account1.getUserId() + " " + account1.getUserName() + " " + 
                           account1.getNumWins() + " " + account1.getNumLosses() + " " +
                           account1.getEloRating() + " " + account1.getDuoPoints());

        // delete account1
        accountDAO.delete(account1);

        // Board gb = new Board();


        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
