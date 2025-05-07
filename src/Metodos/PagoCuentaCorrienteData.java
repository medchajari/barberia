package Metodos;

import Entidades.Barbero;
import Entidades.Cliente;
import Entidades.CuentaCorriente;
import Entidades.PagoCuentaCorriente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.ResultSet;

public class PagoCuentaCorrienteData {
      private Conexion con;
    public PagoCuentaCorrienteData() {
        con = new Conexion(); // Crear una instancia de la clase Conexion
        
    }


    public boolean registrarPago(PagoCuentaCorriente pago) {
        String insertSql = "INSERT INTO pago_cuenta_corriente (idCuentaCorriente, idCliente, pago, idBarbero, fechaPago) "
                         + "VALUES (?, ?, ?, ?, ?)";
        String updateSaldoSql = "UPDATE cuentacorriente SET saldo = saldo - ? WHERE idCuentaCorriente = ?";

        try (Connection connection = con.getConexion()) {
            // Inicia una transacción
            connection.setAutoCommit(false);

            // Inserta el pago
            try (PreparedStatement psInsert = connection.prepareStatement(insertSql)) {
                psInsert.setInt(1, pago.getCuentaCorriente().getIdCuentaCorriente());
                psInsert.setInt(2, pago.getCliente().getIdCliente());
                psInsert.setDouble(3, pago.getPago());
                psInsert.setInt(4, pago.getBarbero().getIdBarbero());
                psInsert.setDate(5, new java.sql.Date(pago.getFechaPago().getTime()));

                psInsert.executeUpdate();
            }

            // Actualiza el saldo en cuentacorriente
            try (PreparedStatement psUpdateSaldo = connection.prepareStatement(updateSaldoSql)) {
                psUpdateSaldo.setDouble(1, pago.getPago());
                psUpdateSaldo.setInt(2, pago.getCuentaCorriente().getIdCuentaCorriente());

                psUpdateSaldo.executeUpdate();
            }

            // Confirma la transacción
            connection.commit();

            return true;

        } catch (SQLException ex) {
            try {
                // Si algo falla, deshace la transacción
                con.getConexion().rollback();
            } catch (SQLException rollbackEx) {
                System.out.println("Error al hacer rollback: " + rollbackEx.getMessage());
            }
            System.out.println("Error al registrar el pago: " + ex.getMessage());
            return false;
        } finally {
            try {
                // Restaurar el modo de confirmación automática
                con.getConexion().setAutoCommit(true);
            } catch (SQLException ex) {
                System.out.println("Error al restaurar el auto-commit: " + ex.getMessage());
            }
        }
    }

   public List<PagoCuentaCorriente> listarPagosPorCliente(int idCliente) {
        List<PagoCuentaCorriente> pagos = new ArrayList<>();
        String sql = "SELECT pcc.idPago, pcc.idCuentaCorriente, pcc.pago, pcc.fechaPago, "
                   + "b.idBarbero, b.nombreBarbero, c.idCliente, c.nombre AS nombreCliente "
                   + "FROM pago_cuenta_corriente pcc "
                   + "JOIN cuentacorriente cc ON pcc.idCuentaCorriente = cc.idCuentaCorriente "
                   + "JOIN cliente c ON pcc.idCliente = c.idCliente "
                   + "LEFT JOIN barbero b ON pcc.idBarbero = b.idBarbero "
                   + "WHERE pcc.idCliente = ?";

        try (Connection connection = con.getConexion();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, idCliente);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setNombre(rs.getString("nombreCliente"));

                CuentaCorriente cuentaCorriente = new CuentaCorriente();
                cuentaCorriente.setIdCuentaCorriente(rs.getInt("idCuentaCorriente"));

                Barbero barbero = new Barbero();
                barbero.setIdBarbero(rs.getInt("idBarbero"));
                barbero.setNombreBarbero(rs.getString("nombreBarbero"));

                PagoCuentaCorriente pago = new PagoCuentaCorriente();
                pago.setIdPago(rs.getInt("idPago"));
                pago.setCuentaCorriente(cuentaCorriente);
                pago.setCliente(cliente);
                pago.setBarbero(barbero);
                pago.setPago(rs.getDouble("pago"));
                pago.setFechaPago(rs.getDate("fechaPago"));

                pagos.add(pago);
            }

        } catch (SQLException ex) {
            System.out.println("Error al listar los pagos: " + ex.getMessage());
        }

        return pagos;
    }
}