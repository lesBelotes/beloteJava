package belote.model;

import belote.enums.ContratTypes;

public class ContratType {
	
	private int value ;
	private String name ;
	private boolean coinchable;
	private String enumName ;
	
	public ContratType(ContratTypes contratTypes) {
		this.enumName = contratTypes.name();
		this.value = contratTypes.getValue();
		this.name = contratTypes.getName();
		this.coinchable = contratTypes.isCoinchable();		
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

	public String getEnumName() {
		return enumName;
	}
	
	
	
	

}
