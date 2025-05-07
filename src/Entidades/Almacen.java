
package Entidades;


public class Almacen {
    
    private int idAlmacen;
    private String nombre;
    private String direccion;

    public Almacen() {
    }

    public Almacen(int idAlmacen) {
        this.idAlmacen = idAlmacen;
    }
    

    public Almacen(int idAlmacen, String nombre) {
        this.idAlmacen = idAlmacen;
        this.nombre = nombre;
    }
    

    public Almacen(int idAlmacen, String nombre, String direccion) {
        this.idAlmacen = idAlmacen;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public int getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(int idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Almacen{" + "idAlmacen=" + idAlmacen + ", nombre=" + nombre + ", direccion=" + direccion + '}';
    }
    
    
    
}
