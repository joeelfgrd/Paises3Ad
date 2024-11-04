package edu.badpals.Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
public class Conectar {
    String urldb = "jdbc:mysql://localhost:3306/paises_db";
    public Connection crearConexion() throws SQLException {
        Properties propiedadesConexion = new Properties();
        propiedadesConexion.setProperty("user", "root");
        propiedadesConexion.setProperty("password", "renaido");
        return DriverManager.getConnection(urldb, propiedadesConexion);
    }
    public void CrearPais(Connection conector, Pais pais) throws SQLException {
        String InsertarPais = "INSERT INTO pais (nombre, habitantes, capital, moneda) VALUES (?, ?, ?, ?)";
        try (PreparedStatement SttmtInsertarPais = conector.prepareStatement(InsertarPais);) {
            SttmtInsertarPais.setString(1, pais.getNombre());
            SttmtInsertarPais.setInt(2, pais.getHabitantes());
            SttmtInsertarPais.setString(3, pais.getCapital());
            SttmtInsertarPais.setString(4, pais.getMoneda());
            int numFilesInsertadas = SttmtInsertarPais.executeUpdate();
            System.out.println("Pais insertado, número de paises insertados: " + numFilesInsertadas);
        } catch (SQLException e) {
            System.err.println("Error SQL: " + e.getMessage());
        }
    }
    public void EliminarPais(Connection conector, Pais pais) throws SQLException {
        String BorrarPais = "DELETE FROM pais WHERE nombre = ?";
        try (PreparedStatement SttmtBorrarPais = conector.prepareStatement(BorrarPais);) {
            SttmtBorrarPais.setString(1, pais.getNombre());
            int numFilesBorradas = SttmtBorrarPais.executeUpdate();
            System.out.println("Pais eliminado, número de paises eliminados: " + numFilesBorradas);
        } catch (SQLException e) {
            System.err.println("Error SQL: " + e.getMessage());
        }
    }
    public void UpdatePais(Connection conector,Pais pais) throws SQLException{
        String ActualizarPais = "UPDATE pais SET habitantes = ?, capital = ?, moneda = ? WHERE nombre = ?";
        try (PreparedStatement SttmtActualizarPais = conector.prepareStatement(ActualizarPais);) {
            SttmtActualizarPais.setInt(1, pais.getHabitantes());
            SttmtActualizarPais.setString(2, pais.getCapital());
            SttmtActualizarPais.setString(3, pais.getMoneda());
            SttmtActualizarPais.setString(4, pais.getNombre());
            int numFilesActualizadas = SttmtActualizarPais.executeUpdate();
            System.out.println("Pais actualizado, número de paises actualizados: " + numFilesActualizadas);
        } catch (SQLException e) {
            System.err.println("Error SQL: " + e.getMessage());
        }

    }

    public List<Pais> ListarPaises(Connection conector) throws SQLException {
        ArrayList<Pais> ListaPaises = new ArrayList<>();
        String Leerpaises = "SELECT * FROM pais";
        try (Statement st = conector.createStatement();
             ResultSet rs = st.executeQuery(Leerpaises);) {
            while (rs.next()) {
                ListaPaises.add(new Pais(
                        rs.getString("nombre"),
                        rs.getInt("habitantes"),
                        rs.getString("capital"),
                        rs.getString("moneda")
                ));
            } } catch (SQLException e) {
            System.err.println("Error en ListarPaises en Conectar: " + e.getMessage());
        }
        return ListaPaises;
    }
}








