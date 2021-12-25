package belote.tests.model;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import belote.model.Card;
import belote.model.CardValue;
import belote.model.Color;
import belote.model.ColorEnum;

class CardTests {

	@Test
	void equalTest() {
		Card aceClub = new Card(new Color(ColorEnum.CLUB), CardValue.ACE);
		Card aceClub2 = new Card(new Color(ColorEnum.CLUB), CardValue.ACE);
		Card jackClub = new Card(new Color(ColorEnum.CLUB), CardValue.JACK);
		Card aceDiamond = new Card(new Color(ColorEnum.DIAMOND), CardValue.ACE);		
		
		assertFalse(!aceClub.equals(aceClub2),"ace Club not same as ace Club");
		assertFalse(aceClub.equals(jackClub),"ace Club same as jack Club");
		assertFalse(aceClub.equals(aceDiamond),"ace Club same as ace Diamond");
	}

}
