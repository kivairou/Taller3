// Tomás Ignacio Zepeda Velasquez | 21789061-6 | ICCI
// Kevin Matias Mauricio Zamora Riquelme | 21578521-1 | ICCI

package logica;

import java.util.Scanner;

import dominio.*;

public class App {

	private static Scanner scan;
	private static Sistema sistema = SistemaImpl.getInstancia();

	public static void main(String[] args) {

		
		scan = new Scanner(System.in);
		int opcion = 0;
		do {
			System.out.println("==== MENU PRINCIPAL ====");
			System.out.println("1. Panel Administrador");
			System.out.println("2. Panel Analista");
			System.out.println("3. Salir");
			System.out.print("Ingrese una opcion: ");

			opcion = scan.nextInt();
			scan.nextLine();

			switch (opcion) {
			case 1:
				menuAdmin();
				break;
			case 2:
				menuAnalista();
				break;
			case 3:
				System.out.println("Adios...");
				break;
			default:
				System.out.println("Ingrese una opcion valida...");

			}

		} while (opcion != 3);

	}
	// Menu Analista
	private static void menuAnalista() {
		int opcion = 0;

		do {
			System.out.println("==== MENU ANALISTA ====");
			System.out.println("1. Top 10 Mejores Hechizos");
			System.out.println("2. Top 3 Mejores Magos");
			System.out.println("3. Mostrar Todos los Hechizos");
			System.out.println("4. Mostrar Todos los Magos");
			System.out.println("5. Mostrar Todos los Hechizos junto a su Puntuacion");
			System.out.println("6. Mostrar Todos los Magos junto a su Puntuacion");
			System.out.println("7. Salir");
			System.out.print("Ingrese una opcion: ");

			opcion = scan.nextInt();
			scan.nextLine();

			switch (opcion) {
			case 1:
				System.out.println("\n--- TOP 10 MEJORES HECHIZOS ---");
                int rankH = 1;
                for (Hechizo h : sistema.diezMejoresHechizos()) {
                    System.out.println(rankH + ". " + h.txtFormato() + "| Puntuacion:" + h.calcularPuntuacion());
                    rankH++;
                }
				break;
			case 2:
				System.out.println("\n--- TOP 3 MEJORES MAGOS ---");
                int rankingM = 1;
                for (Mago m : sistema.tresMejoresMagos()) {
                    System.out.println(rankingM + ". " + m.txtFormato() +"| Puntuacion: "+ m.calcularPuntuacionTotal());
                    rankingM++;
                }
				break;
			case 3:
				System.out.println("\n--- TODOS LOS HECHIZOS ---");
                for (Hechizo h : sistema.mostrarHechizos()) {
                    System.out.println("- " + h.txtFormato());
                }
				break;
			case 4:
				System.out.println("\n--- TODOS LOS MAGOS ---");
                for (Mago m : sistema.mostrarMagos()) {
                    System.out.println("- " + m.txtFormato());
                }
				break;
			case 5:
				System.out.println("\n--- HECHIZOS Y SUS PUNTUACIONES ---");
                
                for (String lineaHechizo : sistema.mostrarHechizosPuntuacion()) {
                    System.out.println(lineaHechizo);
                }
				break;
			case 6:
				System.out.println("\n--- MAGOS Y SUS PUNTUACIONES ---");
               
                for (String lineaMago : sistema.mostrarMagosPuntuacion()) {
                    System.out.println(lineaMago);
                }
				break;
			case 7:
				break;
			default:
				System.out.println("Ingrese una opcion valida...");

			}

		} while (opcion != 7);

	}
	// Menu Administrador
	private static void menuAdmin() {
		int opcion = 0;

		do {
			System.out.println("==== MENU ADMINISTRADOR ====");
			System.out.println("1. Agregar Mago");
			System.out.println("2. Modificar Mago");
			System.out.println("3. Eliminar Mago");
			System.out.println("4. Agregar Hechizo");
			System.out.println("5. Modificar Hechizo");
			System.out.println("6. Eliminar Hechizo");
			System.out.println("7. Salir");
			System.out.print("Ingrese una opcion: ");

			opcion = scan.nextInt();
			scan.nextLine();

			switch (opcion) {
			case 1:
				System.out.print("Ingrese el nombre del nuevo mago: ");
				String nombreMago = scan.nextLine();
				if(sistema.agregarMago(nombreMago)) {
					System.out.println("Mago : "+ nombreMago + " creado con exito");
				}else {
					System.out.println("Ya existe un mago con ese nombre...");
				}
				break;
			case 2:
				menuModificarMago();
				break;
			case 3:
				System.out.print("Ingrese el nombre del mago a eliminar: ");
				String nombreMagoEliminar = scan.nextLine();
				if(sistema.eliminarMago(nombreMagoEliminar)) {
					System.out.println("Mago eliminado correctamente");
				}else {
					System.out.println("El mago no existe...");
				}
				break;
			case 4:
				crearHechizo();
				break;
			case 5:
				modificarHechizo();
				break;
			case 6:
				System.out.print("Ingrese el nombre del hechizo a eliminar: ");
                String hechizoEliminar = scan.nextLine();
                if (sistema.eliminarHechizo(hechizoEliminar)) {
                    System.out.println("Hechizo eliminado");
                } else {
                    System.out.println("hechizo no encontrado");
                }
				break;
			case 7:
				break;
			default:
				System.out.println("Ingrese una opcion valida...");
			}

		} while (opcion != 7);

	}
	// 
	private static void modificarHechizo() {
		System.out.print("Ingrese el nombre del hechizo a modificar: ");
        String nombre = scan.nextLine();
        Hechizo viejo = sistema.buscarHechizo(nombre);
        
        if (viejo == null) {
            System.out.println("El hechizo no existe...");
            return;
        }
        
        try {
            System.out.print("Nuevo Dano para " + viejo.getNombre() + ": ");
            int dano = Integer.parseInt(scan.nextLine());
            Hechizo nuevo = null;
            
            if (viejo instanceof HechizoFuego) {
                System.out.print("Nueva Duración Quemadura: ");
                nuevo = new HechizoFuego(viejo.getNombre(), dano, Integer.parseInt(scan.nextLine()));
            } else if (viejo instanceof HechizoTierra) {
                System.out.print("Nueva Mejora Defensa: ");
                nuevo = new HechizoTierra(viejo.getNombre(), dano, Integer.parseInt(scan.nextLine()));
            } else if (viejo instanceof HechizoPlanta) {
                System.out.print("Nueva Duración Stun: "); int duracionStun = Integer.parseInt(scan.nextLine());
                System.out.print("Nueva Cantidad Plantas: "); int cantidadPlantas = Integer.parseInt(scan.nextLine());
                nuevo = new HechizoPlanta(viejo.getNombre(), dano, duracionStun, cantidadPlantas);
            } else if (viejo instanceof HechizoAgua) {
                System.out.print("Nueva Cantidad Heal: "); int heal = Integer.parseInt(scan.nextLine());
                System.out.print("Nueva Presión Agua: "); int presionAgua = Integer.parseInt(scan.nextLine());
                nuevo = new HechizoAgua(viejo.getNombre(), dano, heal, presionAgua);
            }
            
            if (nuevo != null) {
                sistema.modificarHechizo(nombre, nuevo);
                System.out.println("Propiedades del hechizo actualizadas!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Datos numericos invalidos...");
        }
	}

	private static void crearHechizo() {
		try {
            System.out.print("Nombre del Hechizo: ");
            String nombre = scan.nextLine();
            System.out.print("Tipo (Fuego / Tierra / Planta / Agua): ");
            String tipo = scan.nextLine();
            System.out.print("Dano Base: "); 
            int dano = Integer.parseInt(scan.nextLine());
            
            Hechizo nuevo = null;
            switch (tipo.toLowerCase()) {
                case "fuego":
                    System.out.print("Duración de la Quemadura: ");
                    int duracionQuemadura = Integer.parseInt(scan.nextLine());
                    nuevo = new HechizoFuego(nombre, dano, duracionQuemadura);
                    break;
                case "tierra":
                    System.out.print("Mejora de Defensa: ");
                    int mejoraDefensa = Integer.parseInt(scan.nextLine());
                    nuevo = new HechizoTierra(nombre, dano, mejoraDefensa);
                    break;
                case "planta":
                    System.out.print("Duración del Stun: ");
                    int duracionStun = Integer.parseInt(scan.nextLine());
                    System.out.print("Cantidad de Plantas: ");
                    int cantPlantas = Integer.parseInt(scan.nextLine());
                    nuevo = new HechizoPlanta(nombre, dano, duracionStun, cantPlantas);
                    break;
                case "agua":
                    System.out.print("Cantidad de Heal: ");
                    int cantidadHeal = Integer.parseInt(scan.nextLine());
                    System.out.print("Presión del Agua: ");
                    int presionAgua = Integer.parseInt(scan.nextLine());
                    nuevo = new HechizoAgua(nombre, dano, cantidadHeal, presionAgua);
                    break;
                default:
                    System.out.println("Tipo de elemento no reconocido");
                    return;
            }
            
            if (nuevo != null && sistema.agregarHechizo(nuevo)) {
                System.out.println("Hechizo registrado globalmente en el sistema");
            } else {
                System.out.println("el hechizo ya existe...");
            }
        } catch (NumberFormatException e) {
            System.out.println("Ingrese numeros validos...");
        }
		
	}

	private static void menuModificarMago() {
		System.out.print("Ingrese el nombre del mago que desea modificar: ");
        String antiguoNom = scan.nextLine();
        Mago mago = sistema.buscarMago(antiguoNom);
        
        if (mago == null) {
            System.out.println("Error: El mago " + antiguoNom + " no existe");
            return;
        }

        System.out.println("\n¿Que desea modificar de " + mago.getNombre() + "?");
        System.out.println("1) Modificar su Nombre");
        System.out.println("2) Enseñarle un nuevo Hechizo");
        System.out.println("3) Hacerle olvidar un Hechizo");
        System.out.print("Seleccione: ");
        
        try {
            int op = Integer.parseInt(scan.nextLine());
            if (op == 1) {
                System.out.print("Ingrese el NUEVO nombre para el mago: ");
                String nuevoNom = scan.nextLine();
                if (sistema.modificarMago(antiguoNom, nuevoNom)) {
                    System.out.println("Nombre actualizado a " + nuevoNom + " de forma exitosa");
                } else {
                    System.out.println("No se pudo cambiar el nombre ya está en uso por otro mago");
                }
            } else if (op == 2) {
                System.out.print("Ingrese el nombre del Hechizo a enseñarle: ");
                String hechizoEnsenar = scan.nextLine();
                // Vincula un hechizo existente a la lista interna del mago seleccionado
                if (sistema.agregarHechizoMago(antiguoNom, hechizoEnsenar)) {
                    System.out.println("Hechizo aprendido con exito!");
                } else {
                    System.out.println("Verifique que el hechizo exista y que el mago no lo conozca ya");
                }
            } else if (op == 3) {
                System.out.print("Ingrese el nombre del Hechizo a olvidar: ");
                String hechizoOlvidar = scan.nextLine();
                // Remueve el hechizo específico de la lista interna del mago
                if (sistema.eliminarHechizoMago(antiguoNom, hechizoOlvidar)) {
                    System.out.println("El mago ha olvidado el hechizo correctamente");
                } else {
                    System.out.println("El mago no posee ese hechizo");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada invalida...");
        }
		
	}

}
