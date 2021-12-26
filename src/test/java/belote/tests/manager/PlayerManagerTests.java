package belote.tests.manager;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import belote.exeption.GameException;
import belote.manager.PlayerManager;
import belote.model.Player;

public class PlayerManagerTests {

	private PlayerManager playerManager;

	@Before
	public void intTests() {
		assertNull(playerManager);
		playerManager = PlayerManager.getInstance();		  
	}

	@After
	public void resetPlayerManager() {
		playerManager = null;
	}

	@Test
	public void createPlayerTest() throws GameException {
		String pseudo = "pseudo";
		String idPlayer = playerManager.createPlayer(pseudo);

		Player player = playerManager.getPlayer(idPlayer);

		assertNotNull(player);
		assertEquals(idPlayer,player.getId());
		assertEquals(pseudo,player.getPseudo());
		assertFalse(player.isInGame());
	}
	
	@Test
	public void getPlayerKoTest(){
		Assertions.assertThrows(NoSuchElementException.class, () -> 
		playerManager.getPlayer("1")
				);
	}



}
