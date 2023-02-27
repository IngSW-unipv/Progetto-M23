package IT.unipv.progettoM23.ospedale;

public class Ospedale {
    
	private static Ospedale istanza;
	private RichiestaSaccaDAO rDAO;
	
	
	public Ospedale() {}
	
	
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
