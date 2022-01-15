package belote.model;

import java.util.ArrayList;
import java.util.List;

import belote.enums.ColorEnum;
import belote.enums.Multiplicateur;
import belote.enums.Position;
import belote.exeption.GameException;

public class Round {
	
	//position joueur qui commence le round
	private Position opener;
	
	//position du joueur qui à la belote null si pas de belote
	private Position belote;
	
	// liste des annonces
	private List<Contrat> contrats;
	
	private Contrat contrat;
	
	//plis remportés par l equipe Nord sud
	private List<Pli> plisNS;
	
	//plis remportés par l equipe est ouest
	private List<Pli> plisWE;
	
	//pli en cour
	private Pli pli;
	
	public Round(Position opener) {
		this.opener = opener;
		this.plisNS = new ArrayList<>();
		this.plisWE = new ArrayList<>();
		this.contrats = new ArrayList<>();
		this.pli = new Pli(opener);
	}

	public ColorEnum getAtout() {
		return contrat.getAtout();
	}

	public Contrat getContrat() {
		return contrat;
	}
	
	public List<Contrat> getContrats() {
		return contrats;
	}
	
	public void abbContrat(Contrat contrat) {
		contrats.add(contrat);
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	public Multiplicateur getMultiplicateur() {
		return contrat.getMultiplicateur();
	}

	public Position getOpener() {
		return opener;
	}

	public void setOpener(Position opener) {
		this.opener = opener;
	}

	public Position getTacker() {
		return contrat.getTacker();
	}

	public List<Pli> getPlisNS() {
		return plisNS;
	}
	
	public void addPliToNS(Pli pli) {
		plisNS.add(pli);
	}

	public void setPlisNS(List<Pli> plisNS) {
		this.plisNS = plisNS;
	}

	public List<Pli> getPlisWE() {
		return plisWE;
	}
	
	public void addPliToWE(Pli pli) {
		plisWE.add(pli);
	}

	public void setPlisWE(List<Pli> plisWE) {
		this.plisWE = plisWE;
	}

	/**
	 * 
	 * @return le pli encour
	 */
	public Pli getPli() {
		return pli;
	}

	/**
	 * remplace le pli en cour
	 * @param pli
	 */
	public void setPli(Pli pli) {
		this.pli = pli;
	}
	
	/**
	 * 
	 * @return la position du joueur qui a la belote 
	 * si pas de belote retourn null
	 */
	public Position getBelote() {
		return belote;
	}
	
	/**
	 * 
	 * @param belote position du joueur qui à la belote
	 */
	public void setBelote(Position belote) {
		this.belote = belote;
	}

	/**
	 * ajoute un carte au pli corant
	 * @param card carte à ajouter
	 * @throws GameException si le pli contient trop de carte
	 */
	public void addCard(Card card) throws GameException {
		pli.addCard(card);
	}
}
