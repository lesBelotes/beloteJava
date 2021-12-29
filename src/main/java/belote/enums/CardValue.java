package belote.enums;

public enum CardValue {

	SEVEN("7",0), HEIGHT("8",0), NINE("9",0,14), TEN("10",10),
	JACK("J",2,20), GUEEN("Q",3), KING("K",4), ACE("1",11);

	private String value ;
	private int point;
	private int atouPoint;

	private CardValue(String value, int point) {
		this(value, point, point);
	}

	private CardValue(String value, int point, int atouPoint) {
		this.value = value;
		this.point = point;
		this.atouPoint = atouPoint;
	}

	public String getvalue() {  
		return  this.value ;  
	}
	
	public int getPoint() {
		return point;
	}
	
	public int getAtouPoint() {
		return atouPoint;
	}

}
