/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author MeD
 */
public class TipoPago {
     private int idTipoPago;
    private String nombre; // Ejemplo: "Efectivo", "Transferencia", "Cuenta Corriente"

    public TipoPago() {
    }

    public TipoPago(int idTipoPago, String nombre) {
        this.idTipoPago = idTipoPago;
        this.nombre = nombre;
    }

    public int getIdTipoPago() {
        return idTipoPago;
    }

    public void setIdTipoPago(int idTipoPago) {
        this.idTipoPago = idTipoPago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "TipoPago{" + "idTipoPago=" + idTipoPago + ", nombre=" + nombre + '}';
    }

}
