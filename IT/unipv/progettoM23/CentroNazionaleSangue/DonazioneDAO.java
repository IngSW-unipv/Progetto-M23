package IT.unipv.progettoM23.CentroNazionaleSangue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import IT.unipv.progettoM23.database.JavaDatabaseConn;
import IT.unipv.progettoM23.persona.Donatore;


public class DonazioneDAO implements IDonazioneDAO{
	private String schema;
	private Connection conn;
	
	public DonazioneDAO () 
	{
		super();
		this.schema = "dop";
	}

	public boolean inserisciDonazione(Donazione d) {
		conn = JavaDatabaseConn.startConnection(conn, schema);
		PreparedStatement st1;

		
		try{
			
			

			
			
			String query="Insert into Donazione values (?,?)";
			st1 = conn.prepareStatement(query);
			
			st1.setString(1, d.getCodiceFiscale());
			st1.setDate(2, d.getData());
			
			st1.executeUpdate();
			
			JavaDatabaseConn.closeConnection(conn);
			
			return true;
		}
		
		
		
		
		catch (Exception e) {
			
			JavaDatabaseConn.closeConnection(conn);
			return false;
	    }
		
	}
	
	
	
	
	public ArrayList<Donazione> selectDonazioni(String cf){
		ArrayList<Donazione> result = new ArrayList<>();
		conn = JavaDatabaseConn.startConnection(conn, schema);
		PreparedStatement st1;
		ResultSet rs1;
		
		try{
			
			
			String query="select * from donazione where CodiceFiscale= ? order by DataDonazione DESC";
			st1 = conn.prepareStatement(query);
			
			st1.setString(1, cf);
			
			rs1=st1.executeQuery();
			
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

	public Donazione selectUltimaDonazione(Donatore d) {
		conn = JavaDatabaseConn.startConnection(conn, schema);
		PreparedStatement st1;
		ResultSet rs1;
		Donazione d1=null;

		
		try{
			
		
			
			
			String query="select * from donazione where CodiceFiscale = ? order by DataDonazione desc";
			
			st1 = conn.prepareStatement(query);
			
			st1.setString(1, d.getcodFiscale());
			
			rs1 = st1.executeQuery();
			rs1.next();
			
			
			d1 = new Donazione(rs1.getString(1), rs1.getDate(2));
		}
		
		
		
		
		catch (Exception e) {
			return null;
	    }
		
		JavaDatabaseConn.closeConnection(conn);
		
		return d1;
		
	}
	
	
	
	
//
}

