package IT.unipv.progettoM23.database;

import IT.unipv.progettoM23.Model.persona.LoginRegistrazione;

public interface ILoginRegistrazineDAO {

	public boolean verificaUtente(LoginRegistrazione lr);
	public boolean inserisciUtente(LoginRegistrazione lr);
	public boolean verificaCodiceFiscale(String cf);
}
