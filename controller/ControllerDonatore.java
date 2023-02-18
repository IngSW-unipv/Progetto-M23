package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import IT.unipv.progettoM23.graphics.CenteredFrame;
import Model.ModelDonatore;

public class ControllerDonatore {
	
     public ControllerDonatore(CenteredFrame view,ModelDonatore model) {
    	 
    	 
    	 view.showView("login");
    	 
    	 
    	 
    	 ActionListener AccediListener=new ActionListener() {
    		 
			@Override
			public void actionPerformed(ActionEvent e) {
				String cf=view.getloginView().getContenutoCF();
				String psw=view.getloginView().getContenutoPSW();
				
				System.out.println(cf+"  "+psw);
				
				
				model.setLogin(cf, psw);
				
				
				
				if(!model.verificaCF()) {
					JOptionPane.showMessageDialog(view.getloginView(), "Utente inesistente");
				}
					
				else if(!model.verificaPSW()) {
					JOptionPane.showMessageDialog(view.getloginView(), "Password Errata");
				}
					
				else {
					//model.effettuaLogin(model.getLogin());
					view.showView("utente");
				}
				
			}
    		 
    	 };
    	 
    	 view.getloginView().getAccediButton().addActionListener(AccediListener);
    	 
    	 
     }
}
