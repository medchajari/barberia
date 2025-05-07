package Metodos;

import Entidades.Almacen;
import Entidades.Local;
import Entidades.Producto;
import Entidades.Stock;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class StockData {
     private Conexion con;
    public StockData() {
        con = new Conexion(); // Crear una instancia de la clase Conexion
        
    }


    
    public boolean agregarStock(Stock stock) {
    String sqlSelect = "SELECT cantidad FROM stock WHERE idProducto = ? AND (idAlmacen = ? OR idLocal = ?)";
    String sqlUpdate = "UPDATE stock SET cantidad = cantidad + ? WHERE idProducto = ? AND (idAlmacen = ? OR idLocal = ?)";
    String sqlInsert = "INSERT INTO stock (idProducto, idAlmacen, idLocal, cantidad) VALUES (?, ?, ?, ?)";

    try (Connection connection = con.getConexion();
         PreparedStatement psSelect = connection.prepareStatement(sqlSelect);
         PreparedStatement psUpdate = connection.prepareStatement(sqlUpdate);
         PreparedStatement psInsert = connection.prepareStatement(sqlInsert)) {

        // Establecer los parámetros para la consulta SELECT
        psSelect.setInt(1, stock.getProducto().getIdProducto());
        
        if (stock.getAlmacen() != null) {
            psSelect.setInt(2, stock.getAlmacen().getIdAlmacen());
        } else {
            psSelect.setNull(2, java.sql.Types.INTEGER);
        }
        
        if (stock.getLocal() != null) {
            psSelect.setInt(3, stock.getLocal().getIdLocal());
        } else {
            psSelect.setNull(3, java.sql.Types.INTEGER);
        }

        // Ejecutar la consulta SELECT
        ResultSet rs = psSelect.executeQuery();
        
        if (rs.next()) {
            // Si ya existe el registro, se debe actualizar la cantidad
            int cantidadActual = rs.getInt("cantidad");

            psUpdate.setInt(1, stock.getCantidad());
            psUpdate.setInt(2, stock.getProducto().getIdProducto());
            if (stock.getAlmacen() != null) {
                psUpdate.setInt(3, stock.getAlmacen().getIdAlmacen());
            } else {
                psUpdate.setNull(3, java.sql.Types.INTEGER);
            }
            if (stock.getLocal() != null) {
                psUpdate.setInt(4, stock.getLocal().getIdLocal());
            } else {
                psUpdate.setNull(4, java.sql.Types.INTEGER);
            }
            
            psUpdate.executeUpdate();
            System.out.println("Stock actualizado exitosamente.");
        } else {
            // Si no existe, se debe insertar un nuevo registro
            psInsert.setInt(1, stock.getProducto().getIdProducto());
            
            if (stock.getAlmacen() != null) {
                psInsert.setInt(2, stock.getAlmacen().getIdAlmacen());
            } else {
                psInsert.setNull(2, java.sql.Types.INTEGER);
            }
            
            if (stock.getLocal() != null) {
                psInsert.setInt(3, stock.getLocal().getIdLocal());
            } else {
                psInsert.setNull(3, java.sql.Types.INTEGER);
            }
            
            psInsert.setInt(4, stock.getCantidad());
            
            psInsert.executeUpdate();
            System.out.println("Stock agregado exitosamente.");
        }

        return true;

    } catch (SQLException ex) {
        System.out.println("Error al agregar o actualizar el stock: " + ex.getMessage());
        return false;
    }
}

 
 public boolean transferirStock(int idProducto, int idOrigen, int idDestino, int cantidad, boolean esOrigenAlmacen, boolean esDestinoAlmacen) {
    Connection connection = null;
    PreparedStatement psUpdateStockOrigen = null;
    PreparedStatement psUpdateStockDestino = null;
    PreparedStatement psInsertMovimiento = null;

    String sqlUpdateStockOrigen;
    String sqlUpdateStockDestino;
    String sqlInsertMovimiento;

    // Definir las consultas SQL según el tipo de entidades de origen y destino
    if (esOrigenAlmacen) {
        sqlUpdateStockOrigen = "UPDATE stock SET cantidad = cantidad - ? WHERE idProducto = ? AND idAlmacen = ?";
    } else {
        sqlUpdateStockOrigen = "UPDATE stock SET cantidad = cantidad - ? WHERE idProducto = ? AND idLocal = ?";
    }

    if (esDestinoAlmacen) {
        sqlUpdateStockDestino = "UPDATE stock SET cantidad = cantidad + ? WHERE idProducto = ? AND idAlmacen = ?";
    } else {
        sqlUpdateStockDestino = "UPDATE stock SET cantidad = cantidad + ? WHERE idProducto = ? AND idLocal = ?";
    }

    sqlInsertMovimiento = "INSERT INTO movimientoStock (idProducto, idAlmacen, idLocal, cantidad, tipoMovimiento, fecha) VALUES (?, ?, ?, ?, 'Transferencia', NOW())";

    try {
        connection = con.getConexion();
        connection.setAutoCommit(false);

        // Actualizar stock en la entidad de origen
        psUpdateStockOrigen = connection.prepareStatement(sqlUpdateStockOrigen);
        psUpdateStockOrigen.setInt(1, cantidad);
        psUpdateStockOrigen.setInt(2, idProducto);
        psUpdateStockOrigen.setInt(3, idOrigen);
        psUpdateStockOrigen.executeUpdate();

        // Actualizar stock en la entidad de destino
        psUpdateStockDestino = connection.prepareStatement(sqlUpdateStockDestino);
        psUpdateStockDestino.setInt(1, cantidad);
        psUpdateStockDestino.setInt(2, idProducto);
        psUpdateStockDestino.setInt(3, idDestino);
        psUpdateStockDestino.executeUpdate();

        // Registrar el movimiento de transferencia en MovimientoStock
        psInsertMovimiento = connection.prepareStatement(sqlInsertMovimiento);
        psInsertMovimiento.setInt(1, idProducto);
        psInsertMovimiento.setInt(2, esOrigenAlmacen ? idOrigen : null);
        psInsertMovimiento.setInt(3, esDestinoAlmacen ? idDestino : null);
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
            if (psUpdateStockOrigen != null) psUpdateStockOrigen.close();
            if (psUpdateStockDestino != null) psUpdateStockDestino.close();
            if (psInsertMovimiento != null) psInsertMovimiento.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
 
// Método para descontar stock en un local
    public void descontarStockDeLocal(int idProducto, int idLocal, int cantidad) {
        String sql = "UPDATE stock SET cantidad = cantidad - ? WHERE idProducto = ? AND idLocal = ? AND cantidad >= ?";

        try {
            Connection connection = con.getConexion();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, cantidad);
            ps.setInt(2, idProducto);
            ps.setInt(3, idLocal);
            ps.setInt(4, cantidad);

            int rowsUpdated = ps.executeUpdate();

            if (rowsUpdated == 0) {
                System.out.println("No hay suficiente stock en el local.");
            } else {
                System.out.println("Stock descontado exitosamente en el local.");
            }

            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al descontar stock en el local: " + ex.getMessage());
        }
    }

    // Método para descontar stock en el almacén
    public void descontarStockDeAlmacen(int idProducto, int idAlmacen, int cantidad) {
        String sql = "UPDATE stock SET cantidad = cantidad - ? WHERE idProducto = ? AND idAlmacen = ? AND cantidad >= ?";

        try {
            Connection connection = con.getConexion();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, cantidad);
            ps.setInt(2, idProducto);
            ps.setInt(3, idAlmacen);
            ps.setInt(4, cantidad);

            int rowsUpdated = ps.executeUpdate();

            if (rowsUpdated == 0) {
                System.out.println("No hay suficiente stock en el almacén.");
            } else {
                System.out.println("Stock descontado exitosamente en el almacén.");
            }

            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al descontar stock en el almacén: " + ex.getMessage());
        }
    }

    // Método para verificar si hay suficiente stock en un local
    public boolean hayStockEnLocal(int idProducto, int idLocal, int cantidad) {
        String sql = "SELECT cantidad FROM stock WHERE idProducto = ? AND idLocal = ?";

        try {
            Connection connection = con.getConexion();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idProducto);
            ps.setInt(2, idLocal);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int cantidadActual = rs.getInt("cantidad");
                return cantidadActual >= cantidad;
            }

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al verificar stock en el local: " + ex.getMessage());
        }

        return false;
    }

    // Método para verificar si hay suficiente stock en el almacén
    public boolean hayStockEnAlmacen(int idProducto, int idAlmacen, int cantidad) {
         Connection connection = con.getConexion();
        String sql = "SELECT cantidad FROM stock WHERE idProducto = ? AND idAlmacen = ?";

        try {
           
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idProducto);
            ps.setInt(2, idAlmacen);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int cantidadActual = rs.getInt("cantidad");
                return cantidadActual >= cantidad;
            }

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al verificar stock en el almacén: " + ex.getMessage());
        }

        return false;
    }
    
