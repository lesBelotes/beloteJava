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

public class DeckManagerTests {
	
	private List<Player> getPlayers(){	

		List<Player> players = new ArrayList<>();
		
		Player bob = new Player("Bob", "");
		Player liliane = new Player("Liliane", "");
		Player sandy = new Player("Sandy", "");
		Player tapette = new Player("Tapette", "");
		
		players.add(bob);
		players.add(liliane);
		players.add(sandy);
		players.add(tapette);
		
		return players;
		
	}
	
	@Test
	public void distributeTest() {

		List<Player> players = getPlayers();
		
		DeckManager deckManager = new DeckManager();
		try {
			deckManager.distribute(players);
		} catch (GameException e) {
			e.printStackTrace();
		}
		
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
		
		Assertions.assertThrows(GameException.class, () -> {
			deckManager.distribute(players);
		  });		
	}
	
	@Test
	public void distributeTestToMuchPlayer() {
		
		List<Player> players = getPlayers();
		players.add(new Player("ouaiGros", ""));
		
		DeckManager deckManager = new DeckManager();
		
		Assertions.assertThrows(GameException.class, () -> {
			deckManager.distribute(players);
		  });		
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
	public void testSetAtout() {
		DeckManager deckManager = new DeckManager();
		
		Deck deck = deckManager.createDeck();		
		deckManager.shuffle(deck);
		
		List<Player> players = getPlayers();
		try {
			deckManager.distribute(players);
		} catch (GameException e) {
			e.printStackTrace();
		}
		
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
