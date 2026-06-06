package logica;

public interface Sistema {
 
	void cargarDatos();
	void guardarDatos();
	
	void agregarMago();
	void modificarMago();
	void eliminarMago();
	void agregarHechizoMago();
	void modificarHechizoMago();
	void eliminarHechizoMago();
	
	void diezMejoresHechizos();
	void tresMejoresMagos();
	void mostrarHechizos();
	void mostrarMagos();
	void mostrarHechizosPuntuacion();
	void mostrarMagosPuntuacion();
	
}
