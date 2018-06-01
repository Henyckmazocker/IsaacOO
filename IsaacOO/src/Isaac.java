import java.io.Serializable;

public class Isaac extends Characters implements Serializable{

	int Coin_counter;
	int Bomb_count;
	int img;

	public Isaac(int x, int y, int l, int a) {
		super(x,y,l,a);
		img = 1;
		
	}

	@Override
	public void move() {

		char c = Main.f.getActualChar();

		if(c == 'g') {
			
			Main.save();
			
		}else if (c == 'w') {
			
			if(Main.iscollisions(x-1,y)) {
				Main.mapa.CharMatrix[x][y] = null;
				Main.mapa.CharMatrix[x - 1][y] = this;
				x--;
			}else {
				hit(x-1,y);
			}
		}else if(c == 'a') {
			if(Main.iscollisions(x,y-1)) {
				Main.mapa.CharMatrix[x][y] = null;
				Main.mapa.CharMatrix[x][y - 1] = this;
				y--;
			}else {
				hit(x,y-1);
			}
		}else if (c == 's') {
			if(Main.iscollisions(x+1,y)) {
				Main.mapa.CharMatrix[x][y] = null;
				Main.mapa.CharMatrix[x + 1][y] = this;
				x++;
			}else {
				hit(x+1,y);
			}
		}else if (c == 'd') {
			 if(Main.iscollisions(x,y+1)) {
				Main.mapa.CharMatrix[x][y] = null;
				Main.mapa.CharMatrix[x][y + 1] = this;
				y++;
			 }else {
				 hit(x,y+1);
			 }
		}else {
			
			if(c == 'i') {
				Tear tear = new Tear(getX(),getY(),1);
				tear.move();
				Main.tears.add(tear);
				
			}
			if(c == 'j') {
				Tear tear = new Tear(getX(),getY(),2);
				tear.move();
				Main.tears.add(tear);
				
			}
			if(c == 'k') {
				Tear tear = new Tear(getX(),getY(),3);
				tear.move();
				Main.tears.add(tear);
			}
			if(c == 'l') {
				Tear tear = new Tear(getX(),getY(),4);
				tear.move();
				Main.tears.add(tear);
			} else {
				
				if(c == 'g') {
					Main.save();
				}else if(c == 'h') {
					Main.load();
				}
				
			}
			
		}
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public int getimg() {
		return img;
	}
	
	@Override
	public void die() {
		
		Main.mapa.limpiar();		
		Main.t.setImgbackground("game over.jpg");
		
		Main.timer.cancel();

	}

	@Override
	public void action() {	
		
	}

	@Override
	protected void hit(int x, int y) {
			

			if(Main.mapa.CharMatrix[x][y] instanceof Enemie){
				((Enemie) Main.mapa.CharMatrix[x][y]).attack(Main.isaac);
			}else if(Main.mapa.ExitMatrix[x][y] instanceof Exit){
				
				if(Main.win()) {
				((Exit) Main.mapa.ExitMatrix[x][y]).changemap(Main.mapa.ExitMatrix[x][y]);
				}else {
					
				}
			}
	}

}
