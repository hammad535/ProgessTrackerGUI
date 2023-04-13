package Code;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
		static Connection c = null;
	    public static void connect() {

	        try {
	            Class.forName("org.postgresql.Driver");
	            c = DriverManager
	                    .getConnection("jdbc:postgresql://localhost:5432/ProgressTracker",
	                            "postgres", "root");
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.err.println(e.getClass().getName()+": "+e.getMessage());
	            System.exit(0);
	        }
	        System.out.println("Opened database successfully");
	    }



	}
