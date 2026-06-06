package dominio;

public class HechizoPlanta extends Hechizo {
	private int cantPlantas;
	private int duracionStun;

	public HechizoPlanta(String nombre, int dano,int duracionStun, int cantPlantas) {
		super(nombre, "Planta", dano);
		this.duracionStun = duracionStun;
		this.cantPlantas = cantPlantas;
	}

	
	public int getCantPlantas() {
		return cantPlantas;
	}


	public void setCantPlantas(int cantPlantas) {
		this.cantPlantas = cantPlantas;
	}


	public int getDuracionStun() {
		return duracionStun;
	}


	public void setDuracionStun(int duracionStun) {
		this.duracionStun = duracionStun;
	}


	@Override
	public double calcularPuntuacion() {
		
		return (this.dano +(this.cantPlantas * this.duracionStun));
	}




}
