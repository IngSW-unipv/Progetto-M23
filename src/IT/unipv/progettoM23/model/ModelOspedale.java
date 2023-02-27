package IT.unipv.progettoM23.model;

import IT.unipv.progettoM23.model.donatore.GruppoSanguigno;
import IT.unipv.progettoM23.model.ospedale.Ospedale;
import IT.unipv.progettoM23.model.ospedale.RichiestaSacca;

public class ModelOspedale {
	
	private RichiestaSacca richiesta;
    
	public ModelOspedale() {}
	
	
	public void creaRichiesta(String cf,GruppoSanguigno g,int q) {
		this.richiesta= new RichiestaSacca(cf,g,q);
	}
	
	public void mandaRichiesta() {
		Ospedale.getIstanza().mandaRichiesta(this.richiesta);
	}
	
	
    public boolean cfValido(String cf) {
    	return (cf.length()==16);
    }
    
    
    public boolean gruppoValido(GruppoSanguigno g) {
    	return g!=null;
    } 
    
    
    public boolean quantitaValida(int q) {
    	return ((q>0)&&(q<11));
    }
	
	
}
