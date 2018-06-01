import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Mapa implements Serializable{

	static int FILAS = 13;
	static int COLUMNAS = 15;
	public Casillas[][] matriz = new Casillas[FILAS][COLUMNAS];
	public Tear[][] projectileMatrix = new Tear[FILAS][COLUMNAS];
	public Characters[][] CharMatrix = new Characters[FILAS][COLUMNAS];
	public Exit[][] ExitMatrix = new Exit[FILAS][COLUMNAS];
	String CurrentMap = "mapa1.txt";
	int x = 1;
	int y = 1;

	public Mapa(String txt) {

		this.CurrentMap = txt;

		try {

			BufferedReader in = new BufferedReader(new FileReader(new File(txt)));

			while (in.ready()) {

				for (int i = 0; i < FILAS; i++) {

					String entrada = in.readLine();
					String[] aen = entrada.split(" ");

					for (int j = 0; j < aen.length; j++) {

						if (aen[j].equals("P")) {

							Piedra piedra = new Piedra(i, j);

							matriz[i][j] = piedra;

						} else if (aen[j].equals("N")) {

							Muro muro = new Muro(i, j);

							matriz[i][j] = muro;

						} else if (aen[j].equals("E")) {

							Enemie enemie = new Enemie(i, j, 10, 2);

							CharMatrix[i][j] = enemie;

							Main.enemies.add(enemie);
						
						}else  if (aen[j].equals("I")) {

						
						}else if (aen[j].equals("O1")) {

							Exit exit = new Exit(i, j, 1);

							ExitMatrix[i][j] = exit;

						} else if (aen[j].equals("O2")) {

							Exit exit = new Exit(i, j, 2);

							ExitMatrix[i][j] = exit;

						} else if (aen[j].equals("O3")) {

							Exit exit = new Exit(i, j, 3);

							ExitMatrix[i][j] = exit;

						} else if (aen[j].equals("O4")) {

							Exit exit = new Exit(i, j, 4);

							ExitMatrix[i][j] = exit;
						}

					}
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int[][] toIntMatrix() {

		int[][] imat = new int[FILAS][COLUMNAS];

		for (int i = 1; i < FILAS - 1; i++) {
			for (int j = 1; j < COLUMNAS - 1; j++) {

				try {

					imat[i][j] = matriz[i][j].img();

				} catch (NullPointerException e) {

				}
			}
		}

		return imat;
	}

	public boolean enemiesLeft() {

		
		if(Main.enemies.isEmpty()) {
			return false;
		}else {
			return true;
		}

	}

	public void limpiar() {

		for (int i = 0; i < FILAS; i++) {
			for (int j = 0; j < COLUMNAS; j++) {

				if (matriz[i][j] instanceof Casillas) {

					matriz[i][j] = null;
				}else {

				if (CharMatrix[i][j] instanceof Characters) {

					CharMatrix[i][j] = null;
				}
				}

			}
		}

	}

	public int[][] overdraw(Isaac isaac, ArrayList<Enemie> enemies, ArrayList<Tear> tears) {

		int[][] imat = new int[FILAS][COLUMNAS];

		imat[Main.isaac.x][Main.isaac.y] = Main.isaac.getimg();

		for (Enemie enemie : enemies)

		{

			imat[enemie.x][enemie.y] = enemie.getimg();

		}
		
		for (Tear tear : tears)

		{

			imat[tear.x][tear.y] = tear.img();

		}

		return imat;
	}

}
