package belote.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import belote.manager.GameManager;
import belote.model.Game;

@CrossOrigin
@RestController
public class BeloteController {

	@GetMapping("/beloteArea/connecte")
	public String getMessage() {
		String message = "bonjour Belotiste";

		return message;

	}
	
	
	@GetMapping("/belote/create")
	public String createBelote() {
		
		GameManager n=GameManager.getInstance();
		String id= n.createGame();
		
		return id;
		
	}
	
	

}