public List<Stock> buscarPorAlmacen() {
    List<Stock> listaStock = new ArrayList<>();

    try {
        Connection connection = con.getConexion();
        String sql = "SELECT s.idStock, s.cantidad, p.idProducto, p.nombre AS nombreProducto, p.descripcion, p.precio, a.idAlmacen, a.nombre " +
                     "FROM stock s " +
                     "JOIN producto p ON s.idProducto = p.idProducto " +
                     "LEFT JOIN almacen a ON s.idAlmacen = a.idAlmacen " +
                     "WHERE s.idAlmacen IS NOT NULL AND s.idLocal IS NULL";
             PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Stock stock = new Stock();
            stock.setIdStock(resultSet.getInt("idStock"));
            stock.setCantidad(resultSet.getInt("cantidad"));

            Producto producto = new Producto();
            producto.setIdProducto(resultSet.getInt("idProducto"));
            producto.setNombre(resultSet.getString("nombreProducto"));
            producto.setDescripcion(resultSet.getString("descripcion"));
            producto.setPrecio(resultSet.getDouble("precio"));
            stock.setProducto(producto);

            Almacen almacen = new Almacen();
            almacen.setIdAlmacen(resultSet.getInt("idAlmacen"));
            almacen.setNombre(resultSet.getString("nombre")); // Corregido para usar la columna correcta
            stock.setAlmacen(almacen);

            listaStock.add(stock);
        }

        resultSet.close();
        statement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return listaStock;
}

   
   public List<Stock> buscarPorLocal(int idLocal) {
    List<Stock> listaStock = new ArrayList<>();

    try {
        Connection connection = con.getConexion();
        String sql = "SELECT s.idStock, s.cantidad, p.idProducto, p.nombre, p.descripcion, p.precio, l.idLocal, l.nombreLocal " +
                     "FROM stock s " +
                     "JOIN producto p ON s.idProducto = p.idProducto " +
                     "LEFT JOIN local l ON s.idLocal = l.idLocal " +
                     "WHERE s.idLocal = ? AND s.idAlmacen IS NULL";
      PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idLocal);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Stock stock = new Stock();
            stock.setIdStock(resultSet.getInt("idStock"));
            stock.setCantidad(resultSet.getInt("cantidad"));

            Producto producto = new Producto();
            producto.setIdProducto(resultSet.getInt("idProducto"));
            producto.setNombre(resultSet.getString("nombre"));
            producto.setDescripcion(resultSet.getString("descripcion"));
            producto.setPrecio(resultSet.getDouble("precio"));
            stock.setProducto(producto);

            Local local = new Local();
            local.setIdLocal(resultSet.getInt("idLocal"));
            local.setNombreLocal(resultSet.getString("nombreLocal"));
            stock.setLocal(local);

            listaStock.add(stock);
        }

        resultSet.close();
        statement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return listaStock;
}




}
