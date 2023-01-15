package DataBase;
import java.sql.Connection;
import java.sql.SQLException;


public class JavaDatabaseConn {
	public static Connection startConnection(Connection conn, String schema)
	{
	String DbDrvier=null;
	String DbURL=null;
	String username=null;
	String password=null;
	
	DbDriver= "com.mysql.jdbc.Driver";
	DbURL= "jdbc:mysql://localhost:3306/"+javadop;
	username="root";
	password ="JavaDOP123";
	if (isOpen(conn))
		closeConncection(conn);
	try 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConne(DbURL, username, password);
		
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
public static Connection cloceConnection(Connection conn)
{
	if (!isOPen(conn))
		return null;
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

