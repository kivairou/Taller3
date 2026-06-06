package dominio;

public class HechizoAgua extends Hechizo {
	private int presionAgua;
	private int cantidadHeal;

	public HechizoAgua(String nombre, int dano, int cantidadHeal, int presionAgua) {
		super(nombre, "Agua", dano);
		this.cantidadHeal = cantidadHeal;
		this.presionAgua = presionAgua;
	}

	public int getPresionAgua() {
		return presionAgua;
	}

	public void setPresionAgua(int presionAgua) {
		this.presionAgua = presionAgua;
	}

	public int getCantidadHeal() {
		return cantidadHeal;
	}

	public void setCantidadHeal(int cantidadHeal) {
		this.cantidadHeal = cantidadHeal;
	}

	@Override
	public double calcularPuntuacion() {
		return (this.dano + this.cantidadHeal + this.presionAgua) * 2.0;
	}

}
