package IT.unipv.progettoM23.persona;


public class Paziente extends Persona {
	private String CodiceFiscale;
	urgenza urgenza;
	GruppoSanguigno gruppo;
	public Paziente (String cf, GruppoSanguigno g, urgenza u) {
		
		super(cf,g);
		this.urgenza = u;
		this.CodiceFiscale=cf;
		this.gruppo=g;
	}

	public String getCodiceFiscale() {
		return CodiceFiscale;
	}
	public GruppoSanguigno getGruppo() {
		return gruppo;
	}
	
	public urgenza getUrgenza() {
		return urgenza;
	}
}
