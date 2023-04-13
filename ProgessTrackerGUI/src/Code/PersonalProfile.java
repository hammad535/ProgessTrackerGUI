package Code;

import java.util.ArrayList;

public class PersonalProfile {

	static ArrayList<String> tasks = new ArrayList<String>();		//to hold all uncompleted tasks
    static ArrayList<String> completedTasks = new ArrayList<String>();	//to hold all completed tasks
    static int progress = 1;
    static int points = 0;
    
    static int[] levelThresholds = {0, 100, 150, 200, 250, 300};
    
   
    
    public static void incrementForTaskCompletion() { 	
    	points += 15;   //increment points
       
        
        for (int i = 1; i < levelThresholds.length; i++) {
            if (progress >= levelThresholds[i]) {			//This code checks for the progress that if it has crossed
            	progress = i + 1;						//and threshold, then promote his level
            } else {
                break; // break the loop to stop searching if not such thing
            }
        }
    
    }
	
}
