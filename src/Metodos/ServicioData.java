package Metodos;

import Entidades.Barbero;
import Entidades.Producto;
import Entidades.Servicio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicioData {
    private Conexion con;
    public ServicioData() {
        con = new Conexion(); // Crear una instancia de la clase Conexion
        
    }

    public void agregarServicio(Servicio servicio) {
        String sql = "INSERT INTO servicio (nombre, precio, descripcion) VALUES (?, ?, ?)";
        try {
            Connection connection = con.getConexion(); // Obtener la conexión de la instancia de Conexion
              PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, servicio.getNombre());
            statement.setDouble(2, servicio.getPrecio());
            statement.setString(3, servicio.getDescripcion());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al insertar un servicio: " + ex.getMessage());
        }
    }
    
     public List<Servicio> listarServicio() {
        List<Servicio> servicios = new ArrayList<>();
        try {
             Connection connection = con.getConexion(); // Obtener la conexión de la instancia de Conexion
            String sql = "SELECT * FROM servicio";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idServicio = resultSet.getInt("idServicio");
                String nombre = resultSet.getString("nombre"); 
                double precio = resultSet.getDouble("precio");
                String descripcion = resultSet.getString("descripcion");
                
                Servicio serv = new Servicio(idServicio, nombre, precio, descripcion);
                servicios.add(serv);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return servicios;
    }
     
     public boolean modificarServicio(Servicio servicio) {
    String sql = "UPDATE servicio SET nombre = ?, descripcion = ?, precio = ? WHERE idServicio = ?";

    try {
        Connection connection = con.getConexion();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, servicio.getNombre());
        ps.setString(2, servicio.getDescripcion());
        ps.setDouble(3, servicio.getPrecio());
        ps.setInt(4, servicio.getIdServicio()); // Asegúrate de pasar el ID del producto

        int rowsAffected = ps.executeUpdate();
        ps.close();

        if (rowsAffected > 0) {
            System.out.println("Producto modificado exitosamente.");
            return true;
        } else {
            System.out.println("No se encontró el producto a modificar.");
            return false;
        }
    } catch (SQLException ex) {
        System.out.println("Error al modificar el producto: " + ex.getMessage());
        return false;
    }
}
     
       public void eliminarServicio(int idServicio) {
    String sql = "DELETE FROM servicio WHERE idServicio = ?";
    try {
        Connection connection = con.getConexion(); // Obtener la conexión de la instancia de Conexion
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idServicio);
        int rowsDeleted = statement.executeUpdate();
        
        if (rowsDeleted > 0) {
            System.out.println("Servicio eliminado exitosamente.");
        } else {
            System.out.println("No se encontró servicio con el id proporcionado.");
        }
        
        statement.close();
    } catch (SQLException ex) {
        System.out.println("Error al eliminar el servicio: " + ex.getMessage());
    }
}
     
     public Servicio obtenerServicioPorId(int id) {
    Servicio servicio = null;
    String sql = "SELECT * FROM servicio WHERE idServicio = ?";

    try (  Connection connection = con.getConexion(); 
         PreparedStatement ps = connection.prepareStatement(sql)) {

        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            servicio = new Servicio();
            servicio.setIdServicio(rs.getInt("idServicio"));
            servicio.setNombre(rs.getString("nombre"));
            servicio.setDescripcion(rs.getString("descripcion"));
            servicio.setPrecio(rs.getDouble("precio"));
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return servicio;
}

     
}
