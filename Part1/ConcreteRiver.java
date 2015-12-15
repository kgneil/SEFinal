/**
 * ConcreteRiver.java	A class used for collecting data of a single river
 * 
 * @author Kelsey Neil
 */
public class ConcreteRiver implements ComponentRiver{
	
	//Private fields
	private String riverName;
	private double riverFlow;
	private double distanceTraveled;
	
	/**
	 * Class constructor
	 * 
	 * @param riverName				String of the river name
	 * @param riverFlow				Double for the river flow
	 * @param distanceTraveled		Double for the distanced traveled
	 */
	public ConcreteRiver(String riverName, double riverFlow, double distanceTraveled){
		super();
		this.riverName = riverName;
		this.riverFlow = riverFlow;
		this.distanceTraveled = distanceTraveled;
	}
	

	/**
	 * getRiverName()		method to get the river name
	 * 
	 * @return riverName		String for river name
	 */
	public String getRiverName() {
		return this.riverName;
	}
	
	/**
	 * getRiverFlow()		method to get the river flow
	 * 
	 * @return riverFlow		double for riverFlow
	 */
	public double getRiverFlow() {
		
		return this.riverFlow;
	}
	
	/**
	 * getDistanceTraveled()		method for getting the distanced traveled
	 * 
	 * @return distanceTraveled		double for the distanced traveled
	 */
	public double getDistanceTraveled() {
		return this.distanceTraveled;
	}
	
	
	
	/**
	 * setDistanceTraveled()		method to setting the distanced traveled
	 * 
	 * @param distanceTraveled		double for the distanced traveled
	 */
	public void setDistanceTraveled(double distanceTraveled) {
		this.distanceTraveled = distanceTraveled;
	}
	
	/**
	 * setRiverName()		method to set the river name
	 * 
	 * @param riverName		String for river name
	 */
	public void setRiverName(String riverName) {
		this.riverName = riverName;
	}
	
	/**
	 * setRiverFlow()		method to set the river flow
	 * 
	 * @param riverFlow		double for riverFlow
	 */
	public void setRiverFlow(double riverFlow) {
		this.riverFlow = riverFlow;
	}

	//No need
	public void add(ComponentRiver river) {
		//No need!
	}
	
	/**
	 * print() method for printing out the riverFlow and the distanced traveled
	 */
	public void print() {
		//System.out.println("Then, the "+getRiverName()+" flows into the river.");
		System.out.println(getRiverFlow()+" L/s flows "+getDistanceTraveled()+" km downstream.");

		
	}


}
