package belote.controller;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import belote.manager.GameManager;
import belote.manager.PlayerManager;
import belote.model.Game;
import belote.model.Player;
import belote.websocket.BeloteSocketHandler;

@CrossOrigin
@RestController
@RequestMapping(path = "belote")

public class BeloteController {

	@Autowired
	BeloteSocketHandler socketManager;
	
	@PostMapping("/game")
	public Game createBelote() {
		GameManager n=GameManager.getInstance();
		Game game = n.getNewGame();
		socketManager.broadcastNewGame(game.toString());
		return game;
	}
	
	
	@GetMapping("/games")
	public  Collection<Game> getgames(){
		
		GameManager gameManager=GameManager.getInstance();

		return gameManager.getGames().values();
	}
	
	@PostMapping("/player/{pseudo}")
	public String connectPlayer(@PathVariable String pseudo) {
		PlayerManager playerManager = PlayerManager.getInstance();
		socketManager.broadcastNewPlayer("new one");
		return playerManager.createPlayer(pseudo, "");
	}
	
	@PutMapping("/game/player/{idgame}/{idPlayer}")
     public String addPlayer(@PathVariable String idgame,@PathVariable String idPlayer){	
		
		PlayerManager playerManager = PlayerManager.getInstance();
		GameManager gameManager =GameManager.getInstance();
		
		Player joueur = playerManager.getPlayer(idPlayer);		
		gameManager.addPlayerToGame(idgame, joueur);
		socketManager.broadcastNewPlayer(joueur.toString());
		return "player " + joueur.getPseudo() + " added";
	}
}
