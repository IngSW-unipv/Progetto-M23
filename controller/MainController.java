package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import IT.unipv.progettoM23.graphics.CenteredFrame;
import Model.MainModel;
import Model.ModelCentroDonazioni;
import Model.ModelDonatore;
import Model.ModelOspedale;

public class MainController {
     
	
	public MainController(CenteredFrame view, MainModel model) {
		
		ControllerDonatore controllerDonatore =new ControllerDonatore(view, model.getModelDonatore());
		ControllerCentroDonazioni controllerCentro =new ControllerCentroDonazioni(view, model.getModelCentro());
		ControllerOspedale controllerOspedale=new ControllerOspedale(view,model.getModelOspedale());
		
		
		
		ActionListener interfacciaDonatoreListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				view.showView("login");
			}	
		};
		
		view.getFirstView().getIDonatoreButton().addActionListener(interfacciaDonatoreListener);
		
		
		
		
		
		
		ActionListener interfacciaCentroListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				view.showView("menu");
			}	
		};
		
		view.getFirstView().getICentroButton().addActionListener(interfacciaCentroListener);
		
		
		
		
		
		
		
		ActionListener interfacciaOspedaleListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				view.showView("ospedale");
			}	
		};
		
		view.getFirstView().getIOspedaleButton().addActionListener(interfacciaOspedaleListener);
		
		
		
	}
}
