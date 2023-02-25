package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import IT.unipv.progettoM23.graphics.CenteredFrame;
import IT.unipv.progettoM23.persona.Donatore;
import IT.unipv.progettoM23.persona.DonatoreDAO;
import Model.ModelCentroDonazioni;


public class ControllerCentroDonazioni {

    public ControllerCentroDonazioni(CenteredFrame view, ModelCentroDonazioni model) {
		
   	    //view.showView("menu");
   	    
   	    
   	    ActionListener pulsanteMenu1Listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view.showView("cerca");	
			}
   	    	
   	    };
   	    
   	    view.getMenuView().getButton1().addActionListener(pulsanteMenu1Listener);
		
   	    
   	    
   	    
   	    ActionListener pulsanteMenu2Listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				view.getPrenotazioniView().visualizzaPrenotazioni(model.getTodaysPrenotazioni());
				
				
				view.showView("prenotazioni");	
			}
   	    	
   	    };
   	    
   	    view.getMenuView().getButton2().addActionListener(pulsanteMenu2Listener);
		
   	    
   	    
   	    
   	    
   	    ActionListener pulsanteMenu3Listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				view.getSaccheView().visualizzaNumSacche(model.getNumSacche());
				
				view.showView("sacche");	
			}
   	    	
   	    };
   	    
   	    view.getMenuView().getButton3().addActionListener(pulsanteMenu3Listener);
		
   	    
   	    
   	    
   	    
   	    ActionListener pulsanteMenu4Listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				view.getRichiesteView().visualizzaRichieste(model.getRichiesteEffettuate());
				
				view.showView("richieste");	
			}
   	    	
   	    };
   	    
   	    view.getMenuView().getButton4().addActionListener(pulsanteMenu4Listener);
		
   	    
   	    
   	    
   	    
  	    ActionListener cercaListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String cf=view.getCercaView().getContenutoBarra();
				
				if(!model.cfValido(cf)) {
					JOptionPane.showMessageDialog(view.getCercaView(), "Inserire Codice Fiscale di 16 caratteri");
				}
				
				else if (!model.verificaCF(cf)){
					JOptionPane.showMessageDialog(view.getCercaView(), "Utente Inesistente");
				}
				
				else {
					model.selectDonatore(cf);
					
					Donatore d=model.getDonatoreCercato();
					view.getMostraDonatoreView().changeDati(d.getNome(),d.getCognome(),d.getcodFiscale(),String.valueOf(d.getData()),d.getSesso(),String.valueOf(d.getGruppo()));
					
					view.getMostraDonatoreView().changeDonazioni(model.getDonazioniDonatore());
					
					view.showView("mostraDonatore");
					
				}
			}
   	    }; 
   	    
   	    
   	    view.getCercaView().getCercaButton().addActionListener(cercaListener);
   	    
   	    
   	    
   	    
        ActionListener confermaListener =new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (model.registraDonazione(view.getPrenotazioniView().getSelectedValueOfTable())) {
					
					model.aggiungiSacca(view.getPrenotazioniView().getSelectedValueOfTable());
				
				    JOptionPane.showMessageDialog(view.getPrenotazioniView(), "Donazione Registrata");
				}
				
//				else {
//					//System.out.println(view.getPrenotazioniView().getSelectedValueOfTable());
//					
//					DonatoreDAO dd=new DonatoreDAO();
//					dd.selectDonatore(view.getPrenotazioniView().getSelectedValueOfTable());
//					
//					System.out.println(dd.selectDonatore(view.getPrenotazioniView().getSelectedValueOfTable()).getGruppo());
//				}
				
			}
        };
        
        view.getPrenotazioniView().getConfermaButton().addActionListener(confermaListener);
        
        
        
        
        
        ActionListener cercaGiornoListener =new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Date d=view.getPrenotazioniView().getContenutoData();
				
				if(d==null) {
					 JOptionPane.showMessageDialog(view.getPrenotazioniView(), "Data inserita non valida");
				}
				
				else {
					view.getPreGiornoView().visualizzaPrenotazioni(model.getPrenotazioniGiorno(d));
					view.getPreGiornoView().visualizzaGiorno(d);
					
					view.showView("prenotazioniGiorno");
				}
				
			}
        };
        
        view.getPrenotazioniView().getCercaButton().addActionListener(cercaGiornoListener);
		
        
        
        
        
        
        
        
        
        
        
        
	   	 ActionListener indietroCercaListener =new ActionListener() {
	
	 		@Override
	 		public void actionPerformed(ActionEvent e) {
	 			
	 			view.showView(view.getViewPrecedente(view.getCercaView().getKey()));
	 			
	 		}
	 		 
	 	 };
	 	 
	 	 view.getCercaView().getIndietroButton().addActionListener(indietroCercaListener);
	    
        
        
        
        
        
        
		 ActionListener indietroTrovaListener =new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				view.showView(view.getViewPrecedente(view.getMostraDonatoreView().getKey()));
				
			}
			 
		 };
		 
		 view.getMostraDonatoreView().getIndietroButton().addActionListener(indietroTrovaListener);
	   
		 
		 
		 
		 
		 ActionListener indietroPrenListener =new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				view.showView(view.getViewPrecedente(view.getPrenotazioniView().getKey()));
				
			}
			 
		 };
		 
		 view.getPrenotazioniView().getIndietroButton().addActionListener(indietroPrenListener);
	   
		 
		 
		 
		 
		 
		 ActionListener indietroPrenGiornoListener =new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				view.showView(view.getViewPrecedente(view.getPreGiornoView().getKey()));
				
			}
			 
		 };
		 
		 view.getPreGiornoView().getIndietroButton().addActionListener(indietroPrenGiornoListener);
	   
		 
		 
		 
		 
		 
		 
		 
		 
		 ActionListener indietroSaccheListener =new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				view.showView(view.getViewPrecedente(view.getSaccheView().getKey()));
				
			}
			 
		 };
		 
		 view.getSaccheView().getIndietroButton().addActionListener(indietroSaccheListener);
	   
		 
		 
		 
		 
		 
		 
		 ActionListener indietroRichiesteListener =new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				view.showView(view.getViewPrecedente(view.getRichiesteView().getKey()));
				
			}
			 
		 };
		 
		 view.getRichiesteView().getIndietroButton().addActionListener(indietroRichiesteListener);
	   
		 
		 
		 
		 
		 
		 ActionListener indietroMenuListener =new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				view.showView(view.getViewPrecedente(view.getMenuView().getKey()));
				
			}
			 
		 };
		 
		 view.getMenuView().getIndietroButton().addActionListener(indietroMenuListener);
	   
		 
    
    
        
	}
 
    
}
