package belote.tests.manager;

import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import belote.exeption.GameException;
import belote.manager.DeckManager;
import belote.model.Card;
import belote.model.ColorEnum;
import belote.model.Deck;
import belote.model.Player;
import belote.tests.mocks.PlayersMock;

public class DeckManagerTests {
	
	
	
	@Test
	public void distributeTest() throws GameException {

		List<Player> players = PlayersMock.getPlayers();
		
		DeckManager deckManager = new DeckManager();
		deckManager.distribute(players);
				
		for (Player player : players) {
			int nbCards = player.getHand().size();
			assertFalse(nbCards != 8);			
		}
	}
	
	
	@Test
	public void distributeTestNotEnoughPlayer() {

		List<Player> players = new ArrayList<>();
		players.add(new Player("ouaiGros", ""));

		DeckManager deckManager = new DeckManager();

		Assertions.assertThrows(GameException.class, () -> 
		deckManager.distribute(players)
				);		
	}
	
	@Test
	public void distributeTestToMuchPlayer() {
		
		List<Player> players = PlayersMock.getPlayers();
		players.add(new Player("ouaiGros", ""));
		
		DeckManager deckManager = new DeckManager();
		
		Assertions.assertThrows(GameException.class, () -> 
			deckManager.distribute(players)
		  );		
	}
	
	@Test
	public void testCreate() {
		DeckManager deckManager = new DeckManager();
		
		Deck deck = deckManager.createDeck();		
		Deck deck2 = deckManager.createDeck();
		
		int nbCards = deck.getCards().size();
		
		assertFalse(nbCards != 32);		
		assertFalse(!deck.getCards().equals(deck2.getCards()));		
	}
	
	@Test
	public void testShuffle() {
		DeckManager deckManager = new DeckManager();
		
		Deck deck = deckManager.createDeck();
		Deck deck2 = deckManager.createDeck();
		
		deckManager.shuffle(deck);
		
		int nbCards = deck.getCards().size();
		
		assertFalse(nbCards != 32);		
		assertFalse(deck.getCards().equals(deck2.getCards()));		
	}
	
	@Test
	public void testSetAtout() throws GameException {
		DeckManager deckManager = new DeckManager();
		
		Deck deck = deckManager.createDeck();		
		deckManager.shuffle(deck);
		
		List<Player> players = PlayersMock.getPlayers();
		deckManager.distribute(players);
		
		deckManager.setAtout(deck, ColorEnum.CLUB);
		
		for (Player player : players) {
			for (Card card : player.getHand()) {
				if(ColorEnum.CLUB.equals(card.getColor())) {
					assertFalse(!ColorEnum.CLUB.equals(deck.getAtout()));
				}else {
					assertFalse(card.getColor().equals(deck.getAtout()));
				}
			}						
		}
	}

}
