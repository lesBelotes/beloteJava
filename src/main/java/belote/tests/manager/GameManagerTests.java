package belote.tests.manager;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import belote.exeption.GameException;
import belote.manager.GameManager;
import belote.model.Game;
import belote.model.State;
import belote.tests.mocks.PlayersMock;

class GameManagerTests {
	
	private GameManager gameManager;
	   
	  @BeforeEach
	  void intTests() {
		  assertNull(gameManager);
		  gameManager = GameManager.getInstance();
		  PlayersMock.iniPlayers();
	  }
	  
	  @AfterEach
	  void resetGameManager() {
		  gameManager = null;
	  }
	
	@Test
	void createGameTestNotNull() {
		String idGame = gameManager.createGame();
		Game game = gameManager.getGameById(idGame);
		
		assertNotNull(game);
		assertEquals(idGame,game.getId());
	}
	
	@Test
	void createGameTestNotEqualGame() throws GameException {
		Game game1 = gameManager.getNewGame();
		Game game2 = gameManager.getNewGame();
		
		assertNotEquals(game1,game2);
	}
	
	@Test
	void addPlayerToGameTest() throws GameException {
		String idGame = gameManager.createGame();
		Game game = gameManager.getGameById(idGame);
		
		gameManager.addPlayerToGame(idGame, PlayersMock.getBob());
		assertEquals(PlayersMock.getBob(), game.getNorth());
		assertTrue(PlayersMock.getBob().isInGame());
		assertEquals(game.getState(), State.WAITING);
		
		gameManager.addPlayerToGame(idGame, PlayersMock.getLiliane());
		assertEquals(PlayersMock.getLiliane(), game.getWest());
		assertTrue(PlayersMock.getLiliane().isInGame());
		assertEquals(game.getState(), State.WAITING);

		gameManager.addPlayerToGame(idGame, PlayersMock.getSandy());
		assertEquals(PlayersMock.getSandy(), game.getSouth());
		assertTrue(PlayersMock.getSandy().isInGame());
		assertEquals(game.getState(), State.WAITING);

		gameManager.addPlayerToGame(idGame, PlayersMock.getTapette());
		assertEquals(PlayersMock.getTapette(), game.getEast());
		assertTrue(PlayersMock.getTapette().isInGame());
		assertEquals(game.getState(), State.START);
	}
	
	@Test
	void addPlayerToGameTestPositionOk() throws GameException {
		String idGame = gameManager.createGame();
		Game game = gameManager.getGameById(idGame);

		gameManager.addPlayerToGame(idGame, PlayersMock.getLiliane(),3);
		assertEquals(PlayersMock.getLiliane(), game.getEast());
		assertTrue(PlayersMock.getLiliane().isInGame());
		assertEquals(game.getState(), State.WAITING);
		
		gameManager.addPlayerToGame(idGame, PlayersMock.getSandy(),1);
		assertEquals(PlayersMock.getSandy(), game.getWest());
		assertTrue(PlayersMock.getSandy().isInGame());
		assertEquals(game.getState(), State.WAITING);

		gameManager.addPlayerToGame(idGame, PlayersMock.getBob(),2);
		assertEquals(PlayersMock.getBob(), game.getSouth());
		assertTrue(PlayersMock.getBob().isInGame());
		assertEquals(game.getState(), State.WAITING);

		gameManager.addPlayerToGame(idGame, PlayersMock.getTapette(),0);
		assertEquals(PlayersMock.getTapette(), game.getNorth());
		assertTrue(PlayersMock.getTapette().isInGame());
		assertEquals(game.getState(), State.START);
	}
	
	@Test
	void addPlayerToGameTestPositionKo() {
		String idGame = gameManager.createGame();
		Game game = gameManager.getGameById(idGame);

		Assertions.assertThrows(GameException.class, () -> 
		gameManager.addPlayerToGame(idGame, PlayersMock.getLiliane(),7)
				);
		assertEquals(game.getNbPlayer(), 0);
	}
	
	

}
