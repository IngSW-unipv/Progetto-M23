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
				
		
		this.setSize(l,a);
		
		this.setLocation(posX,posY);
		
		//this.setLayout(null);                    //set layout=null per spostare elementi in jpanel
		
		Color col =new Color(140,0,0);
		this.setBackground(col);
		
		Container c=this.getContentPane();
		//c.setLayout(new GridLayout(20,20));
		
		//GridBagConstraints grid=new GridBagConstraints();
		SimplePanel p=new SimplePanel();
		p.setLayout(null);
		c.add(p);

		
	}
	
}