import java.io.Serializable;

public class Muro extends Casillas implements Serializable{

	
	
	public Muro(int x, int y){
		
		this.x=x;
		this.y=y;
		img = 0;
		
	}
	
	public int getimg() {
		
		return img;
	}
	
	@Override
	protected void hit(int x, int y) {
		
	}

}
