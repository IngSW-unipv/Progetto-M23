package Model;

import IT.unipv.progettoM23.ospedale.Ospedale;
import IT.unipv.progettoM23.ospedale.RichiestaSacca;
import IT.unipv.progettoM23.persona.GruppoSanguigno;

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
