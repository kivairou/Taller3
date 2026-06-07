package logica;

import java.util.List;

import dominio.*;

public interface Sistema {
 
	void cargarDatos();
	void guardarDatos();
	
	boolean agregarMago();
	boolean modificarMago();
	boolean eliminarMago();
	boolean agregarHechizoMago();
	boolean modificarHechizoMago();
	boolean eliminarHechizoMago();
	
	List<Hechizo> diezMejoresHechizos();
	List<Mago> tresMejoresMagos();
	List<Hechizo> mostrarHechizos();
	List<Mago> mostrarMagos();
	List<Hechizo> mostrarHechizosPuntuacion();
	List<Mago> mostrarMagosPuntuacion();

	Mago buscarMago(String nombre);
	Hechizo buscarHechizo(String nombre);
	
}
