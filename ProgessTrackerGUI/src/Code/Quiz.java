package Code;

import java.sql.SQLException;
import java.util.ArrayList;

public class Quiz {

	String quizId,quizName;
	
	static ArrayList<Quiz> tasks=new ArrayList<>();
	static ArrayList<Quiz> completedTasks = new ArrayList<>();

	public Quiz(String quizId, String quizName) {
		super();
		this.quizId = quizId;
		this.quizName = quizName;
	}

	public static boolean completeTask(String taskName) throws SQLException{
    	
    	for(int i=0;i<Quiz.tasks.size();i++) {
    		if(Quiz.tasks.get(i).quizName.equalsIgnoreCase(taskName)) {
    			PersonalProfile.incrementForTaskCompletion();
    			completedTasks.add(Quiz.tasks.get(i));
    			tasks.remove(i);		//remove it from unCompleted tasks               
                
    			DBOperations.deleteQuizesData();
                DBOperations.deleteCompletedQuizesData();
                DBOperations.writeCompletedQuizes();                
                DBOperations.writeQuizes();
                
                return true;
    		}
    	}
    	
    	return false;
    }
	
	
	
	public static  boolean deleteTask(String taskName) throws SQLException{
    	
    	for(int i=0;i<Quiz.tasks.size();i++) {
    		if(Quiz.tasks.get(i).quizName.equalsIgnoreCase(taskName)) {
    			
    			tasks.remove(i);		//remove it from unCompleted tasks
                DBOperations.deleteQuizesData();         
                DBOperations.writeQuizes();
                return true;
    		}
    	}
    	
    	return false;
    }
	
	public static  boolean addTask(String taskName) throws SQLException{
    	
    	int index=Quiz.tasks.size();
    	Quiz.tasks.add(new Quiz(""+index+1,taskName));
    	DBOperations.deleteQuizesData();         
        DBOperations.writeQuizes();    	
    	return true;
    }
	
}
