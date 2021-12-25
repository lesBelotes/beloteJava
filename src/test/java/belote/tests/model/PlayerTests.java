package belote.tests.model;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import belote.model.Card;
import belote.model.CardValue;
import belote.model.Color;
import belote.model.ColorEnum;
import belote.model.Player;
import belote.tests.mocks.PlayersMock;

class PlayerTests {

	@Test
	void equalTest() {
		Player player1 = new Player("Bob", "1", "1");
		assertFalse(!player1.equals(PlayersMock.getBob()),"Bob not same as Bob");
		assertFalse(player1.equals(PlayersMock.getLiliane()),"Bob same as Liliane");
	}
	
	@Test
	void handTest() {
		Player bob = new Player("Bob", "1", "1");
		assertFalse(!(bob.getHand() != null && bob.getHand().isEmpty()),
				"bad hand at beginnig");		

		bob.addCardToHand(new Card(ColorEnum.CLUB, CardValue.ACE));
		assertFalse(bob.getHand().size() != 1,"card no add to hand");		

		Card aceClub = new Card(new Color(ColorEnum.CLUB), CardValue.ACE);
		assertFalse(!bob.getHand().contains(aceClub),"wrong card added");
	}

}
