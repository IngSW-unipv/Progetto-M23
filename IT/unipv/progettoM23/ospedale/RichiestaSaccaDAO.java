package IT.unipv.progettoM23.ospedale;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import IT.unipv.progettoM23.database.JavaDatabaseConn;
import IT.unipv.progettoM23.persona.GruppoSanguigno;


public class RichiestaSaccaDAO implements IRichiestaSaccaDAO {
	
	private String schema;
	private Connection conn;
	
	
	
	public RichiestaSaccaDAO() 
	{
		super();
		this.schema = "dop";
	}

	
	
	
	
	
	public void inserisciRichiesta(RichiestaSacca rd) {
		conn = JavaDatabaseConn.startConnection(conn, schema);
		Statement st1;

		
		try{
			
			st1 = conn.createStatement();
			
			
			String query="Insert into richiesta values ('"+rd.getCodiceFiscale()+"','"+
	        rd.getGruppo1()+"','"+rd.getQuantità()+ "','"+rd.getEffettuato()+"', '0')";
			
			st1.executeUpdate(query);
			
			System.out.println("Data inserted successfully");
			
			JavaDatabaseConn.closeConnection(conn);
		}
		
		
		catch (Exception e) {e.printStackTrace();
	    }
		
		JavaDatabaseConn.closeConnection(conn);
		
	}
	
	
	
	
	
	
	
	
	public String[][] getArrayRichieste() {
		
		
		ArrayList<String[]> result =new ArrayList<>();

		
		conn = JavaDatabaseConn.startConnection(conn, schema);
		Statement st1;
		ResultSet rs1;
		
	
           try{
			
		       st1 = conn.createStatement();
			   String query="select * from richiesta where EffettuatoONo='EFFETTUATO'" ;
			   rs1=st1.executeQuery(query);
		
			
			   while(rs1.next()) {
			
				   String[] p= {rs1.getString(1), rs1.getString(2),String.valueOf(rs1.getInt(3))};
				   result.add(p);
			   }
           }
		
		
		catch (Exception e) {e.printStackTrace();
	    }
		
		JavaDatabaseConn.closeConnection(conn);
		
		
        return result.toArray(new String[result.size()][3]);
			           
		
	}
	
	
	
	
	
	
	public ArrayList<RichiestaSacca> selectRichiesteNonEffettuate(){
		
		ArrayList<RichiestaSacca> result = new ArrayList<>();
		
		conn = JavaDatabaseConn.startConnection(conn, schema);
		Statement st1;
		ResultSet rs1;
		
	
           try{
			
			st1 = conn.createStatement();
			String query="select * from richiesta where EffettuatoONo='NON EFFETTUATO' order by NUMID ASC" ;
			rs1=st1.executeQuery(query);
			
			
			while(rs1.next()) {
			GruppoSanguigno gr;
			gr = GruppoSanguigno.valueOf(rs1.getString(2));
				
			RichiestaSacca p= new RichiestaSacca(rs1.getString(1), gr, rs1.getInt(3));
			result.add(p);
			
			}
           }
		
		
		catch (Exception e) {result = null;
		JavaDatabaseConn.closeConnection(conn);
	    }
		
		JavaDatabaseConn.closeConnection(conn);
		
        return result;
			
           
	}
	
	
	
	
	
	public void setRichiestaEffettuata(RichiestaSacca rs){
		
		
		conn = JavaDatabaseConn.startConnection(conn, schema);
		PreparedStatement st1;
		
		
	
           try{
        	
        	
   			
   			String query="UPDATE richiesta SET EffettuatoONo = 'EFFETTUATO' WHERE NUMID = (SELECT t.NUMID FROM (SELECT MIN(NUMID) AS NUMID FROM richiesta WHERE CodiceFiscale = ? AND EffettuatoONo = 'NON EFFETTUATO') AS t);";
   			st1 = conn.prepareStatement(query);
   			
   			st1.setString(1, rs.getCodiceFiscale());
   			
   			st1.executeUpdate();
   			
   			System.out.println("Data updated successfully");
			
           }
		
		
		catch (Exception e) {e.printStackTrace();
		JavaDatabaseConn.closeConnection(conn);
	    }
		
		JavaDatabaseConn.closeConnection(conn);
		   
	}
}
