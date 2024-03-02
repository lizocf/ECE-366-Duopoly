package jdbc;

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
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
