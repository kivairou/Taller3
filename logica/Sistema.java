package logica;

import java.util.List;

import dominio.*;

public interface Sistema {
 
	void cargarDatos();
	void guardarDatos();
	
	boolean agregarMago(String nombre);
	boolean modificarMago(String nombreAntiguo, String nombreNuevo);
	boolean eliminarMago(String nombre);
	boolean agregarHechizoMago(String nombreMago, String nombreHechizo);
	boolean eliminarHechizoMago(String nombreMago, String nombreHechizo);
	
	boolean agregarHechizo(Hechizo h);
	boolean modificarHechizo(String nombre, Hechizo nuevoHechizo);
	boolean eliminarHechizo(String nombre);
	
	List<Hechizo> diezMejoresHechizos();
	List<Mago> tresMejoresMagos();
	List<Hechizo> mostrarHechizos();
	List<Mago> mostrarMagos();
	List<String> mostrarHechizosPuntuacion();
	List<String> mostrarMagosPuntuacion();

	Mago buscarMago(String nombre);
	Hechizo buscarHechizo(String nombre);
	
}
