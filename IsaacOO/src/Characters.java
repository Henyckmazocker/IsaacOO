import java.io.Serializable;



public abstract class Characters implements Serializable{
	
	int x;
	int y;
	int life;
	int attck;
	
	public Characters(int x, int y, int l, int a) {
		this.x=x;
		this.y=y;
		this.life=l;
		this.attck=a;	
	}
	
	public abstract void move();
	
	public abstract void die();
	
	public abstract void action();
	
	protected abstract void hit(int x, int y);

}
