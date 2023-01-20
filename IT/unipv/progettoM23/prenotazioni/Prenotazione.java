package IT.unipv.progettoM23.prenotazioni;

import java.sql.Date;
import java.sql.Time;
import IT.unipv.progettoM23.persona.Donatore;

public class Prenotazione {
	
	private Date data;
	private Time ora;
	private Donatore donatore;

	public Prenotazione(Donatore d, Date data, Time ora) {
		this.data =data;
		this.ora = ora;
		this.donatore=d;
		
		
	}
	
	public Time getOra() {
		return this.ora;
	}

}
