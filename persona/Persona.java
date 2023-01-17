package persona;
//import java.util.ArrayList;

import java.time.LocalDate;
import java.util.HashMap;

import DataBase.JavaDatabaseConn;

import java.sql.Connection;


public class Persona {
    
	private String nome, cognome, codFiscale;
	private boolean uomo;
	private GruppoSanguigno gruppo;
	private LocalDate dob; 
	
	
	public Persona( String n,String c,String cf,Boolean s,LocalDate d,GruppoSanguigno g) {
		this.nome=n;
		this.cognome=c;
		this.codFiscale=cf;
		this.uomo=s;
		this.gruppo=g;
		this.dob=d;

	}
	
	
	
	public static class MappaGruppi {
		
		public final HashMap<GruppoSanguigno, GruppoSanguigno[] > mappaGruppi = new HashMap<GruppoSanguigno, GruppoSanguigno[] >();
		
		
		public MappaGruppi() {
			
			GruppoSanguigno[] donatoriA = {GruppoSanguigno.A,GruppoSanguigno.ZERO};
			mappaGruppi.put(GruppoSanguigno.A, donatoriA);
			
			GruppoSanguigno[] donatoriB = {GruppoSanguigno.B,GruppoSanguigno.ZERO};
			mappaGruppi.put(GruppoSanguigno.B, donatoriB);
			
			GruppoSanguigno[] donatoriAB = {GruppoSanguigno.A,GruppoSanguigno.B,GruppoSanguigno.AB,GruppoSanguigno.ZERO};
			mappaGruppi.put(GruppoSanguigno.AB, donatoriAB);
			
			GruppoSanguigno[] donatori0 = {GruppoSanguigno.ZERO};
			mappaGruppi.put(GruppoSanguigno.ZERO, donatori0);
		}
		
		
		public GruppoSanguigno[] chiDonaA(GruppoSanguigno g) {	
			return this.mappaGruppi.get(g);	
		}
		
	}
	
	
	
	
	
	public static void main(String[] args) {

		MappaGruppi pr = new MappaGruppi();
		
		System.out.println(pr.chiDonaA(GruppoSanguigno.A)[1]);
		
		

		Connection conn=null;
		conn=JavaDatabaseConn.startConnection(conn, "Donatore");
		
		JavaDatabaseConn.closeConnection(conn);
	}
	
}
