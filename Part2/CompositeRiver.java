import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;


/**
 * CompositeRiver.java	A class used for finding information out about your exploration
 * 
 * @author Kelsey Neil
 */
public class CompositeRiver implements ComponentRiver{
	
	private String riverName;
	private double riverTotalFlow;
	private double totalDistanceTraveled;
	private ArrayList<ComponentRiver> rivers = new ArrayList<ComponentRiver>();
	private ComponentRiver right;
	private ComponentRiver left;
	private List<ComponentRiver> list;
	
	
	/**
	 * Class constructor
	 * 
	 * @param rivers	ArrayList of rivers
	 */
	public CompositeRiver (ComponentRiver left, ComponentRiver right, ArrayList<ComponentRiver> rivers){
		this.left = left;
		this.right = right; 
		this.rivers = rivers;
		
	}
	

	/**
	 * toList()					method to create list of component rivers
	 * 
	 * @return list				ArrayList of list of rivers
	 */
	public List<ComponentRiver> toList(){
		list = this.left.toList();
		list.addAll(this.right.toList());
		list.add(this);
		return list;
	}
	
	/**
	 * Adds river to the arraylist of rivers
	 * 
	 * @return rivers 	ArrayList of ComponentRiver
	 */
	public ArrayList<ComponentRiver> getRiverList() {
		return rivers;
	}
	
	/**
	 * Adds river to the ArrayList of rivers
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
	public double getTotalRiverFlow() {
		int i = 0;
		for (ComponentRiver river: rivers) {
			if(i==0){
				this.riverTotalFlow=river.getRiverFlow();
			}
			else{
				this.riverTotalFlow=riverTotalFlow-river.getRiverFlow();
			}
			i++;
		}
		return this.riverTotalFlow;
	}
	
	/**
	 * getDistanceTraveled()		returns a double of distanced traveled
	 * 
	 * @return distanceTraveled		Double of distanced Traveled
	 */
	public double getTotalDistanceTraveled() {
		for (ComponentRiver river: rivers) {
			this.totalDistanceTraveled= this.totalDistanceTraveled+ river.getDistanceTraveled();
		}
		return this.totalDistanceTraveled;
	}

	/**
	 * print() prints the information of each river
	 */
	public void print() {		
		System.out.println("You have now explored the "+rivers.get(0).getRiverName() );
		System.out.println("The river is at least "+((int)this.getTotalDistanceTraveled())+ " km long");
		System.out.println("From the furthest distance we explored: ");
		for(int i=(rivers.size()-1); i>=0; i--){
			rivers.get(i).print();
			if(i==0){
				System.out.println("Then, the "+rivers.get(i).getRiverName()+" flows into the sea.");
			} else{
				System.out.println("Then, the "+rivers.get(i).getRiverName()+" flows into the river.");
			}
		}
		
	}
	
	//Not used!
	public ComponentRiver getTributaries(int i) {
		return rivers.get(i);
	}
	
	/**
	 * getDistanceTraveled() 	method for geting the distanceTraveled
	 */
	public double getDistanceTraveled() {
		return 0;
	}
	
	/**
	 * getRiverFlow() 	method for getting the river flow
	 */
	public double getRiverFlow() {
		return 0;
	}


}
