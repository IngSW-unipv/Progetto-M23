package IT.unipv.progettoM23.database.elementiDAO;

import java.util.ArrayList;

import IT.unipv.progettoM23.model.centro.Donazione;
import IT.unipv.progettoM23.model.donatore.Donatore;

public interface IDonazioneDAO {
	public boolean inserisciDonazione(Donazione d);
	public ArrayList<Donazione> selectDonazioni(String cf);
	public Donazione selectUltimaDonazione(Donatore d);

}
