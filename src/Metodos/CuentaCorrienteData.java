
package Metodos;

import Entidades.Barbero;
import Entidades.Cliente;
import Entidades.CuentaCorriente;
import Entidades.DetalleCuentaCorriente;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import org.mariadb.jdbc.Statement;
import java.sql.Connection;   
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
    public class CuentaCorrienteData {
      private Conexion con;
      private CuentaCorriente cuentaCorriente;


    public CuentaCorrienteData() {
        con = new Conexion(); // Crear una instancia de la clase Conexion
        
    }



    
    public void agregarCuentaCorriente(CuentaCorriente cuenta) {
    String sql = "INSERT INTO cuentacorriente (idCliente, saldo) VALUES (?, ?)";

    try (Connection connection = con.getConexion();
         PreparedStatement ps = connection.prepareStatement(sql)) {

        ps.setInt(1, cuenta.getCliente().getIdCliente());
        ps.setDouble(2, cuenta.getSaldo());

        ps.executeUpdate();
    } catch (SQLException ex) {
        System.out.println("Error al agregar la cuenta corriente: " + ex.getMessage());
    }
}
    
    public void agregarDetalleCuentaCorriente(DetalleCuentaCorriente detalle) {
    String sql = "INSERT INTO detallecuentacorriente (idCuentaCorriente, idBarbero, monto, descripcion, fechaMovimiento) VALUES (?, ?, ?, ?, ?)";

    try (Connection connection = con.getConexion();
         PreparedStatement ps = connection.prepareStatement(sql)) {

        ps.setInt(1, detalle.getCuentaCorriente().getIdCuentaCorriente());
        ps.setInt(2, detalle.getBarbero().getIdBarbero());
        ps.setDouble(3, detalle.getMonto());
        ps.setString(4, detalle.getDescripcion());
        ps.setDate(5, new java.sql.Date(detalle.getFechaMovimiento().getTime()));

        ps.executeUpdate();
    } catch (SQLException ex) {
        System.out.println("Error al agregar el detalle de la cuenta corriente: " + ex.getMessage());
    }
}
    
public void actualizarSaldo(int idCuentaCorriente, double monto) {
    String sql = "UPDATE cuentacorriente SET saldo = saldo + ? WHERE idCuentaCorriente = ?";

    try (Connection connection = con.getConexion();
         PreparedStatement ps = connection.prepareStatement(sql)) {

        ps.setDouble(1, monto);
        ps.setInt(2, idCuentaCorriente);

        ps.executeUpdate();
    } catch (SQLException ex) {
        System.out.println("Error al actualizar el saldo: " + ex.getMessage());
    }
}


//public List<CuentaCorriente> listarCuentasPorCliente(int idCliente) {
//    List<CuentaCorriente> cuentas = new ArrayList<>();
//    String sql = "SELECT cc.idCuentaCorriente, c.nombre AS nombreCliente, "
//               + "d.idBarbero, b.nombreBarbero, cc.saldo, "
//               + "d.idDetalleCuentaCorriente, d.fechaMovimiento, d.descripcion, d.monto, d.esCredito "
//               + "FROM cuentacorriente cc "
//               + "JOIN cliente c ON cc.idCliente = c.idCliente "
//               + "LEFT JOIN detallecuentacorriente d ON cc.idCuentaCorriente = d.idCuentaCorriente "
//               + "LEFT JOIN barbero b ON d.idBarbero = b.idBarbero "
//               + "WHERE cc.idCliente = ?";
//
//    try (Connection connection = con.getConexion();
//         PreparedStatement ps = connection.prepareStatement(sql)) {
//
//        ps.setInt(1, idCliente);
//        ResultSet rs = ps.executeQuery();
//
//        while (rs.next()) {
//            int idCuentaCorriente = rs.getInt("idCuentaCorriente");
//            CuentaCorriente cuenta = cuentas.stream()
//                .filter(c -> c.getIdCuentaCorriente() == idCuentaCorriente)
//                .findFirst()
//                .orElse(null);
//
//            if (cuenta == null) {
//                Cliente cliente = new Cliente();
//                cliente.setIdCliente(idCliente);
//                cliente.setNombre(rs.getString("nombreCliente"));
//
//                cuenta = new CuentaCorriente(idCuentaCorriente, cliente, null, rs.getDouble("saldo"));
//                cuentas.add(cuenta);
//            }
//
//            int idDetalle = rs.getInt("idDetalleCuentaCorriente");
//            if (idDetalle > 0) {
//                Barbero barbero = new Barbero();
//                barbero.setIdBarbero(rs.getInt("idBarbero"));
//                barbero.setNombreBarbero(rs.getString("nombreBarbero"));
//
//                DetalleCuentaCorriente detalle = new DetalleCuentaCorriente();
//                detalle.setIdDetalleCuentaCorriente(idDetalle);
//                detalle.setCuentaCorriente(cuenta);
//                detalle.setFechaMovimiento(rs.getDate("fechaMovimiento"));
//                detalle.setDescripcion(rs.getString("descripcion"));
//                detalle.setMonto(rs.getDouble("monto"));
//                detalle.setBarbero(barbero); // Asigna el barbero desde la tabla detallecuentacorriente
//
//                cuenta.addDetalle(detalle);
//            }
//        }
//    } catch (SQLException ex) {
//        System.out.println("Error al listar las cuentas corrientes: " + ex.getMessage());
//    }
//
//    return cuentas;
//}

   public List<CuentaCorriente> listarCuentasPorCliente(int idCliente) {
    List<CuentaCorriente> cuentas = new ArrayList<>();
    String sql = "SELECT cc.idCuentaCorriente, c.nombre AS nombreCliente, "
               + "d.idBarbero, b.nombreBarbero, cc.saldo, "
               + "d.idDetalleCuentaCorriente, d.fechaMovimiento, d.descripcion, d.monto, d.esCredito "
               + "FROM cuentacorriente cc "
               + "JOIN cliente c ON cc.idCliente = c.idCliente "
               + "LEFT JOIN detallecuentacorriente d ON cc.idCuentaCorriente = d.idCuentaCorriente "
               + "LEFT JOIN barbero b ON d.idBarbero = b.idBarbero "
               + "WHERE cc.idCliente = ?";

    try (Connection connection = con.getConexion();
         PreparedStatement ps = connection.prepareStatement(sql)) {

        ps.setInt(1, idCliente);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int idCuentaCorriente = rs.getInt("idCuentaCorriente");
            CuentaCorriente cuenta = cuentas.stream()
                .filter(c -> c.getIdCuentaCorriente() == idCuentaCorriente)
                .findFirst()
                .orElse(null);

            if (cuenta == null) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(idCliente);
                cliente.setNombre(rs.getString("nombreCliente"));

                Barbero barbero = new Barbero();
                barbero.setIdBarbero(rs.getInt("idBarbero"));
                barbero.setNombreBarbero(rs.getString("nombreBarbero"));

                cuenta = new CuentaCorriente(idCuentaCorriente, cliente, barbero, rs.getDouble("saldo"));
                cuentas.add(cuenta);
            }

            int idDetalle = rs.getInt("idDetalleCuentaCorriente");
            if (idDetalle > 0) {
                Barbero barbero = new Barbero();
                barbero.setIdBarbero(rs.getInt("idBarbero"));
                barbero.setNombreBarbero(rs.getString("nombreBarbero"));

                DetalleCuentaCorriente detalle = new DetalleCuentaCorriente();
                detalle.setIdDetalleCuentaCorriente(idDetalle);
                detalle.setCuentaCorriente(cuenta);
                detalle.setFechaMovimiento(rs.getDate("fechaMovimiento"));
                detalle.setDescripcion(rs.getString("descripcion"));
                detalle.setMonto(rs.getDouble("monto"));
                detalle.setBarbero(barbero);

                cuenta.addDetalle(detalle);
            }
        }
    } catch (SQLException ex) {
        System.out.println("Error al listar las cuentas corrientes: " + ex.getMessage());
    }

    return cuentas;
}
 
    public CuentaCorriente obtenerCuentaPorCliente(int idCliente) {
    CuentaCorriente cuentaCorriente = null;
    String sql = "SELECT * FROM cuentacorriente WHERE idCliente = ?";

    try (Connection connection = con.getConexion();
         PreparedStatement ps = connection.prepareStatement(sql)) {

        ps.setInt(1, idCliente);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Cliente cliente = new Cliente();
            cliente.setIdCliente(rs.getInt("idCliente"));
            // Aquí podrías cargar más datos del cliente si es necesario

            Barbero barbero = new Barbero();
            barbero.setIdBarbero(rs.getInt("idBarbero"));
            // Aquí podrías cargar más datos del barbero si es necesario

            cuentaCorriente = new CuentaCorriente(
                rs.getInt("idCuentaCorriente"),
                cliente,
                barbero,
                rs.getDouble("saldo")
            );
        }
    } catch (SQLException ex) {
        System.out.println("Error al obtener la cuenta corriente por cliente: " + ex.getMessage());
    }

    return cuentaCorriente;
}

    
    
}

    

