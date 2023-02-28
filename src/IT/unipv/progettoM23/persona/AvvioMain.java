package IT.unipv.progettoM23.persona;

import IT.unipv.progettoM23.controller.MainController;
import IT.unipv.progettoM23.model.MainModel;
import IT.unipv.progettoM23.view.CenteredFrame;


  public class AvvioMain {
	
	public AvvioMain() {}	

	public static void main(String[] args) {
    
		CenteredFrame frame= new CenteredFrame(800,600);   
		
		MainModel model= new MainModel();
		
		MainController controller= new MainController(frame,model);
		
		controller.avviaController();


	}
	
}
