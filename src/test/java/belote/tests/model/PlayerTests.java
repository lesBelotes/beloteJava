package belote.tests.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import belote.enums.CardValue;
import belote.enums.ColorEnum;
import belote.model.Card;
import belote.model.Color;
import belote.model.Player;
import mocks.PlayersMock;

public class PlayerTests {

	@Test
	public void equalTest() {
		Player player1 = new Player("Bob", "1");
		assertEquals(player1, PlayersMock.getBob());
		assertNotEquals(player1, PlayersMock.getLiliane());
	}
	
	@Test
	public void handTest() {
		Player bob = new Player("Bob", "1");
		assertFalse(!(bob.getHand() != null && bob.getHand().isEmpty()),
				"bad hand at beginnig");		

		bob.addCardToHand(new Card(ColorEnum.CLUB, CardValue.ACE));		
		assertEquals(1, bob.getHand().size());			

		Card aceClub = new Card(new Color(ColorEnum.CLUB), CardValue.ACE);
		assertTrue(bob.getHand().contains(aceClub));
	}

}
