package belote.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import belote.enums.Position;
import belote.manager.DeckManager;
import belote.manager.GameManager;
import belote.manager.GamesRules;
import belote.manager.PlayerManager;
import belote.manager.RoundManager;
import belote.model.Card;
import belote.model.ContratType;
import belote.model.Game;
import belote.model.Player;
import belote.model.Round;
import belote.util.GameUtil;
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
	
	@GetMapping("/players")
	public  Collection<Player> getPlayers(){
		
		PlayerManager playerManager = PlayerManager.getInstance();

		return playerManager.getPlayers().values();
	}
	
	
	@PostMapping("/player/{pseudo}")
	public String connectPlayer(@PathVariable String pseudo) {
		PlayerManager playerManager = PlayerManager.getInstance();
		socketManager.broadcastNewPlayer("new one");
		return playerManager.createPlayer(pseudo);
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
	
	@GetMapping("/game/contrats")
	public List<ContratType> getContratTypes(){	

		return GameUtil.getContratTypes();
	}
	
	@GetMapping("/game/colors")
	public List<String> getColors(){	

		return GameUtil.getColors();
	}
	
	@PutMapping("/game/card/{cardName}/{idPlayer}")
	public String playCard(@PathVariable String cardName,@PathVariable String idPlayer){

		
		return "";
	}
	
	@PutMapping("/game/card/{cardName}/{idGame}/{idPlayer}")
	public String playCard(@PathVariable String cardName,@PathVariable String idGame,@PathVariable String idPlayer){		
		Game game = GameManager.getInstance().getGameById(idGame);
		Player player = PlayerManager.getInstance().getPlayer(idPlayer);
		Position position = GameUtil.getPosition(player, game);
		RoundManager roundManager = new RoundManager(new GamesRules());
		Card card = player.getCard(cardName);
		roundManager.playCard(card, game, position);
		socketManager.broadcastCardPlayed(card);
		return "playCard : "+ cardName;
	}
	
	@PutMapping("/game/players/cards/{idGame}")
    public String distribute(@PathVariable String idGame){	
		
		Game game = GameManager.getInstance().getGameById(idGame);
		DeckManager deckManager = new DeckManager();
		deckManager.distribute(game.getPlayers());
		socketManager.broadcastDistribute();
		game.setRound(new Round(Position.NORTH));
		
				
		return "distribute " ;
	}
}
