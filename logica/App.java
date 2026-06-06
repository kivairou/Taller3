package logica;

import java.util.Scanner;

public class App {

	private static Scanner scan;
	private static Sistema sistema = new SistemaImpl();

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
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			default:
				System.out.println("Ingrese una opcion valida...");

			}

		} while (opcion != 7);

	}

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
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			default:
				System.out.println("Ingrese una opcion valida...");
			}

		} while (opcion != 7);

	}

}
