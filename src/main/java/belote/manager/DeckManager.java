package belote.manager;

import java.util.ArrayList;
import java.util.List;

import belote.exeption.GameException;
import belote.model.Card;
import belote.model.CardValue;
import belote.model.Color;
import belote.model.ColorEnum;
import belote.model.Deck;
import belote.model.Player;
import belote.util.RandomUtil;

public class DeckManager {

	private static final String INVALID_PLAYER_NUMBER = "Invalide nummber player";
	private static final String NB_PLAYER = "Nb player :";
	private static final String ESP = " ";

	/**
	 * distribut 8 cartes à chaque joueur à partir d'un nouveau deck mélangé
	 * Cette distribition se fait par 1, 2 ou 3 catres 
	 * jusqu'à ce les joueurs aient 8 cartes chacun
	 * @param players list des joueurs dont on veut distribuer les cartes
	 * @throws GameException si le nombre de joueurs est différent de 4
	 */
	public void distribute(List<Player> players) throws GameException {
		Deck deck = createDeck();
		shuffle(deck);
		distribute(players, deck);
	}

	/**
	 * distribut 8 cartes à chaque joueur.
	 * Cette distribition se fait par 1, 2 ou 3 catres 
	 * jusqu'à ce les joueurs aient 8 cartes chacun
	 * @param players ist des joueurs dont on veut distribuer les cartes
	 * @param deck contient les cartes à distribuer celui ci n est pas mélangé
	 * @throws GameException si le nombre de joueurs est différent de 4
	 */
	public void distribute(List<Player> players, Deck deck) throws GameException {

		if(players.size() != 4) {
			throw new GameException(
					INVALID_PLAYER_NUMBER + ESP + NB_PLAYER + ESP + String.valueOf(players.size())
					);
		}

		int cardsDistributed = 0;
		while (!deck.getCards().isEmpty()) {
			int cardToDistribute = nbCardToDistribute(cardsDistributed);
			cardsDistributed += cardToDistribute;

			for (Player player : players) {
				for (int i = 0; i < cardToDistribute; i++) {
					player.addCardToHand(deck.getCards().remove(0));
				}
			}
		}
	}


	/**
	 * créer un deck non mélangé
	 * @return le deck créé
	 */
	public Deck createDeck() {
		Deck deck = new Deck();
		List<Card> cards = new ArrayList<>();		
		for(ColorEnum colorEnum : ColorEnum.values()) {
			Color color = new Color(colorEnum);
			deck.addColor(color);			
			for(CardValue value : CardValue.values()) {
				cards.add(new Card(color, value));
			}			
		}		
		deck.setCards(cards);
		return deck;
	}


	/**
	 * créer un deck
	 * @return le deck créé et mélanger
	 * @return
	 */
	public Deck shuffle() {
		Deck deck = createDeck();
		shuffle(deck);
		return deck;
	}

	/**
	 * mélange un deck
	 * @param deck le deck mélangé
	 */
	public void shuffle(Deck deck) {

		List<Card> cardsTemp = new ArrayList<>();		
		while (!deck.getCards().isEmpty()) {			
			RandomUtil randomUtil = new RandomUtil();

			int index = randomUtil.getRandom(deck.getCards().size());			
			cardsTemp.add(deck.getCards().remove(index));
		}		
		deck.setCards(cardsTemp);
	}

	/**
	 *  
	 * @param cardsDistributed nombre de carte déja distribuées
	 * @return un int aléatoire de 1 à 3
	 */
	private int nbCardToDistribute(int cardsDistributed) {

		return nbCardToDistribute(cardsDistributed,2);
	}

	/**
	 * 
	 * @param cardsDistributed nombre de carte déja distribuées
	 * @param nbCardMax valeur max à renvoyer
	 * @return un int aléatoire de 1 à valeur de nbCardMax +1
	 */
	private int nbCardToDistribute(int cardsDistributed, int nbCardMax) {

		RandomUtil randomUtil = new RandomUtil();
		int nbCard = randomUtil.getRandom(nbCardMax) + 1;

		cardsDistributed += nbCard;

		if(cardsDistributed > 8) {
			cardsDistributed -= nbCard;
			nbCard = nbCardToDistribute(cardsDistributed,nbCardMax-1);
		}

		return nbCard;
	}

	/**
	 * choisi une couleur à l atout
	 * @param deck jeu dont on veut choisir l atout
	 * @param colorAtout couleur de l atout choisi
	 */
	public void setAtout(Deck deck, ColorEnum colorAtout) {
		deck.setAtout(colorAtout);
		for(ColorEnum colorEnum : ColorEnum.values()) {
			boolean isAtout = colorEnum.equals(colorAtout);
			deck.getColor(colorEnum).setAtout(isAtout);			
		}				
	}

}
