package belote.model;

public class Color {
	
	private ColorEnum colorEnum;
	private boolean isAtout;
	
	public Color(ColorEnum color) {
		this(color, false);
	}
	
	public Color(ColorEnum color, boolean isAtout) {
		this.colorEnum = color;
		this.isAtout = isAtout;
	}

	public ColorEnum getColor() {
		return colorEnum;
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
		result = prime * result + ((colorEnum == null) ? 0 : colorEnum.hashCode());
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
		return colorEnum.equals(other.colorEnum);
	}
	
	
	
	
}
