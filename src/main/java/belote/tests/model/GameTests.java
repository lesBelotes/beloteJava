package belote.tests.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import belote.model.Game;
import belote.model.State;
import belote.tests.Mocks.PlayersMock;

class GameTests {
	
	private static final String ONE = "one";
	private static final String TWO = "two";
	private static final String PLAYER_NOT_ADD = "player not added";
		
	@Test
	void newGameTest() {
		Game game = new Game(ONE);		
		assertFalse(!ONE.equals(game.getId()),"new game id null");
		assertFalse(game.getTeamEW() == null,"new game team EW null");
		assertFalse(game.getTeamNS() == null,"new game team NS null");
		assertFalse(!State.WAITING.equals(game.getState()),"new game not in waitaing");
		assertFalse(game.getNbPlayer() != 0,"new game need 0 player");
		assertFalse(game.scorePointEW() != 0,"new game score EW not 0");
		assertFalse(game.scorePointNS() != 0,"new game score NS not 0");
	}
	
	@Test
	void equalTest() {
		Game game1 = new Game(ONE);
		Game game2 = new Game(TWO);
		assertFalse(!game1.equals(new Game(ONE)),"gameUn not equal gameUn");
		assertFalse(game1.equals(game2),"gameUn not equal gameDeux");
	}
	
	@Test
	void addNorthPlayerTest() {
		Game game = new Game(ONE);
		game.setNorth(PlayersMock.getBob());

		assertFalse(game.getNbPlayer() != 1,PLAYER_NOT_ADD);
		assertFalse(!PlayersMock.getBob().equals(game.getNorth()),"Player not in North");
	}
	
	@Test
	void addWestPlayerTest() {
		Game game = new Game(ONE);
		game.setWest(PlayersMock.getBob());

		assertFalse(game.getNbPlayer() != 1,PLAYER_NOT_ADD);
		assertFalse(!PlayersMock.getBob().equals(game.getWest()),"Player not in West");
	}
	
	@Test
	void addSouthPlayerTest() {
		Game game = new Game(ONE);
		game.setSouth(PlayersMock.getBob());

		assertFalse(game.getNbPlayer() != 1,PLAYER_NOT_ADD);
		assertFalse(!PlayersMock.getBob().equals(game.getSouth()),"Player not in South");
	}
	
	@Test
	void addEastPlayerTest() {
		Game game = new Game(ONE);
		game.setEast(PlayersMock.getBob());

		assertFalse(game.getNbPlayer() != 1,PLAYER_NOT_ADD);
		assertFalse(!PlayersMock.getBob().equals(game.getEast()),"Player not in East");
	}
	
	@Test
	void addScoreTest() {
		String errorEW = "score EW not 80";
		Game game = new Game(ONE);		
		game.addPointToEW(80);
		assertFalse(game.scorePointEW() != 80,errorEW);
		assertFalse(game.scorePointNS() != 0,"score NS not 0");
		
		game.addPointToNS(120);
		assertFalse(game.scorePointEW() != 80,errorEW);
		assertFalse(game.scorePointNS() != 120,"score NS not 120");
		
		game.addPointToNS(100);
		assertFalse(game.scorePointEW() != 80,errorEW);
		assertFalse(game.scorePointNS() != 220,"score NS not 220");
	}

}
