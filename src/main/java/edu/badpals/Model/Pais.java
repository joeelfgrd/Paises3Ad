package edu.badpals.Model;

public class Pais {
    private String nombre;
    private int habitantes;
    private String capital;
    private String moneda;
    public Pais(String nombre, int habitantes, String capital, String moneda) {
        this.nombre = nombre;
        this.habitantes = habitantes;
        this.capital = capital;
        this.moneda = moneda;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getHabitantes() {
        return habitantes;
    }
    public void setHabitantes(int habitantes) {
        this.habitantes = habitantes;
    }
    public String getCapital() {
        return capital;
    }
    public void setCapital(String capital) {
        this.capital = capital;
    }
    public String getMoneda() {
        return moneda;
    }
    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "nombre='" + nombre + '\'' +
                ", habitantes=" + habitantes +
                ", capital='" + capital + '\'' +
                ", moneda='" + moneda + '\'' +
                '}';
    }
}
