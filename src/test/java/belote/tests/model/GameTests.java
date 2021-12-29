package belote.tests.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;

import belote.enums.State;
import belote.model.Game;
import mocks.PlayersMock;

public class GameTests {
	
	private static final String ONE = "one";
	private static final String TWO = "two";
		
	@Test
	public void newGameTest() {
		Game game = new Game(ONE);
		
		assertEquals(ONE, game.getId());	
		assertNotNull(game.getTeamEW());	
		assertNotNull(game.getTeamNS());
		assertEquals(State.WAITING, game.getState());
		assertEquals(0, game.getNbPlayer());
		assertEquals(0, game.scorePointEW());
		assertEquals(0, game.scorePointNS());
	}
	
	@Test
	public void equalTest() {
		Game game1 = new Game(ONE);
		Game game2 = new Game(TWO);
		assertEquals(game1, new Game(ONE));
		assertNotEquals(game1, game2);
	}
	
	@Test
	public void addNorthPlayerTest() {
		Game game = new Game(ONE);
		game.setNorth(PlayersMock.getBob());

		assertEquals(1,game.getNbPlayer());
		assertEquals(game.getNorth(),PlayersMock.getBob());
	}
	
	@Test
	public void addWestPlayerTest() {
		Game game = new Game(ONE);
		game.setWest(PlayersMock.getBob());
		
		assertEquals(1,game.getNbPlayer());
		assertEquals(game.getWest(),PlayersMock.getBob());
	}
	
	@Test
	public void addSouthPlayerTest() {
		Game game = new Game(ONE);
		game.setSouth(PlayersMock.getBob());
		
		assertEquals(1,game.getNbPlayer());
		assertEquals(game.getSouth(),PlayersMock.getBob());
	}
	
	@Test
	public void addEastPlayerTest() {
		Game game = new Game(ONE);
		game.setEast(PlayersMock.getBob());
		
		assertEquals(1,game.getNbPlayer());
		assertEquals(game.getEast(),PlayersMock.getBob());
	}
	
	@Test
	public void addScoreTest() {
		Game game = new Game(ONE);
		
		game.addPointToEW(80);		
		assertEquals(80,game.scorePointEW());
		assertEquals(0,game.scorePointNS());
		
		game.addPointToNS(120);		
		assertEquals(80,game.scorePointEW());
		assertEquals(120,game.scorePointNS());
		
		game.addPointToNS(100);		
		assertEquals(80,game.scorePointEW());
		assertEquals(220,game.scorePointNS());
	}

}
