
package Entidades;


public class Stock {
    private int idStock;
    private Producto producto;
    private Almacen almacen;  // Puede ser nulo si está en una sucursal
    private Local local;  // Puede ser nulo si está en el almacén
    private int cantidad;

    public Stock() {
    }

    public Stock(int idStock, Producto producto, Almacen almacen, Local local, int cantidad) {
        this.idStock = idStock;
        this.producto = producto;
        this.almacen = almacen;
        this.local = local;
        this.cantidad = cantidad;
    }

    public int getIdStock() {
        return idStock;
    }

    public void setIdStock(int idStock) {
        this.idStock = idStock;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    

    @Override
    public String toString() {
        return "Stock{" + "idStock=" + idStock + ", producto=" + producto + ", almacen=" + almacen + ", local=" + local + ", cantidad=" + cantidad + '}';
    }
    
    
    
    
}
