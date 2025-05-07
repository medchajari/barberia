package Entidades;

public class ResultadoBusqueda {
    private String tipo;
    private Producto producto;
    private Servicio servicio;
    private double precio; // Nuevo atributo
    private int idProducto;
    private int idServicio;

    // Constructor que acepta un Producto
    public ResultadoBusqueda(Producto producto) {
        this.tipo = "Producto";
        this.producto = producto;
        this.precio = producto.getPrecio(); 
        this.idProducto = producto.getIdProducto();
    }

    // Constructor que acepta un Servicio
    public ResultadoBusqueda(Servicio servicio) {
        this.tipo = "Servicio";
        this.servicio = servicio;
        this.precio = servicio.getPrecio();
        this.idServicio = servicio.getIdServicio(); 
    }

    // Constructor que acepta tanto Producto como Servicio
    public ResultadoBusqueda(String tipo, Producto producto, Servicio servicio, double precio, int idProducto, int idServicio) {
        this.tipo = tipo;
        this.producto = producto;
        this.servicio = servicio;
        this.precio = precio;
        this.idProducto = idProducto;
        this.idServicio = idServicio;
    }

    // Getter y setter para idServicio
    public int getIdServicio() { 
        return idServicio; 
    }
    
    public void setIdServicio(int idServicio) { 
        this.idServicio = idServicio; 
    }

    // Getter y setter para idProducto
    public int getIdProducto() { 
        return idProducto; 
    }

    public void setIdProducto(int idProducto) { 
        this.idProducto = idProducto; 
    }

    // Getters para otros atributos
    public String getTipo() {
        return tipo;
    }

    public Producto getProducto() { 
        return producto; 
    }

    public Servicio getServicio() { 
        return servicio; 
    }

    public double getPrecio() { 
        return precio; 
    }

    // Métodos para obtener nombre y descripción
    public String getNombre() {
        return producto != null ? producto.getNombre() : servicio.getNombre();
    }

    public String getDescripcion() {
        return producto != null ? producto.getDescripcion() : servicio.getDescripcion();
    }
}
