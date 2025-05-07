package Entidades;

import java.util.Date;

public class CajaBarbero {
    private int idCajaBarbero;
    private int idBarbero;
    private String nombreBarbero;
    private double saldo;
    private Date fecha; // Nuevo campo para la fecha
    private int idCajaGeneral; // Nuevo campo para relacionar con CajaGeneral

    // Getters y Setters

    public int getIdCajaBarbero() {
        return idCajaBarbero;
    }

    public void setIdCajaBarbero(int idCajaBarbero) {
        this.idCajaBarbero = idCajaBarbero;
    }

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

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdCajaGeneral() {
        return idCajaGeneral;
    }

    public void setIdCajaGeneral(int idCajaGeneral) {
        this.idCajaGeneral = idCajaGeneral;
    }
}
