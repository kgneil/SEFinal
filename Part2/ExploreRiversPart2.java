import java.util.ArrayList;
import java.util.Scanner;
/**
 * ExploreRivers.java	A class used for collecting data of your exploration
 * 
 * @author Kelsey Neil
 */
public class ExploreRiversPart2 {
	
	//Private Fields
	private Scanner input;
	private double distanceTraveled;
    private double riverFlows;
	private String riverName;
    protected static ComponentRiver river;
    protected static ComponentRiver tribRiver;
    private ArrayList<ComponentRiver> rivers = new ArrayList<ComponentRiver>();
    CompositeRiver compositeRiver;
	private double tribRiverFlows;
	private double tribDistanceTraveled;
    
	/**
	 * Class constructor
	 */
	public ExploreRiversPart2(){
		input = new Scanner(System.in);
		System.out.println("You have found the mouth of a new river where it spills into the sea.  What do the natives call this river?");
        this.riverName = input.nextLine();
        retrieveFlow();
        retrieveMainRiver();
	}
	
	/**
	 * retreiveFlow()	Method for retreiving the river flow
	 */
	public void retrieveFlow(){
		while (true) {
			System.out.println("How much water is flowing?  (L/s)");
	        try {
	        	double newRiverFlows = Double.parseDouble(input.nextLine());
	        	if(this.riverFlows!=0 && newRiverFlows>this.riverFlows){
	        		System.out.println("The water flowing can not be greater than the overall flow!");
	        	} else{
	        		this.riverFlows= Math.abs(riverFlows-newRiverFlows);
	        		break;
	        	}
	        } catch (NumberFormatException e) {
	            System.out.println("I didn't understand that!");
	        }
		}
	}
	
	/**
	 * retreiveMainRiver()	Method for looping through and getting the other rivers
	 */
	public void retrieveMainRiver(){
        while (true) {
        	System.out.println("How far did you walk until you reached the next junction? (in km)");
            try {
            	this.distanceTraveled= Double.parseDouble(input.nextLine());
            	river = new ConcreteRiver(this.riverName, this.riverFlows, this.distanceTraveled);
            	
            	rivers.add(river);
            	compositeRiver = new CompositeRiver(river,river,rivers);
                river.add(river);
            } catch (NumberFormatException e) {
                System.out.println("I didn't understand that!");
                break;
            }
        	String end = isEnd();
        	if (end.equals("y")) {
        		System.out.println("Do you want to explore more of the Nile? (Y/n)");
        		if (input.nextLine().equalsIgnoreCase("y")){
        			retrieveMainRiver();
        		}
        		else{
	                System.out.println("Great!  We're done!");
	                //compositeRiver = new CompositeRiver(river,river);
	                compositeRiver.print();
	                //river.print();
	                break;	
        		}
            } else {
                System.out.println("That means you must be at another confluence.  What is the name the locals have given the river flowing into this one?");
                this.riverName = input.nextLine();
                
                retrieveFlow();
                mainOrTrib();
                	
            }
            
        }
	}

		
	
	private void mainOrTrib() {
		System.out.println("Are you continuing up the main river or up the tributary?  (M/t)");
		String MorT= input.nextLine();
		if(MorT.equals("t")){
			getTributary();
		}
		else{
			retrieveMainRiver();
		}
		
	}

	private void getTributary() {
		while (true) {
        	System.out.println("How far did you walk until you reached the next junction? (in km)");
            try {
            	this.tribDistanceTraveled= Double.parseDouble(input.nextLine());
            	tribRiver = new ConcreteRiver(this.riverName, this.tribRiverFlows, this.tribDistanceTraveled);
            	//rivers.add(river);
            	compositeRiver = new CompositeRiver(river,tribRiver,rivers);
                river.add(river);
            } catch (NumberFormatException e) {
                System.out.println("I didn't understand that!");
                break;
            }
        	String end = isEnd();
        	if (end.equals("y")) {
        		System.out.println("Do you want to explore more of the main river? y/n");
        		String endish=input.nextLine();
        		if (end.equals("y")) {
        			retrieveMainRiver();
        		}
        		else{
        			System.out.println("Great!  We're done!");
                    //compositeRiver = new CompositeRiver(river,river);
                    compositeRiver.print();
        		}
            } else {
            	System.out.println("That means you must be at another confluence.  What is the name the locals have given the river flowing into this one?");
                this.riverName = input.nextLine();
                
                
                while (true) {
        			System.out.println("How much water is flowing from that tributary into the main river?  (L/s)");
        	        try {
        	        	double newRiverFlows = Double.parseDouble(input.nextLine());
        	        		this.tribRiverFlows= Math.abs(tribRiverFlows-newRiverFlows);
        	        		break;
        	        	}
        	         catch (NumberFormatException e) {
        	            System.out.println("I didn't understand that!");
        	        }
        		}
                mainOrTrib();
            }
		}
		
	}

	/**
	 * isEnd()	Method called to see if the person reached the end
	 * 
	 * @return boolean
	 */
	public String isEnd(){
		System.out.println("Did you reach the end of your travels? (y/N)");
        return input.nextLine();
	}
	
	/**
	 * Unit Testing
	 */
	public static void main(String[] args) {
    	ExploreRiversPart2 er = new ExploreRiversPart2();
    }
	
	
}