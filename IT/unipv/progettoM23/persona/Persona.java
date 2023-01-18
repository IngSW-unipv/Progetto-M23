package IT.unipv.progettoM23.persona;
//import java.util.ArrayList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import IT.unipv.progettoM23.database.JavaDatabaseConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Driver;

public class Persona {
    
	private String nome, cognome, codFiscale, sesso;

	private GruppoSanguigno gruppo;
	private Date dob; 
	
	
	public Persona( String cf,String c,String n, Date d, String s,GruppoSanguigno g) {
		this.nome=n;
		this.cognome=c;
		this.codFiscale=cf;
		this.sesso=s;
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
	
	
	
	
	public String toString() {
		return this.nome+" "+this.cognome;
	}
	
	
	
	
	public static void main(String[] args) {

		MappaGruppi pr = new MappaGruppi();
		
		System.out.println(pr.chiDonaA(GruppoSanguigno.A)[1]);
		
		DonatoreDAO s = new DonatoreDAO();
	    ArrayList<Donatore> d = s.selectAll();
	    
	    System.out.println(d.get(0));
	}
	
}
