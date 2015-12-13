import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;



public class CompositeRiver implements ComponentRiver{
	
	private String riverName;
	private double riverFlow;
	private double distanceTraveled;
	private ArrayList<ComponentRiver> rivers = new ArrayList<ComponentRiver>();
	
	
	/**
	 * Class constructor
	 * 
	 * @param rivers	ArrayList of rivers
	 */
	public CompositeRiver (ArrayList<ComponentRiver> rivers){
		this.rivers = rivers;
		
	}
	
	/**
	 * Adds river to the arraylist of rivers
	 * 
	 * @param river		river of ComponentRiver
	 */
	public void add(ComponentRiver river) {
		rivers.add(river);
	}
	
	/**
	 * getRiverName()		returns a string of the river name
	 * 
	 * @return riverName	String of the river name
	 */
	public String getRiverName() {
		return this.riverName;
	}
	
	/**
	 * getRiverFlow()		returns a string of the river name
	 * 
	 * @return riverFlow	Double of the river flow
	 */
	public double getRiverFlow() {
		
		return this.riverFlow;
	}
	
	/**
	 * getDistanceTraveled()		returns a double of distanced traveled
	 * 
	 * @return distanceTraveled		Double of distanced Traveled
	 */
	public double getDistanceTraveled() {
		return this.distanceTraveled;
	}

	/**
	 * print() prints the information of each river
	 */
	public void print() {
		for (ComponentRiver river: rivers) {
			river.print();
			System.out.println("River Flow: "+river);
			System.out.println("River Flow: "+getRiverFlow());
			System.out.println("--------------------------------");
		}
		
	}

	public ComponentRiver getTributaries(int i) {
		return rivers.get(i);
	}


}
