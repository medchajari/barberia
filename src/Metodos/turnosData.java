package Metodos;

import Entidades.Turnos;
import Entidades.Cliente;
import Entidades.Barbero;
import Entidades.Local;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class turnosData {

    private Conexion con;

    public turnosData() {
        this.con = new Conexion();
    }

    // Método para agregar un nuevo turno
    public boolean agregarTurno(Turnos turno) {
        String sql = "INSERT INTO turnos (idLocal, idBarbero, idCliente, servicio, fecha, hora) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = con.getConexion();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, turno.getNombreLocal().getIdLocal());
            ps.setInt(2, turno.getNombreBarbero().getIdBarbero());
            ps.setInt(3, turno.getNombre().getIdCliente());
            ps.setString(4, turno.getServicio());
            ps.setDate(5, new java.sql.Date(turno.getFecha().getTime()));
            ps.setString(6, turno.getHora());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para actualizar un turno existente
    public boolean actualizarTurno(Turnos turno) {
        String sql = "UPDATE turnos SET idLocal = ?, idBarbero = ?, idCliente = ?, servicio = ?, fecha = ?, hora = ? WHERE idTurno = ?";
        try (Connection connection = con.getConexion();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, turno.getNombreLocal().getIdLocal());
            ps.setInt(2, turno.getNombreBarbero().getIdBarbero());
            ps.setInt(3, turno.getNombre().getIdCliente());
            ps.setString(4, turno.getServicio());
            ps.setDate(5, new java.sql.Date(turno.getFecha().getTime()));
            ps.setString(6, turno.getHora());
            ps.setInt(7, turno.getIdTurno());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para eliminar un turno
    public boolean eliminarTurno(int idTurno) {
        String sql = "DELETE FROM turnos WHERE idTurno = ?";
        try (Connection connection = con.getConexion();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idTurno);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para buscar un turno por ID
    public Turnos buscarTurnoPorId(int idTurno) {
        String sql = "SELECT * FROM turnos WHERE idTurno = ?";
        try (Connection connection = con.getConexion();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idTurno);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Turnos turno = new Turnos();
                turno.setIdTurno(rs.getInt("idTurno"));
                turno.setNombreLocal(new Local(rs.getInt("idLocal")));
                turno.setNombreBarbero(new Barbero(rs.getInt("idBarbero")));
                turno.setNombre(new Cliente(rs.getInt("idCliente")));
                turno.setServicio(rs.getString("servicio"));
                turno.setFecha(rs.getDate("fecha"));
                turno.setHora(rs.getString("hora"));
                return turno;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Método para obtener todos los turnos
    public List<Turnos> obtenerTodosLosTurnos() {
        List<Turnos> turnos = new ArrayList<>();
        String sql = "SELECT * FROM turnos";
        try (Connection connection = con.getConexion();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Turnos turno = new Turnos();
                turno.setIdTurno(rs.getInt("idTurno"));
                turno.setNombreLocal(new Local(rs.getInt("idLocal")));
                turno.setNombreBarbero(new Barbero(rs.getInt("idBarbero")));
                turno.setNombre(new Cliente(rs.getInt("idCliente")));
                turno.setServicio(rs.getString("servicio"));
                turno.setFecha(rs.getDate("fecha"));
                turno.setHora(rs.getString("hora"));
                turnos.add(turno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return turnos;
    }
    

    
    
 public List<Turnos> buscarTurnos(int idLocal, int idBarbero, Date fecha) {
    List<Turnos> listaTurnos = new ArrayList<>();
    String sql = "SELECT t.*, c.nombre AS nombreCliente FROM turnos t " +
                 "JOIN cliente c ON t.idCliente = c.idCliente " +
                 "WHERE t.idLocal = ? AND t.idBarbero = ? AND t.fecha = ? " +
                 "ORDER BY t.hora ASC";  // Ordena los resultados por la hora en orden ascendente
    
    try (Connection connection = con.getConexion();
         PreparedStatement ps = connection.prepareStatement(sql)) {
        ps.setInt(1, idLocal);
        ps.setInt(2, idBarbero);
        ps.setDate(3, new java.sql.Date(fecha.getTime()));
        
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Turnos turno = new Turnos();
            turno.setIdTurno(rs.getInt("idTurno"));
            turno.setNombreLocal(new Local(rs.getInt("idLocal")));
            turno.setNombreBarbero(new Barbero(rs.getInt("idBarbero")));
            
            // Obtener el nombre del cliente directamente de la consulta
            Cliente cliente = new Cliente(rs.getInt("idCliente"));
            cliente.setNombre(rs.getString("nombreCliente"));
            turno.setNombre(cliente);
            
            turno.setServicio(rs.getString("servicio"));
            turno.setFecha(rs.getDate("fecha"));
            turno.setHora(rs.getString("hora"));
            listaTurnos.add(turno);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return listaTurnos;
}


    
    
    
}