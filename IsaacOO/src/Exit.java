import java.io.Serializable;

public class Exit extends Casillas implements Serializable {

	int x;
	int y;
	int dir;

	public Exit(int x, int y, int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;

	}

	@Override
	protected void hit(int x, int y) {
	}

	public void changemap(Exit exit) {

		if (exit.dir == 1) {

			Main.mapa.x--;

			Main.mapa.CurrentMap = Mapademapas.mapademapas[Main.mapa.x][Main.mapa.y];
			
			Main.initWorld();
			Main.mapa.x--;

			
			Main.isaac.x = 10;

		} else if (exit.dir == 2) {
			
			Main.mapa.y--;

			Main.mapa.CurrentMap = Mapademapas.mapademapas[Main.mapa.x][Main.mapa.y];
			
			Main.initWorld();
			Main.mapa.y--;

			
			Main.isaac.y = 13;

		} else if (exit.dir == 3) {
			
			Main.mapa.y++;

			Main.mapa.CurrentMap = Mapademapas.mapademapas[Main.mapa.x][Main.mapa.y];
			
			Main.initWorld();
			Main.mapa.y++;

			Main.isaac.y = 2;

		} else if (exit.dir == 4) {
			
			Main.mapa.x++;

			Main.mapa.CurrentMap = Mapademapas.mapademapas[Main.mapa.x][Main.mapa.y];
			
			Main.initWorld();
			Main.mapa.x++;

			Main.isaac.x = 2;


		}

	}

}
