package Metodos;

import Metodos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class UsuarioData {
private Conexion con;
  

    public UsuarioData() {
        con = new Conexion(); // Crear una instancia de la clase Conexion
        
    }

    public String autenticarUsuario(String nombreUsuario, String contrasena) {
        String rol = null;

        try {
           Connection connection = con.getConexion();
       
            String sql = "SELECT rol FROM usuarios WHERE nombreUsuario = ? AND contrasena = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, nombreUsuario);
            ps.setString(2, contrasena);

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                rol = resultSet.getString("rol");
            }

            resultSet.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rol;
    }
}