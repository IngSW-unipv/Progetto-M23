package IT.unipv.progettoM23.graphics;

import java.awt.*;
import java.util.BitSet;
import java.util.HashMap;

import javax.swing.*;


public class CenteredFrame extends JFrame{
	
	private CardLayout cardLayout;
	private JPanel cards;
	
	
	private FirstPanel firstView;
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
    private OspedalePanel ospedaleView;
    
    private final HashMap<String,String> mappaPaginaPrecedente=new HashMap<String,String>();
    
    
    
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
		 
		 
		 
		 this.mappaPaginaPrecedente.put("login","principale");
		 this.mappaPaginaPrecedente.put("utente","login");
		 this.mappaPaginaPrecedente.put("registrazione","login");
		 this.mappaPaginaPrecedente.put("menu","principale");
		 this.mappaPaginaPrecedente.put("cerca","menu");
		 this.mappaPaginaPrecedente.put("mostraDonatore","cerca");
		 this.mappaPaginaPrecedente.put("prenotazioni","menu");
		 this.mappaPaginaPrecedente.put("prenotazioniGiorno","prenotazioni");
		 this.mappaPaginaPrecedente.put("sacche","menu");
		 this.mappaPaginaPrecedente.put("richieste","menu");
		 this.mappaPaginaPrecedente.put("ospedale","principale");

		
	}
	
	
	public void creaCardPanel() {
		
		firstView=new FirstPanel();
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
		ospedaleView=new OspedalePanel();
		
		
		
		
		this.cardLayout=new CardLayout();
		this.cards =new JPanel(cardLayout);
		
		String[] keys= {"principale","login","utente","registrazione","menu","cerca","mostraDonatore","prenotazioni","prenotazioniGiorno","sacche","richieste","ospedale"};
		
		cards.add(firstView,keys[0]);
		cards.add(loginView,keys[1]);
		cards.add(utenteView,keys[2]);
		cards.add(registrationView,keys[3]);
		cards.add(menuView,keys[4]);
		cards.add(cercaView,keys[5]);
		cards.add(mostraDonatoreView,keys[6]);
		cards.add(prenotazioniView,keys[7]);
		cards.add(preGiornoView,keys[8]);
     	cards.add(saccheView,keys[9]);
		cards.add(richiesteView,keys[10]);
		cards.add(ospedaleView,keys[11]);
		
		
		this.add(cards);
		
	}
	
	
	public void showView(String key) {
		
		this.cardLayout.show(this.cards, key);
		
		System.out.println();
	}
	
	
	
	public LoginPanel getloginView(){
		return this.loginView;
	}
	
	public DonatorePanel getUtenteView() {
		return this.utenteView;
	}
	
	public RegistrationPanel getRegistrationView() {
		return this.registrationView;
	}
	
	public MenuPanel getMenuView() {
		return this.menuView;
	}
	
	public InserisciCodFisPanel getCercaView() {
		return this.cercaView;
	}
	
	public CercaDonatorePanel getMostraDonatoreView() {
		return this.mostraDonatoreView;
	}
	
	public VisualPrenotazioniPanel getPrenotazioniView() {
		return this.prenotazioniView;
	}
	
	public PrenGiornoPanel getPreGiornoView() {
		return this.preGiornoView;
	}
	
	
	public SacchePanel getSaccheView() {
		return this.saccheView;
	}
	
	public RichiestePanel getRichiesteView() {
		return this.richiesteView;
	}
	
	public OspedalePanel getOspedaleView() {
		return this.ospedaleView;
	}
	

}