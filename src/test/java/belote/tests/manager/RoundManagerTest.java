package belote.tests.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import belote.enums.Position;
import belote.exeption.GameException;
import belote.manager.RoundManager;
import belote.model.Card;
import belote.model.Game;
import belote.model.Pli;
import belote.model.ResultContrat;
import belote.model.Round;
import mocks.CardsMock;
import mocks.ContratsMock;
import mocks.GameRulesMock;
import mocks.GamesMock;
import mocks.PlayersMock;
import mocks.PliMock;
import mocks.RoundsMock;

public class RoundManagerTest {
	
	private GameRulesMock gameRules;
	private RoundManager roundManager;

	@Before
	public void intTests() {
		gameRules = new GameRulesMock();
		roundManager = new RoundManager(gameRules);
		RoundsMock.iniRounds();
		GamesMock.iniGames();
		PlayersMock.iniPlayers();
		PliMock.initPlis();
	}

	
	@Test
	public void playCardHandTest() throws GameException {
		gameRules.setPlayCard(true);
		
		Card card = CardsMock.getAceClub();
		
		Set<Card> hand = new HashSet<>();
		hand.add(card);
		hand.add(CardsMock.getAceSpade());
		hand.add(CardsMock.getKingHeart());
		
		Round round = RoundsMock.getRoundNorth();
		
		roundManager.playCard(card, hand, round);
		
		Pli pli = round.getPli();
		
		assertFalse(hand.contains(card));
		assertEquals(1, pli.ndCards());
		assertTrue(pli.getCards().contains(card));		
		
	}
	
	@Test
	public void playCardHandKoTest() throws GameException {		
		gameRules.setPlayCard(false);
		
		Card card = CardsMock.getAceClub();
		
		Set<Card> hand = new HashSet<>();
		hand.add(card);
		hand.add(CardsMock.getAceSpade());
		hand.add(CardsMock.getKingHeart());
		
		Round round = RoundsMock.getRoundNorth();
		
		Assertions.assertThrows(GameException.class, () -> 
		roundManager.playCard(card, hand, round)
				);

		Pli pli = round.getPli();
		
		assertTrue(hand.contains(card));
		assertFalse(pli.getCards().contains(card));
		assertEquals(0, pli.ndCards());
	}
	
	@Test
	public void playCardGameTest() throws GameException {		

		gameRules.setPlayCard(true);
		
		Card card = CardsMock.getAceClub();
		
		PlayersMock.getSandy().addCardToHand(card);
		PlayersMock.getSandy().addCardToHand(CardsMock.getAceSpade());
		PlayersMock.getSandy().addCardToHand(CardsMock.getKingHeart());
		
		Round round = RoundsMock.getRoundNorth();
		Game game = GamesMock.getGamePlyers();
		game.setRound(round);
		
		roundManager.playCard(card, game, Position.SOUTH);

		Pli pli = game.getRound().getPli();
		Set<Card> hand = PlayersMock.getSandy().getHand();
		
		assertFalse(hand.contains(card));
		assertEquals(1, pli.ndCards());
		assertTrue(pli.getCards().contains(card));
		
	}
	
	@Test
	public void playCardGameKoTest() throws GameException {
		
		gameRules.setPlayCard(false);
		
		Card card = CardsMock.getAceClub();
		
		Round round = RoundsMock.getRoundNorth();
		Game game = GamesMock.getGamePlyers();
		game.setRound(round);
		
		PlayersMock.getSandy().addCardToHand(card);
		
		Assertions.assertThrows(GameException.class, () -> 
		roundManager.playCard(card, game, Position.SOUTH)
				);

		Pli pli = game.getRound().getPli();
		Set<Card> hand = PlayersMock.getSandy().getHand();
		
		assertTrue(hand.contains(card));
		assertFalse(pli.getCards().contains(card));
		assertEquals(0, pli.ndCards());
		
	}
	
