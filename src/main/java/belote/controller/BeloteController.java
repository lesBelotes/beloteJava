package belote.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import belote.exeption.GameException;
import belote.manager.GameManager;
import belote.manager.PlayerManager;
import belote.model.Game;
import belote.model.Player;

@CrossOrigin
@RestController
@RequestMapping(path = "belote")

public class BeloteController {

	
	@PostMapping("/game")
	public String createBelote() {
		
		GameManager n=GameManager.getInstance();
		String id= n.createGame();
		
		return id;
		
	}
	
	
	@GetMapping("/games")
	public  Map<String, Game> getgames(){
		
		GameManager gameManager=GameManager.getInstance();

		return gameManager.getGames();
	}
	
	@PostMapping("/player/{pseudo}")
	public String connectPlayer(@PathVariable String pseudo) {
		PlayerManager playerManager = PlayerManager.getInstance();
		return playerManager.createPlayer(pseudo, "");
	}
	
	@PutMapping("/game/player/{idgame}/{idPlayer}")
     public String addPlayer(@PathVariable String idgame,@PathVariable String idPlayer){	
		
		PlayerManager playerManager = PlayerManager.getInstance();
		GameManager gameManager =GameManager.getInstance();
		
		Player joueur = playerManager.getPlayer(idPlayer);		
		  
			try {
				gameManager.addPlayerToGame(idgame, joueur);
			} catch (GameException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return "player " + joueur.getPseudo() + " added";
	}
}
