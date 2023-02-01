package IT.unipv.progettoM23.graphics;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimplePanel extends JPanel {
	
	public SimplePanel() {
		
		JTextField insCD =new JTextField(20);
		this.add(insCD);
		
		JTextField insPSW =new JTextField(20);
		this.add(insPSW);
		
		Color c =new Color(140,0,0);
		this.setBackground(c);
	}
}
