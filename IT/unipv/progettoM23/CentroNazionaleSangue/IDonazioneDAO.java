package IT.unipv.progettoM23.CentroNazionaleSangue;

import java.sql.Date;
import java.util.ArrayList;

import IT.unipv.progettoM23.persona.Donatore;

public interface IDonazioneDAO {
	public void inserisciDonazione(Donazione d);
	public ArrayList<Donazione> selectAll(String cf);

}
