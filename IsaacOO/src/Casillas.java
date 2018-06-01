import java.io.Serializable;

public abstract class Casillas implements Serializable{

	int x, y;
	int img;

	protected abstract void hit(int x, int y);
	
	public int img()
	{
		return img;
	}

}
