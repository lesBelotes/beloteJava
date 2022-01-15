package belote.manager;

import java.util.List;
import java.util.Set;

import belote.enums.Position;
import belote.interfaces.IGameRules;
import belote.model.Card;
import belote.model.ContratType;
import belote.model.Pli;
import belote.model.ResultContrat;
import belote.model.Round;

public class GamesRules implements IGameRules {

	@Override
	public boolean canPlayrCard(Card card, Set<Card> hand, Pli pli) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List<Card> cardPlayable(Set<Card> hand, Pli pli) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position getWinner(Pli pli) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultContrat pointToAdd(Round round) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isContratDetermined(List<ContratType> contrats) {
		// TODO Auto-generated method stub
		return false;
	}

}
