import java.io.Serializable;

public class Tear extends Casillas implements Serializable{

	int d;
	
	public Tear(int x, int y, int d) {

		this.x = x;
		this.y = y;
		this.d = d;
		img = 2;

	}

	public void move() {

		switch (d) {

		case 1:
			if(Main.iscollisions(x-1,y)) {

				if (Main.mapa.CharMatrix[x][y] instanceof Isaac) {

					Main.mapa.projectileMatrix[x - 1][y] = this;
					x--;
					
				} else {
					Main.mapa.projectileMatrix[x][y] = null;
					Main.mapa.projectileMatrix[x - 1][y] = this;
					x--;
				}
			}else {
				hit(x-1,y);
				Main.mapa.projectileMatrix[x][y] = null;
				Main.tears.remove(this);

			}
			break;
			
		case 2:
			if (Main.iscollisions(x,y-1)) {

				if (Main.mapa.CharMatrix[x][y] instanceof Isaac) {

					Main.mapa.projectileMatrix[x][y - 1] = this;
					y--;
					
				} else {
					Main.mapa.projectileMatrix[x][y] = null;
					Main.mapa.projectileMatrix[x][y - 1] = this;
					y--;
				}
			}
			else {
				hit(x,y+1);
				Main.mapa.projectileMatrix[x][y] = null;
				Main.tears.remove(this);

			}
			break;
			
		case 3:
			if (Main.iscollisions(x+1,y)) {
				
				if(Main.mapa.CharMatrix[x][y] instanceof Isaac) {
					
					Main.mapa.projectileMatrix[x + 1][y] = this;
					x++;

				}else {
					
				Main.mapa.projectileMatrix[x][y] = null;
				Main.mapa.projectileMatrix[x + 1][y] = this;
				x++;
			}
			}
			else {
				hit(x+1,y);
				Main.mapa.projectileMatrix[x][y] = null;
				Main.tears.remove(this);

			}
			break;
			
		case 4:
			if (Main.iscollisions(x,y+1)) {
				if(Main.mapa.CharMatrix[x][y] instanceof Isaac) {
					
					Main.mapa.projectileMatrix[x][y + 1] = this;
					y++;

				}else {
				Main.mapa.projectileMatrix[x][y] = null;
				Main.mapa.projectileMatrix[x][y + 1] = this;
				y++;
			}
			}else {
				hit(x,y+1);
				Main.mapa.projectileMatrix[x][y] = null;
				Main.tears.remove(this);
			}
			break;
		}
		
		System.out.println(this.x +" "+ this.y);

	}

	public int getX() {
		
		return x;
		
	}
	
	public int getY() {
		
		return x;
		
	}
	
	@Override
	protected void hit(int x, int y) {
		
		
			if(Main.mapa.CharMatrix[x][y] instanceof Enemie){

				attack((Enemie) Main.mapa.CharMatrix[x][y]);
				
				if(Main.mapa.CharMatrix[this.x][this.y] instanceof Enemie) {
					
					attack((Enemie) Main.mapa.CharMatrix[x][y]);
					
				}
				
			}
	}

	static void attack(Enemie enemie) {
		
		enemie.life=enemie.life-Main.isaac.attck;
		
		if(enemie.life<=0) {
			
			enemie.die();
			
		}
		
	}

}
