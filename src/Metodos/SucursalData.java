package Metodos;

import Entidades.Local;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SucursalData {
   private Conexion con;
    public SucursalData() {
        con = new Conexion(); // Crear una instancia de la clase Conexion
        
    }
    public void agregarSucursal(Local sucursal) {
        String sql = "INSERT INTO sucursal (nombre, direccion) VALUES (?, ?)";

        try {
             Connection connection = con.getConexion(); // Obtener la conexión de la instancia de Conexion
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, sucursal.getNombreLocal());

            ps.executeUpdate();
            ps.close();

            System.out.println("Sucursal agregada exitosamente.");
        } catch (SQLException ex) {
            System.out.println("Error al agregar la sucursal: " + ex.getMessage());
        }
    }
}
