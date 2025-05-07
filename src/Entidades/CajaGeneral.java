/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.List;
import java.util.Date;
/**
 *
 * @author MeD
 */
public class CajaGeneral {
    private int idCajaGeneral;
    private double saldo;
    private Date fecha;
    private List<MovimientoCaja> movimientos;

    public CajaGeneral() {
    }

    public CajaGeneral(int idCajaGeneral, double saldo) {
        this.idCajaGeneral = idCajaGeneral;
        this.saldo = saldo;
    }

    public CajaGeneral(int idCajaGeneral, double saldo, Date fecha, List<MovimientoCaja> movimientos) {
        this.idCajaGeneral = idCajaGeneral;
        this.saldo = saldo;
        this.fecha = fecha;
        this.movimientos = movimientos;
    }
    
    
    
    

    public CajaGeneral(int idCajaGeneral, double saldo, List<MovimientoCaja> movimientos) {
        this.idCajaGeneral = idCajaGeneral;
        this.saldo = saldo;
        this.movimientos = movimientos;
    }
    
//     // Método para actualizar el saldo en base a un movimiento
//    public void actualizarSaldo(MovimientoCaja movimientoCaja) {
//        if ("Ingreso".equals(movimientoCaja.getTipoMovimiento())) {
//            this.saldo += movimientoCaja.getMonto();
//        } else if ("Egreso".equals(movimientoCaja.getTipoMovimiento())) {
//            this.saldo -= movimientoCaja.getMonto();
//        }
//        this.movimientos.add(movimientoCaja);  // Agregar el movimiento a la lista
//    }

    public int getIdCajaGeneral() {
        return idCajaGeneral;
    }

    public void setIdCajaGeneral(int idCajaGeneral) {
        this.idCajaGeneral = idCajaGeneral;
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
    
    

    public List<MovimientoCaja> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<MovimientoCaja> movimientos) {
        this.movimientos = movimientos;
    }

    @Override
    public String toString() {
        return "CajaGeneral{" + "idCajaGeneral=" + idCajaGeneral + ", saldo=" + saldo + ", fecha=" + fecha + ", movimientos=" + movimientos + '}';
    }

   
    
    
    
}
