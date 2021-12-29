package belote.model;

public class ResultContrat {
	
	private boolean completed;
	private int pointToAdd;
	
	public ResultContrat(boolean completed, int pointToAdd) {
		super();
		this.completed = completed;
		this.pointToAdd = pointToAdd;
	}
	
	public boolean isCompleted() {
		return completed;
	}
	
	public int getPointToAdd() {
		return pointToAdd;
	}
	
	

}