	@Test
	public void addPliToTeamWinnerTest() {

		gameRules.setPlayCard(true);
		
		Round round = RoundsMock.getRoundNorth();
		
		Pli pli = PliMock.getFullCardsEast();
		round.setPli(pli);		
		roundManager.addPliToTeamWinner(Position.EAST, round);
		Pli lastPliAdded = round.getPlisWE().get(0);
		
		assertEquals(lastPliAdded, pli);
		assertEquals(1, round.getPlisWE().size());
		assertTrue( round.getPlisNS().isEmpty());
		
		pli = PliMock.getFullCardsWest();
		round.setPli(pli);		
		roundManager.addPliToTeamWinner(Position.WEST, round);
		lastPliAdded = round.getPlisWE().get(1);
		
		assertEquals(lastPliAdded, pli);
		assertEquals(2, round.getPlisWE().size());
		assertTrue( round.getPlisNS().isEmpty());
		
		pli = PliMock.getFullCardsNorth();
		round.setPli(pli);		
		roundManager.addPliToTeamWinner(Position.NORTH, round);
		lastPliAdded = round.getPlisNS().get(0);
		
		assertEquals(lastPliAdded, pli);
		assertEquals(2, round.getPlisWE().size());
		assertEquals(1, round.getPlisNS().size());
		
		pli = PliMock.getFullCardsSouth();
		round.setPli(pli);		
		roundManager.addPliToTeamWinner(Position.SOUTH, round);
		lastPliAdded = round.getPlisNS().get(1);
		
		assertEquals(lastPliAdded, pli);
		assertEquals(2, round.getPlisWE().size());
		assertEquals(2, round.getPlisNS().size());
		
	}
	
	@Test
	public void newPliTest() {
		gameRules.setWinner(Position.WEST);
		
		Round round = RoundsMock.getRoundNorth();
		Pli pli = PliMock.getFullCardsEast();
		round.setPli(pli);
		roundManager.newPli(round);
		Pli lastPliAdded = round.getPlisWE().get(0);
		
		assertEquals(lastPliAdded, pli);
		assertEquals(1, round.getPlisWE().size());
		assertEquals(0, round.getPli().ndCards());

		assertEquals(Position.WEST, round.getPli().getBeginner());		
	}
	
	@Test
	public void newRoundTest() {
		Game game = GamesMock.getGamePlyers();
		game.setRound(RoundsMock.getRoundNorth());
		
		roundManager.newRound(game);
		
		Round newRound =  game.getRound();
		assertEquals(Position.WEST, newRound.getOpener());
		assertTrue(game.getRounds().contains(RoundsMock.getRoundNorth()));
		
	}
	
	@Test
	public void addPointToGameTrst() {
		
		gameRules.setResultContrat(new ResultContrat(true, 100));
		
		Game game = GamesMock.getGamePlyers();
		
		Round round = RoundsMock.getRoundNorth();
		round.setContrat(ContratsMock.getHundredClub());
		
		game.setRound(round);
		
		roundManager.addPointToGame(game);
		
		assertEquals(100, game.scorePointEW());		
		assertEquals(0, game.scorePointNS());
		
		gameRules.setResultContrat(new ResultContrat(false, 110));
		
		round.setContrat(ContratsMock.getHundredTenDiamond());
		game.setRound(round);
		
		roundManager.addPointToGame(game);
		
		assertEquals(210, game.scorePointEW());		
		assertEquals(0, game.scorePointNS());
		
		gameRules.setResultContrat(new ResultContrat(false, 100));
		
		round.setContrat(ContratsMock.getHundredClub());
		game.setRound(round);
		
		roundManager.addPointToGame(game);
		
		assertEquals(210, game.scorePointEW());		
		assertEquals(100, game.scorePointNS());
		
		gameRules.setResultContrat(new ResultContrat(true, 110));
		
		round.setContrat(ContratsMock.getHundredTenDiamond());
		game.setRound(round);
		
		roundManager.addPointToGame(game);
		
		assertEquals(210, game.scorePointEW());		
		assertEquals(210, game.scorePointNS());		
		
	}
	
}
