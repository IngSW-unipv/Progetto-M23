package persona;

import java.io.*;
import java.util.HashMap;
import java.util.ArrayList;

public class ProvaAperturaFile {
    
	
	//private String[] gruppi= {null};
	public HashMap<GruppoSanguigno, ArrayList<GruppoSanguigno> > mappaGruppi = new HashMap<GruppoSanguigno, ArrayList<GruppoSanguigno> >();
	
	
	
	public ProvaAperturaFile() {}
	
	

	public void trovaGruppiDonatori() {
		
		
		try {
			
			String linea;
			String[] gruppi= {null};
			ArrayList <GruppoSanguigno> gruppiEnum = new ArrayList<>();
			
			FileReader fr=new FileReader("GruppiDonatori");
			BufferedReader fileGruppi= new BufferedReader(fr);
			
			while((linea=fileGruppi.readLine())!="") {
				
				
				gruppi=linea.split(",");
				
				
			    for(String s: gruppi) {
			    	
			    	GruppoSanguigno group;				
					group=GruppoSanguigno.valueOf(s);
					
					gruppiEnum.add(group);
					
				
			    }
			    
			    
			    GruppoSanguigno primoGruppo=gruppiEnum.get(0);
			    gruppiEnum.remove(0);
			    
			    
			    Entry <GruppoSanguigno,ArrayList<GruppoSanguigno>> e;
			    //mappaGruppi.entrySet(primoGruppo,gruppiEnum);

			    //mappaGruppi.put(primoGruppo, gruppiEnum);
			
		
			}
			
			fr.close();
			fileGruppi.close();
		}
		
		catch(FileNotFoundException fe) {
			System.out.println("not found");
		}
		
		catch(IOException ioe) {
			System.out.println("io");
		}
		
		finally {}
	
	}
}
