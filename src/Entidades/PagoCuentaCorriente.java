package Entidades;

import java.util.Date;

public class PagoCuentaCorriente {
    private int idPago;
    private CuentaCorriente cuentaCorriente;
    private Cliente cliente;
    private double pago;
    private Barbero barbero;
    private Date fechaPago;

    public PagoCuentaCorriente() {
    }

    public PagoCuentaCorriente(int idPago, CuentaCorriente cuentaCorriente, Cliente cliente, double pago, Barbero barbero, Date fechaPago) {
        this.idPago = idPago;
        this.cuentaCorriente = cuentaCorriente;
        this.cliente = cliente;
        this.pago = pago;
        this.barbero = barbero;
        this.fechaPago = fechaPago;
    }

    // Getters y Setters

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public CuentaCorriente getCuentaCorriente() {
        return cuentaCorriente;
    }

    public void setCuentaCorriente(CuentaCorriente cuentaCorriente) {
        this.cuentaCorriente = cuentaCorriente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getPago() {
        return pago;
    }

    public void setPago(double pago) {
        this.pago = pago;
    }

    public Barbero getBarbero() {
        return barbero;
    }

    public void setBarbero(Barbero barbero) {
        this.barbero = barbero;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }
}
