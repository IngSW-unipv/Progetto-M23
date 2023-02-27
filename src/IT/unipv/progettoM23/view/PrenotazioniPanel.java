package IT.unipv.progettoM23.view;

import java.awt.*;
import java.sql.Date;
import java.time.LocalDate;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;



public class PrenotazioniPanel extends CartaPanel{
	
	private static final long serialVersionUID = 1L;
	private JLabel testo;
	private ContainerPanel cp,container;
	private JButton indietro,cerca,conferma;
	private JTextField giornoTF,meseTF,annoTF;
	private JTable table;


    
	public PrenotazioniPanel() {
		
		this.setKey("prenotazioni");
		
		this.setLayout(new BorderLayout());
		
		this.setBackground(new Color(100,0,0));
		
		Color white=new Color(255,255,255);
		
		
		LocalDate todayLD =LocalDate.now();
		Date today=Date.valueOf(todayLD);
		
		
		
			
		container=new ContainerPanel(new GridLayout(0,3));
		
		
		cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));
		
		indietro =new JButton("Indietro");
		cp.add(indietro);
		
	    container.add(cp);

	    
	    
		cp=new ContainerPanel(new FlowLayout(FlowLayout.CENTER));
		
	    testo = new JLabel("cerca al giorno : ");
	    testo.setForeground(white);
	    cp.add(testo);
	    
	    giornoTF=new JTextField(2);
	    meseTF=new JTextField(2);
	    annoTF=new JTextField(4);
	    
	    cp.add(giornoTF);
	    cp.add(meseTF);
	    cp.add(annoTF);
	    
	    container.add(cp);
	    
	    
	    
	    
	    
	    
		cp=new ContainerPanel(new FlowLayout(FlowLayout.RIGHT));
		
		cerca =new JButton("Cerca");
		cp.add(cerca);
		
	    container.add(cp);

	    
	    this.add(container,BorderLayout.NORTH);
	    
	    
	    
	    
	    
	    
	    
	    
	    cp=new ContainerPanel(new FlowLayout(FlowLayout.LEFT));
		
	    testo = new JLabel(" Prenotazioni Di Oggi ("+today+") :");
	    testo.setForeground(white);
	    testo.setFont(new Font("Dialog",Font.PLAIN,20));
	    cp.add(testo,BorderLayout.NORTH);
	    
		table= new JTable();
		table.setPreferredSize(new Dimension(250,500));	
		
		cp.add(table,BorderLayout.CENTER);
	
		this.add(cp,BorderLayout.CENTER);
		
		
		
		
		
		
	    container=new ContainerPanel(new GridLayout(0,1));
	    
	    cp=new ContainerPanel(new FlowLayout(FlowLayout.CENTER));
	    container.add(cp);
	    
	    
	    cp=new ContainerPanel(new FlowLayout(FlowLayout.CENTER));

	    conferma =new JButton("Conferma");
		cp.add(conferma);
		
		container.add(cp);
		
		this.add(container,BorderLayout.EAST);
		
	}
	
	
	
	
	public JTable getTabellaPrenotazioni() {
		return this.table;
	}
	
	public JButton getConfermaButton() {
		return this.conferma;
	}
	
	public JButton getCercaButton() {
		return this.cerca;
	}	
	
	
	  public JButton getIndietroButton() {
		  return this.indietro;
	  }
	
	
	
	public void visualizzaPrenotazioni(String[][] dati) {
		String[] colonne= {"Codice Fiscale","Orario"};
		
		DefaultTableModel tabModel =new DefaultTableModel(dati,colonne);
		
		this.table.setModel(tabModel);
		
		if(table.getRowCount()!=0) {
		    table.setRowHeight((int) (table.getPreferredSize().getHeight()/table.getRowCount()));
		}
	}
	
	
	
	
	public String getSelectedValueOfTable() {
		
		try {
		    return (String)this.table.getValueAt(this.table.getSelectedRow(),0);
		}
		
		catch(Exception e) {
		   return null;
		}

	}
	
	
	
	
	public Date getContenutoData() {
		
		String giorno=this.giornoTF.getText();
		String mese=this.meseTF.getText();
		String anno=this.annoTF.getText();
		
		try {
		    Date d= Date.valueOf(anno+"-"+mese+"-"+giorno); 
		    return d;
		}
		
		catch (Exception e) {
			return null;
		}
	}
	
	
}
