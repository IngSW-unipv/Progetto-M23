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
		ResultSet rs1, rs2;
		
		Statement st2;
	
		try{
			
			st1 = conn.createStatement();
			String query="select * from prenotazione where DataPrenotazione = '2023-01-19'";
			rs1=st1.executeQuery(query);
			
			
			while(rs1.next()) {
				
				st2= conn.createStatement();
				String query1= "select * from donatore where CodiceFiscale ="+rs1.getString(1);
				rs2 = st2.executeQuery(query1);
				
				String grs = rs2.getString(6);
				GruppoSanguigno gr;
				gr = GruppoSanguigno.valueOf(grs);
				
				Donatore donat= new Donatore(rs2.getString(1), rs2.getString(2), rs2.getString(3), rs2.getDate(4), rs2.getString(5), gr);
				
				Prenotazione p= new Prenotazione(donat, rs1.getDate(2), rs1.getTime(3));
				result.add(p);
				
			}
		}
		
		
		catch (Exception e) {e.printStackTrace();
	    }
		
		JavaDatabaseConn.closeConnection(conn);
		
        return result;
   }
}