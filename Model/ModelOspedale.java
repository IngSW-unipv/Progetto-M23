package Model;

import IT.unipv.progettoM23.ospedale.RichiestaSacca;
import IT.unipv.progettoM23.ospedale.RichiestaSaccaDAO;
import IT.unipv.progettoM23.persona.GruppoSanguigno;

public class ModelOspedale {
	
	private RichiestaSaccaDAO rDAO;
	
	private RichiestaSacca richiesta;
    
	public ModelOspedale() {
		
		rDAO=new RichiestaSaccaDAO();
	}
	
	
	public void creaRichiesta(String cf,GruppoSanguigno g,int q) {
		this.richiesta= new RichiestaSacca(cf,g,q);
	}
	
	public void mandaRichiesta() {
		rDAO.inserisciRichiesta(this.richiesta);
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
