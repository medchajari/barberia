package Metodos;

import Entidades.Barbero;
import Entidades.Cliente;
import Entidades.Local;
import Entidades.Producto;
import Entidades.ResultadoBusqueda;
import Entidades.Servicio;
import Entidades.Stock;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.PreparedStatement;
import org.mariadb.jdbc.Statement;


public class ProductoData {
    private Conexion con;
    private LocalData localData;
    public ProductoData() {
        con = new Conexion(); // Crear una instancia de la clase Conexion
        localData = new LocalData();
    }
    
    public int agregarProducto(Producto producto) {
    String sql = "INSERT INTO producto (codigo_barra,nombre, descripcion, precio) VALUES (?, ?, ?,?)";
    int idProducto = 0;

    try {
        Connection connection = con.getConexion(); // Obtener la conexión de la instancia de Conexion
        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, producto.getCodigo_barra());
        ps.setString(2, producto.getNombre());
        ps.setString(3, producto.getDescripcion());
        ps.setDouble(4, producto.getPrecio());

        ps.executeUpdate();

        // Obtener el ID generado para el nuevo producto
        ResultSet generatedKeys = ps.getGeneratedKeys();
        if (generatedKeys.next()) {
            idProducto = generatedKeys.getInt(1);
        }

        generatedKeys.close();
        ps.close();

        System.out.println("Producto agregado exitosamente.");
    } catch (SQLException ex) {
        System.out.println("Error al agregar el producto: " + ex.getMessage());
    }

