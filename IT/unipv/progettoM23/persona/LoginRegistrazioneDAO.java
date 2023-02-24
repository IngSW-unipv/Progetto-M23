package IT.unipv.progettoM23.persona;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import IT.unipv.progettoM23.database.JavaDatabaseConn;

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
		Statement st1;
		ResultSet rs1;
		boolean b = false;
//		LoginRegistrazione lr1;
		try{
			
			st1 = conn.createStatement();
			String query="select * from log_reg where CodiceFiscale="+"'"+lr.getCodiceFiscale()+"'"+
			"and password="+"'"+lr.getPassword()+"'";
			
			rs1=st1.executeQuery(query);
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
		Statement st1;
		ResultSet rs1;
		Boolean b = false;
//		LoginRegistrazione lr1 = null;
		try{
			
			st1 = conn.createStatement();
			String query="select * from log_reg where CodiceFiscale="+"'"+cf+"'";
			
			rs1=st1.executeQuery(query);
			rs1.next();
			
			rs1.getString(1);
			rs1.getString(2);
			b = true;
			
			
						
		}
		
		
	
		catch (Exception e) { 
		//e.printStackTrace();
			b=false;
	    }
		
		JavaDatabaseConn.closeConnection(conn);
		
         return b;
   }
	
	
	
	public boolean inserisciUtente(LoginRegistrazione lr){
	
		conn = JavaDatabaseConn.startConnection(conn, schema);
		Statement st1;
		boolean b = false;

		
		try{
			
			st1 = conn.createStatement();
			
			
			
			String query="Insert into log_reg values ('"+lr.getCodiceFiscale()+"','"
			+lr.getPassword()+"')";
			
			st1.executeUpdate(query);
			
			b = true;
		}
		
		
		
		
		catch (Exception e) {
			b = false;
			//e.printStackTrace();
	    }
		
		JavaDatabaseConn.closeConnection(conn);
		
    return b;   
   }
	
}
