package edu.badpals;

import edu.badpals.Controller.Menu;
import edu.badpals.Model.Conectar;
import edu.badpals.View.ViewMenu;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Conectar conectar = new Conectar();

        try (Connection conector = conectar.crearConexion()) {
            if (conector != null) {
                ViewMenu viewMenu = new ViewMenu(conectar);
                Menu menu = new Menu(viewMenu, conector);
                menu.mostrarMenu();
            }
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }
    }
}
