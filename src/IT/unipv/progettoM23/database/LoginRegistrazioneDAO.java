package IT.unipv.progettoM23.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import IT.unipv.progettoM23.Model.persona.LoginRegistrazione;

public class LoginRegistrazioneDAO implements ILoginRegistrazineDAO  {
	private String schema;
	private Connection conn;
	
	public LoginRegistrazioneDAO () 
	{
		super();
		this.schema = "dop";
	}

	public boolean verificaUtente(LoginRegistrazione lr){
		
		conn = JavaDatabaseConn.startConnection(conn, schema);
		PreparedStatement st1;
		ResultSet rs1;
		boolean b = false;
		
		
		try{
			
			
			String query="select * from log_reg where CodiceFiscale=? and password=? ";
			
			st1 = conn.prepareStatement(query);
			
			st1.setString(1, lr.getCodiceFiscale());
			st1.setString(2, lr.getPassword());
			
			rs1=st1.executeQuery();
			
			rs1.next();
			rs1.getString(1); 
			rs1.getString(2);
			b=true;
			
						
		}
		
		catch (Exception e) { 
			b=false;
	    }
		
		JavaDatabaseConn.closeConnection(conn);
		
         return b;
   }
	
	
	
	public boolean verificaCodiceFiscale(String cf){
		
		conn = JavaDatabaseConn.startConnection(conn, schema);
		PreparedStatement st1;
		ResultSet rs1;
		Boolean b = false;

		try{
			
			
			String query="select * from log_reg where CodiceFiscale=?";
			
			st1 = conn.prepareStatement(query);
			
			st1.setString(1, cf);
			
			rs1=st1.executeQuery();
			
			rs1.next();
			rs1.getString(1);
			rs1.getString(2);
			b = true;
			
			
						
		}
		
		
	
		catch (Exception e) { 

			b=false;
	    }
		
		JavaDatabaseConn.closeConnection(conn);
		
         return b;
   }
	
	
	
	public boolean inserisciUtente(LoginRegistrazione lr){
	
		conn = JavaDatabaseConn.startConnection(conn, schema);
		PreparedStatement st1;
		boolean b = false;

		
		try{
			
			
			
			
			
			String query="Insert into log_reg values (?,?)";
			
			st1 = conn.prepareStatement(query);
			
			st1.setString(1, lr.getCodiceFiscale());
			st1.setString(2, lr.getPassword());
			
			
			
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
