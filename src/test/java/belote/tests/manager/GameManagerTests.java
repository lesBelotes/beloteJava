package belote.tests.manager;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import belote.enums.State;
import belote.exeption.GameException;
import belote.manager.GameManager;
import belote.model.Game;
import mocks.PlayersMock;

public class GameManagerTests {

	private GameManager gameManager;

	@Before
	public void intTests() {
		assertNull(gameManager);
		gameManager = GameManager.getInstance();
		PlayersMock.iniPlayers();
	}

	@After
	public void resetGameManager() {
		gameManager = null;
	}

	@Test
	public void createGameTestNotNull() {
		String idGame = gameManager.createGame();
		Game game = gameManager.getGameById(idGame);

		assertNotNull(game);
		assertEquals(idGame,game.getId());
	}

	@Test
	public void createGameTestNotEqualGame() throws GameException {
		Game game1 = gameManager.getNewGame();
		Game game2 = gameManager.getNewGame();

		assertNotEquals(game1,game2);
	}

	@Test
	public void addPlayerToGameTest() throws GameException {
		String idGame = gameManager.createGame();
		Game game = gameManager.getGameById(idGame);

		gameManager.addPlayerToGame(idGame, PlayersMock.getBob());
		assertEquals(PlayersMock.getBob(), game.getNorth());
		assertTrue(PlayersMock.getBob().isInGame());
		assertEquals(State.WAITING, game.getState());

		gameManager.addPlayerToGame(idGame, PlayersMock.getLiliane());
		assertEquals(PlayersMock.getLiliane(), game.getWest());
		assertTrue(PlayersMock.getLiliane().isInGame());
		assertEquals(State.WAITING, game.getState());

		gameManager.addPlayerToGame(idGame, PlayersMock.getSandy());
		assertEquals(PlayersMock.getSandy(), game.getSouth());
		assertTrue(PlayersMock.getSandy().isInGame());
		assertEquals(State.WAITING, game.getState());

		gameManager.addPlayerToGame(idGame, PlayersMock.getTapette());
		assertEquals(PlayersMock.getTapette(), game.getEast());
		assertTrue(PlayersMock.getTapette().isInGame());
		assertEquals(State.START, game.getState());
	}

	@Test
	public void addPlayerToGameTestPositionOk() throws GameException {
		String idGame = gameManager.createGame();
		Game game = gameManager.getGameById(idGame);

		gameManager.addPlayerToGame(idGame, PlayersMock.getLiliane(),3);
		assertEquals(PlayersMock.getLiliane(), game.getEast());

		gameManager.addPlayerToGame(idGame, PlayersMock.getSandy(),1);
		assertEquals(PlayersMock.getSandy(), game.getWest());

		gameManager.addPlayerToGame(idGame, PlayersMock.getBob(),2);
		assertEquals(PlayersMock.getBob(), game.getSouth());

		gameManager.addPlayerToGame(idGame, PlayersMock.getTapette(),0);
		assertEquals(PlayersMock.getTapette(), game.getNorth());
	}

	@Test
	public void addPlayerToGameTestPositionKo() {
		String idGame = gameManager.createGame();
		Game game = gameManager.getGameById(idGame);

		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		gameManager.addPlayerToGame(idGame, PlayersMock.getLiliane(),7)
				);
		assertEquals(0, game.getNbPlayer());	
	}



}
