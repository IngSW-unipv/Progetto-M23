package IT.unipv.progettoM23.prenotazioni;

import java.sql.Connection;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.sql.Date;
import java.sql.Driver;

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
		ArrayList<Prenotazione> result = new ArrayList<>();
		conn = JavaDatabaseConn.startConnection(conn, schema);
		Statement st1;
		ResultSet rs1;
		
	
           try{
			
			st1 = conn.createStatement();
			String query="select * from prenotazione where DataPrenotazione='"+data+"'" ;
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
		
		
		catch (Exception e) {e.printStackTrace();
	    }
		
		JavaDatabaseConn.closeConnection(conn);
		
        return result;
	
    }
	
	
	
	public String[][] getArrayPrenotazioni(Date data) {
	
	
		ArrayList<String[]> result = new ArrayList<>();
		
		conn = JavaDatabaseConn.startConnection(conn, schema);
		Statement st1;
		ResultSet rs1;
		
	
           try{
			
			st1 = conn.createStatement();
			String query="select * from prenotazione where DataPrenotazione='"+data+"'" ;
			rs1=st1.executeQuery(query);
			
			
			while(rs1.next()) {
			
				String[] p= {rs1.getString(1), String.valueOf(rs1.getTime(3))};
				result.add(p);
			}
           }
		
		
		catch (Exception e) {e.printStackTrace();
	    }
		
		JavaDatabaseConn.closeConnection(conn);
		
        return (String[][]) result.toArray() ;
			           
		
	}
	
}


