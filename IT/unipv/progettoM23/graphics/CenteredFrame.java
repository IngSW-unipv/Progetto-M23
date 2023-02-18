package IT.unipv.progettoM23.graphics;

import java.awt.*;
import javax.swing.*;

import IT.unipv.progettoM23.graphics.DonatoreInterface.DonatorePanel;
import IT.unipv.progettoM23.graphics.registrazine.RegistrationPanel;


public class CenteredFrame extends JFrame{
	
	private CardLayout cardLayout;
	private JPanel cards;
	
	
	private LoginPanel loginView;
	private DonatorePanel utenteView;
    private RegistrationPanel registrationView;
    private MenuPanel menuView;
    private InserisciCodFisPanel cercaView;
    private CercaDonatorePanel mostraDonatoreView;
    private VisualPrenotazioniPanel prenotazioniView;
    private PrenGiornoPanel preGiornoView;
    private SacchePanel saccheView;
    private RichiestePanel richiesteView;
    
    
    
	public CenteredFrame(int l,int a) {
		
		Toolkit kit =Toolkit.getDefaultToolkit();
		Dimension screenSize= kit.getScreenSize();
		
		int AltScreen=screenSize.height;
		int LunScreen=screenSize.width;
		
		
		int posX=(LunScreen-l)/2;
		int posY=(AltScreen-a)/2;
				
		
		this.setSize(l,a);
		
		this.setLocation(posX,posY);
				
		Color col =new Color(100,0,0);
		this.setBackground(col);
		
		//Container c=this.getContentPane();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		 this.creaCardPanel();
		
	}
	
	
	public void creaCardPanel() {
		
		loginView =new LoginPanel();
		utenteView=new DonatorePanel();
		registrationView= new RegistrationPanel();
		menuView= new MenuPanel();
		cercaView=new InserisciCodFisPanel();
		mostraDonatoreView=new CercaDonatorePanel();
		prenotazioniView=new VisualPrenotazioniPanel();
		preGiornoView=new PrenGiornoPanel();
		saccheView=new SacchePanel();
		richiesteView=new RichiestePanel();
		
		
		
		this.cardLayout=new CardLayout();
		this.cards =new JPanel(cardLayout);
		
		String[] keys= {"login","utente","registrazione","menu","cerca","mostraDonatore","prenotazioni","prenotazioniGiorno","sacche","richieste"};
		

		cards.add(loginView,keys[0]);
		cards.add(utenteView,keys[1]);
		cards.add(registrationView,keys[2]);
		cards.add(menuView,keys[3]);
		cards.add(cercaView,keys[4]);
		cards.add(mostraDonatoreView,keys[5]);
		cards.add(prenotazioniView,keys[6]);
		cards.add(preGiornoView,keys[7]);
     	cards.add(saccheView,keys[8]);
		cards.add(richiesteView,keys[9]);
		
		
		this.add(cards);
		
	}
	
	
	public void showView(String key) {
		
		this.cardLayout.show(this.cards, key);
		
	}
	
}