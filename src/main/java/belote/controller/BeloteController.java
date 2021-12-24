package belote.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import belote.exeption.GameException;
import belote.manager.GameManager;
import belote.model.Game;
import belote.model.Player;

@CrossOrigin
@RestController
public class BeloteController {

	
	@GetMapping("/belote/create")
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
}
