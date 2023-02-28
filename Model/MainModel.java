package Model;

public class MainModel {
    
	private ModelDonatore modelDonatore;
	private ModelCentroDonazioni modelCentro;
	private ModelOspedale modelOspedale;
	
	public MainModel() {
		
		modelDonatore=new ModelDonatore();
		modelCentro=new ModelCentroDonazioni();
		modelOspedale=new ModelOspedale();
	}
	
	
	
	public ModelDonatore getModelDonatore(){
		return this.modelDonatore;
	}
	
	public ModelCentroDonazioni getModelCentro() {
		return this.modelCentro;
	}
	
	public ModelOspedale getModelOspedale() {
		return this.modelOspedale;
	}
}
