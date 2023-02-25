package IT.unipv.progettoM23.ospedale;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
			
			
			String query="Insert into richiesta values ('"+rd.getCodiceFiscale()+"','"+
	        rd.getGruppo1()+"','"+rd.getQuantità()+ "','NON EFFETTUATO')";
			
			st1.executeUpdate(query);
			
			System.out.println("Data inserted successfully");
			
			JavaDatabaseConn.closeConnection(conn);
		}
		
		
		catch (Exception e) {e.printStackTrace();
	    }
		
		JavaDatabaseConn.closeConnection(conn);
		
	}
	
	
	
	
	
	public String[][] getArrayRichieste() {
		
		
		ArrayList<String[]> result =new ArrayList<>();
		//String[][] result ;
		
		conn = JavaDatabaseConn.startConnection(conn, schema);
		Statement st1;
		ResultSet rs1;
		
	
           try{
			
		       st1 = conn.createStatement();
			   String query="select * from richiesta where EffettuatoONo='EFFETTUATO'" ;
			   rs1=st1.executeQuery(query);
		
			
			   while(rs1.next()) {
			
				   String[] p= {rs1.getString(1), rs1.getString(2),String.valueOf(rs1.getInt(3))};
				   result.add(p);
			   }
           }
		
		
		catch (Exception e) {e.printStackTrace();
	    }
		
		JavaDatabaseConn.closeConnection(conn);
		
		
        return result.toArray(new String[result.size()][3]);
			           
		
	}
	

}
