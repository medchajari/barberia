
package Entidades;

import java.util.Date;


public class Turnos {
    private int idTurno;
    private Local nombreLocal;
    private Barbero nombreBarbero;
    private Cliente nombre;
    private String servicio;
    private Date fecha;
    private String hora;

    public Turnos() {
    }

    public Turnos(int idTurno, Local nombreLocal, Barbero nombreBarbero, Cliente nombre, String servicio, Date fecha, String hora) {
        this.idTurno = idTurno;
        this.nombreLocal = nombreLocal;
        this.nombreBarbero = nombreBarbero;
        this.nombre = nombre;
        this.servicio = servicio;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public Local getNombreLocal() {
        return nombreLocal;
    }

    public void setNombreLocal(Local nombreLocal) {
        this.nombreLocal = nombreLocal;
    }

    public Barbero getNombreBarbero() {
        return nombreBarbero;
    }

    public void setNombreBarbero(Barbero nombreBarbero) {
        this.nombreBarbero = nombreBarbero;
    }

    public Cliente getNombre() {
        return nombre;
    }

    public void setNombre(Cliente nombre) {
        this.nombre = nombre;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Turnos{" + "idTurno=" + idTurno + ", nombreLocal=" + nombreLocal + ", nombreBarbero=" + nombreBarbero + ", nombre=" + nombre + ", servicio=" + servicio + ", fecha=" + fecha + ", hora=" + hora + '}';
    }

    
    
    
    
    
}
