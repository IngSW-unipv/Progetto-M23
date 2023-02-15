package IT.unipv.progettoM23.graphics;

import java.awt.*;
import javax.swing.*;

import IT.unipv.progettoM23.graphics.DonatoreInterface.DonatorePanel;
import IT.unipv.progettoM23.graphics.registrazine.RegistrationPanel;
import java.awt.CardLayout;

public class CenteredFrame extends JFrame{
	
	private LoginPanel loginView;
	private DonatorePanel donatoreView;
	private RegistrationPanel registrationView;
	private MenuPanel menuView;
	private InserisciCodFisPanel inserisciCodView;
	private CercaDonatorePanel cercaDonatoreView;
	private VisualPrenotazioniPanel prenotazioniView;
	private PrenGiornoPanel prenGiornoView;
	private SacchePanel saccheView;
	
    
	public CenteredFrame(int l,int a) {
		
		Toolkit kit =Toolkit.getDefaultToolkit();
		Dimension screenSize= kit.getScreenSize();
		
		int AltScreen=screenSize.height;
		int LunScreen=screenSize.width;
		
		
		int posX=(LunScreen-l)/2;
		int posY=(AltScreen-a)/2;
				
		
		this.setSize(l,a);
		
		this.setLocation(posX,posY);
		
		//this.setLayout(null);                    //set layout=null per spostare elementi in jpanel
		
		Color col =new Color(140,0,0);
		this.setBackground(col);
		
		Container c=this.getContentPane();
		//c.setLayout(new GridLayout(20,20));
		
		//GridBagConstraints grid=new GridBagConstraints();
		//SimplePanel p=new SimplePanel();
		//p.setLayout(null);
		//c.add(p);

		
	}
	

	
}