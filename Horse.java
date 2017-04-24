package racehorse; 

public class Horse {
	private String horseName;
	private Integer raceDistance;
	private Integer distanceCovered;
	private Integer gateDistance;
	private Boolean reachGate;
	private Boolean reachFinish;
	private Boolean goBoost;
	private String warCry;
	
	public Horse (String horseName, Integer raceDistance, Integer distanceCovered, Integer gateDistance, 
		Boolean reachGate, Boolean reachFinish, Boolean goBoost, String warCry) {
		this.horseName = horseName;
		this.raceDistance = raceDistance;
		this.distanceCovered = distanceCovered;
		this.gateDistance = gateDistance;
		this.reachGate = reachGate;
		this.reachFinish = reachFinish;
		this.goBoost = goBoost;		
		this.warCry = warCry;
	}
	
	public Integer getGateDistance() {
		return this.gateDistance;
	}

	public void setGateDistance(Integer input) {
		gateDistance = input;
	}
	
	public Boolean getGateStatus() {
		return this.reachGate;
	}
	
	public void setGateStatus(Boolean input) {
		this.reachGate = input;
	}
	
	public Boolean getFinishStatus() {
		return this.reachFinish;
	}

	public void setFinishStatus(Boolean input) {
		this.reachFinish = input;
	}
	
	public Integer getRaceDistance() {
		return this.raceDistance;
	}
	
	public void setRaceDistance(Integer input) {
		this.raceDistance = input;
	}
	
	public String getHorseName() {
		return this.horseName;
	}
	
	public void setHorseName(String input) {
		this.horseName = input;
	}
	
	public void setDistanceCovered(Integer input) {
		this.distanceCovered = input;
	}
	
	public Integer getDistanceCovered() {
		return this.distanceCovered;
	}
	
	public Boolean getBoost() {
		return this.goBoost;
	}
	
	public void setBoost(Boolean input) {
		this.goBoost = input;
	}

	public void setWarCry(String input) {
		this.warCry = input;
	}

	public String getWarCry() {
		return this.warCry;
	}
}