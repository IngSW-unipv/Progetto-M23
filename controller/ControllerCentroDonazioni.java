package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import IT.unipv.progettoM23.graphics.CenteredFrame;
import IT.unipv.progettoM23.persona.Donatore;
import Model.ModelCentroDonazioni;


public class ControllerCentroDonazioni {

    public ControllerCentroDonazioni(CenteredFrame view, ModelCentroDonazioni model) {
		
   	    view.showView("menu");
   	    
   	    
   	    
   	    
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
				view.showView("sacche");	
			}
   	    	
   	    };
   	    
   	    view.getMenuView().getButton3().addActionListener(pulsanteMenu3Listener);
		
   	    
   	    
   	    
   	    
   	    ActionListener pulsanteMenu4Listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
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
				
				model.registraDonazione(view.getPrenotazioniView().getSelectedValueOfTable());
				
			}
        };
        
        view.getPrenotazioniView().getConfermaButton().addActionListener(confermaListener);
		
	}
    
   
    
}
