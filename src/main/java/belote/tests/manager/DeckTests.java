package belote.tests.manager;

import static org.junit.Assert.*;

import org.junit.Test;

import belote.model.Deck;

public class DeckTests {

	@Test
	public void testCreate() {
		Deck deck = new Deck();
		
		Deck deck2 = new Deck();
		int nbCards = deck.getCards().size();
		
		assertFalse(nbCards != 32);
		
		assertFalse(!deck.getCards().equals(deck2.getCards()));
		
	}
	
	@Test
	public void testShuffle() {
		Deck deck = new Deck();
		Deck deck2 = new Deck();
		
		deck.shuffle();
		
		int nbCards = deck.getCards().size();
		
		assertFalse(nbCards != 32);
		
		assertFalse(deck.getCards().equals(deck2.getCards()));
		
	}

}
