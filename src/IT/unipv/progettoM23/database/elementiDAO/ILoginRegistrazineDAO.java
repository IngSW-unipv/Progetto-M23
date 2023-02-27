package IT.unipv.progettoM23.database.elementiDAO;

import IT.unipv.progettoM23.model.donatore.LoginRegistrazione;

public interface ILoginRegistrazineDAO {

	public boolean verificaUtente(LoginRegistrazione lr);
	public boolean inserisciUtente(LoginRegistrazione lr);
	public boolean verificaCodiceFiscale(String cf);
}
