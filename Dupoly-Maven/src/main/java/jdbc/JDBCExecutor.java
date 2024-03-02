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
        
        // account1.setUserName("Spicless");
        // account1 = accountDAO.createInstance(account1);
        
        account1 = accountDAO.findById(4);
        accountDAO.update(account1);
        
        System.out.println(account1.getUserId() + " " + account1.getUserName());
        // Board gb = new Board();


        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
