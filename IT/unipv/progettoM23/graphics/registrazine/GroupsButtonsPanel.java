package IT.unipv.progettoM23.graphics.registrazine;

import java.awt.GridLayout;

import javax.swing.*;


public class GroupsButtonsPanel extends JPanel {
	
    public GroupsButtonsPanel() {
    	
    	this.setLayout(new GridLayout(1,1));
    	
	    JRadioButton Abutton = new JRadioButton("A");
	    JRadioButton Bbutton = new JRadioButton("B");
	    JRadioButton ABbutton = new JRadioButton("AB");
	    JRadioButton Zbutton = new JRadioButton("0");
	    
	    ButtonGroup groupButtons=new ButtonGroup();
	    groupButtons.add(Abutton);
	    groupButtons.add(Bbutton);
	    groupButtons.add(ABbutton);
	    groupButtons.add(Zbutton);
	    
	    this.add(Abutton);
	    this.add(Bbutton);
	    this.add(ABbutton);
	    this.add(Zbutton);
    }
}
