package IT.unipv.progettoM23.database.elementiDAO;

import java.sql.Date;
import java.util.ArrayList;

import IT.unipv.progettoM23.model.donatore.Prenotazione;


public interface IPrenotazioneDAO { 
	
    public ArrayList<Prenotazione> selectDate(Date data);
    
    public void inserisciPrenotazione(Prenotazione p);
    
    public Prenotazione selectUltimaPrenotazione(String cf);
    
    public String[][] getArrayPrenotazioni(Date data);
    
    public Prenotazione selectUltimaPrenGiorno(Date data);
    
    public Prenotazione selectPrimaPrenGiorno(Date data);

}
