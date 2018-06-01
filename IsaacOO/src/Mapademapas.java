
public class Mapademapas {

	private static Mapademapas instance;
	
	
		
		static String[][]mapademapas = {{null,"mapa2.txt","mapa4.txt"},
										{null,"mapa1.txt","mapa3.txt"},
										{null,null,null}};
		
	
	public static Mapademapas getInstance() {
		
		if(instance==null) {
			
			instance=new Mapademapas();
			
		}
		
		return instance;
		
	}
	
}
