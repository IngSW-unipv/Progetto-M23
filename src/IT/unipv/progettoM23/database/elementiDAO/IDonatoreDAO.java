package IT.unipv.progettoM23.database.elementiDAO;
import java.sql.SQLException;
import java.util.ArrayList;

import IT.unipv.progettoM23.model.donatore.Donatore;

public interface IDonatoreDAO {

	public ArrayList<Donatore> selectAll() throws SQLException;
	public Donatore selectDonatore(String cf);
}
