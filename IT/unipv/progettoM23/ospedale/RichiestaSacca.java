package IT.unipv.progettoM23.ospedale;

import IT.unipv.progettoM23.persona.GruppoSanguigno;

public class RichiestaSacca {
	private String CodiceFiscale;
	private int quantità;
	private String effettuato;
	GruppoSanguigno gruppo;
	
public RichiestaSacca(String cf, GruppoSanguigno gr, int q, String ne ) {
	
	this.CodiceFiscale=cf;
	this.gruppo=gr;
	this.quantità=q;
	this.effettuato=ne;
			
}

    public String getCodiceFiscale() {
    	return CodiceFiscale;
    }

    public GruppoSanguigno getGruppo() {
    	return gruppo;
    }
    
    public int getQuantità() {
    	return quantità;
    }
    public String getEffettuato() {
    	return effettuato;
    }
}
