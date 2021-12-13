package belote.tests.manager;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import belote.exeption.GameException;
import belote.manager.GameManager;
import belote.model.Game;
import belote.tests.Mocks.PlayersMock;

class GameManagerTests {
	
	private GameManager gameManager;
	   
	  @BeforeEach
	  void intTests() {
		  assertFalse(gameManager != null);
		  gameManager = GameManager.getInstance();		  
	  }
	  
	  @AfterEach
	  void resetGameManager() {
		  gameManager = null;
	  }

	@Test
	void test() {
		//fail("Not yet implemented");
	}
	
	@Test
	void createGameTestNotNull() {
		String idGame = gameManager.createGame();
		Game game = gameManager.getGameById(idGame);
		
		assertFalse(game == null);
		assertFalse(!idGame.equals(game.getId()));
	}
	
	@Test
	void createGameTestNotEqualGame() throws GameException {
		Game game1 = gameManager.getNewGame();
		Game game2 = gameManager.getNewGame();
		
		assertFalse(game1.equals(game2));
	}
	
	@Test
	void addPlayerToGameTest() throws GameException {
		String idGame = gameManager.createGame();
		Game game = gameManager.getGameById(idGame);
		
		gameManager.addPlayerToGame(idGame, PlayersMock.getBob());
		assertFalse(!PlayersMock.getBob().equals(game.getNorth()));
		assertFalse(!PlayersMock.getBob().isInGame());
		
		gameManager.addPlayerToGame(idGame, PlayersMock.getLiliane());
		assertFalse(!PlayersMock.getLiliane().equals(game.getWest()));
		assertFalse(!PlayersMock.getLiliane().isInGame());	

		gameManager.addPlayerToGame(idGame, PlayersMock.getSandy());
		assertFalse(!PlayersMock.getSandy().equals(game.getSouth()));
		assertFalse(!PlayersMock.getSandy().isInGame());

		gameManager.addPlayerToGame(idGame, PlayersMock.getTapette());
		assertFalse(!PlayersMock.getTapette().equals(game.getEast()));
		assertFalse(!PlayersMock.getTapette().isInGame());
	}
	
	@Test
	void addPlayerToGameTestPositionOk() throws GameException {
		String idGame = gameManager.createGame();
		Game game = gameManager.getGameById(idGame);

		gameManager.addPlayerToGame(idGame, PlayersMock.getLiliane(),3);
		assertFalse(!PlayersMock.getLiliane().equals(game.getEast()));
		
		gameManager.addPlayerToGame(idGame, PlayersMock.getSandy(),1);
		assertFalse(!PlayersMock.getSandy().equals(game.getWest()));	

		gameManager.addPlayerToGame(idGame, PlayersMock.getBob(),2);
		assertFalse(!PlayersMock.getBob().equals(game.getSouth()));

		gameManager.addPlayerToGame(idGame, PlayersMock.getTapette(),0);
		assertFalse(!PlayersMock.getTapette().equals(game.getNorth()));
	}
	
	@Test
	void addPlayerToGameTestPositionKo() {
		String idGame = gameManager.createGame();
		Game game = gameManager.getGameById(idGame);

		Assertions.assertThrows(GameException.class, () -> 
		gameManager.addPlayerToGame(idGame, PlayersMock.getLiliane(),7)
				);
		assertFalse(game.getNbPlayer() != 0);		
	}
	
	

}
