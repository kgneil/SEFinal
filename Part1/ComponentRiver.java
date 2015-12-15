/**
 * ComponentRiver.java	An Interface used for the exploration of rivers
 * 
 * @author Kelsey Neil
 */
public interface ComponentRiver {
		
	public double getDistanceTraveled();

	public void add(ComponentRiver river);
	
	public void print();
	
	public double getRiverFlow();

	public String getRiverName();

}
