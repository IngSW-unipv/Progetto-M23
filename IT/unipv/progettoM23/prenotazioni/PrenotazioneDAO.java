package IT.unipv.progettoM23.prenotazioni;

import java.sql.Connection;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.sql.Date;
import java.sql.Driver;
import java.sql.PreparedStatement;

import IT.unipv.progettoM23.database.JavaDatabaseConn;
import IT.unipv.progettoM23.persona.Donatore;
import IT.unipv.progettoM23.persona.DonatoreDAO;
import IT.unipv.progettoM23.persona.GruppoSanguigno;
 	 

public class PrenotazioneDAO implements IPrenotazioneDAO {
	
	private String schema;
	private Connection conn;

	
	public PrenotazioneDAO () 
	{
		super();
		this.schema = "dop";
	}
	
	
	public ArrayList<Prenotazione> selectDate(Date data){
		ArrayList<Prenotazione> result = new ArrayList<>(10);
		
		conn = JavaDatabaseConn.startConnection(conn, schema);
		Statement st1;
		ResultSet rs1;
		
	
           try{
			
			st1 = conn.createStatement();
			String query="select * from prenotazione where DataPrenotazione='"+data+"'"+"order by OraPrenotazione ASC" ;
			rs1=st1.executeQuery(query);
			
			
			while(rs1.next()) {
			
				Prenotazione p= new Prenotazione(rs1.getString(1), rs1.getDate(2), rs1.getTime(3));
				result.add(p);
			}
           }
		
		
		catch (Exception e) {e.printStackTrace();
	    }
		
		JavaDatabaseConn.closeConnection(conn);
		
        return result;
			
           
	}
	
	public void  inserisciPrenotazione(Prenotazione p){
		
		conn = JavaDatabaseConn.startConnection(conn, schema);
		Statement st1;

		
		try{
			
			st1 = conn.createStatement();
			
			String query="Insert into Prenotazione values ('"+p.getCodiceFiscale()+"','"
			+p.getData()+"','"+p.getOra()+"')";
			
			st1.executeUpdate(query);
			
			System.out.println("Data inserted successfully");
		}
		
		
		
		
		catch (Exception e) {e.printStackTrace();
	    }
		
		JavaDatabaseConn.closeConnection(conn);
		
       
   }
	

	public Prenotazione selectUltimaPrenotazione(String cf){
		Prenotazione result = null;
		conn = JavaDatabaseConn.startConnection(conn, schema);
		Statement st1;
		ResultSet rs1;
		
	
        try{
			
			st1 = conn.createStatement();
			String query="select * from prenotazione where CodiceFiscale='"+cf+"'"+"order by DataPrenotazione DESC" ;
			rs1=st1.executeQuery(query);
			
			
			rs1.next(); 
			
			Prenotazione p = new Prenotazione(rs1.getString(1), rs1.getDate(2), rs1.getTime(3));
			result = p;
		}
		
		
		catch (Exception e) {
			return null;
	    }
		
		JavaDatabaseConn.closeConnection(conn);
		
        return result;
	
    }
	
	
	
	public String[][] getArrayPrenotazioni(Date data) {
	
	
		String[][] result = new String[10][2];
		
		conn = JavaDatabaseConn.startConnection(conn, schema);
		Statement st1;
		ResultSet rs1;
		
	
           try{
			
			st1 = conn.createStatement();
			String query="select * from prenotazione where DataPrenotazione='"+data+"'" ;
			rs1=st1.executeQuery(query);
			
			int count=0;
			
			while(rs1.next()) {
			
				String[] p= {rs1.getString(1), String.valueOf(rs1.getTime(3))};
				result[count]=p;
				count++;
			}
           }
		
		
		catch (Exception e) {e.printStackTrace();
	    }
		
		JavaDatabaseConn.closeConnection(conn);
		
        return result;
			           
		
	}
	

public void  cancellaPrenotazione(Prenotazione p){
		
		conn = JavaDatabaseConn.startConnection(conn, schema);
		PreparedStatement st1;


		try{
			
			String query="Delete prenotazione from prenotazione where CodiceFiscale = ? and DataPrenotazione = ?";
			st1 = conn.prepareStatement(query);
			
            st1.setString(1, p.getCodiceFiscale());
            st1.setDate(2, p.getData() );
			
			st1.executeUpdate();
			
		}
		
		
		
		
		catch (Exception e) {e.printStackTrace();
	    }
		
		JavaDatabaseConn.closeConnection(conn);
		
       
   }
	
public Prenotazione selectUltimaPrenGiorno(Date data) {
	
	
	Prenotazione result;
	
	conn = JavaDatabaseConn.startConnection(conn, schema);
	PreparedStatement st1;
	ResultSet rs1;
	
	

       try{
    	   
    	String query="select * from prenotazione where DataPrenotazione= ? order by OraPrenotazione DESC" ;
		st1 = conn.prepareStatement(query);
		st1.setDate(1, data);
		
		rs1=st1.executeQuery();
		
		rs1.next();
		
		result = new Prenotazione(rs1.getString(1), rs1.getDate(2), rs1.getTime(3));
       }
	
	
	catch (Exception e) {result = null;
    }
	
	JavaDatabaseConn.closeConnection(conn);
	
    return result;
		           
	
}

public Prenotazione selectPrimaPrenGiorno(Date data) {
	
	
	Prenotazione result;
	
	conn = JavaDatabaseConn.startConnection(conn, schema);
	PreparedStatement st1;
	ResultSet rs1;
	
	

       try{
    	   
    	String query="select * from prenotazione where DataPrenotazione= ? order by OraPrenotazione ASC" ;
		st1 = conn.prepareStatement(query);
		st1.setDate(1, data);
		
		rs1=st1.executeQuery();
		
		rs1.next();
		
		result = new Prenotazione(rs1.getString(1), rs1.getDate(2), rs1.getTime(3));
       }
	
	
	catch (Exception e) {result = null;
    }
	
	JavaDatabaseConn.closeConnection(conn);
	
    return result;
		           
	
}
}


