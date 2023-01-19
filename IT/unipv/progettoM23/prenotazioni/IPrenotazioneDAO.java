package IT.unipv.progettoM23.prenotazioni;

import java.sql.Date;
import java.util.ArrayList;

public interface IPrenotazioneDAO {
	public ArrayList<Prenotazione> selectDate(Date data);

}
