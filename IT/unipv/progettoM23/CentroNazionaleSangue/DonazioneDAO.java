package IT.unipv.progettoM23.CentroNazionaleSangue;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import IT.unipv.progettoM23.database.JavaDatabaseConn;
import IT.unipv.progettoM23.persona.Donatore;
import IT.unipv.progettoM23.persona.GruppoSanguigno;

public class DonazioneDAO implements IDonazioneDAO{
	private String schema;
	private Connection conn;
	
	public DonazioneDAO () 
	{
		super();
		this.schema = "dop";
	}

	public void inserisciDonazione(Donazione d) {
		conn = JavaDatabaseConn.startConnection(conn, schema);
		Statement st1;

		
		try{
			
			st1 = conn.createStatement();
			
			
			String query="Insert into Donazione values ('"+d.getCodiceFiscale()+"','"+
	        d.getData() +"')";
			
			st1.executeUpdate(query);
			
			System.out.println("Data inserted successfully");
		}
		
		
		
		
		catch (Exception e) {e.printStackTrace();
	    }
		
		JavaDatabaseConn.closeConnection(conn);
		
	}
	
	public ArrayList<Donazione> selectDonazioni(String cf){
		ArrayList<Donazione> result = new ArrayList<>();
		conn = JavaDatabaseConn.startConnection(conn, schema);
		Statement st1;
		ResultSet rs1;
		
		try{
			
			st1 = conn.createStatement();
			String query="select * from donazione where CodiceFiscale='"+cf+"'"+"order by DataDonazione DESC";
			rs1=st1.executeQuery(query);
			
		    while(rs1.next())
		    {
			
				
				Donazione d= new Donazione(rs1.getString(1), rs1.getDate(2));
				result.add(d);
				
			}
		}
		
		
		
		
		catch (Exception e) {e.printStackTrace();
	    }
		
		JavaDatabaseConn.closeConnection(conn);
		
        return result;
   }

	
	
	
	
	
//
}
