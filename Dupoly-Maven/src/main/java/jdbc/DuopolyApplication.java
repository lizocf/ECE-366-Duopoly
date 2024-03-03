package jdbc;

import com.fasterxml.jackson.core.JsonProcessingException;
import game.*;
import jdbc.*;
import jdbc.account_util.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.databind.ObjectMapper;





@SpringBootApplication
@RestController
public class DuopolyApplication {

	@GetMapping("/helloWorld")
	public String helloWorld() {
		System.out.println("HELLO WORLD");
		return "Hello World";
	}

	@GetMapping("/simpleTest")
	public String simpleTest()
	{
		System.out.println("TESTING 123");
		return "d";

	}

	@GetMapping("/getUserName/{userName}")
	public AccountUtil getUserName(@PathVariable("userName") String userName) {
		System.out.println(userName);
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
                "duopoly", "postgres", "password");
		AccountUtil account1 = new AccountUtil();
		account1.setUserName(userName);
		try {
            Connection connection = dcm.getConnection();
            AccountDAO accountDAO = new AccountDAO(connection);

            account1 = accountDAO.findById(account1);
            System.out.println(account1);
        }
        catch(SQLException e) {
            e.printStackTrace();
		}
		return account1;
	}

	//SORRY LZL
//	@GetMapping("/createAccount/{userName}")
//	public AccountUtil createAccount(@PathVariable("userName") String userName) {
//		System.out.println(userName);
//		DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
//                "duopoly", "postgres", "password");
//		AccountUtil account1 = new AccountUtil();
//		account1.setUserName(userName);
//		try {
//            Connection connection = dcm.getConnection();
//            AccountDAO accountDAO = new AccountDAO(connection);
//
//            account1 = accountDAO.createInstance(account1);
//            System.out.println(account1);
//        }
//        catch(SQLException e) {
//            e.printStackTrace();
//		}
//		return account1;
//	}

	@PostMapping("/createNewAccount")
	public AccountUtil createNewAccount(@RequestBody String json) throws JsonProcessingException
	{
		System.out.println(json);
		ObjectMapper objectMapper = new ObjectMapper();
		Map <String, String> inputMap = objectMapper.readValue(json, Map.class);
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
				"duopoly", "postgres", "password");
		AccountUtil account1 = new AccountUtil();

		try {
			Connection connection = dcm.getConnection();
			AccountDAO accountDAO = new AccountDAO(connection);
			account1.setUserName(inputMap.get("user_name"));

			account1 = accountDAO.createInstance(account1);
			System.out.println(account1);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return account1;
	}


	@GetMapping("/updateWins/{userName}")
	public AccountUtil updateWins(@PathVariable("userName") String userName) {
		System.out.println(userName);
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
                "duopoly", "postgres", "password");
		AccountUtil account1 = new AccountUtil();
		account1.setUserName(userName);
		try {
            Connection connection = dcm.getConnection();
            AccountDAO accountDAO = new AccountDAO(connection);

			account1 = accountDAO.findById(account1);
            accountDAO.update(account1);
            System.out.println(account1);
        }
        catch(SQLException e) {
            e.printStackTrace();
		}
		return account1;
	}

	@GetMapping("/updateLoss/{userName}")
	public AccountUtil updateLoss(@PathVariable("userName") String userName) {
		System.out.println(userName);
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
                "duopoly", "postgres", "password");
		AccountUtil account1 = new AccountUtil();
		account1.setUserName(userName);
		try {
            Connection connection = dcm.getConnection();
            AccountDAO accountDAO = new AccountDAO(connection);

			account1 = accountDAO.findById(account1);
            accountDAO.update_loss(account1);
            System.out.println(account1);
        }
        catch(SQLException e) {
            e.printStackTrace();
		}
		return account1;
	}

	@GetMapping("/updateDP/{userName}/{duo_points}")
	public AccountUtil updateDP(@PathVariable("userName") String userName,
								@PathVariable("duo_points") int duo_points) {
		System.out.println(userName);
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
                "duopoly", "postgres", "password");
		AccountUtil account1 = new AccountUtil();
		account1.setUserName(userName);
		try {
            Connection connection = dcm.getConnection();
            AccountDAO accountDAO = new AccountDAO(connection);

			account1 = accountDAO.findById(account1);
            accountDAO.update_dp(account1, duo_points);
            System.out.println(account1);
        }
        catch(SQLException e) {
            e.printStackTrace();
		}
		return account1;
	}

	@GetMapping("/updateElo/{userName}/{elo_rating}")
	public AccountUtil updateElo(@PathVariable("userName") String userName,
								 @PathVariable("elo_rating") String elo) {
		System.out.println(userName);
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
                "duopoly", "postgres", "password");
		AccountUtil account1 = new AccountUtil();
		account1.setUserName(userName);
		try {
            Connection connection = dcm.getConnection();
            AccountDAO accountDAO = new AccountDAO(connection);

			account1 = accountDAO.findById(account1);
            accountDAO.update_elo(account1, elo);
            System.out.println(account1);
        }
        catch(SQLException e) {
            e.printStackTrace();
		}
		return account1;
	}

	@GetMapping("/deleteAccount/{userName}")
	public AccountUtil updateElo(@PathVariable("userName") String userName) {
		System.out.println(userName);
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
                "duopoly", "postgres", "password");
		AccountUtil account1 = new AccountUtil();
		account1.setUserName(userName);
		try {
            Connection connection = dcm.getConnection();
            AccountDAO accountDAO = new AccountDAO(connection);

			account1 = accountDAO.findById(account1);
            accountDAO.delete(account1);
            System.out.println(account1);
        }
        catch(SQLException e) {
            e.printStackTrace();
		}
		return account1;
	}

	public static void main(String[] args) {
		SpringApplication.run(DuopolyApplication.class, args);
	}
}
