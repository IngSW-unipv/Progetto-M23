package IT.unipv.progettoM23.persona;
import java.util.ArrayList;

public interface IDonatoreDAO {

	public ArrayList<Donatore> selectAll();
	public Donatore selectDonatore(String cf);
	public void inserisciDonatore(Donatore d);
}
