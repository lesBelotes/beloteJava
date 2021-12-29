package belote.tests.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import belote.enums.Position;
import belote.model.Game;
import belote.model.Team;
import belote.util.GameUtil;
import mocks.PlayersMock;

public class GameUtilTests {
	
	private Game game;
	
	@Before
	public void iniTest() {
		PlayersMock.iniPlayers();
		game = new Game("1");
		game.setNorth(PlayersMock.getBob());
		game.setWest(PlayersMock.getLiliane());
		game.setSouth(PlayersMock.getSandy());
		game.setEast(PlayersMock.getTapette());		
	}
	
	@After
	public void finishTest() {
		
	}
	
	@Test
	public void getTeamByPlyerTest() {
		
		Team teamNorth = GameUtil.getTeam(PlayersMock.getBob(), game);
		Team teamSouth = GameUtil.getTeam(PlayersMock.getSandy(), game);
		
		Team teamWest = GameUtil.getTeam(PlayersMock.getLiliane(), game);
		Team teamEast = GameUtil.getTeam(PlayersMock.getTapette(), game);
		
		assertEquals(teamNorth, game.getTeamNS());
		assertEquals(teamSouth, game.getTeamNS());
		
		assertEquals(teamWest, game.getTeamEW());
		assertEquals(teamEast, game.getTeamEW());
		
	}
	
	@Test
	public void getTeamByPositionTest(){
		
		Team teamNorth = GameUtil.getTeam(Position.NORTH, game);
		Team teamSouth = GameUtil.getTeam(Position.SOUTH, game);
		
		Team teamWest = GameUtil.getTeam(Position.WEST, game);
		Team teamEast = GameUtil.getTeam(Position.EAST, game);
		
		assertEquals(teamNorth, game.getTeamNS());
		assertEquals(teamSouth, game.getTeamNS());
		
		assertEquals(teamWest, game.getTeamEW());
		assertEquals(teamEast, game.getTeamEW());
		
	}
	
	@Test
	public void getPositionTest() {
		
		Position north = GameUtil.getPosition(PlayersMock.getBob(), game);
		Position south = GameUtil.getPosition(PlayersMock.getSandy(), game);
		
		Position west = GameUtil.getPosition(PlayersMock.getLiliane(), game);
		Position east = GameUtil.getPosition(PlayersMock.getTapette(), game);
		
		assertEquals(Position.NORTH, north);
		assertEquals(Position.SOUTH, south);
		
		assertEquals(Position.WEST, west);
		assertEquals(Position.EAST, east);
		
	}
	

}