    return idProducto; // Devolver el idProducto generado
}
    
  public boolean modificarProducto(Producto producto) {
    String sql = "UPDATE producto SET codigo_barra = ?, nombre = ?, descripcion = ?, precio = ? WHERE idProducto = ?";

    try {
        Connection connection = con.getConexion();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, producto.getCodigo_barra());
        ps.setString(2, producto.getNombre());
        ps.setString(3, producto.getDescripcion());
        ps.setDouble(4, producto.getPrecio());
        ps.setInt(5, producto.getIdProducto()); // Asegúrate de pasar el ID del producto

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

      
      


    public void agregarProducto2(Producto producto) {
        String sql = "INSERT INTO producto (codigo_barra,nombre, descripcion, precio) VALUES (?, ?,?, ?)";

        try {
                 Connection connection = con.getConexion(); // Obtener la conexión de la instancia de Conexion
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, producto.getCodigo_barra());
            ps.setString(2, producto.getNombre());
            ps.setString(3, producto.getDescripcion());
            ps.setDouble(4, producto.getPrecio());

            ps.executeUpdate();
            ps.close();

            System.out.println("Producto agregado exitosamente.");
        } catch (SQLException ex) {
            System.out.println("Error al agregar el producto: " + ex.getMessage());
        }
    }
    
       public List<Producto> listarProductos() {
        List<Producto> produc = new ArrayList<>();
        try {
             Connection connection = con.getConexion(); // Obtener la conexión de la instancia de Conexion
            String sql = "SELECT * FROM producto";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idProducto = resultSet.getInt("idProducto");
                String codigo_barra = resultSet.getString("codigo_barra"); 
                String nombre = resultSet.getString("nombre");                    
                 String descripcion = resultSet.getString("descripcion"); 
                
                Producto pro = new Producto(idProducto,codigo_barra,nombre,descripcion);
                produc.add(pro);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produc;
    }
    


  public void agregarProductoALocal(int idProducto) {
    String sqlStock = "INSERT INTO stock (idProducto, idAlmacen, idLocal, cantidad) VALUES (?, ?, ?, ?)";

    try {
        Connection connection = con.getConexion(); // Obtener la conexión de la instancia de Conexion

        // Obtener la lista de todos los locales
        List<Local> locales = localData.listarLocal();

        // Insertar en la tabla stock para cada local
        for (Local local : locales) {
            PreparedStatement psStock = connection.prepareStatement(sqlStock);
            psStock.setInt(1, idProducto);
            psStock.setNull(2, java.sql.Types.INTEGER); // idAlmacen es null para locales
            psStock.setInt(3, local.getIdLocal());
            psStock.setInt(4, 0); // Cantidad inicial en cada local es 0
            psStock.executeUpdate();
            psStock.close();
        }

        // Insertar en la tabla stock para el almacén
        PreparedStatement psStockAlmacen = connection.prepareStatement(sqlStock);
        psStockAlmacen.setInt(1, idProducto);
        psStockAlmacen.setInt(2, 1); // idAlmacen es 1
        psStockAlmacen.setNull(3, 0); // idLocal es 0 para almacén
        psStockAlmacen.setInt(4, 0); // Cantidad inicial en el almacén es 0
        psStockAlmacen.executeUpdate();
        psStockAlmacen.close();

        System.out.println("Stock agregado para todos los locales y el almacén.");
    } catch (SQLException ex) {
        System.out.println("Error al agregar el stock: " + ex.getMessage());
    }
}  


       
       public List<ResultadoBusqueda> buscarProductoYServicio(String criterio) {
    List<ResultadoBusqueda> resultados = new ArrayList<>();

    String sqlProducto = "SELECT idProducto,codigo_barra,nombre, descripcion, precio FROM producto WHERE nombre LIKE ? OR descripcion LIKE ?";
    String sqlServicio = "SELECT idServicio,nombre, descripcion, precio FROM servicio WHERE nombre LIKE ? OR descripcion LIKE ?";

    try (Connection connection = con.getConexion();
         PreparedStatement psProducto = connection.prepareStatement(sqlProducto);
         PreparedStatement psServicio = connection.prepareStatement(sqlServicio)) {

        // Buscar en la tabla de productos
        psProducto.setString(1, "%" + criterio + "%");
        psProducto.setString(2, "%" + criterio + "%");
        try (ResultSet rsProducto = psProducto.executeQuery()) {
            while (rsProducto.next()) {
                int idProducto = rsProducto.getInt("idProducto");
                String nombre = rsProducto.getString("nombre");
                String codigo_barra = rsProducto.getString("codigo_barra");
                String descripcion = rsProducto.getString("descripcion");
                double precio = rsProducto.getDouble("precio");
                Producto producto = new Producto();
                producto.setIdProducto(idProducto);
                producto.setCodigo_barra(codigo_barra);
                producto.setNombre(nombre);
                producto.setDescripcion(descripcion);
                producto.setPrecio(precio);  // Ajustar según tu clase Producto
                resultados.add(new ResultadoBusqueda(producto));
            }
        }

        // Buscar en la tabla de servicios
        psServicio.setString(1, "%" + criterio + "%");
        psServicio.setString(2, "%" + criterio + "%");
        try (ResultSet rsServicio = psServicio.executeQuery()) {
            while (rsServicio.next()) {
                int idServicio = rsServicio.getInt("idServicio");
                 String nombre = rsServicio.getString("nombre");                
                String descripcion = rsServicio.getString("descripcion");
                double precio = rsServicio.getDouble("precio");
                Servicio servicio = new Servicio();
                servicio.setIdServicio(idServicio);
                servicio.setNombre(nombre);
                servicio.setDescripcion(descripcion);
                servicio.setPrecio(precio);  // Ajustar según tu clase Servicio
                resultados.add(new ResultadoBusqueda(servicio));
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
        throw new RuntimeException("Error al buscar productos y servicios", e);
    }

    return resultados;
}
       
   

public Producto buscarPorCodigoBarra(String codigo) {
    String sql = "SELECT * FROM producto WHERE codigo_barra = ?";
    try (Connection con = this.con.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, codigo);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Producto p = new Producto();
            p.setIdProducto(rs.getInt("idProducto"));
            p.setCodigo_barra(rs.getString("codigo_barra"));
            p.setNombre(rs.getString("nombre"));
            p.setDescripcion(rs.getString("descripcion"));
            p.setPrecio(rs.getDouble("precio"));
            return p;
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return null;
}

 




 }