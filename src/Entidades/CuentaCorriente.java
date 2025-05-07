package Entidades;

import java.util.ArrayList;
import java.util.List;

public class CuentaCorriente {
    private int idCuentaCorriente;
    private Cliente cliente;
    private Barbero barbero;  // Referencia al barbero
    private double saldo;
 private List<DetalleCuentaCorriente> detalles; 
    // Constructor por defecto
    public CuentaCorriente() {}
 public void addDetalle(DetalleCuentaCorriente detalle) {
        if (detalles == null) {
            detalles = new ArrayList<>();
        }
        detalles.add(detalle);
    }

    public List<DetalleCuentaCorriente> getDetalles() {
        return detalles;
    }
   
 // Constructor con todos los campos
    public CuentaCorriente(int idCuentaCorriente, Cliente cliente, Barbero barbero, double saldo) {
        this.idCuentaCorriente = idCuentaCorriente;
        this.cliente = cliente;
        this.barbero = barbero;
        this.saldo = saldo;
    }

    // Nuevo constructor sin idCuentaCorriente (para cuando se va a insertar una nueva cuenta)
    public CuentaCorriente(Cliente cliente, Barbero barbero, double saldo) {
        this.cliente = cliente;
        this.barbero = barbero;
        this.saldo = saldo;
    }

    
     // Getters y Setters
    public int getIdCuentaCorriente() {
        return idCuentaCorriente;
    }

    public void setIdCuentaCorriente(int idCuentaCorriente) {
        this.idCuentaCorriente = idCuentaCorriente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Barbero getBarbero() {
        return barbero;
    }

    public void setBarbero(Barbero barbero) {
        this.barbero = barbero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
