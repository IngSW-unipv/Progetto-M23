package IT.unipv.progettoM23.ospedale;

import IT.unipv.progettoM23.persona.GruppoSanguigno;

public class RichiestaSacca {
	private String CodiceFiscale;
	private int quantità;
	private String effettuato;
	GruppoSanguigno gruppo;
	
public RichiestaSacca(String cf, GruppoSanguigno gr, int q) {
	
	this.CodiceFiscale=cf;
	this.gruppo=gr;
	this.quantità=q;
	this.effettuato="NON EFFETTUATO";
			
}

    public String getCodiceFiscale() {
    	return CodiceFiscale;
    }

    public GruppoSanguigno getGruppo() {
    	return gruppo;
    }
    
    public String getGruppo1() {
    	return String.valueOf(this.gruppo);
    }
    
    public int getQuantità() {
    	return quantità;
    }
    
    
    public void setEffettuato() {
    	this.effettuato = "EFFETTUATO";
    	
    }
    
    public String getEffettuato() {
    	return this.effettuato;
    }
}
