package dbconn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	static final String URL="jdbc:mysql://localhost:3306/";
	static final String DATABASE_NAME="travelagency";
	static final String USERNAME="root";
	static final String PASSWORD="root";
	static final String PARAMS = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	public static Connection getConnection(){
		Connection con=null;
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(URL+DATABASE_NAME + PARAMS,USERNAME,PASSWORD);
 
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return con;
	}
}
