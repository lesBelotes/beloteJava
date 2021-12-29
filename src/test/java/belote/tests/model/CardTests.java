package belote.tests.model;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Test;

import belote.enums.CardValue;
import belote.enums.ColorEnum;
import belote.model.Card;
import belote.model.Color;

public class CardTests {

	@Test
	public void equalTest() {
		Card aceClub = new Card(new Color(ColorEnum.CLUB), CardValue.ACE);
		Card aceClub2 = new Card(new Color(ColorEnum.CLUB), CardValue.ACE);
		Card jackClub = new Card(new Color(ColorEnum.CLUB), CardValue.JACK);
		Card aceDiamond = new Card(new Color(ColorEnum.DIAMOND), CardValue.ACE);	
		
		assertEquals(aceClub, aceClub2);
		assertNotEquals(aceClub, jackClub);
		assertNotEquals(aceClub, aceDiamond);
	}

}
