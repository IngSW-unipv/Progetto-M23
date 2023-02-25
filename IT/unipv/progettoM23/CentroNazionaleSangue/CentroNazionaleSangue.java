package IT.unipv.progettoM23.CentroNazionaleSangue;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import IT.unipv.progettoM23.ospedale.RichiestaSacca;
import IT.unipv.progettoM23.ospedale.RichiestaSaccaDAO;
import IT.unipv.progettoM23.persona.GruppoSanguigno;
import IT.unipv.progettoM23.sacche.ControllerSacche;

public class CentroNazionaleSangue {
	
	ControllerSacche cs;
    
	public CentroNazionaleSangue() {
		cs=new ControllerSacche();
	}
	
	
	
	
	public static class MappaGruppi {
		
		private final HashMap<GruppoSanguigno, GruppoSanguigno[] > mappaGruppi = new HashMap<GruppoSanguigno, GruppoSanguigno[] >();
		
		
		public MappaGruppi() {
			
			GruppoSanguigno[] donatoriA = {GruppoSanguigno.A,GruppoSanguigno.ZERO};
			mappaGruppi.put(GruppoSanguigno.A, donatoriA);
			
			GruppoSanguigno[] donatoriB = {GruppoSanguigno.B,GruppoSanguigno.ZERO};
			mappaGruppi.put(GruppoSanguigno.B, donatoriB);
			
			GruppoSanguigno[] donatoriAB = {GruppoSanguigno.A,GruppoSanguigno.B,GruppoSanguigno.AB,GruppoSanguigno.ZERO};
			mappaGruppi.put(GruppoSanguigno.AB, donatoriAB);
			
			GruppoSanguigno[] donatori0 = {GruppoSanguigno.ZERO};
			mappaGruppi.put(GruppoSanguigno.ZERO, donatori0);
		}
		
		
		public GruppoSanguigno[] chiDonaA(GruppoSanguigno g) {	
			return this.mappaGruppi.get(g);	
		}
		
	}
	
	
	
	
	
	public int[] getNumSacche() {
		
		int[] numSacche = new int[4];
		
		numSacche[0]=cs.getNumSacche(GruppoSanguigno.A);
		numSacche[1]=cs.getNumSacche(GruppoSanguigno.B);
		numSacche[2]=cs.getNumSacche(GruppoSanguigno.AB);
		numSacche[3]=cs.getNumSacche(GruppoSanguigno.ZERO);
		
		
		return numSacche;
	}
	
	
	
	
	public boolean registraDonazione(String cf) {
		
		if(cf!=null) {
		
			Date today=Date.valueOf(LocalDate.now());
			Donazione donazione=new Donazione(cf,today);
			DonazioneDAO dDAO= new DonazioneDAO();
			
			return dDAO.inserisciDonazione(donazione);
			
		}
		else {
			return false;
		}
	}
	
	
	
	
	public void soddisfaRichieste() {
		
		RichiestaSaccaDAO rDAO= new RichiestaSaccaDAO();
		
		ArrayList<RichiestaSacca> richieste= rDAO.selectRichiesteNonEffettuate();
		
		MappaGruppi mg=new MappaGruppi();
		
		for (RichiestaSacca r :richieste){
			
			
			//RichiestaSacca r=new RichiestaSacca(null,null,3);
			
			
			GruppoSanguigno gruppo=r.getGruppo();
			int quantita=r.getQuantità();
			
			
			GruppoSanguigno[] gruppiDonatori= mg.chiDonaA(gruppo);
			
			
			int SaccheDisponibili=0;
			
			for(GruppoSanguigno g:gruppiDonatori) {
			    SaccheDisponibili+=this.cs.getNumSacche(g);
			}
			
			
			if(SaccheDisponibili>=quantita) {
				
				int count=0;
				
				while(quantita!=0) {
					
					if (cs.getNumSacche(gruppiDonatori[count])>=quantita) {
						
						quantita=0;
						cs.cambiaNumSacche(gruppiDonatori[count], -quantita);
					}
					else {
						quantita-=cs.getNumSacche(gruppiDonatori[count]);
						
						cs.cambiaNumSacche(gruppiDonatori[count], - cs.getNumSacche(gruppiDonatori[count]));
					}	
				}
				
				
				rDAO.setRichiestaEffettuata(r);
				
			}
			
		}
		
		
	}
	
	
	public ControllerSacche getControllerSacche() {
		return this.cs;
	}

	
	
}
