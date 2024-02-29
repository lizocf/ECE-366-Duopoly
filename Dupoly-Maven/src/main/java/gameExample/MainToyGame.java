package gameExample;
import game.*;
import jdbc.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class MainToyGame
{
    public static void main(String[] args) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost",
                "duopoly", "postgres", "password");

        // Intailize Player account information
        Player account1 = new Player();
        Player account2 = new Player();

        account1.setUser_name("Spicless");
        account1.setDuo_points(700);
        account1.setUser_id(1);

        account2.setUser_name("Mudkip");
        account2.setDuo_points(700);
        account2.setUser_id(2);

        Board gb = new Board();

        try {
            Connection connection = dcm.getConnection();
            gb.gameBoard[1].isOccupied(true,account1.getUser_name(),connection);
            // gb.gameBoard[4].isOccupied(true,account2.getUser_name(),connection);

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

}
