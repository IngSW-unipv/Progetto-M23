package IT.unipv.progettoM23.database.elementiDAO;

import java.util.ArrayList;

import IT.unipv.progettoM23.model.ospedale.RichiestaSacca;


public interface IRichiestaSaccaDAO {

	public void inserisciRichiesta(RichiestaSacca rd);
	public ArrayList<RichiestaSacca> selectRichiesteNonEffettuate();
}
