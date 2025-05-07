
package Entidades;

public class DetalleCaja {
       private int idDetalleCaja;
    private MovimientoCaja movimientoCaja;  // Asociación con la entidad MovimientoCaja
    private TipoPago tipoPago;  // Efectivo, Transferencia, Cuenta Corriente
    private double monto;

    public DetalleCaja() {
    }

    public DetalleCaja(int idDetalleCaja, MovimientoCaja movimientoCaja, TipoPago tipoPago, double monto) {
        this.idDetalleCaja = idDetalleCaja;
        this.movimientoCaja = movimientoCaja;
        this.tipoPago = tipoPago;
        this.monto = monto;
    }

    public int getIdDetalleCaja() {
        return idDetalleCaja;
    }

    public void setIdDetalleCaja(int idDetalleCaja) {
        this.idDetalleCaja = idDetalleCaja;
    }

    public MovimientoCaja getMovimientoCaja() {
        return movimientoCaja;
    }

    public void setMovimientoCaja(MovimientoCaja movimientoCaja) {
        this.movimientoCaja = movimientoCaja;
    }

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "DetalleCaja{" + "idDetalleCaja=" + idDetalleCaja + ", movimientoCaja=" + movimientoCaja + ", tipoPago=" + tipoPago + ", monto=" + monto + '}';
    }
    
    
}
