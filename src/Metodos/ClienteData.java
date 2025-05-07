package Metodos;

import Entidades.Barbero;
import Entidades.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteData {
     private Conexion con;

    public ClienteData() {
        this.con = new Conexion();
    }

    public void agregarCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (nombre, direccion, telefono) VALUES (?, ?, ?)";
        try {
           Connection connection = con.getConexion(); // Obtener la conexión de la instancia de Conexion
           PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getDireccion());
            statement.setString(3, cliente.getTelefono());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al insertar un cliente: " + ex.getMessage());
        }
    }
    
    public List<Cliente> listarCliente() {
        List<Cliente> cliente = new ArrayList<>();
        try {
             Connection connection = con.getConexion(); // Obtener la conexión de la instancia de Conexion
            String sql = "SELECT * FROM cliente";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idCliente = resultSet.getInt("idCliente");
                String nombre = resultSet.getString("nombre");    
                String direccion = resultSet.getString("direccion"); 
                String telefono = resultSet.getString("telefono"); 
                
                Cliente clie = new Cliente(idCliente, nombre, direccion, telefono);
                cliente.add(clie);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cliente;
    }
    
    
    public void eliminarCliente(int idCliente) {
    String sql = "DELETE FROM cliente WHERE idCliente = ?";
    try {
        Connection connection = con.getConexion(); // Obtener la conexión de la instancia de Conexion
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idCliente);
        int rowsDeleted = statement.executeUpdate();
        
        if (rowsDeleted > 0) {
            System.out.println("Cliente eliminado exitosamente.");
        } else {
            System.out.println("No se encontró un Cliente con el id proporcionado.");
        }
        
        statement.close();
    } catch (SQLException ex) {
        System.out.println("Error al eliminar el Cliente: " + ex.getMessage());
    }
}
}
