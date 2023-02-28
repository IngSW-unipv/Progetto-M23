package IT.unipv.progettoM23.database;

import java.sql.Date;
import java.util.ArrayList;

import IT.unipv.progettoM23.Model.prenotazioni.Prenotazione;


public interface IPrenotazioneDAO { 
	
    public ArrayList<Prenotazione> selectDate(Date data);
    
    public void inserisciPrenotazione(Prenotazione p);
    
    public Prenotazione selectUltimaPrenotazione(String cf);
    
    public String[][] getArrayPrenotazioni(Date data);
    
    public Prenotazione selectUltimaPrenGiorno(Date data);
    
    public Prenotazione selectPrimaPrenGiorno(Date data);

}
