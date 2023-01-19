package IT.unipv.progettoM23.saccheSangue;

import java.io.BufferedReader;
import java.io.FileReader;


import IT.unipv.progettoM23.persona.GruppoSanguigno;

public class ControllerSacche {
    
	public ControllerSacche() {}
	
	public int getNumSacche(GruppoSanguigno g) {
		
		int numero=-1;
		
		try {
			FileReader fr=new FileReader("saccheSangue");
			BufferedReader fileTesto= new BufferedReader(fr);
			
			String linea;
			
			
			while( (linea=fileTesto.readLine())!= "") {
			
			    String elRiga[]=linea.split(",");
			    
			    GruppoSanguigno gr;
			    gr=GruppoSanguigno.valueOf(elRiga[0]);
			    
			    if (gr==g) {
			    	numero= Integer.parseInt(elRiga[1]);
			    }
			}
			
			
			fr.close();
		}
		
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return numero;
	}
}
