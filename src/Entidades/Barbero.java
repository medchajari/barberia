package Entidades;

public class Barbero {
    private int idBarbero;
    private String nombreBarbero;

    // Constructor por defecto
    public Barbero() {
    }

    // Constructor que acepta el ID
    public Barbero(int idBarbero) {
        this.idBarbero = idBarbero;
    }

    // Constructor que acepta el ID y el nombre
    public Barbero(int idBarbero, String nombreBarbero) {
        this.idBarbero = idBarbero;
        this.nombreBarbero = nombreBarbero;
    }

    // Getters y setters
    public int getIdBarbero() {
        return idBarbero;
    }

    public void setIdBarbero(int idBarbero) {
        this.idBarbero = idBarbero;
    }

    public String getNombreBarbero() {
        return nombreBarbero;
    }

    public void setNombreBarbero(String nombreBarbero) {
        this.nombreBarbero = nombreBarbero;
    }
}