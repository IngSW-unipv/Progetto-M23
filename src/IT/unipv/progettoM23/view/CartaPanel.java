package IT.unipv.progettoM23.view;

import javax.swing.JPanel;

public class CartaPanel extends JPanel {
    
	private static final long serialVersionUID = 1L;
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
