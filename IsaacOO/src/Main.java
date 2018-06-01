import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Main{

	static Taulell t = new Taulell();
	static Finestra f = new Finestra(t);
	static Timer timer = new Timer();
	static Isaac isaac = new Isaac(2,2,10,10);
	static Enemie enemie;
	public static  ArrayList<Casillas> col = new ArrayList<Casillas>();
	public static  ArrayList<Tear> tears = new ArrayList<Tear>();
	public static  ArrayList<Enemie> enemies = new ArrayList<Enemie>();
	public static  ArrayList<Bomb> bombs = new ArrayList<Bomb>();
	public static Mapa mapa = new Mapa("mapa1.txt");
	public static Mapademapas mapademapas;
	public static  int count = 0;
	
	public static void main(String[] args) {

		initgfx();
		initpartida();
		view();
		jugar();

	}

	public static  boolean iscollisions(int x, int y) {
		
		if(mapa.matriz[x][y] == null && mapa.CharMatrix[x][y] == null && mapa.ExitMatrix[x][y] == null && mapa.projectileMatrix[x][y] == null) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	public static void initWorld(){
		
		System.out.println(mapa.CurrentMap);
	
		mapa = new Mapa(mapa.CurrentMap);
				
		t.setImgbackground("mapa0.jpg");
		
	}

	private static  void jugar() {

		count++;
		movetear();
		
		view();

		if (count % 2 == 0)isaac.move();
		if (count % 2 == 0)moveenemies();
		
		view();
		win();

	}

	public static  boolean win() {
		
		if(!mapa.enemiesLeft()) {
		
		t.setImgbackground("mapa1.jpg");
		//Main.mapa.limpiar();
		view();
		
		return true;
		}else {
			return false;
		}
		
	}

	private static  void moveenemies() {
		
		for (int i = 0; i < enemies.size(); i++) {

			enemies.get(i).move();

		}
	}

	private static  void movetear() {

		for (int i = 0; i < tears.size(); i++) {

			tears.get(i).move();

		}

	}

	private static  void initpartida() {
		
		timer.schedule(new TimerTask() {

			public void run() {

				jugar();
			}

		}, 0, 300);
	}

	private static  void initgfx() {
		// background
		t.setActimgbackground(true);
		t.setImgbackground("mapa0.jpg");
		t.setPAD(0);
		// imagenes
		t.setActimatges(true);
		String[] imatges = { "", "isaac.png", "bubble.png", "", "piedra.png", "isaac_standing.png", "", "", "", "", "",
				"", "", "", "", "", "", "", "", "", "", "", "", "" };
		t.setImatges(imatges);

	}

	static void view() {
		t.dibuixa(mapa.toIntMatrix());
		t.overdibuixa(mapa.overdraw(isaac, enemies, tears));
	}

	public static void save() {

		FileOutputStream fos;
		try {
			fos = new FileOutputStream("save.sav");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(mapa);
			oos.writeObject(isaac);
			oos.writeObject(enemies);
			oos.writeObject(tears);
			System.out.println("Guardado");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void load() {
		
		FileInputStream fis;
		try {
			fis = new FileInputStream("save.sav");
			
			ObjectInputStream ois = new ObjectInputStream(fis);
			while(true) {
				Object o = ois.readObject();
				if (o instanceof Mapa) mapa = (Mapa) o;
				else if(o instanceof Isaac) isaac = (Isaac) o;
				else if(o instanceof ArrayList<?>) {
					ArrayList<?> ao = (ArrayList<?>) o;
					if(ao.isEmpty()) {
						
					}else {
					Object so = ao.get(0);
					if (so instanceof Enemie) enemies = (ArrayList<Enemie>) o;
					else if (so instanceof Tear) tears = (ArrayList<Tear>) o;
					}
					System.out.println(enemies.size());
				}
				System.out.println("Cargado");
				System.out.println(mapa.CurrentMap);
				
			}
			
		} catch (IOException | ClassNotFoundException e) {
			
			if(mapa.enemiesLeft()) {
			
			t.setImgbackground("mapa0.jpg");
			
			}
			System.out.println("Cargado");
		}
		
	}


}
