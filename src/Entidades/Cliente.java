
package Entidades;

public class Cliente {
    private int idCliente;
    private String nombre;
    private String direccion;
    private String telefono;

    // Constructor por defecto
    public Cliente() {
    }

    public Cliente(int idCliente, String nombre, String direccion, String telefono) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    
    

    // Constructor que acepta el ID
    public Cliente(int idCliente) {
        this.idCliente = idCliente;
    }

    // Getters y setters
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }
    
    
}