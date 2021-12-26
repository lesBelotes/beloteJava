package belote.model;

public class Card {
	
	private Color color;
	private CardValue value;
	
	public Card(ColorEnum colorEnum, CardValue value) {
		this(new Color(colorEnum), value);
	}
	
	public Card(Color color, CardValue value) {
		this.color = color;
		this.value = value;
	}

	public Color getColor() {
		return color;
	}

	public CardValue getValue() {
		return value;
	}

	public void setAtout(boolean isAtout) {
		color.setAtout(isAtout);
	}
	
	public int getPoint() {
		if(color.isAtout()) {
			return CardPoint.getAtoutPoint(value);
		}
		return CardPoint.getPoint(value);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		Card other = (Card) obj;
		if (!color.equals(other.color))
			return false;
		
		return value.equals(other.value);
	}

	@Override
	public String toString() {
		return "Card [value=" + value + ", color=" + color + "]";
	}
	
	
	
	
	
	

}
