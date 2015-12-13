import java.util.ArrayList;
import java.util.Scanner;

public class ExploreRivers {
	
	private Scanner input;
	private double distanceTraveled;
    private double RiverNames;
    private double riverFlows;
	private String riverName;
    protected static ComponentRiver river;
    private ArrayList<ComponentRiver> rivers = new ArrayList<ComponentRiver>();
    CompositeRiver compositeRiver;
    
    
	public ExploreRivers(){
		input = new Scanner(System.in);
		
		System.out.println("You have found the mouth of a new river where it spills into the sea.  What do the natives call this river?");
        String riverName = input.nextLine();
        
        //measure the amount of flow
        retrieveFlow();
        
        river = new ConcreteRiver(riverName, riverFlows, 0);
        //Add to the arraylist
        rivers.add(river);
        //add river to comonent river
        river.add(river);
        
        retrieveTributary();
        //river.print();

	}
	
	public void retrieveFlow(){
		while (true) {
			System.out.println("How much water is flowing?  (L/s)");
	        try {
	            Double newRiverFlows = Double.parseDouble(input.nextLine());
	            this.riverFlows = Math.abs(this.riverFlows - newRiverFlows);
	            break;
	        } catch (NumberFormatException e) {
	            System.out.println("I didn't understand that!");
	        }
		}
	}
	
	
	public void retrieveTributary(){
        while (true) {
        	System.out.println("How far did you walk until you reached the next junction? (in km)");
            try {
                Double newDistance= Double.parseDouble(input.nextLine());
                this.distanceTraveled = this.distanceTraveled+newDistance;
            } catch (NumberFormatException e) {
                System.out.println("I didn't understand that!");
                break;
            }
        	String end = isEnd();
        	if (end.equals("y")) {
                System.out.println("Great!  We're done!");
                compositeRiver = new CompositeRiver(rivers);
                compositeRiver.print();
                //river.print();
                break;	
            } else {
                System.out.println("That means you must be at another confluence.  What is the name the locals have given the river flowing into this one?");
                this.riverName = input.nextLine();
                
                retrieveFlow();
                
                river = new ConcreteRiver(this.riverName, this.riverFlows, this.distanceTraveled);
                rivers.add(river);
                river.add(river);
            }
            
        }
	}
	
	public String isEnd(){
		System.out.println("Did you reach the end of your travels? (y/N)");
        return input.nextLine();
	}
	
	
	public static void main(String[] args) {
    	ExploreRivers er = new ExploreRivers();
    }
	
	
}