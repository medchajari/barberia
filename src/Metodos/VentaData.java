/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metodos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Entidades.Venta;
import Entidades.DetalleVenta;
public class VentaData {
     private Conexion con;
     public VentaData() {
        con = new Conexion(); // Crear una instancia de la clase Conexion
        
    }
    
    public int registrarVenta(Venta venta) {
        String sql = "INSERT INTO venta (fecha, montoTotal) VALUES (?, ?)";
        int idVenta = 0;

        try {
            Connection connection = con.getConexion();
            PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setDate(1, new java.sql.Date(venta.getFecha().getTime()));
            ps.setDouble(2, venta.getMontoTotal());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idVenta = rs.getInt(1);
            }

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al registrar la venta: " + ex.getMessage());
        }

        return idVenta;
    }

    public void registrarDetalleVenta(DetalleVenta detalleVenta) {
        String sql = "INSERT INTO detalleventa (idVenta, idProducto, cantidad, precioVenta) VALUES (?, ?, ?, ?)";

        try {
            Connection connection = con.getConexion();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, detalleVenta.getIdVenta());
            ps.setInt(2, detalleVenta.getIdProducto());
            ps.setInt(3, detalleVenta.getCantidad());
            ps.setDouble(4, detalleVenta.getPrecioVenta());
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al registrar el detalle de la venta: " + ex.getMessage());
        }
    }
    
}
