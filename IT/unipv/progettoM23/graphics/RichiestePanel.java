package IT.unipv.progettoM23.graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RichiestePanel extends JPanel{
 
	
	public RichiestePanel() {
	    this.setLayout(new BorderLayout());
	    
	    this.setBackground(new Color(100,0,0));
	    
	
	    String[] columnNames = { "Gruppo", "Quantità", "Giorno", "Richiedente" };
	    String[][] data = {
	      {"A", "1","10-11-2022", "VVSPLJ00H54Z314X"},
	      {"B", "5", "27-09-2022", "LLETFJ88F21S12B"},
	      {"AB", "10","09-02-2022", "PLSJSH22F48X192A"},
	       {"0", "20", "12-10-2022", "SLSKDA98B38S281B"}
	      };
	
	    DefaultTableModel model = new DefaultTableModel(data, columnNames);
	    
	    JTable table = new JTable(model);
	    JScrollPane scrollPane = new JScrollPane(table);
	    //scrollPane.setPreferredSize(new Dimension(400, 200));
	
	    this.add(scrollPane,BorderLayout.CENTER);
	    
	}
  }
