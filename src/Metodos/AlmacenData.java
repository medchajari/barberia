package Metodos;

import Entidades.Almacen;
import Entidades.Barbero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AlmacenData {
    private Conexion con;
    public AlmacenData() {
        con = new Conexion(); // Crear una instancia de la clase Conexion
        
    }

    public void agregarAlmacen(Almacen almacen) {
        String sql = "INSERT INTO almacen (nombre, direccion) VALUES (?, ?)";

        try {
            Connection connection = con.getConexion(); // Obtener la conexión de la instancia de Conexion
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, almacen.getNombre());
            ps.setString(2, almacen.getDireccion());

            ps.executeUpdate();
            ps.close();

            System.out.println("Almacén agregado exitosamente.");
        } catch (SQLException ex) {
            System.out.println("Error al agregar el almacén: " + ex.getMessage());
        }
    }
    
       public List<Almacen> listarAmacen() {
        List<Almacen> almacen = new ArrayList<>();
        try {
             Connection connection = con.getConexion(); // Obtener la conexión de la instancia de Conexion
            String sql = "SELECT * FROM almacen";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idAlmacen = resultSet.getInt("idAlmacen");
                String nombre = resultSet.getString("nombre");                
                
                Almacen alm = new Almacen(idAlmacen,nombre);
                almacen.add(alm);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return almacen;
    }
       
       
       
       
//       public boolean abastecerSucursalDesdeAlmacen(int idProducto, int idAlmacen, int idLocal, int cantidad) {
//    Connection connection = null;
//    PreparedStatement psUpdateAlmacen = null;
//    PreparedStatement psUpdateLocal = null;
//    PreparedStatement psInsertMovimiento = null;
//
//    String sqlUpdateAlmacen = "UPDATE stock SET cantidad = cantidad - ? WHERE idProducto = ? AND idAlmacen = ?";
//    String sqlUpdateLocal = "UPDATE stock SET cantidad = cantidad + ? WHERE idProducto = ? AND idLocal = ?";
//    String sqlInsertMovimiento = "INSERT INTO movimientoStock (idProducto, idAlmacen, idLocal, cantidad, tipoMovimiento, fecha) VALUES (?, ?, ?, ?, 'Abastecimiento', NOW())";
//
//    try {
//        connection = con.getConexion();
//        connection.setAutoCommit(false);
//
//        // Actualizar stock en almacén
//        psUpdateAlmacen = connection.prepareStatement(sqlUpdateAlmacen);
//        psUpdateAlmacen.setInt(1, cantidad);
//        psUpdateAlmacen.setInt(2, idProducto);
//        psUpdateAlmacen.setInt(3, idAlmacen);
//        psUpdateAlmacen.executeUpdate();
//
//        // Actualizar stock en sucursal
//        psUpdateLocal = connection.prepareStatement(sqlUpdateLocal);
//        psUpdateLocal.setInt(1, cantidad);
//        psUpdateLocal.setInt(2, idProducto);
//        psUpdateLocal.setInt(3, idLocal);
//        psUpdateLocal.executeUpdate();
//
//        // Registrar el movimiento en MovimientoStock
//        psInsertMovimiento = connection.prepareStatement(sqlInsertMovimiento);
//        psInsertMovimiento.setInt(1, idProducto);
//        psInsertMovimiento.setInt(2, idAlmacen);
//        psInsertMovimiento.setInt(3, idLocal);
//        psInsertMovimiento.setInt(4, cantidad);
//        psInsertMovimiento.executeUpdate();
//
//        connection.commit();
//        return true;
//
//    } catch (SQLException e) {
//        if (connection != null) {
//            try {
//                connection.rollback();
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//        }
//        e.printStackTrace();
//        return false;
//
//    } finally {
//        try {
//            if (psUpdateAlmacen != null) psUpdateAlmacen.close();
//            if (psUpdateLocal != null) psUpdateLocal.close();
//            if (psInsertMovimiento != null) psInsertMovimiento.close();
//            if (connection != null) connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}

//public boolean abastecerSucursalDesdeAlmacen(int idProducto, int idAlmacen, int idLocal, int cantidad) {
//    Connection connection = null;
//    PreparedStatement psUpdateAlmacen = null;
//    PreparedStatement psUpdateLocal = null;
//    PreparedStatement psInsertMovimiento = null;
//
//    String sqlUpdateAlmacen = "UPDATE stock SET cantidad = cantidad - ? WHERE idProducto = ? AND idAlmacen = ?";
//    String sqlUpdateLocal = "UPDATE stock SET cantidad = cantidad + ? WHERE idProducto = ? AND idLocal = ?";
//    String sqlInsertMovimiento = "INSERT INTO movimientostock (idProducto, idAlmacenOrigen, idLocalDestino, cantidad, tipoMovimiento, fechaMovimiento) VALUES (?, ?, ?, ?, 'Abastecimiento', NOW())";
//
//    try {
//        connection = con.getConexion();
//        connection.setAutoCommit(false);
//
//        // Actualizar stock en almacén
//        psUpdateAlmacen = connection.prepareStatement(sqlUpdateAlmacen);
//        psUpdateAlmacen.setInt(1, cantidad);
//        psUpdateAlmacen.setInt(2, idProducto);
//        psUpdateAlmacen.setInt(3, idAlmacen);
//        psUpdateAlmacen.executeUpdate();
//
//        // Actualizar stock en sucursal
//        psUpdateLocal = connection.prepareStatement(sqlUpdateLocal);
//        psUpdateLocal.setInt(1, cantidad);
//        psUpdateLocal.setInt(2, idProducto);
//        psUpdateLocal.setInt(3, idLocal);
//        psUpdateLocal.executeUpdate();
//
//        // Registrar el movimiento en MovimientoStock
//        psInsertMovimiento = connection.prepareStatement(sqlInsertMovimiento);
//        psInsertMovimiento.setInt(1, idProducto);
//        psInsertMovimiento.setInt(2, idAlmacen);  // idAlmacenOrigen
//        psInsertMovimiento.setInt(3, idLocal);    // idLocalDestino
//        psInsertMovimiento.setInt(4, cantidad);
//        psInsertMovimiento.executeUpdate();
//
//        connection.commit();
//        return true;
//
//    } catch (SQLException e) {
//        if (connection != null) {
//            try {
//                connection.rollback();
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//        }
//        e.printStackTrace();
//        return false;
//
//    } finally {
//        try {
//            if (psUpdateAlmacen != null) psUpdateAlmacen.close();
//            if (psUpdateLocal != null) psUpdateLocal.close();
//            if (psInsertMovimiento != null) psInsertMovimiento.close();
//            if (connection != null) connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}

public boolean abastecerSucursalDesdeAlmacen(int idProducto, int idAlmacen, int idLocal, int cantidad) {
    Connection connection = null;
    PreparedStatement psSelectAlmacen = null;
    PreparedStatement psUpdateAlmacen = null;
    PreparedStatement psUpdateLocal = null;
    PreparedStatement psInsertMovimiento = null;

    String sqlSelectAlmacen = "SELECT cantidad FROM stock WHERE idProducto = ? AND idAlmacen = ?";
    String sqlUpdateAlmacen = "UPDATE stock SET cantidad = cantidad - ? WHERE idProducto = ? AND idAlmacen = ?";
    String sqlUpdateLocal = "UPDATE stock SET cantidad = cantidad + ? WHERE idProducto = ? AND idLocal = ?";
    String sqlInsertMovimiento = "INSERT INTO movimientostock (idProducto, idAlmacenOrigen, idLocalDestino, cantidad, tipoMovimiento, fechaMovimiento) VALUES (?, ?, ?, ?, 'Abastecimiento', NOW())";

    try {
        connection = con.getConexion();
        connection.setAutoCommit(false);

        // Verificar la cantidad disponible en el almacén
        psSelectAlmacen = connection.prepareStatement(sqlSelectAlmacen);
        psSelectAlmacen.setInt(1, idProducto);
        psSelectAlmacen.setInt(2, idAlmacen);
        ResultSet rs = psSelectAlmacen.executeQuery();

        if (rs.next()) {
            int cantidadDisponible = rs.getInt("cantidad");
            if (cantidadDisponible < cantidad) {
                // Si la cantidad disponible es menor que la requerida, cancelar el proceso
                JOptionPane.showMessageDialog(null, "Stock insuficiente en el almacén.");
                connection.rollback();
                return false;
            }
        } else {
            // Si no hay stock del producto en el almacén, cancelar el proceso
            JOptionPane.showMessageDialog(null, "No hay stock del producto en el almacén.");
            connection.rollback();
            return false;
        }

        // Actualizar stock en almacén
        psUpdateAlmacen = connection.prepareStatement(sqlUpdateAlmacen);
        psUpdateAlmacen.setInt(1, cantidad);
        psUpdateAlmacen.setInt(2, idProducto);
        psUpdateAlmacen.setInt(3, idAlmacen);
        psUpdateAlmacen.executeUpdate();

        // Actualizar stock en sucursal
        psUpdateLocal = connection.prepareStatement(sqlUpdateLocal);
        psUpdateLocal.setInt(1, cantidad);
        psUpdateLocal.setInt(2, idProducto);
        psUpdateLocal.setInt(3, idLocal);
        psUpdateLocal.executeUpdate();

        // Registrar el movimiento en MovimientoStock
        psInsertMovimiento = connection.prepareStatement(sqlInsertMovimiento);
        psInsertMovimiento.setInt(1, idProducto);
        psInsertMovimiento.setInt(2, idAlmacen);  // idAlmacenOrigen
        psInsertMovimiento.setInt(3, idLocal);    // idLocalDestino
        psInsertMovimiento.setInt(4, cantidad);
        psInsertMovimiento.executeUpdate();

        connection.commit();
        return true;

    } catch (SQLException e) {
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        e.printStackTrace();
        return false;

    } finally {
        try {
            if (psSelectAlmacen != null) psSelectAlmacen.close();
            if (psUpdateAlmacen != null) psUpdateAlmacen.close();
            if (psUpdateLocal != null) psUpdateLocal.close();
            if (psInsertMovimiento != null) psInsertMovimiento.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

       
}
