package belote.tests.manager;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import belote.manager.DeckManager;
import belote.model.Player;
import junit.framework.Assert;

public class DeckManagerTests {
	
	@Test
	public void distributeTest() {

		List<Player> players = new ArrayList<>();
		
		Player bob = new Player("Bob", "");
		Player liliane = new Player("Liliane", "");
		Player sandy = new Player("Sandy", "");
		Player tapette = new Player("Tapette", "");
		
		players.add(bob);
		players.add(liliane);
		players.add(sandy);
		players.add(tapette);
		
		DeckManager deckManager = new DeckManager();
		deckManager.distribute(players);
		
		for (Player player : players) {
			int nbCards = player.getHand().size();
			assertFalse(nbCards != 8);			
		}
		
		
	}

}
