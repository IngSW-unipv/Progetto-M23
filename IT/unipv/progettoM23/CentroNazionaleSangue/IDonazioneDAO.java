package IT.unipv.progettoM23.CentroNazionaleSangue;

import java.util.ArrayList;

import IT.unipv.progettoM23.persona.Donatore;

public interface IDonazioneDAO {
	public boolean inserisciDonazione(Donazione d);
	public ArrayList<Donazione> selectDonazioni(String cf);
	public Donazione selectUltimaDonazione(Donatore d);

}
