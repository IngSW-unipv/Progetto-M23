package IT.unipv.progettoM23.database;

import java.util.ArrayList;

import IT.unipv.progettoM23.Model.ospedale.RichiestaSacca;


public interface IRichiestaSaccaDAO {

	public void inserisciRichiesta(RichiestaSacca rd);
	public ArrayList<RichiestaSacca> selectRichiesteNonEffettuate();
}
