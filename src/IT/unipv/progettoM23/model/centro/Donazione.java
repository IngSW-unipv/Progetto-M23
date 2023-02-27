package IT.unipv.progettoM23.model.centro;

import java.sql.Date;


public class Donazione {
	private String donatore;
	private Date data;
	
public Donazione (String cf, Date a) {
	this.donatore = cf;
	this.data=a;
	
}

public String getCodiceFiscale() {
	return this.donatore;
	
}
public Date getData() {
	return data;
}

}

