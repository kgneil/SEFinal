
public interface ComponentRiver {
	
	public String getRiverName();
	
	public double getRiverFlow();
	
	public double getDistanceTraveled();

	public void add(ComponentRiver river);
	
	public void print();
	
	public ComponentRiver getTributaries(int i);
	
}
