package logica;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dominio.*;
import java.util.Scanner;

public class SistemaImpl implements Sistema {
	// Instancia única global del sistema (Patrón Singleton)
	private static SistemaImpl instancia;
	
	private ArrayList<Mago> magos;
	private ArrayList<Hechizo> hechizos;

	public SistemaImpl(){
		this.magos = new ArrayList<>();
		this.hechizos = new ArrayList<>();
		cargarDatos();
	}
	
	public static SistemaImpl getInstancia()  {
		if (instancia == null) {
			instancia = new SistemaImpl();
		}
		return instancia;
	}
	

	@Override
	public void cargarDatos() {
		//cargar hechizos
		try {
			File txtHechizos = new File("Hechizos.txt");
			Scanner scan = new Scanner(txtHechizos);

			while (scan.hasNextLine()) {
				String linea = scan.nextLine();
				String[] partes = linea.split(";");

				String nombre = partes[0];
				String tipo = partes[1];
				int dano = Integer.parseInt(partes[2]);

				switch (tipo) {
				case "Fuego":
					int duracionQuemadura = Integer.parseInt(partes[3]);
					Hechizo nuevoHechizoFuego = new HechizoFuego(nombre, dano, duracionQuemadura);
					hechizos.add(nuevoHechizoFuego);
					break;
				case "Agua":
					String[] partesAgua = partes[3].split(",");
					int cantHeal = Integer.parseInt(partesAgua[0]);
					int presionAgua = Integer.parseInt(partesAgua[1]);
					Hechizo nuevoHechizoAgua = new HechizoAgua(nombre, dano, cantHeal, presionAgua);
					hechizos.add(nuevoHechizoAgua);
					break;
				case "Tierra":
					int mejoraDefensa = Integer.parseInt(partes[3]);
					Hechizo nuevoHechizoTierra = new HechizoTierra(nombre, dano, mejoraDefensa);
					hechizos.add(nuevoHechizoTierra);
					break;
				case "Planta":
					String[] partesPlanta = partes[3].split(",");
					int duracionStun = Integer.parseInt(partesPlanta[0]);
					int cantPlantas = Integer.parseInt(partesPlanta[1]);
					Hechizo nuevoHechizoPlanta = new HechizoPlanta(nombre, dano, duracionStun, cantPlantas);
					hechizos.add(nuevoHechizoPlanta);
					break;
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el archivo de hechizos...");
		}
		//cargar magos
		try {
			File txtMagos = new File("Magos.txt");
			Scanner scan = new Scanner(txtMagos);

			while (scan.hasNextLine()) {
				String linea = scan.nextLine();
				String[] partes = linea.split(";");

				String nombreMago = partes[0];
				Mago nuevoMago = new Mago(nombreMago);

				String[] hechizosMago = partes[1].split("\\|");
				for (String hNombre : hechizosMago) {
					Hechizo h = buscarHechizo(hNombre);
					if (h != null) {
						nuevoMago.agregarHechizo(h);
					}
				}
				magos.add(nuevoMago);
			}

		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el archivo de magos...");
		}
	}

	@Override
	public void guardarDatos() {
		//guardar hechizos
		try(BufferedWriter escritor = new BufferedWriter(new FileWriter("Hechizos.txt"))) {
			for(Hechizo h: hechizos) {
				escritor.write(h.txtFormato());
				escritor.newLine();
				
			}
		}catch(IOException e) {
			System.out.println("Error al guardar Hechizos.txt" + e.getMessage());
		}
		//guardar magos
		try(BufferedWriter escritor = new BufferedWriter(new FileWriter("Magos.txt"))) {
			for(Mago m: magos) {
				escritor.write(m.txtFormato());
				escritor.newLine();
				
			}
		}catch(IOException e) {
			System.out.println("Error al guardar Magos.txt" + e.getMessage());
		}

	}

	@Override
	public boolean agregarMago(String nombre) {
		if(buscarMago(nombre)!= null ) return false;
		magos.add(new Mago(nombre));
		guardarDatos();
		return true;
	}

	@Override
	public boolean modificarMago(String nombreAntiguo, String nombreNuevo) {
		Mago m = buscarMago(nombreAntiguo);
		if(m != null && (nombreAntiguo.equalsIgnoreCase(nombreNuevo) || buscarMago(nombreNuevo) == null)) {
			m.setNombre(nombreNuevo);
			guardarDatos();
			return true;
		}
		return false;
	

	}

	@Override
	public boolean eliminarMago(String nombre) {
		Mago m = buscarMago(nombre);
		if(m != null) {
			magos.remove(m);
			guardarDatos();
			return true;
		}
		return false;
	}

	@Override
	public boolean agregarHechizoMago(String nombreMago, String nombreHechizo) {
		Mago m = buscarMago(nombreMago);
		Hechizo h = buscarHechizo(nombreHechizo);
		if(m != null && h != null) {
			m.agregarHechizo(h);
			guardarDatos();
			return true;
		}
		return false;
	}

	@Override
	public boolean eliminarHechizoMago(String nombreMago, String nombreHechizo) {
		Mago m = buscarMago(nombreMago);
		Hechizo h = buscarHechizo(nombreHechizo);
		if(m != null && h != null) {
			m.eliminarHechizo(h);
			guardarDatos();
			return true;
		}
		return false;
	}

	@Override
	public boolean agregarHechizo(Hechizo h) {
		if(buscarHechizo(h.getNombre()) != null) return false;
		hechizos.add(h);
		guardarDatos();
		return true;
	}

	@Override
	public boolean modificarHechizo(String nombre, Hechizo nuevoHechizo) {
		Hechizo antiguo = buscarHechizo(nombre);
        if (antiguo != null) {
            int indice = hechizos.indexOf(antiguo);
            hechizos.set(indice, nuevoHechizo);
           
            for (Mago m : magos) {
                if (m.getHechizosMago().contains(antiguo)) {
                    m.eliminarHechizo(antiguo);
                    m.agregarHechizo(nuevoHechizo);
                }
            }
            guardarDatos();
            return true;
        }
		return false;
	}

	@Override
	public boolean eliminarHechizo(String nombre) {
		Hechizo h = buscarHechizo(nombre);
        if (h != null) {
            hechizos.remove(h);
            for (Mago m : magos) {
                m.eliminarHechizo(h);
            }
            guardarDatos();
            return true;
        }
		return false;
	}


	@Override
	public List<Hechizo> diezMejoresHechizos() {
		List<Hechizo> copia = new ArrayList<>(hechizos);
		// Expresión Lambda comparadora basada en cálculos dinámicos
        copia.sort((h1, h2) -> Double.compare(h2.calcularPuntuacion(), h1.calcularPuntuacion()));
        return copia.subList(0, Math.min(10, copia.size()));
	}

	@Override
	public List<Mago> tresMejoresMagos() {
		List<Mago> copia = new ArrayList<>(magos);
		// Lambda comparadora basada en la sumatoria agregada de las listas internas del mago
        copia.sort((m1, m2) -> Double.compare(m2.calcularPuntuacionTotal(), m1.calcularPuntuacionTotal()));
        return copia.subList(0, Math.min(3, copia.size()));
	}

	@Override
	public List<Hechizo> mostrarHechizos() {
		return hechizos;
		

	}

	@Override
	public List<Mago> mostrarMagos() {
		return magos;
		

	}

	@Override
	public List<String> mostrarHechizosPuntuacion() {
		List<String> reporte = new ArrayList<>();
	    
	    for (Hechizo h : hechizos) {
	        
	        double puntaje = h.calcularPuntuacion(); 
	       
	        String linea = h.txtFormato()+ " | Puntuación: " + puntaje;
	        reporte.add(linea);
	    }
	    
	    return reporte;
	}

	@Override
	public List<String> mostrarMagosPuntuacion() {
		List<String> reporte = new ArrayList<>();
	    
	    for (Mago m : magos) {
	        
	        double puntajeTotal = m.calcularPuntuacionTotal();
	        
	        
	        String linea = m.txtFormato() + " | Puntuación Total: " + puntajeTotal;
	        reporte.add(linea);
	    }
	    
	    return reporte;
	}

	@Override
	public Mago buscarMago(String nombre) {
		for(Mago m: magos) {
			if(m.getNombre().equalsIgnoreCase(nombre)) {
				return m;
			}
		}
		return null;
	}

	@Override
	public Hechizo buscarHechizo(String nombre) {
		for(Hechizo h: hechizos) {
			if(h.getNombre().equalsIgnoreCase(nombre)){
				return h;
			}
		}
		return null;
	}

	
}
