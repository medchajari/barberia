package Metodos;

import Entidades.Barbero;
import Entidades.CajaBarbero;
import Entidades.CajaGeneral;
import Entidades.MovimientoCaja;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.mariadb.jdbc.Statement;
public class CajaData {
private Conexion con;

private CajaGeneralData cajaGeneralData;

    public CajaData() {
        con = new Conexion(); // Crear una instancia de la clase Conexion
        
    }

    


    public int abrirCajaBarbero(int idBarbero, int idCajaGeneral) {
    int idCajaBarbero = -1; // Inicializa con un valor inválido para indicar si la caja se abrió correctamente

    String insertSql = "INSERT INTO cajabarbero (idBarbero, saldo, fecha, idCajaGeneral) VALUES (?, ?, CURDATE(), ?)";

    try (Connection connection = con.getConexion();
         PreparedStatement ps = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS)) {

        ps.setInt(1, idBarbero);
        ps.setDouble(2, 0.0); // Saldo inicial 0
        ps.setInt(3, idCajaGeneral);
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            idCajaBarbero = rs.getInt(1); // Obtén el ID generado de la nueva caja del barbero
        }
        rs.close();
    } catch (SQLException ex) {
        System.out.println("Error al abrir la caja del barbero: " + ex.getMessage());
    }

    return idCajaBarbero; // Retorna el ID de la caja del barbero, o -1 si hubo un problema
}


    
    public int abrirCajaDelDia(double saldoInicial) {
    int idCajaGeneral = -1;
    String checkSql = "SELECT idCajaGeneral FROM cajageneral WHERE fecha = CURDATE()";
    String insertSql = "INSERT INTO cajageneral (saldo, fecha) VALUES (?, CURDATE())";

    try (Connection connection = con.getConexion();
         PreparedStatement checkPs = connection.prepareStatement(checkSql);
         PreparedStatement insertPs = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS)) {

        // Verificar si ya existe una caja general para la fecha actual
        ResultSet rsCheck = checkPs.executeQuery();
        if (rsCheck.next()) {
            // Si ya existe, obtener el ID de la caja existente
            idCajaGeneral = rsCheck.getInt("idCajaGeneral");
            System.out.println("Ya existe una caja general para la fecha actual.");
        } else {
            // Si no existe, abrir una nueva caja general
            insertPs.setDouble(1, saldoInicial);
            insertPs.executeUpdate();

            ResultSet rsInsert = insertPs.getGeneratedKeys();
            if (rsInsert.next()) {
                idCajaGeneral = rsInsert.getInt(1);
                System.out.println("Caja del día abierta con éxito.");
            }
            rsInsert.close();
        }
        rsCheck.close();
    } catch (SQLException ex) {
        System.out.println("Error al abrir la caja del día: " + ex.getMessage());
    }

    return idCajaGeneral;
}
    

