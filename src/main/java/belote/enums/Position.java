package belote.enums;

public enum Position {
	
NORTH(0), WEST(1), SOUTH(2), EAST(3);
	
	private int intPosition ;  
    
    private Position(int intPosition) {  
        this.intPosition = intPosition ;  
   }  
     
    public int getIntPosition() {  
        return  this.intPosition ;  
   }

}
