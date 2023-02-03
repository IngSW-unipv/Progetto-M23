package IT.unipv.progettoM23.prenotazioni;

import java.sql.Date;
import java.util.ArrayList;

import IT.unipv.progettoM23.persona.Donatore;

public interface IPrenotazioneDAO {
public ArrayList<Prenotazione> selectDate(Date data);
public void inserisciPrenotazione(Prenotazione p);

}
