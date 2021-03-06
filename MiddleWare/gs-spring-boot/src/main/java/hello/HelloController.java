package hello;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


	@Autowired
	private GameService gameService;

	@Autowired
	private PlayerService playerService;

	@CrossOrigin
	@RequestMapping("/")
	public String index() {
		return "Greetings from Deez Boot!";
	}

	// Retrieves all pure game data in the database
	@CrossOrigin
	@RequestMapping("/games")
	public List<Game> getAllGames() {
		System.out.println("method getAllGames() called");
		return gameService.getAllGames();
	}

	// Retrieves a game by its id number
	@CrossOrigin
	@RequestMapping("/game")
	public Game getGameById(@RequestParam("Id") int GameId) {
		System.out.println("method getGameById() called on id " + GameId);
		return gameService.getGameById(GameId);
	}

	// Retrieves modified game data from the database for displaying
	@CrossOrigin
	@RequestMapping("/gamesDisplay")
	public List<GameDisplayData> getAllGamesDisplay() {
		System.out.println("method getAlGamesDisplay() called");
		return gameService.getAllGamesDisplay();
	}

	// Retrives Raw Player Data
	@CrossOrigin
	@RequestMapping("/players")
	public List<Player> getAllPlayers() {
		System.out.println("method getAllPlayers() called");
		return playerService.getAllPlayers();
	}

	// Retrieves Player Display Data
	@CrossOrigin
	@RequestMapping("/playersDisplay")
	public Collection<PlayerDisplayData> getAllPlayersDisplay() {
		System.out.println("method getAllPlayersDisplay() Called");
		return playerService.getAllPlayersDisplay();
	}

	// Adds a player to the database
	@CrossOrigin
	@RequestMapping("/addPlayer")
	public int addPlayer(@RequestBody(required = false) Player player) {
		System.out.println("method addPlayer() called");
		System.out.println(player.getName());
		System.out.println(player.getDesc());
		return playerService.addPlayer(player);
	}
	
	//Adds a game to the database
	@CrossOrigin
	@RequestMapping("/addGame")
	public int addGame(@RequestBody(required = true) Game game) {
		System.out.println("Method addGame() called");
		return gameService.addGame(game);
	}
	
	//Removes a player from the database
	@CrossOrigin
	@RequestMapping("/removePlayer")
	public int removePlayer(@RequestParam("Id") int id) {
		System.out.println("Method removePlayer() called on player with id " + id);
		return playerService.removePlayer(id);
	}

}