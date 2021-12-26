package belote.tests.model;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.Test;

import belote.model.Card;
import mocks.CardsMovk;

public class ColorTests {
	
	@Test
	public void equalTest() {
		Card aceClub = CardsMovk.getAceClub();
		Card heightClub = CardsMovk.getHeightClub();
		
		assertEquals(aceClub.getColor(), heightClub.getColor());		
	}

}
