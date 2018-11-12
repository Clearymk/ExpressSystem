package application.pojo;

public class ChargeInfo {
	public ChargeInfo(float transportCost, float predictTime) {
		this.transportCost = transportCost;
		this.predictTime = predictTime;
	}
	private float transportCost;
	private float predictTime;
	public float getTransportCost() {
		return transportCost;
	}
	public void setTransportCost(float transportCost) {
		this.transportCost = transportCost;
	}
	public float getPredictTime() {
		return predictTime;
	}
	public void setPredictTime(float predictTime) {
		this.predictTime = predictTime;
	}
	
	
}
