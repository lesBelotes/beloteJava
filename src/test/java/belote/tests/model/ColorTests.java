package belote.tests.model;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.Test;

import belote.model.Card;
import mocks.CardsMock;

public class ColorTests {
	
	@Test
	public void equalTest() {
		Card aceClub = CardsMock.getAceClub();
		Card heightClub = CardsMock.getHeightClub();
		
		assertEquals(aceClub.getColor(), heightClub.getColor());		
	}

}
