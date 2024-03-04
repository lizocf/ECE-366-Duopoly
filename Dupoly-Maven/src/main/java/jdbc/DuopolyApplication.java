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

import jdbc.game_util.GameDAO;
import jdbc.game_util.GameUtil;
import jdbc.player_util.*;
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

	Board gb = new Board();



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


	@PostMapping("/updateWins")
	public AccountUtil updateWins(@RequestBody String json) throws JsonProcessingException
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
			account1 = accountDAO.findById(account1);
			accountDAO.update(account1);
			System.out.println(account1);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return account1;
	}


	@PostMapping("/updateLoss")
	public AccountUtil updateLoss(@RequestBody String json) throws JsonProcessingException
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
			account1 = accountDAO.findById(account1);
			accountDAO.update_loss(account1);
			System.out.println(account1);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return account1;
	}

	@PostMapping("/updateDP")
	public AccountUtil updateDP(@RequestBody String json) throws JsonProcessingException
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
			account1 = accountDAO.findById(account1);
			accountDAO.update_dp(account1, Integer.valueOf(inputMap.get("duo_points")));
			System.out.println(account1);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return account1;
	}

	@PostMapping("/updateElo")
	public AccountUtil updateElo(@RequestBody String json) throws JsonProcessingException
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
			account1 = accountDAO.findById(account1);
			accountDAO.update_elo(account1, inputMap.get("elo"));
			System.out.println(account1);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return account1;
	}

	@PostMapping("/deleteAccount")
	public AccountUtil deleteAcc(@RequestBody String json) throws JsonProcessingException
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
			account1 = accountDAO.findById(account1);
			accountDAO.delete(account1);
			System.out.println(account1);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return account1;
	}

	@PostMapping("/createNewGame")
	public GameUtil createNewGame(@RequestBody String json) throws JsonProcessingException
	{
		System.out.println(json);
		ObjectMapper objectMapper = new ObjectMapper();
		Map <String, String> inputMap = objectMapper.readValue(json, Map.class);
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
				"duopoly", "postgres", "password");
		GameUtil newGame = new GameUtil();
		try {
			Connection connection = dcm.getConnection();
			GameDAO gameDAO = new GameDAO(connection);
			newGame.setGameCode(inputMap.get("game_code"));

			newGame = gameDAO.createInstance(newGame);
			System.out.println(newGame);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return newGame;
	}

