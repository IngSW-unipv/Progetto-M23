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
	Date data;
	
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
		this.data=data;
	
           try{
			
			st1 = conn.createStatement();
			String query="select * from prenotazione where DataPrenotazione='2023-01-01'" ;
			rs1=st1.executeQuery(query);
			
			
			while(rs1.next()) {
				
				
				//	st2 = conn.createStatement();
				//	DonatoreDAO d1 = new DonatoreDAO();
				//	Donatore d2;
				//	d2= d1.selectDonatore(rs1.getString(1));
					
				

				
				Prenotazione p= new Prenotazione(rs1.getString(1), rs1.getDate(2), rs1.getTime(3));
				result.add(p);
				
			
				
			
			}
           }
		
		
		catch (Exception e) {e.printStackTrace();
	    }
		
		JavaDatabaseConn.closeConnection(conn);
		
        return result;
			
           
	}
	
	

	
}


