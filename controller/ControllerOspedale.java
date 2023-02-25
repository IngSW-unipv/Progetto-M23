package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import IT.unipv.progettoM23.graphics.CenteredFrame;
import IT.unipv.progettoM23.persona.GruppoSanguigno;
import Model.ModelOspedale;

public class ControllerOspedale {
    
	public ControllerOspedale(CenteredFrame view, ModelOspedale model) {
		
		
		ActionListener MandaRicListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String cf=view.getOspedaleView().getContenutoCF();
				GruppoSanguigno g=view.getOspedaleView().getContenutoGruppo();
				int q=view.getOspedaleView().getContenutoQuantita();
				
				
				if (!model.cfValido(cf)) {
					
					JOptionPane.showMessageDialog(view.getOspedaleView(), "Inserire Codice Fiscale di 16 Caratteri");
				}
				
				else if(!model.gruppoValido(g)) {
					
					JOptionPane.showMessageDialog(view.getOspedaleView(), "Selezionare Gruppo");
				}
				else if(!model.quantitaValida(q)) {
					
					JOptionPane.showMessageDialog(view.getOspedaleView(), "Inserire quantità compresa tra 1-10");
				}
				
				else {
					
					model.creaRichiesta(cf, g, q);
					model.mandaRichiesta();
					
					JOptionPane.showMessageDialog(view.getOspedaleView(), "Richiesta Effettuata");
				}
				
			}
			
		};
		
		
		view.getOspedaleView().getMandaButton().addActionListener(MandaRicListener);
		
		
		
		
		
		
		
		
		
		 ActionListener indietroOspedaleListener =new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				view.showView(view.getViewPrecedente(view.getOspedaleView().getKey()));
				
			}
			 
		 };
		 
		 view.getOspedaleView().getIndietroButton().addActionListener(indietroOspedaleListener);
	   
		 
		
		
	}
}