// PlayerDAO stuff //
	@GetMapping("/getPlayerInGame/{gameId}/{userId}")
	public PlayerUtil getPlayerInGame(@PathVariable("gameId") int gameId,
								  @PathVariable("userId") int userId) {
		System.out.println(gameId);
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
				"duopoly", "postgres", "password");
		PlayerUtil player1 = new PlayerUtil();
		player1.setGameId(gameId);
		player1.setUserId(userId);
		try {
			Connection connection = dcm.getConnection();
			PlayerDAO playerDAO = new PlayerDAO(connection);

			player1 = playerDAO.findById(player1);
			System.out.println(player1);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return player1;
	}

	@PostMapping("/createPlayerInGame")
	public PlayerUtil createPlayerInGame(@RequestBody String json) throws JsonProcessingException
	{
		System.out.println(json);
		ObjectMapper objectMapper = new ObjectMapper();
		Map <String, String> inputMap = objectMapper.readValue(json, Map.class);
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
				"duopoly", "postgres", "password");
		PlayerUtil player1 = new PlayerUtil();

		try {
			Connection connection = dcm.getConnection();
			PlayerDAO playerDAO = new PlayerDAO(connection);
			//
			player1.setUserId(Integer.valueOf(inputMap.get("user_id")));
			player1.setGameId(Integer.valueOf(inputMap.get("game_id")));
			// The next 2 lines cause build error
			//player1.setUserId(inputMap.get("user_id"));
			//player1.setGameId(inputMap.get("game_id"));

			player1 = playerDAO.createInstance(player1);
			System.out.println(player1);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return player1;
	}

	@PostMapping("/updateDead")
	public PlayerUtil updateDead(@RequestBody String json) throws JsonProcessingException
	{
		System.out.println(json);
		ObjectMapper objectMapper = new ObjectMapper();
		Map <String, String> inputMap = objectMapper.readValue(json, Map.class);
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
				"duopoly", "postgres", "password");
		PlayerUtil player1 = new PlayerUtil();

		try {
			Connection connection = dcm.getConnection();
			PlayerDAO playerDAO = new PlayerDAO(connection);
			player1.setUserId(Integer.valueOf(inputMap.get("user_id")));
			player1.setGameId(Integer.valueOf(inputMap.get("game_id")));
			player1 = playerDAO.findById(player1);
			playerDAO.update(player1);
			System.out.println(player1);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return player1;
	}

	@PostMapping("/updateCash")
	public PlayerUtil updateCash(@RequestBody String json) throws JsonProcessingException
	{
		System.out.println(json);
		ObjectMapper objectMapper = new ObjectMapper();
		Map <String, String> inputMap = objectMapper.readValue(json, Map.class);
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
				"duopoly", "postgres", "password");
		PlayerUtil player1 = new PlayerUtil();

		try {
			Connection connection = dcm.getConnection();
			PlayerDAO playerDAO = new PlayerDAO(connection);
			player1.setUserId(Integer.valueOf(inputMap.get("user_id")));
			player1.setGameId(Integer.valueOf(inputMap.get("game_id")));
			player1 = playerDAO.findById(player1);
			playerDAO.update_cash(player1, Integer.valueOf(inputMap.get("profit")));
			System.out.println(player1);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return player1;
	}

	@PostMapping("/updateJail")
	public PlayerUtil updateJail(@RequestBody String json) throws JsonProcessingException
	{
		System.out.println(json);
		ObjectMapper objectMapper = new ObjectMapper();
		Map <String, String> inputMap = objectMapper.readValue(json, Map.class);
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
				"duopoly", "postgres", "password");
		PlayerUtil player1 = new PlayerUtil();

		try {
			Connection connection = dcm.getConnection();
			PlayerDAO playerDAO = new PlayerDAO(connection);
			player1.setUserId(Integer.valueOf(inputMap.get("user_id")));
			player1.setGameId(Integer.valueOf(inputMap.get("game_id")));
			player1 = playerDAO.findById(player1);
			playerDAO.update_jail(player1, Boolean.valueOf(inputMap.get("jail")));
			System.out.println(player1);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return player1;
	}

	@PostMapping("/updateAfk")
	public PlayerUtil updateAfk(@RequestBody String json) throws JsonProcessingException
	{
		System.out.println(json);
		ObjectMapper objectMapper = new ObjectMapper();
		Map <String, String> inputMap = objectMapper.readValue(json, Map.class);
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
				"duopoly", "postgres", "password");
		PlayerUtil player1 = new PlayerUtil();

		try {
			Connection connection = dcm.getConnection();
			PlayerDAO playerDAO = new PlayerDAO(connection);
			player1.setUserId(Integer.valueOf(inputMap.get("user_id")));
			player1.setGameId(Integer.valueOf(inputMap.get("game_id")));
			player1 = playerDAO.findById(player1);
			playerDAO.update_afk(player1, Boolean.valueOf(inputMap.get("afk")));
			System.out.println(player1);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return player1;
	}

	@PostMapping("/updatePos")
	public PlayerUtil updatePos(@RequestBody String json) throws JsonProcessingException
	{
		System.out.println(json);
		ObjectMapper objectMapper = new ObjectMapper();
		Map <String, String> inputMap = objectMapper.readValue(json, Map.class);
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
				"duopoly", "postgres", "password");
		PlayerUtil player1 = new PlayerUtil();

		try {
			Connection connection = dcm.getConnection();
			PlayerDAO playerDAO = new PlayerDAO(connection);
			player1.setUserId(Integer.valueOf(inputMap.get("user_id")));
			player1.setGameId(Integer.valueOf(inputMap.get("game_id")));
			player1 = playerDAO.findById(player1);
			playerDAO.update_position(player1, Integer.valueOf(inputMap.get("move_to")));
			System.out.println(player1);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return player1;
	}

	@GetMapping("/createOwnedProperty")
	public void createOwnedProperty(@RequestBody String json) throws JsonProcessingException
	{
		System.out.println(json);
		ObjectMapper objectMapper = new ObjectMapper();
		Map <String, String> inputMap = objectMapper.readValue(json, Map.class);
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
				"duopoly", "postgres", "password");

		try
		{
			Connection connection = dcm.getConnection();
			gb.gameBoard[Integer.valueOf(inputMap.get("space"))].isOccupied(true,Integer.valueOf(inputMap.get("user_id")),Integer.valueOf(inputMap.get("game_id")),connection);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	//

	public static void main(String[] args) {
		SpringApplication.run(DuopolyApplication.class, args);
	}
}


// Plan of Attack
// Initalize Players and Can do a couple of turns. We just do it on postman and write a script then it seems like we may be done???
