package belote.tests.model;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import belote.enums.Position;
import belote.exeption.GameException;
import belote.model.Card;
import belote.model.Pli;
import mocks.CardsMock;
import mocks.PlayersMock;

public class PliTests {
	
	private Pli pli;
	
	@Before
	public void intTests() {
		  PlayersMock.iniPlayers();
		  CardsMock.intCards();
		  pli = new Pli(Position.NORTH);
	  }
	
	@Test
	public void contructTest() {		
		assertEquals(Position.NORTH,pli.getBeginner());
		assertTrue(pli.getCards().isEmpty());
		
	}
	
	@Test
	public void contructWithCardTest() throws GameException {
		
		Card card = CardsMock.getAceSpade();
		pli = new Pli(Position.NORTH,card);		
		
		assertEquals(Position.NORTH,pli.getBeginner());
		assertEquals(pli.colorAsk(),card.getColor());		
	}
	
	@Test
	public void addCardTest() throws GameException {
		
		pli.addCard(CardsMock.getAceSpade());		
		assertEquals(1,pli.ndCards());
		
		pli.addCard(CardsMock.getAceClub());
		assertEquals(2,pli.ndCards());
		
		pli.addCard(CardsMock.getHeightDiamond());		
		assertEquals(3,pli.ndCards());
		
		pli.addCard(CardsMock.getQueenHeart());		
		assertEquals(4,pli.ndCards());
		
		List<Card> cards = pli.getCards();
		
		assertEquals(cards.get(0),CardsMock.getAceSpade());
		assertEquals(cards.get(1),CardsMock.getAceClub());
		assertEquals(cards.get(2),CardsMock.getHeightDiamond());
		assertEquals(cards.get(3),CardsMock.getQueenHeart());
		
	}
	
	@Test
	public void addCardKoTest() throws GameException {
		
		pli.addCard(CardsMock.getAceSpade());		
		pli.addCard(CardsMock.getAceClub());
		pli.addCard(CardsMock.getHeightDiamond());
		pli.addCard(CardsMock.getQueenHeart());
		
		Assertions.assertThrows(GameException.class, () -> 
		pli.addCard(CardsMock.getKingHeart())
				);		
	}
	
	@Test
	public void colorAskTest() throws GameException {

		Card card = CardsMock.getAceSpade();
		pli.addCard(card);
		assertEquals(pli.colorAsk(),card.getColor());
	}
	
	@Test
	public void colorAskKoTest() {
	
		Assertions.assertThrows(GameException.class, () -> 
		pli.colorAsk()
				);
	}
	
	

}
