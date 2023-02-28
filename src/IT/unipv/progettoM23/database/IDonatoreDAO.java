package IT.unipv.progettoM23.database;
import java.sql.SQLException;
import java.util.ArrayList;

import IT.unipv.progettoM23.Model.persona.Donatore;

public interface IDonatoreDAO {

	public ArrayList<Donatore> selectAll() throws SQLException;
	public Donatore selectDonatore(String cf);
}
