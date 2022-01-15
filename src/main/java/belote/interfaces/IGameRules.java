package belote.interfaces;

import java.util.List;
import java.util.Set;

import belote.enums.Position;
import belote.model.Card;
import belote.model.ContratType;
import belote.model.Pli;
import belote.model.ResultContrat;
import belote.model.Round;

public interface IGameRules {
	
		
	/**
	 * verifi si la carte peut erre
	 * @param card carte à verifier
	 * @param hand main du joueur à tester
	 * @param pli pli auquel on souhaite ajouter la carte
	 * @return true si la carte est jouab
	 */
	public boolean canPlayrCard(Card card, Set<Card> hand, Pli pli);
	
	/**
	 * 
	 * @param hand main à verifier
	 * @param pli pli pli auquel on souhaite ajouter la carte
	 * @return les cartes jouables d'une main
	 */
	public List<Card> cardPlayable(Set<Card> hand, Pli pli);
	
		
	/**
	 * 
	 * @param pli dont on doit determiner le vainquer
	 * @return la position du vainqueur du pli
	 */
	public Position getWinner(Pli pli);
	
	/**
	 * calcul des points à ajouter
	 * si le contrat est rempli, les points sont ajouté à l'equipe prreneuse 
	 * sinon les points sont à ajouter à l autre equipe
	 * @param round
	 * @return
	 */
	public ResultContrat pointToAdd(Round round);
	
	/**
	 * détermine si la phase d'enchere est terminée
	 * @param contrats 
	 * @return true si la phase est terminée
	 */
	public boolean isContratDetermined(List<ContratType> contrats);

}
