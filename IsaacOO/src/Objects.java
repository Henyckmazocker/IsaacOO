import java.io.Serializable;

public abstract class Objects extends Casillas implements Serializable{

	
	public Objects(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	
	public abstract void effect();

}
