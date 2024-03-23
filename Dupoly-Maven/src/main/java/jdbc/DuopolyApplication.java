package jdbc;

import com.fasterxml.jackson.core.JsonProcessingException;
import game.*;
import jdbc.account_util.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

import jdbc.game_util.GameDAO;
import jdbc.game_util.GameUtil;
import jdbc.player_util.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;






@SpringBootApplication
@RestController
@Import({SpringBootTest.class, Account.class, Player.class})
@CrossOrigin
public class DuopolyApplication {

	Board gb = new Board();

	@GetMapping("/simpleTest")
	public String simpleTest()
	{
		System.out.println("TESTING 123");
		return "d";
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
	
	@GetMapping("/getAllPlayersInGame/{gameId}")
	public PlayerUtil[] getAllPlayersInGame(@PathVariable("gameId") int gameId) {
		System.out.println(gameId);
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
				"duopoly", "postgres", "password");
		PlayerUtil player1 = new PlayerUtil();
		PlayerUtil[] players = new PlayerUtil[10];
		player1.setGameId(gameId);
		try {
			Connection connection = dcm.getConnection();
			PlayerDAO playerDAO = new PlayerDAO(connection);

			players = playerDAO.findByGameId(player1);
			System.out.println(players);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return players;
	}

	@GetMapping("/gameMove")
	public void createOwnedProperty(@RequestBody String json) throws JsonProcessingException
	{
		// System.out.println(json);
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

	public static void main(String[] args) { SpringApplication.run(DuopolyApplication.class, args); }

}
