package Metodos;

import Entidades.Barbero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BarberoData {
    private Conexion con;
    public BarberoData() {
        con = new Conexion(); // Crear una instancia de la clase Conexion
        
    }

    public void agregarBarbero(Barbero barbero) {
        String sql = "INSERT INTO Barbero (nombreBarbero) VALUES (?)";
        try {
             Connection connection = con.getConexion(); // Obtener la conexión de la instancia de Conexion
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, barbero.getNombreBarbero());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al insertar un barbero: " + ex.getMessage());
        }
    }
    
    public List<Barbero> listarBarberos() {
        List<Barbero> barberos = new ArrayList<>();
        try {
             Connection connection = con.getConexion(); // Obtener la conexión de la instancia de Conexion
            String sql = "SELECT * FROM barbero";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idBarbero = resultSet.getInt("idBarbero");
                String nombreBarbero = resultSet.getString("nombreBarbero");                
                
                Barbero barb = new Barbero(idBarbero,nombreBarbero);
                barberos.add(barb);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return barberos;
    }
    
    
    public void eliminarBarbero(int idBarbero) {
    String sql = "DELETE FROM barbero WHERE idBarbero = ?";
    try {
        Connection connection = con.getConexion(); // Obtener la conexión de la instancia de Conexion
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idBarbero);
        int rowsDeleted = statement.executeUpdate();
        
        if (rowsDeleted > 0) {
            System.out.println("Barbero eliminado exitosamente.");
        } else {
            System.out.println("No se encontró un barbero con el id proporcionado.");
        }
        
        statement.close();
    } catch (SQLException ex) {
        System.out.println("Error al eliminar el barbero: " + ex.getMessage());
    }
}
    
    
    
        public Barbero obtenerBarberoPorId(int idBarbero) {
        Barbero barbero = null;
        String sql = "SELECT * FROM barbero WHERE idBarbero = ?";

        try {
             Connection connection = con.getConexion(); // Obtener la conexión de la instancia de Conexion
        PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idBarbero);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                barbero = new Barbero();
                barbero.setIdBarbero(rs.getInt("idBarbero"));
                barbero.setNombreBarbero(rs.getString("nombreBarbero"));
            }

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener el barbero: " + ex.getMessage());
        }

        return barbero;
    }
    
    
    
}
