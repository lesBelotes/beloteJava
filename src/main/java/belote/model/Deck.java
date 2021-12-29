package belote.model;

import java.util.EnumMap;
import java.util.List;

import belote.enums.ColorEnum;

public class Deck  {
	
	private List<Card> cards;
	private EnumMap<ColorEnum, Color> colors;
	private ColorEnum atout;
	
	public Deck() {
		colors = new EnumMap<>(ColorEnum.class);
	}
	
	public List<Card> getCards() {
		return cards;
	}
	
	public void addColor(Color color) {
		colors.put(color.getColor(), color);		
	}
	
	/**
	 * renvoie un Color à partir de la liste de couleur
	 * @param colorEnum clé de la couleur à renvoyer
	 * @return la color demandé
	 */
	public Color getColor(ColorEnum colorEnum) {
		return colors.get(colorEnum);
	}
	
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public ColorEnum getAtout() {
		return atout;
	}

	public void setAtout(ColorEnum atout) {
		this.atout = colors.get(atout).getColor();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cards == null) ? 0 : cards.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deck other = (Deck) obj;
		if (cards == null) {
			if (other.cards != null)
				return false;
		} else if (!cards.equals(other.cards))
			return false;
		return true;
	}


	
	
	
	
	

}
