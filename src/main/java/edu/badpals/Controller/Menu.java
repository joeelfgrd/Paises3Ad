package edu.badpals.Controller;

import edu.badpals.View.ViewMenu;

import java.sql.Connection;
import java.util.Scanner;

public class Menu {

    private final ViewMenu viewMenu;
    private final Connection conector;

    public Menu(ViewMenu viewMenu, Connection conector) {
        this.viewMenu = viewMenu;
        this.conector = conector;
    }

    public void mostrarMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            int opcion;
            do {
                System.out.println("\n--- Menú CRUD Países ---");
                System.out.println("1. Crear un nuevo país");
                System.out.println("2. Leer todos los países");
                System.out.println("3. Actualizar un país");
                System.out.println("4. Borrar un país");
                System.out.println("5. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1 -> viewMenu.crearPais(conector, scanner);
                    case 2 -> viewMenu.listarPaises(conector);
                    case 3 -> viewMenu.actualizarPais(conector, scanner);
                    case 4 -> viewMenu.eliminarPais(conector, scanner);
                    case 5 -> System.out.println("Saliendo del programa...");
                    default -> System.out.println("Opción no válida.");
                }
            } while (opcion != 5);
        } catch (Exception e) {
            System.err.println("Error al procesar el menú: " + e.getMessage());
        }
    }
}
