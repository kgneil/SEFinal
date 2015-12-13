
public class ConcreteRiver implements ComponentRiver{
	
	//Private fields
	private String riverName;
	private double riverFlow;
	private double distanceTraveled;
	protected CompositeRiver compositeRiver;
	
	public ConcreteRiver(String riverName, double riverFlow, double distanceTraveled){
		super();
		this.riverName = riverName;
		this.riverFlow = riverFlow;
		this.distanceTraveled = distanceTraveled;
	}
	
	public void attachCompositeGame(CompositeRiver newCR) {
		this.compositeRiver = newCR;
	}
	
	
	public String getRiverName() {
		return this.riverName;
	}

	public double getRiverFlow() {
		
		return this.riverFlow;
	}

	public double getDistanceTraveled() {
		return this.distanceTraveled;
	}
	
	
	

	public void setDistanceTraveled(double distanceTraveled) {
		this.distanceTraveled = distanceTraveled;
	}

	public void setRiverName(String riverName) {
		this.riverName = riverName;
	}

	public void setRiverFlow(double riverFlow) {
		this.riverFlow = riverFlow;
	}

	public void add(ComponentRiver river) {
		//No need!
	}

	public void print() {
		
		System.out.println("Name: "+getRiverName());
		System.out.println("Flow: "+getRiverFlow());
		System.out.println("Distance: "+getDistanceTraveled());

		
	}


	public ComponentRiver getTributaries(int i) {
		//This doesnt have anything yet
		return null;
	}

}
