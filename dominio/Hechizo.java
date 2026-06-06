package dominio;

public abstract class Hechizo {
	protected String nombre;
	protected String tipo;
	protected int dano;
	
	public Hechizo(String nombre, String tipo, int dano) {
		
		this.nombre = nombre;
		this.tipo = tipo;
		this.dano = dano;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public int getDano() {
		return dano;
	}
	
	public abstract double calcularPuntuacion();
}
