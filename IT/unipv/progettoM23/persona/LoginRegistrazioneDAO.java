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

	public void verificaUtente(LoginRegistrazione lr){
		
		conn = JavaDatabaseConn.startConnection(conn, schema);
		Statement st1;
		ResultSet rs1;
		//String b = null;
		LoginRegistrazione lr1;
		try{
			
			st1 = conn.createStatement();
			String query="select * from log_reg where CodiceFiscale="+"'"+lr.getCodiceFiscale()+"'"+
			"and password="+"'"+lr.getPassword()+"'";
			
			rs1=st1.executeQuery(query);
			rs1.next();
			lr1= new LoginRegistrazione(rs1.getString(1), rs1.getString(2));
			
			System.out.println("Utente Verificato");
						
		}
		
		
	
		catch (Exception e) { 
			e.printStackTrace();
	    }
		
		JavaDatabaseConn.closeConnection(conn);
		
        // return b;
   }
	
	
	
	
	public void inserisciUtente(LoginRegistrazione lr){
	
		conn = JavaDatabaseConn.startConnection(conn, schema);
		Statement st1;

		
		try{
			
			st1 = conn.createStatement();
			
			
			
			String query="Insert into log_reg values ('"+lr.getCodiceFiscale()+"','"
			+lr.getPassword()+"')";
			
			st1.executeUpdate(query);
			
			System.out.println("Data inserted successfully");
		}
		
		
		
		
		catch (Exception e) {e.printStackTrace();
	    }
		
		JavaDatabaseConn.closeConnection(conn);
		
       
   }
}