public int obtenerCajaBarberoDelDia(int idBarbero) {
    String sql = "SELECT idCajaBarbero, fecha FROM cajabarbero WHERE idBarbero = ? AND fecha = CURDATE()";
    int idCajaBarbero = -1;

    try (Connection connection = con.getConexion();
         PreparedStatement ps = connection.prepareStatement(sql)) {

        ps.setInt(1, idBarbero);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            idCajaBarbero = rs.getInt("idCajaBarbero");
            Date fecha = rs.getDate("fecha");  // Obtenemos la fecha para verificar
            System.out.println("Caja Barbero: " + idCajaBarbero + ", Fecha: " + fecha);
        } else {
            System.out.println("No se encontró caja del barbero para el día de hoy.");
        }
        rs.close();
    } catch (SQLException ex) {
        System.out.println("Error al obtener la caja del barbero: " + ex.getMessage());
    }

    return idCajaBarbero;
}
    
    public int obtenerCajaDelDia() {
    String sql = "SELECT idCajaGeneral FROM cajageneral WHERE fecha = CURDATE()";
    int idCajaGeneral = -1;

    try (Connection connection = con.getConexion();
         PreparedStatement ps = connection.prepareStatement(sql)) {

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            idCajaGeneral = rs.getInt("idCajaGeneral");
        }
        rs.close();
    } catch (SQLException ex) {
        System.out.println("Error al obtener la caja del día: " + ex.getMessage());
    }

    return idCajaGeneral;
}
    
    public int abrirCajaDelDia2(double saldoInicial) {
    int idCajaGeneral = obtenerCajaDelDia(); // Primero intenta obtener la caja del día

    if (idCajaGeneral == -1) {
        String sql = "INSERT INTO cajageneral (saldo, fecha) VALUES (?, CURDATE())";

        try (Connection connection = con.getConexion();
             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setDouble(1, saldoInicial);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idCajaGeneral = rs.getInt(1);
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error al abrir la caja del día: " + ex.getMessage());
        }
    }

    return idCajaGeneral;
}
    

    public int registrarMovimientoCaja(MovimientoCaja movimiento) {
        String sql = "INSERT INTO movimientocaja (descripcion, monto, fecha, esIngreso, idCajaBarbero, idCajaGeneral) VALUES (?, ?, ?, ?, ?, ?)";
        int idMovimiento = 0;

        try {
            Connection connection = con.getConexion();
            PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, movimiento.getDescripcion());
            ps.setDouble(2, movimiento.getMonto());
            ps.setDate(3, new java.sql.Date(movimiento.getFecha().getTime()));
            ps.setBoolean(4, movimiento.isEsIngreso());
            ps.setInt(5, movimiento.getIdCajaBarbero());
            ps.setInt(6, movimiento.getIdCajaGeneral());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idMovimiento = rs.getInt(1);
            }

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al registrar el movimiento de caja: " + ex.getMessage());
        }

        return idMovimiento;
    }

    public void actualizarSaldoBarbero(int idBarbero, double monto) {
    String sql = "UPDATE cajabarbero SET saldo = saldo + ? WHERE idBarbero = ? AND fecha = CURDATE()";

    try {
        Connection connection = con.getConexion();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setDouble(1, monto);
        ps.setInt(2, idBarbero);
        ps.executeUpdate();
        ps.close();
    } catch (SQLException ex) {
        System.out.println("Error al actualizar el saldo del barbero: " + ex.getMessage());
    }
}

    public List<CajaBarbero> listarCajasDelDia() {
    List<CajaBarbero> cajas = new ArrayList<>();
    String sql = "SELECT cb.idCajaBarbero, cb.idBarbero, cb.saldo, cb.fecha, cb.idCajaGeneral " +
                 "FROM cajabarbero cb " +
                 "WHERE cb.fecha = CURDATE()";

    try (Connection connection = con.getConexion();
         PreparedStatement ps = connection.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            CajaBarbero caja = new CajaBarbero();
            caja.setIdCajaBarbero(rs.getInt("idCajaBarbero"));
            caja.setIdBarbero(rs.getInt("idBarbero"));
            caja.setSaldo(rs.getDouble("saldo"));
            caja.setFecha(rs.getDate("fecha"));
            caja.setIdCajaGeneral(rs.getInt("idCajaGeneral"));
            cajas.add(caja);
        }
    } catch (SQLException ex) {
        System.out.println("Error al listar las cajas del día: " + ex.getMessage());
    }

    return cajas;
}
      public void actualizarSaldoGeneral(double monto, int idCajaGeneral) {
    String sql = "UPDATE cajageneral SET saldo = saldo + ? WHERE idCajaGeneral = ?";

    try (Connection connection = con.getConexion();
         PreparedStatement ps = connection.prepareStatement(sql)) {

        ps.setDouble(1, monto);
        ps.setInt(2, idCajaGeneral); // Usar el idCajaGeneral pasado como parámetro
        ps.executeUpdate();

    } catch (SQLException ex) {
        System.out.println("Error al actualizar el saldo de la caja general: " + ex.getMessage());
    }
}
      
      
    public List<CajaGeneral> listarCajaGeneralPorFecha(Date desde, Date hasta) {
    List<CajaGeneral> cajasGenerales = new ArrayList<>();
    String sql = "SELECT idCajaGeneral, fecha, saldo FROM cajageneral WHERE fecha BETWEEN ? AND ? ORDER BY fecha DESC";

    try (Connection connection = con.getConexion();
         PreparedStatement ps = connection.prepareStatement(sql)) {

        ps.setDate(1, new java.sql.Date(desde.getTime()));
        ps.setDate(2, new java.sql.Date(hasta.getTime()));

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            CajaGeneral cajaGeneral = new CajaGeneral();
            cajaGeneral.setIdCajaGeneral(rs.getInt("idCajaGeneral"));
            cajaGeneral.setFecha(rs.getDate("fecha"));
            cajaGeneral.setSaldo(rs.getDouble("saldo"));
            cajasGenerales.add(cajaGeneral);
        }
    } catch (SQLException ex) {
        System.out.println("Error al listar las cajas generales: " + ex.getMessage());
    }

    return cajasGenerales;
}
    
    



public List<CajaBarbero> listarCajaBarberoPorFecha(Date desde, Date hasta, Integer idBarbero) {
    List<CajaBarbero> cajasBarberos = new ArrayList<>();
    String sql = "SELECT cb.idCajaBarbero, cb.fecha, cb.saldo, cb.idBarbero, b.nombreBarbero "
               + "FROM cajabarbero cb JOIN barbero b ON cb.idBarbero = b.idBarbero "
               + "WHERE cb.fecha BETWEEN ? AND ?";

    if (idBarbero != null) {
        sql += " AND cb.idBarbero = ?";
    }

    sql += " ORDER BY cb.fecha DESC";

    try (Connection connection = con.getConexion();
         PreparedStatement ps = connection.prepareStatement(sql)) {

        ps.setDate(1, new java.sql.Date(desde.getTime()));
        ps.setDate(2, new java.sql.Date(hasta.getTime()));
        
        if (idBarbero != null) {
            ps.setInt(3, idBarbero);
        }

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            CajaBarbero cajaBarbero = new CajaBarbero();
            cajaBarbero.setIdCajaBarbero(rs.getInt("idCajaBarbero"));
            cajaBarbero.setFecha(rs.getDate("fecha"));
            cajaBarbero.setSaldo(rs.getDouble("saldo"));
            cajaBarbero.setIdBarbero(rs.getInt("idBarbero"));
            cajaBarbero.setNombreBarbero(rs.getString("nombreBarbero")); // Asigna el nombre del barbero

            cajasBarberos.add(cajaBarbero);
        }
    } catch (SQLException ex) {
        System.out.println("Error al listar las cajas de barberos: " + ex.getMessage());
    }

    return cajasBarberos;
}

    
}