package IT.unipv.progettoM23.graphics;

import java.awt.*;
import javax.swing.*;


public class CenteredFrame extends JFrame{
    
	public CenteredFrame(int l,int a) {
		
		Toolkit kit =Toolkit.getDefaultToolkit();
		Dimension screenSize= kit.getScreenSize();
		
		int AltScreen=screenSize.height;
		int LunScreen=screenSize.width;
		
		
		int posX=(LunScreen-l)/2;
		int posY=(AltScreen-a)/2;
				
		
		setSize(l,a);
		
		setLocation(posX,posY);
		
		
        SimplePanel p=new SimplePanel();	
		Container c=this.getContentPane();
		c.add(p);
		
	}
	
}