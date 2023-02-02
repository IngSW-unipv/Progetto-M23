package IT.unipv.progettoM23.graphics;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimplePanel extends JPanel {
	
	public SimplePanel() {
		
		
		this.setLayout(null);//new GridBagLayout());
		//GridBagConstraints c=new GridBagConstraints();
		//c.insets= new Insets(100,100,100,100);
		
		JTextField insCD =new JTextField(20);
		insCD.setBounds(400, 200,20,50);
		//c.gridx=0;
		//c.gridy=0;
		//this.add(insCD,c);
		
		JTextField insPSW =new JTextField(20);
		//c.gridx=10;
		//c.gridy=30;
		//this.add(insPSW,c);
		
		Color col =new Color(50,0,0);
		this.setBackground(col);
		
		//this.repaint();
	}
}
