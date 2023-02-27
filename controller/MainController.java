package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import IT.unipv.progettoM23.graphics.CenteredFrame;
import Model.MainModel;

public class MainController {
	
	private ControllerDonatore controllerDonatore;
	private ControllerCentroDonazioni controllerCentro;
	private ControllerOspedale controllerOspedale;
	
	private CenteredFrame view;
	private MainModel model;
	
	
	public MainController(CenteredFrame view, MainModel model) {
		this.view=view;
		this.model=model;
		
	}
	
	
	public void avviaController() {
		
		this.controllerDonatore =new ControllerDonatore(view, model.getModelDonatore());
		this.controllerCentro =new ControllerCentroDonazioni(view, model.getModelCentro());
		this.controllerOspedale=new ControllerOspedale(view,model.getModelOspedale());
		
		this.controllerDonatore.avviaController();
		this.controllerCentro.avviaController();
		this.controllerOspedale.avviaController();
		
		
	
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
