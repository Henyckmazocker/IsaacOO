import java.io.Serializable;

public class Coin extends Objects implements Serializable{

	public Coin(int x, int y) {
		super(x, y);

		int value = 1;
		
	}


	@Override
	public void effect() {

		Main.isaac.Coin_counter = Main.isaac.Coin_counter + 1;
		
	}


	@Override
	protected void hit(int x, int y) {
		// TODO Auto-generated method stub
	}

}
