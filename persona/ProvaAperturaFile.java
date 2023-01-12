package persona;

import java.io.*;

public class ProvaAperturaFile {
    
	public ProvaAperturaFile() {}
	
	public void trovaGruppiDonatori() {
		
		
		try {
			FileReader fr=new FileReader("testo.txt");
			BufferedReader fileTesto= new BufferedReader(fr);
			
			String linea=fileTesto.readLine();
			
			System.out.println(linea);
			
			fr.close();
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
