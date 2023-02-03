package IT.unipv.progettoM23.persona;


public class Paziente extends Persona {
	urgenza urgenza;
	public Paziente (String cf, GruppoSanguigno g, urgenza u) {
		
		super(cf,g);
		this.urgenza = u;
	}

}
