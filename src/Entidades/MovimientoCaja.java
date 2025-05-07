/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Date;

/**
 *
 * @author MeD
 */
public class MovimientoCaja {
    
//     private int idMovimiento;
//    private double monto;
//    private String tipoMovimiento; // Puede ser "Ingreso", "Egreso", etc.
//    private Date fechaMovimiento;
    
   private int idMovimiento;
    private String descripcion;
    private double monto;
    private Date fecha;
    private boolean esIngreso;
    private int idCajaGeneral;
    private int idCajaBarbero;

    public MovimientoCaja() {
    }

    public MovimientoCaja(int idMovimiento, String descripcion, double monto, Date fecha, boolean esIngreso, int idCajaGeneral, int idCajaBarbero) {
        this.idMovimiento = idMovimiento;
        this.descripcion = descripcion;
        this.monto = monto;
        this.fecha = fecha;
        this.esIngreso = esIngreso;
        this.idCajaGeneral = idCajaGeneral;
        this.idCajaBarbero = idCajaBarbero;
    }

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isEsIngreso() {
        return esIngreso;
    }

    public void setEsIngreso(boolean esIngreso) {
        this.esIngreso = esIngreso;
    }

    public int getIdCajaGeneral() {
        return idCajaGeneral;
    }

    public void setIdCajaGeneral(int idCajaGeneral) {
        this.idCajaGeneral = idCajaGeneral;
    }

    public int getIdCajaBarbero() {
        return idCajaBarbero;
    }

    public void setIdCajaBarbero(int idCajaBarbero) {
        this.idCajaBarbero = idCajaBarbero;
    }

    @Override
    public String toString() {
        return "MovimientoCaja{" + "idMovimiento=" + idMovimiento + ", descripcion=" + descripcion + ", monto=" + monto + ", fecha=" + fecha + ", esIngreso=" + esIngreso + ", idCajaGeneral=" + idCajaGeneral + ", idCajaBarbero=" + idCajaBarbero + '}';
    }

    
}
