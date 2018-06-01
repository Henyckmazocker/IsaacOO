import java.io.Serializable;

public class Bomb extends Objects implements Serializable{
	
	int range;

	public Bomb(int x, int y, int r) {
		super(x, y);
		
		this.range = r;
	}

	@Override
	public void effect() {

		if(Main.isaac.Bomb_count >= 0)
		{
			Bomb b= new Bomb (Main.isaac.x,Main.isaac.y, 1);
			
			Main.bombs.add(this);
		}
	
	}

	@Override
	protected void hit(int x, int y) {
		// TODO Auto-generated method stub

	}

}
