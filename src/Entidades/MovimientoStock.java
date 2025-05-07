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
public class MovimientoStock {
     private int idMovimiento;
    private Producto producto;
    private Almacen almacenOrigen; // Puede ser nulo si viene de una sucursal
    private Local sucursalOrigen; // Puede ser nulo si viene del almacén
    private Almacen almacenDestino; // Puede ser nulo si va a una sucursal
    private Local sucursalDestino; // Puede ser nulo si va al almacén
    private int cantidad;
    private Date fechaMovimiento;
    private String tipoMovimiento; // Ejemplo: "Abastecimiento", "Venta", "Transferencia"

    public MovimientoStock() {
    }

    public MovimientoStock(int idMovimiento, Producto producto, Almacen almacenOrigen, Local sucursalOrigen, Almacen almacenDestino, Local sucursalDestino, int cantidad, Date fechaMovimiento, String tipoMovimiento) {
        this.idMovimiento = idMovimiento;
        this.producto = producto;
        this.almacenOrigen = almacenOrigen;
        this.sucursalOrigen = sucursalOrigen;
        this.almacenDestino = almacenDestino;
        this.sucursalDestino = sucursalDestino;
        this.cantidad = cantidad;
        this.fechaMovimiento = fechaMovimiento;
        this.tipoMovimiento = tipoMovimiento;
    }

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Almacen getAlmacenOrigen() {
        return almacenOrigen;
    }

    public void setAlmacenOrigen(Almacen almacenOrigen) {
        this.almacenOrigen = almacenOrigen;
    }

    public Local getSucursalOrigen() {
        return sucursalOrigen;
    }

    public void setSucursalOrigen(Local sucursalOrigen) {
        this.sucursalOrigen = sucursalOrigen;
    }

    public Almacen getAlmacenDestino() {
        return almacenDestino;
    }

    public void setAlmacenDestino(Almacen almacenDestino) {
        this.almacenDestino = almacenDestino;
    }

    public Local getSucursalDestino() {
        return sucursalDestino;
    }

    public void setSucursalDestino(Local sucursalDestino) {
        this.sucursalDestino = sucursalDestino;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    @Override
    public String toString() {
        return "MovimientoStock{" + "idMovimiento=" + idMovimiento + ", producto=" + producto + ", almacenOrigen=" + almacenOrigen + ", sucursalOrigen=" + sucursalOrigen + ", almacenDestino=" + almacenDestino + ", sucursalDestino=" + sucursalDestino + ", cantidad=" + cantidad + ", fechaMovimiento=" + fechaMovimiento + ", tipoMovimiento=" + tipoMovimiento + '}';
    }

    
    
}
