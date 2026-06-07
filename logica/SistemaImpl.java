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

	}

	@Override
	public boolean agregarMago() {
		return false;
		// TODO Auto-generated method stub

	}

	@Override
	public boolean modificarMago() {
		return false;
		// TODO Auto-generated method stub

	}

	@Override
	public boolean eliminarMago() {
		return false;
		// TODO Auto-generated method stub

	}

	@Override
	public boolean agregarHechizoMago() {
		return false;
		// TODO Auto-generated method stub

	}

	@Override
	public boolean modificarHechizoMago() {
		return false;
		// TODO Auto-generated method stub

	}

	@Override
	public boolean eliminarHechizoMago() {
		return false;
		// TODO Auto-generated method stub

	}

	@Override
	public List diezMejoresHechizos() {
		return hechizos;
		// TODO Auto-generated method stub

	}

	@Override
	public List tresMejoresMagos() {
		return hechizos;
		// TODO Auto-generated method stub

	}

	@Override
	public List mostrarHechizos() {
		return hechizos;
		// TODO Auto-generated method stub

	}

	@Override
	public List mostrarMagos() {
		return hechizos;
		// TODO Auto-generated method stub

	}

	@Override
	public List mostrarHechizosPuntuacion() {
		return hechizos;
		// TODO Auto-generated method stub

	}

	@Override
	public List mostrarMagosPuntuacion() {
		return hechizos;
		// TODO Auto-generated method stub

	}

	@Override
	public Mago buscarMago(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hechizo buscarHechizo(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
