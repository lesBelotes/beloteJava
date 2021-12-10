package belote.model;

public enum CardValue {
	
	SEVEN("7"), HEIGHT("8"), NINE("9"), TEN("10"), JACK("J"), GUEEN("Q"), KING("K"), ACE("1");
	
	private String abbreviation ;  
    
    private CardValue(String abreviation) {  
        this.abbreviation = abreviation ;  
   }  
     
    public String getAbbreviation() {  
        return  this.abbreviation ;  
   }  

}
