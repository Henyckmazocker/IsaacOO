import java.io.Serializable;

public class Bomb_suelo extends Objects implements Serializable{

	public Bomb_suelo(int x, int y) {
		super(x, y);

		
		
	}

	@Override
	public void effect() {

		Main.isaac.Bomb_count = Main.isaac.Bomb_count + 1;
		
	}

	@Override
	protected void hit(int x, int y) {
	}

}
