package belote.enums;

public enum ContratTypes {
	
	EIGHTY(80,"80",false), NINETY(90,"90"), HUNDRED(100,"100"),
	HUNDREDTEN(110,"110"), HUNDREDTWENTY(120,"120"), HUNDREDTHIRTY(130,"130"),
	HUNDREDFORTY(140,"140"), HUNDREDFIFTY(150,"150"), HUNDREDSIXTY(160,"160"),
	CAPOT(260,"capot",false);
	
	private int value ;
	private String name ;
	private boolean coinchable;

	private ContratTypes(int value,String name) {  
		this(value, name, true);
	}

	private ContratTypes(int value, String name, boolean coinchable) {
		this.value = value;
		this.name = name;
		this.coinchable = coinchable;
	}

	public int getValue() {
		return value;
	}	

	public String getName() {
		return name;
	}
	
	public boolean isCoinchable() {
		return coinchable;
	}

}
