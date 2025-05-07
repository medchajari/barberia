
package Entidades;

import java.util.Date;


public class Venta {
      private int idVenta;
    private Date fecha;
    private double montoTotal;

    public Venta() {
    }

    public Venta(int idVenta, Date fecha, double montoTotal) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.montoTotal = montoTotal;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    @Override
    public String toString() {
        return "Venta{" + "idVenta=" + idVenta + ", fecha=" + fecha + ", montoTotal=" + montoTotal + '}';
    }
    
    
    
}
