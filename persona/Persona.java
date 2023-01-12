package persone;
import java.util.ArrayList;


public class Persona {
    
	private String nome, cognome, codFiscale;
	private boolean uomo;
	
	private ArrayList<Persona> Caselle = new ArrayList<>();
	
	public Persona( String n,String c,String cf,Boolean s) {
		this.nome=n;
		this.cognome=c;
		this.codFiscale=cf;
		this.uomo=s;
		da togliere
	}
}
