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
	
	public void eliminarHechizo(Hechizo h) {
		hechizosMago.remove(h);
	}
	public void agregarHechizo(Hechizo h) {
		if (!hechizosMago.contains(h)) {
			hechizosMago.add(h);
		}
	}
	
}
