package Entidades;

import java.util.Date;

public class DetalleCuentaCorriente {
    private int idDetalleCuentaCorriente;
    private CuentaCorriente cuentaCorriente;
    private Barbero barbero;
    private double monto;
    private String descripcion;
    private Date fechaMovimiento;

    // Constructor
    public DetalleCuentaCorriente(int idDetalleCuentaCorriente, CuentaCorriente cuentaCorriente, Barbero barbero,double monto, String descripcion, Date fechaMovimiento) {
        this.idDetalleCuentaCorriente = idDetalleCuentaCorriente;
        this.cuentaCorriente = cuentaCorriente;
        this.barbero = barbero;
        this.monto = monto;
        this.descripcion = descripcion;
        this.fechaMovimiento = fechaMovimiento;
    }

    // Constructor por defecto
    public DetalleCuentaCorriente() {}

    // Getters y Setters
    public int getIdDetalleCuentaCorriente() {
        return idDetalleCuentaCorriente;
    }

    public Barbero getBarbero() {
        return barbero;
    }

    public void setBarbero(Barbero barbero) {
        this.barbero = barbero;
    }
    
    

    public void setIdDetalleCuentaCorriente(int idDetalleCuentaCorriente) {
        this.idDetalleCuentaCorriente = idDetalleCuentaCorriente;
    }

    public CuentaCorriente getCuentaCorriente() {
        return cuentaCorriente;
    }

    public void setCuentaCorriente(CuentaCorriente cuentaCorriente) {
        this.cuentaCorriente = cuentaCorriente;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

