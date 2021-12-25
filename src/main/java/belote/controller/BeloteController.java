package belote.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import belote.exeption.GameException;
import belote.manager.GameManager;
import belote.manager.PlayerManager;
import belote.model.Player;

@CrossOrigin
@RestController
@RequestMapping(path = "belote")

public class BeloteController {

	
	@PutMapping("/game")
	public String createBelote() {
		
		GameManager n=GameManager.getInstance();
		String id= n.createGame();
		
		return id;
		
	}
	
	@GetMapping("/beloteArea/connecte/{pseudo}/{ip}/{id}/{idgame}")
     public String beloteArea(@PathVariable String pseudo,@PathVariable String ip,@PathVariable String id,@PathVariable String idgame){
		
		Player joueur=new Player(pseudo,ip,id);
		
		
		GameManager j=GameManager.getInstance();
		
		  
			try {
				j.addPlayerToGame(idgame, joueur);
			} catch (GameException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		return id;
	}
	
	@GetMapping("/belote/games")
	public  GameManager getgames(){
		
		
		GameManager games=GameManager.getInstance();
		
		return games;
	}
	
	@GetMapping("/beloteArea/connecte/{pseudo}/{ip}")
	public String connectPlayer(@PathVariable String pseudo,@PathVariable String ip) {
		PlayerManager playerManager = PlayerManager.getInstance();
		return playerManager.createPlayer(pseudo, ip);
	}
	
	@GetMapping("/beloteArea/addPlayer/{idPlayer}/{idgame}")
     public String addPlayer(@PathVariable String idPlayer,@PathVariable String idgame){	
		
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
