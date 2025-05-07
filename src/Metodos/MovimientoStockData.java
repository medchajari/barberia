package Metodos;

import Entidades.MovimientoStock;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MovimientoStockData {
      private Conexion con;
    public MovimientoStockData() {
        con = new Conexion(); // Crear una instancia de la clase Conexion
        
    }

    public void agregarMovimientoStock(MovimientoStock movimientoStock) {
        String sql = "INSERT INTO movimientoStock (idProducto, idAlmacenOrigen, idSucursalOrigen, idAlmacenDestino, idSucursalDestino, cantidad, fechaMovimiento, tipoMovimiento) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection connection = con.getConexion(); // Obtener la conexión de la instancia de Conexion
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, movimientoStock.getProducto().getIdProducto());
            if (movimientoStock.getAlmacenOrigen() != null) {
                ps.setInt(2, movimientoStock.getAlmacenOrigen().getIdAlmacen());
            } else {
                ps.setNull(2, java.sql.Types.INTEGER);
            }
            if (movimientoStock.getSucursalOrigen() != null) {
                ps.setInt(3, movimientoStock.getSucursalOrigen().getIdLocal());
            } else {
                ps.setNull(3, java.sql.Types.INTEGER);
            }
            if (movimientoStock.getAlmacenDestino() != null) {
                ps.setInt(4, movimientoStock.getAlmacenDestino().getIdAlmacen());
            } else {
                ps.setNull(4, java.sql.Types.INTEGER);
            }
            if (movimientoStock.getSucursalDestino() != null) {
                ps.setInt(5, movimientoStock.getSucursalDestino().getIdLocal());
            } else {
                ps.setNull(5, java.sql.Types.INTEGER);
            }
            ps.setInt(6, movimientoStock.getCantidad());
            ps.setDate(7, new java.sql.Date(movimientoStock.getFechaMovimiento().getTime()));
            ps.setString(8, movimientoStock.getTipoMovimiento());

            ps.executeUpdate();
            ps.close();

            System.out.println("Movimiento de stock registrado exitosamente.");
        } catch (SQLException ex) {
            System.out.println("Error al registrar el movimiento de stock: " + ex.getMessage());
        }
    }
}
