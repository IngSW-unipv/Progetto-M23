package IT.unipv.progettoM23.persona;
//import java.util.ArrayList;

public interface ILoginRegistrazineDAO {

	public boolean verificaUtente(LoginRegistrazione lr);
	public boolean inserisciUtente(LoginRegistrazione lr);
	public boolean verificaCodiceFiscale(String cf);
}
