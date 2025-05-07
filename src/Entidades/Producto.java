/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author MeD
 */
public class Producto {
    
      private int idProducto;
      private String codigo_barra;
    private String nombre;
    private String descripcion;
    private double precio;

    public Producto() {
    }

    public Producto(int idProducto,String codigo_barra, String nombre, String descripcion) {
        this.idProducto = idProducto;
        this.codigo_barra = codigo_barra;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Producto(int idProducto) {
        this.idProducto = idProducto;
    }
    
    
    

    public Producto(int idProducto, String codigo_barra, String nombre, String descripcion, double precio) {
        this.idProducto = idProducto;
        this.codigo_barra = codigo_barra;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getCodigo_barra() {
        return codigo_barra;
    }

    public void setCodigo_barra(String codigo_barra) {
        this.codigo_barra = codigo_barra;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", codigo_barra=" + codigo_barra + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + '}';
    }

    
    
    
    
}
