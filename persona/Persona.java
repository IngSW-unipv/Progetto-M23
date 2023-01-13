package persona;
//import java.util.ArrayList;

import java.time.LocalDate;


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
	
	public static void main(String[] args) {
		
		//System.out.println(GruppoSanguigno.A);
		ProvaAperturaFile paf=new ProvaAperturaFile();
		
		
		System.out.println(paf.mappaGruppi.size());
			
		System.out.println( paf.mappaGruppi.get(GruppoSanguigno.A).get(0) );
		
		
		
	}
}
