package IT.unipv.progettoM23.ospedale;

import java.sql.Connection;
import java.sql.Statement;

import IT.unipv.progettoM23.CentroNazionaleSangue.Donazione;
import IT.unipv.progettoM23.database.JavaDatabaseConn;

public class RichiestaSaccaDAO implements IRichiestaSaccaDAO {
	
	private String schema;
	private Connection conn;
	
	public RichiestaSaccaDAO() 
	{
		super();
		this.schema = "dop";
	}

	public void inserisciRichiesta(RichiestaSacca rd) {
		conn = JavaDatabaseConn.startConnection(conn, schema);
		Statement st1;

		
		try{
			
			st1 = conn.createStatement();
			
			
			String query="Insert into Donazione values ('"+rd.getCodiceFiscale()+"','"+
	        rd.getGruppo()+"','"+rd.getQuantità()+ "','"+ rd.getEffettuato() +"')";
			
			st1.executeUpdate(query);
			
			System.out.println("Data inserted successfully");
		}
		
		
		
		
		catch (Exception e) {e.printStackTrace();
	    }
		
		JavaDatabaseConn.closeConnection(conn);
		
	}
	

}
