import java.io.Serializable;

public class Enemie extends Characters implements Serializable{

	int img;
	
	public Enemie(int x, int y, int l, int a) {
		super(x,y,l,a);
		img = 5;
	}
	
	@Override
	public void move() {

			int opt = (int) (Math.random() * 4);
			switch (opt) {
			case 0:
				if (Main.iscollisions(x - 1, y)) {

					Main.mapa.CharMatrix[x][y] = null;
					Main.mapa.CharMatrix[x - 1][y] = this;

					x--;
				}else {
					hit(x-1,y);
				}
				break;
			case 1:
				if (Main.iscollisions(x, y - 1)) {

					Main.mapa.CharMatrix[x][y] = null;
					Main.mapa.CharMatrix[x][y - 1] = this;

					y--;
				}else {
					hit(x,y-1);
				}
				break;
			case 2:
				if (Main.iscollisions(x + 1, y)) {

					Main.mapa.CharMatrix[x][y] = null;
					Main.mapa.CharMatrix[x + 1][y] = this;

					x++;
				}else {
					hit(x+1,y);
				}
				break;
			case 3:
				if (Main.iscollisions(x, y + 1)) {

					Main.mapa.CharMatrix[x][y] = null;
					Main.mapa.CharMatrix[x][y + 1] = this;

					y++;
				}else {
					hit(x,y+1);
				}
				break;
			}
	}

	@Override
	public void die() {

		Main.mapa.CharMatrix[x][y] = null;
		
		Main.enemies.remove(this);
		
	}

	@Override
	public void action() {

	}
	
	public void attack(Isaac isaac) {
		
		Main.isaac.life=Main.isaac.life-this.attck;
		
		if(Main.isaac.life<=0) {
			Main.isaac.die();
		}
		
	}
	
	public int getimg() {
		return img;
	}

	@Override
	protected void hit(int x, int y) {

			
			if(Main.mapa.projectileMatrix[x][y] instanceof Tear) {
				Tear.attack(this);
			}	
		
			
			if(Main.mapa.CharMatrix[x][y] instanceof Isaac){
				attack(Main.isaac);
			}

	}
}
