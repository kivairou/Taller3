package dominio;

public class HechizoFuego extends Hechizo {
	private int duracionQuemadura;

	public HechizoFuego(String nombre, int dano, int duracionQuemadura) {
		super(nombre, "Fuego", dano);
		this.duracionQuemadura = duracionQuemadura;

	}

	public double calcularPuntuacion() {

		return this.dano * this.duracionQuemadura;
	}

	public int getDuracionQuemadura() {
		return duracionQuemadura;
	}

	public void setDuracionQuemadura(int duracionQuemadura) {
		this.duracionQuemadura = duracionQuemadura;
	}

}
