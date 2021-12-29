package belote.enums;

public enum Multiplicateur {

	NORMAL(1), COINCHE(2), CONTRE(4);

	private int multiple ;  

	private Multiplicateur(int multiple) {  
		this.multiple = multiple ;  
	}  

	public int getMultiple() {  
		return  this.multiple ;  
	}

}
