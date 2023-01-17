package DataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Driver;


public class JavaDatabaseConn {
	
	public static Connection startConnection(Connection conn, String schema){
		
        String DbDriver=null;
		String DbURL=null;
		String username=null;
		String password=null;
	
		DbDriver= "com.mysql.jdbc.Driver";
		DbURL= "jdbc:mysql://localhost:3306/"+schema;
		username="root";
		password ="JavaDOP123";
		
		
		if (isOpen(conn)) {
			closeConnection(conn);
		}
		
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(DbURL, username, password);
			
		}
		
		
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
		return conn;
		
	}
	
	
	
	
		
	public static boolean isOpen(Connection conn)
		{
			if (conn == null)
				return false;
			else return true;
		}
		
	
	
	
	
	public static Connection closeConnection(Connection conn){
	    	
		if (!isOpen(conn)) {
			return null;
		}
		try
		{
			conn.close();
			conn = null;
			
		}
		catch (SQLException e)
		{
		 e.printStackTrace();
		 return null;
		}
		return conn;
		}
	}
	
