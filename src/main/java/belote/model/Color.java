package belote.model;

public class Color {
	
	private ColorEnum color;
	private boolean isAtout;
	
	public Color(ColorEnum color) {
		this(color, false);
	}
	
	public Color(ColorEnum color, boolean isAtout) {
		this.color = color;
		this.isAtout = isAtout;
	}

	public ColorEnum getColor() {
		return color;
	}

	public boolean isAtout() {
		return isAtout;
	}

	public void setAtout(boolean isAtout) {
		this.isAtout = isAtout;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
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
		Color other = (Color) obj;
		return color.equals(other.color);
	}
	
	
	
	
}
