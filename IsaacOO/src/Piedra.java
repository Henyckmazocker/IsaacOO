import java.io.Serializable;

public class Piedra extends Casillas implements Serializable{
	
	
	
	public Piedra(int x, int y)
	{
		
		this.x = x;
		this.y = y;
		
		img = 4;
	}

	@Override
	protected void hit(int x, int y)
	{
		
	}


	public int img()
	{
		return img;
	}
}
