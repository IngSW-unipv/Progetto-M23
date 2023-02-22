package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JOptionPane;

import IT.unipv.progettoM23.graphics.CenteredFrame;
import IT.unipv.progettoM23.persona.GruppoSanguigno;
import Model.ModelDonatore;

public class ControllerDonatore {
	
     public ControllerDonatore(CenteredFrame view,ModelDonatore model) {
    	 
    	 
    	 view.showView("login");
    	 
    	 
    	 
    	 ActionListener accediListener=new ActionListener() {
    		 
			@Override
			public void actionPerformed(ActionEvent e) {
				String cf=view.getloginView().getContenutoCF();
				String psw=view.getloginView().getContenutoPSW();
				
				
				
				model.setLogin(cf, psw);
				
				
				
				if(!model.verificaCF()) {
					JOptionPane.showMessageDialog(view.getloginView(), "Utente inesistente");
				}
					
				else if(!model.verificaPSW()) {
					JOptionPane.showMessageDialog(view.getloginView(), "Password Errata");
				}
					
				else {
					model.effettuaLogin(model.getLogin());
					
			    	view.getUtenteView().setNome(model.getNomeDonatore());
			    	view.getUtenteView().setCognome(model.getCognomeDonatore());
			    	view.getUtenteView().changeSaluto();
			    	
			    	view.getUtenteView().setPrenotazione(model.getPrenotazioneDonatore());
			    	//model.getPrenotazioneDonatore();
			    	view.getUtenteView().changeTestoPren();	
			    	
			    	view.getUtenteView().setDonazioni(model.getDonazioniDonatore());
			    	view.getUtenteView().changeDonazioni();
			    	
					
					view.showView("utente");
				}
				
			}
    		 
    	 };
    	 
    	 view.getloginView().getAccediButton().addActionListener(accediListener);
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 ActionListener registraListener=new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				view.showView("registrazione");
					
			}			 
    			 
         };
    	 view.getloginView().getRegistraButton().addActionListener(registraListener);

      
    	 
    	 
    	 
    	 ActionListener continuaListener=new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String cf=view.getRegistrationView().getContenutoCF();
				String psw=view.getRegistrationView().getContenutoPSW();
				String nome=view.getRegistrationView().getContenutoNome();
				String cognome=view.getRegistrationView().getContenutoCogn();
				String sesso=view.getRegistrationView().getContenutoSesso();
				GruppoSanguigno gruppo=view.getRegistrationView().getContenutoGruppo();
				Date data=view.getRegistrationView().getContenutoData();
						
				
				
				if (!model.cfValido(cf)) {
					JOptionPane.showMessageDialog(view.getRegistrationView(), "Inserire Codice Fiscale di 16 caratteri");
				}
				else if (!model.pswValida(psw)) {
					JOptionPane.showMessageDialog(view.getRegistrationView(), "Inserire Password di almeno 6 caratteri");
				}
				else if (!model.nomeValido(nome)) {
					JOptionPane.showMessageDialog(view.getRegistrationView(), "Inserire Nome");
				}
				else if (!model.cognomeValido(cognome)) {
					JOptionPane.showMessageDialog(view.getRegistrationView(), "Inserire Cognome");
				}
				else if (!model.sessoValido(sesso)) {
					JOptionPane.showMessageDialog(view.getRegistrationView(), "Inserire Sesso");
				}
				else if (!model.gruppoValido(gruppo)) {
					JOptionPane.showMessageDialog(view.getRegistrationView(), "Inserire Gruppo Sanguigno");
				}
				else if (!model.dataValida(data)) {
					JOptionPane.showMessageDialog(view.getRegistrationView(), "Inserire Data Valida");
				}
				
				else {
					model.creaDonatore(cf, psw, cognome, nome, data, sesso, gruppo);
					
			    	view.getUtenteView().setNome(model.getNomeDonatore());
			    	view.getUtenteView().setCognome(model.getCognomeDonatore());
			    	view.getUtenteView().changeSaluto();
					
			    	model.getPrenotazioneDonatore();
			    	view.getUtenteView().changeTestoPren();
			    	
			    	view.getUtenteView().setDonazioni(model.getDonazioniDonatore());
			    	view.getUtenteView().changeDonazioni();
			    	
			    	
					view.showView("utente");
				}
				
				
			}
			
    	 };
    	 
    	 view.getRegistrationView().getContinuaButton().addActionListener(continuaListener);
    	 
    	 
    	 
    	 
    	 ActionListener prenotaListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
                if(!model.puoDonare()) {
                	JOptionPane.showMessageDialog(view.getUtenteView(), "Devono Passare almeno 6 mesi se femmina o 3 se maschio dall'ultima donazione");
                	
                }
                
                else if (!model.puoPrenotare()) {
                	
                	JOptionPane.showMessageDialog(view.getUtenteView(), "Ha gia una prenotaione in corso");	
                }
				
                else {
                	model.assegnaPrenotazione();
                	
                	view.getUtenteView().setPrenotazione(model.getPrenotazioneDonatore());
			    	view.getUtenteView().changeTestoPren();
                }
			}
    		 
    		 
    	 };
    	 
    	 view.getUtenteView().getPrenotaButton().addActionListener(prenotaListener);
    	 
    	 
    	 
    	 
    	 
    	 
    	 ActionListener cancellaListener =new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(model.puoPrenotare()) {
					JOptionPane.showMessageDialog(view.getUtenteView(), "Non hai nessuna prenotazione in corso");
				}
				else {
					
					model.cancellaPrenotazione();
					view.getUtenteView().setPrenotazione(null);
					view.getUtenteView().changeTestoPren();
				}
				
			}
    		 
    	 };
    	 
    	 view.getUtenteView().getCancellaButton().addActionListener(cancellaListener);
    	 
    	 
    	 
    	 
    	 
        
     }
}
