package application.model;

public class SearchChargeList {
	private double weight;
	private double transportationTime;
	private double fee;
	
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getTransportationTime() {
		return transportationTime;
	}
	public void setTransportationTime(double transportationTime) {
		this.transportationTime = transportationTime;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	
	public SearchChargeList() {
	}
	
	public SearchChargeList(double weight, double transportationTime, double fee) {
		this.weight = weight;
		this.transportationTime = transportationTime;
		this.fee = fee;
	}
}
