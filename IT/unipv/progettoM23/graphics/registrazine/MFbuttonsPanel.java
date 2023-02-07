package IT.unipv.progettoM23.graphics.registrazine;


import java.awt.GridLayout;

import javax.swing.*;

public class MFbuttonsPanel extends JPanel {
	
    public MFbuttonsPanel() {
    	
    	this.setLayout(new GridLayout(1,1));
    	
	    JRadioButton Mbutton = new JRadioButton("M");
	    JRadioButton Fbutton = new JRadioButton("F");
	    
	    ButtonGroup MFbuttons=new ButtonGroup();
	    MFbuttons.add(Mbutton);
	    MFbuttons.add(Fbutton);
	    
	    this.add(Mbutton);
	    this.add(Fbutton);
    }
}
