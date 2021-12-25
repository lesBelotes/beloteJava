package belote.tests.manager;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import belote.manager.PlayerManager;
import belote.model.Player;

public class PlayerManagerTests {
	
	private PlayerManager playerManager;
	   
	  @BeforeEach
	  void intTests() {
		  assertNull(playerManager);
		  playerManager = PlayerManager.getInstance();		  
	  }
	  
	  @AfterEach
	  void resetPlayerManager() {
		  playerManager = null;
	  }
	  
	  @Test
		void createGameTestNotNull() {
			String pseudo = "pseudo";
			String ip = "ip";
			String idPlayer = playerManager.createPlayer(pseudo, ip);
			
			Player player = playerManager.getPlayer(idPlayer);
			
			assertNotNull(player);
			assertEquals(idPlayer,player.getId());
			assertEquals(pseudo,player.getPseudo());
			assertEquals(ip,player.getIp());
			assertFalse(player.isInGame());
		}

}
