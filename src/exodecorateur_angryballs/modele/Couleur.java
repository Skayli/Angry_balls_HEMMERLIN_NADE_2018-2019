package exodecorateur_angryballs.modele;

/**
 * Classe représentant une couleur, au format RGB
 *
 */
public class Couleur {
	
	int red;
	int green;
	int blue;

	public Couleur(int r, int g, int b) {
		// TODO Auto-generated constructor stub
		this.red = r;
		this.blue = b;
		this.green = g;
	}

	public int getRed() {
		return red;
	}

	public int getGreen() {
		return green;
	}

	public int getBlue() {
		return blue;
	}
	
	public String toString() {
		return "Couleur[r:"+red+", g:"+green+"b:"+blue+"]";
	}
	
	public static Couleur red() {
		return new Couleur(255, 0, 0);
	}
	
	public static Couleur green() {
		return new Couleur(0, 255, 0);
	}
	
	public static Couleur blue() {
		return new Couleur(0, 0 ,255);
	}
	
	public static Couleur cyan() {
		return new Couleur(0, 255, 255);
	}
	
	public static Couleur yellow() {
		return new Couleur(255, 255, 0);
	}
	
	public static Couleur gray() {
		return new Couleur(128, 128, 128);
	}
	
	public static Couleur black() {
		return new Couleur(255, 255, 255);
	}
	
	public static Couleur white() {
		return new Couleur(0, 0, 0);
	}
	
	public static Couleur orange() {
		return new Couleur(255, 165, 0);
	}
	
	public static Couleur purple() {
		return new Couleur(238, 138, 138);
	}
	
	public static Couleur pink() {
		return new Couleur(255, 192, 203);
	}
	
	
	

}
