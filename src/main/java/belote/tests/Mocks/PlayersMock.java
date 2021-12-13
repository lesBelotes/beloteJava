package belote.tests.Mocks;

import java.util.ArrayList;
import java.util.List;

import belote.model.Player;

public class PlayersMock {
	
	private static Player bob ;
	private static Player liliane ;
	private static Player sandy ;
	private static Player tapette ;
	
	private PlayersMock() {
		
	}
	
	public static List<Player> getPlayers(){	

		List<Player> players = new ArrayList<>();
		
		players.add(getBob());
		players.add(getLiliane());
		players.add(getSandy());
		players.add(getTapette());
		
		return players;
		
	}
	
	public static Player getBob() {
		if(bob == null) {
			bob = new Player("Bob", "1", "1");
		}
		return bob;
	}
	
	public static Player getLiliane() {
		if(liliane == null) {
			liliane = new Player("Liliane", "2", "2");
		}
		return liliane;
	}
	
	public static Player getSandy() {
		if(sandy == null) {
			sandy = new Player("Sandy", "3", "3");
		}
		return sandy;
	}
	
	public static Player getTapette() {
		if(tapette == null) {
			tapette = new Player("Tapette", "4", "4");
		}
		return tapette;
	}

}
