package IT.unipv.progettoM23.model.donatore;

public class LoginRegistrazione {
	private String codiceFiscale;
	private String password;

	public LoginRegistrazione(String cf, String ps) {
		this.codiceFiscale=cf;
		this.password=ps;
		
	}
	
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	
	public String getPassword() {
		return password;
		
	}
}
