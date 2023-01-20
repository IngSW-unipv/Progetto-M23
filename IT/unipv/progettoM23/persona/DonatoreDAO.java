package IT.unipv.progettoM23.persona;
import java.sql.Connection;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.Statement;
//import java.time.LocalDate;
//import java.sql.Date;
//import java.sql.Driver;

import IT.unipv.progettoM23.database.JavaDatabaseConn;
 	 

public class DonatoreDAO implements IDonatoreDAO {
	
	private String schema;
	private Connection conn;
	
	public DonatoreDAO () 
	{
		super();
		this.schema = "dop";
	}
	
	
	public ArrayList<Donatore> selectAll(){
		ArrayList<Donatore> result = new ArrayList<>();
		conn = JavaDatabaseConn.startConnection(conn, schema);
		Statement st1;
		ResultSet rs1;
		
		try{
			
			st1 = conn.createStatement();
			String query="select * from donatore";
			rs1=st1.executeQuery(query);
			
			
			while(rs1.next()) {
				String grs = rs1.getString(6);
				GruppoSanguigno gr;
				gr = GruppoSanguigno.valueOf(grs);
				
				Donatore d= new Donatore(rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getDate(4), rs1.getString(5), gr);
				result.add(d);
				
			}
		}
		
		
		catch (Exception e) {e.printStackTrace();
	    }
		
		JavaDatabaseConn.closeConnection(conn);
		
        return result;
   }
}