package IT.unipv.progettoM23.ospedale;

import java.util.ArrayList;

import IT.unipv.progettoM23.CentroNazionaleSangue.Donazione;

public interface IRichiestaSaccaDAO {

	public void inserisciRichiesta(RichiestaSacca rd);
	public ArrayList<RichiestaSacca> selectRichiesteNonEffettuate();
}
