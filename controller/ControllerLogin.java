package controller;

import IT.unipv.progettoM23.graphics.CenteredFrame;
import IT.unipv.progettoM23.graphics.LoginPanel;
import IT.unipv.progettoM23.persona.DonatoreDAO;

public class ControllerLogin {
	
	private final DonatoreDAO donatoreDao;
	private final CenteredFrame frame;
	private final LoginPanel panel;
	public ControllerLogin (DonatoreDAO donatoreDao,CenteredFrame frame,LoginPanel panel )
	{
		this.donatoreDao = donatoreDao;
		this.frame = frame;
		this.panel = panel;
		setListeners();
		
	}

}
