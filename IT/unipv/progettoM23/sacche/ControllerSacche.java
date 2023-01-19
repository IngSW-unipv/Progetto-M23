package IT.unipv.progettoM23.sacche;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import IT.unipv.progettoM23.persona.GruppoSanguigno;

public class ControllerSacche {
    
	public ControllerSacche() {}
	
	public int getNumSacche(GruppoSanguigno g) {
		
		int numero=-1;
		
		try {
			FileReader fr=new FileReader("saccheSangue.txt");
			BufferedReader fileTesto= new BufferedReader(fr);
			
			String linea;
			
			while( (linea=fileTesto.readLine()) != null) {
			
			    String elRiga[]=linea.split(",");
			    
			    GruppoSanguigno gr;
			    gr=GruppoSanguigno.valueOf(elRiga[0]);
			    
			    if (gr==g) {
			    	numero= Integer.parseInt(elRiga[1]);
			    }
			}
			
			fileTesto.close();
			//fr.close();
		}
		
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return numero;
	}
	
	
	
	
	public void cambiaNumSacche(GruppoSanguigno g,int n) {
		
		try {
			FileReader fr=new FileReader("saccheSangue.txt");
			BufferedReader frb= new BufferedReader(fr);
			

			
			String linea;
			ArrayList<String[]> linee= new ArrayList<>();
			
			
			while( (linea=frb.readLine()) != null) {
			
			    String elRiga[]=linea.split(",");
			    linee.add(elRiga);  
			}
			
			
			frb.close();
			fr.close();
			
			
			FileWriter fw= new FileWriter("saccheSangue.txt");
			BufferedWriter fwb=new BufferedWriter(fw);
			    
			    
			for(String[] line:linee) {
				
                GruppoSanguigno gr;
			    gr=GruppoSanguigno.valueOf(line[0]);
			    
			    if (gr==g) {
			    	fwb.write(line[0]+","+( String.valueOf(Integer.parseInt(line[1])+n)+"\n"));
			    }
			    else {
			    	fwb.write(line[0]+","+line[1]+"\n");
			    }
			}    

			fwb.close();
			fw.close();
		}
		
		
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	
	
	
}
