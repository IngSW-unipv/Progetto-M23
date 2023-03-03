package IT.unipv.progettoM23.Model.ospedale;

import IT.unipv.progettoM23.database.RichiestaSaccaDAO;

public class Ospedale {
    
	private static Ospedale istanza;
	private RichiestaSaccaDAO rDAO;
	
	
	private Ospedale() {}
	
	
	public static Ospedale getIstanza() {
		
		if (istanza==null) {
			
			 istanza =new Ospedale();
		}

		return istanza;
	}
	
	
	
	public void mandaRichiesta(RichiestaSacca richiesta) {
		rDAO= new RichiestaSaccaDAO();
		rDAO.inserisciRichiesta(richiesta);
	}
}
