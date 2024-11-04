package edu.badpals.View;

import edu.badpals.Model.Conectar;
import edu.badpals.Model.Pais;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ViewMenu {

    private final Conectar conectar;

    public ViewMenu(Conectar conectar) {
        this.conectar = conectar;
    }

    public void crearPais(Connection conector, Scanner scanner) throws SQLException {
        System.out.print("Nombre del país: ");
        String nombre = scanner.nextLine();
        System.out.print("Número de habitantes: ");
        int habitantes = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Capital: ");
        String capital = scanner.nextLine();
        System.out.print("Moneda: ");
        String moneda = scanner.nextLine();

        Pais pais = new Pais(nombre, habitantes, capital, moneda);
        conectar.CrearPais(conector, pais);
    }

    public void listarPaises(Connection conector) throws SQLException {
        List<Pais> paises = conectar.ListarPaises(conector);
        StringBuilder sb = new StringBuilder();
        sb.append("\n---Nombre - Habitantes - Capital - Moneda---\n");

        for (Pais pais : paises) {
            sb.append(pais.getNombre()).append(" - ")
                    .append(pais.getHabitantes()).append(" - ")
                    .append(pais.getCapital()).append(" - ")
                    .append(pais.getMoneda()).append("\n");
        }

        System.out.println(sb);
    }

    public void actualizarPais(Connection conector, Scanner scanner) throws SQLException {
        System.out.print("Nombre del país a actualizar: ");
        String nombre = scanner.nextLine();
        System.out.print("Número de habitantes: ");
        int habitantes = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Capital: ");
        String capital = scanner.nextLine();
        System.out.print("Moneda: ");
        String moneda = scanner.nextLine();

        Pais pais = new Pais(nombre, habitantes, capital, moneda);
        conectar.UpdatePais(conector, pais);
    }

    public void eliminarPais(Connection conector, Scanner scanner) throws SQLException {
        System.out.print("Nombre del país a borrar: ");
        String nombre = scanner.nextLine();

        Pais pais = new Pais(nombre, 0, "", "");
        conectar.EliminarPais(conector, pais);
    }
}
