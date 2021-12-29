package belote.manager;

import java.util.Set;

import belote.enums.Position;
import belote.exeption.GameException;
import belote.interfaces.IGameRules;
import belote.model.Card;
import belote.model.Game;
import belote.model.Player;
import belote.model.Pli;
import belote.model.ResultContrat;
import belote.model.Round;
import belote.util.GameUtil;

public class RoundManager {
	
	private IGameRules gameRules;	
	
	public RoundManager(IGameRules gameRules) {
		super();
		this.gameRules = gameRules;
	}

	/**
	 * Joue une carte:
	 * ajoute lacarte au pli courant 
	 * et la retire de la main
	 * @param card carte à ajouter
	 * @param hand main dujoueur
	 * @param round dont on doit jouer la carte
	 * @throws GameException si la carte n est pas jouable
	 */
	public void playCard(Card card, Set<Card> hand , Round round) throws GameException {
		
		Pli pli = round.getPli();
		if(!gameRules.canPlayrCard(card, hand, pli)) {
			throw new GameException(String.format("Can t play %s", card));
		}
		hand.remove(card);
		round.addCard(card);			
	}
	
	/**
	 * Joue une carte:
	 * ajoute lacarte au pli courant 
	 * et la retire de la main
	 * @param card carte à ajouter 
	 * @param game partie dont on doit jouer la carte
	 * @param position dujoueur
	 * @throws GameException si la carte n est pas jouable
	 */
	public void playCard(Card card, Game game, Position position) throws GameException {		

		Player player = GameUtil.getPlayer(position, game);
		Round round = game.getRound();		
		playCard(card, player.getHand(), round);
	}
	
	/**
	 * ajoute le plicourant àl'equipe gagnante
	 * @param winner position du vainqueur du pli
	 * @param round contenant le plicourant
	 */
	public void addPliToTeamWinner(Position winner, Round round) {
		
		Pli pli = round.getPli();		
		if(Position.WEST.equals(winner) || Position.EAST.equals(winner)) {
			round.addPliToWE(pli);
		}else {
			round.addPliToNS(pli);
		}		
	}
	
	/**
	 * Place le pli courant dans la liste des pli de l'equipe gagnate.
	 * Remplace le pli courant par un nouveau pli
	 * @param round contenant le pli à modifier
	 */
	public void newPli(Round round) {
		Pli pli = round.getPli();
		Position winner = gameRules.getWinner(pli);
		addPliToTeamWinner(winner, round);
		round.setPli(new Pli(winner));		
	}
	
	/**
	 * Place le round courant dans la liste des rounds de la partie.
	 * Remplace le round courant par un nouveau round
	 * @param game contenant le round à modifier
	 */
	public void newRound(Game game) {		
		Position oldBeginner = game.getRound().getOpener();		
		Round round = new Round(GameUtil.getNext(oldBeginner));
		game.addRound(game.getRound());
		game.setRound(round);		
	}
	
	/**
	 * ajoute les points du round coarant à l'equipe gagnante
	 * @param game
	 */
	public void addPointToGame(Game game) {

		Round round = game.getRound();		
		ResultContrat resultContrat = gameRules.pointToAdd(round);
		
		Position winner = round.getTacker();
		
		if(! resultContrat.isCompleted()) {
			winner = GameUtil.getNext(winner);
		}
		
		GameUtil.getTeam(winner, game).addPoints(resultContrat.getPointToAdd());
	}
	

}
