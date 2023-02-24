package IT.unipv.progettoM23.graphics;

import javax.swing.JPanel;

public class CartaPanel extends JPanel {
    
	private String key;
	
	public CartaPanel() {
		super();
	}
	
	public void setKey(String k) {
		this.key=k;
	}
	
	public String getKey() {
		return this.key;
	}
	
}
