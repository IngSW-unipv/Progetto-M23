package IT.unipv.progettoM23.ospedale;

import java.util.ArrayList;


public interface IRichiestaSaccaDAO {

	public void inserisciRichiesta(RichiestaSacca rd);
	public ArrayList<RichiestaSacca> selectRichiesteNonEffettuate();
}
