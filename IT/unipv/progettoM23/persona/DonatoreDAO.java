package IT.unipv.progettoM23.persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.SQLException;
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
	
	
	
	public ArrayList<Donatore> selectAll() throws SQLException{
		ArrayList<Donatore> result = new ArrayList<>();
		conn = JavaDatabaseConn.startConnection(conn, schema);
		Statement st1;
		ResultSet rs1;
		
		try{
			
			st1 = conn.createStatement();
			String query="select * from donatore";
			rs1=st1.executeQuery(query);
			
		    while(rs1.next())
		    {
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
	
	
	
	public Donatore selectDonatore(String cf) {
		//ArrayList<Donatore> result = new ArrayList<>();
		conn = JavaDatabaseConn.startConnection(conn, schema);
		PreparedStatement st1;
		ResultSet rs1;
		Donatore d= null;
		try{
			
			
			String query="select * from donatore where CodiceFiscale=?";
			st1 = conn.prepareStatement(query);
			st1.setString(1, cf);
			
			rs1=st1.executeQuery();
			
			rs1.next();
	        String grs = rs1.getString(6);
			GruppoSanguigno gr;
			gr = GruppoSanguigno.valueOf(grs);
				
			d= new Donatore(rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getDate(4), rs1.getString(5), gr);
			 
			
			
		}
		
		
		
		
		catch (Exception e) {e.printStackTrace();
	    }
		
		JavaDatabaseConn.closeConnection(conn);
		
        return d;
        
        
     }
	
	public boolean inserisciDonatore(Donatore d){
		
		conn = JavaDatabaseConn.startConnection(conn, schema);
		PreparedStatement st1;
		boolean b = false;

		
		try{
			
			
			String query="Insert into donatore values (?,?,?,?,?,?)";
			
			st1 = conn.prepareStatement(query);
			st1.setString(1, d.getcodFiscale());
			st1.setString(2, d.getCognome());
			st1.setString(3, d.getNome());
			st1.setDate(4, d.getData());
			st1.setString(5, d.getSesso());
			
			String gruppo = String.valueOf(d.getGruppo());
			st1.setString(6, gruppo);
			
			
			
			st1.executeUpdate();
			
			b = true;
		}
		
		
		
		
		catch (Exception e) {
			b = false;
	    }
		
		JavaDatabaseConn.closeConnection(conn);
		
    return b;   
   }
	
	

	

		
   }
	
	
	
	
	


