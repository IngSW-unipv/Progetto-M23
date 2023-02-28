package IT.unipv.progettoM23.database;

import java.util.ArrayList;

import IT.unipv.progettoM23.Model.CentroNazionaleSangue.Donazione;
import IT.unipv.progettoM23.Model.persona.Donatore;

public interface IDonazioneDAO {
	public boolean inserisciDonazione(Donazione d);
	public ArrayList<Donazione> selectDonazioni(String cf);
	public Donazione selectUltimaDonazione(Donatore d);

}
