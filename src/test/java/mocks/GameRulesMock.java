package mocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import belote.enums.Position;
import belote.interfaces.IGameRules;
import belote.model.Card;
import belote.model.ContratType;
import belote.model.Pli;
import belote.model.ResultContrat;
import belote.model.Round;

public class GameRulesMock implements IGameRules{
	
	private Position winner;
	private ResultContrat resultContrat;
	private boolean playCard;
	private boolean contratDetermined;
	
	

	public GameRulesMock(Position winner, ResultContrat resultContrat, boolean playCard, boolean contratDetermined) {
		super();
		this.winner = winner;
		this.resultContrat = resultContrat;
		this.playCard = playCard;
		this.contratDetermined = contratDetermined;
	}

	public GameRulesMock(Position winner, ResultContrat resultContrat, boolean playCard) {
		this(winner, resultContrat, playCard, false);
	}

	public GameRulesMock() {
		super();
	}
	
	@Override
	public boolean canPlayrCard(Card card, Set<Card> hand, Pli pli) {
		return playCard;
	}
	
	public void setPlayCard(boolean playCard) {
		this.playCard = playCard;
	}

	@Override
	public List<Card> cardPlayable(Set<Card> hand, Pli pli) {
		List<Card> cards =new ArrayList<Card>();
		cards.addAll(hand);
		return cards;
	}

	@Override
	public Position getWinner(Pli pli) {
		return winner;
	}
	
	public void setWinner(Position winner) {
		this.winner = winner;
	}

	@Override
	public ResultContrat pointToAdd(Round round) {
		return resultContrat;
	}
	
	public void setResultContrat(ResultContrat resultContrat) {
		this.resultContrat = resultContrat;
	}
	
	public void setContratDetermined(boolean contratDetermined) {
		this.contratDetermined = contratDetermined;
	}

	@Override
	public boolean isContratDetermined(List<ContratType> contrats) {
		return contratDetermined;
	}

}
