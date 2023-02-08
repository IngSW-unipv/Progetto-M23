package IT.unipv.progettoM23.persona;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IDonatoreDAO {

	public ArrayList<Donatore> selectAll() throws SQLException;
	public Donatore selectDonatore(String cf);
}
