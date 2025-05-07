package Metodos;

import Entidades.Barbero;
import Entidades.Local;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocalData {
   private Conexion con;
    public LocalData() {
        con = new Conexion(); // Crear una instancia de la clase Conexion
        
    }

    public void agregarLocal(Local local) {
        String sql = "INSERT INTO local (nombreLocal) VALUES (?)";
        try {
            Connection connection = con.getConexion(); // Obtener la conexión de la instancia de Conexion
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, local.getNombreLocal());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al insertar un local: " + ex.getMessage());
        }
    }
    
    
      public List<Local> listarLocal() {
        List<Local> locales = new ArrayList<>();
        try {
             Connection connection = con.getConexion(); // Obtener la conexión de la instancia de Conexion
            String sql = "SELECT * FROM local";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idBarbero = resultSet.getInt("idLocal");
                String nombreBarbero = resultSet.getString("nombreLocal");                
                
                Local loc = new Local(idBarbero, nombreBarbero);
                locales.add(loc);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return locales;
    }
      
         public void eliminarLocal(int idLocal) {
    String sql = "DELETE FROM local WHERE idLocal = ?";
    try {
        Connection connection = con.getConexion(); // Obtener la conexión de la instancia de Conexion
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idLocal);
        int rowsDeleted = statement.executeUpdate();
        
        if (rowsDeleted > 0) {
            System.out.println("Sucursal eliminada exitosamente.");
        } else {
            System.out.println("No se encontró una Sucursal con el id proporcionado.");
        }
        
        statement.close();
    } catch (SQLException ex) {
        System.out.println("Error al eliminar Sucursal: " + ex.getMessage());
    }
}
      
}
