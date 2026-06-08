package dominio;

import java.util.ArrayList;

public class Mago {
	private String nombre;
	private ArrayList<Hechizo> hechizosMago;

	public Mago(String nombre) {

		this.nombre = nombre;
		this.hechizosMago = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	public ArrayList<Hechizo> getHechizosMago() {
		return hechizosMago;
	}

	public void eliminarHechizo(Hechizo h) {
		hechizosMago.remove(h);
	}

	public void agregarHechizo(Hechizo h) {
		if (!hechizosMago.contains(h)) {
			hechizosMago.add(h);
		}
	}

	public double calcularPuntuacionTotal() {
		double total = 0;
		for (Hechizo h: hechizosMago) {
			total += h.calcularPuntuacion();
		}
		return total;
	}
	
	public String txtFormato() {
		StringBuilder escritor = new StringBuilder();
        escritor.append(nombre).append(";");
        for (int i = 0; i < hechizosMago.size(); i++) {
            escritor.append(hechizosMago.get(i).getNombre());
            if (i < hechizosMago.size() - 1) {
                escritor.append("|");
            }
        }
        return escritor.toString();
	}

}