package belote.model;

import belote.enums.ColorEnum;
import belote.enums.ContratTypes;
import belote.enums.Multiplicateur;
import belote.enums.Position;

public class Contrat {
	
	private ContratTypes contratTypes;
	private ColorEnum atout;
	private Position tacker;
	private Multiplicateur multiplicateur;
	
	public Contrat(ContratTypes contratTypes, ColorEnum atout, Position tacker) {
		super();
		this.contratTypes = contratTypes;
		this.atout = atout;
		this.tacker = tacker;
		this.multiplicateur = Multiplicateur.NORMAL;
	}

	public Contrat(Position tacker) {
		this(null, null, tacker);
	}

	public ContratTypes getContratTypes() {
		return contratTypes;
	}

	public ColorEnum getAtout() {
		return atout;
	}

	public Position getTacker() {
		return tacker;
	}

	public Multiplicateur getMultiplicateur() {
		return multiplicateur;
	}
	
	public void setMultiplicateur(Multiplicateur multiplicateur) {
		this.multiplicateur = multiplicateur;
	}
	
	
	
}
