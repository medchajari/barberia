
package Metodos;


import Entidades.Barbero;
import Entidades.CajaGeneral;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Entidades.MovimientoCaja;
import Entidades.TipoPago;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.mariadb.jdbc.Statement;
public class CajaGeneralData {
    
    private Conexion con;
    public CajaGeneralData() {
        con = new Conexion(); // Crear una instancia de la clase Conexion
        
    }
    
    public int abrirCajaGeneral() {
    int idCajaGeneral = 0;
    String sqlSelect = "SELECT idCajaGeneral FROM cajageneral WHERE DATE(fecha) = CURDATE()";
    String sqlInsert = "INSERT INTO cajageneral (saldo, fecha) VALUES (?, NOW())";

    try (Connection connection = con.getConexion();
         PreparedStatement selectStmt = connection.prepareStatement(sqlSelect);
         PreparedStatement insertStmt = connection.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS)) {

        ResultSet rs = selectStmt.executeQuery();
        if (rs.next()) {
            idCajaGeneral = rs.getInt("idCajaGeneral");
        } else {
            insertStmt.setDouble(1, 0.0); // Inicialmente, saldo 0
            insertStmt.executeUpdate();
            ResultSet generatedKeys = insertStmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                idCajaGeneral = generatedKeys.getInt(1);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return idCajaGeneral;
}
    
//    public void actualizarSaldoGeneral(double monto) {
//        String sql = "UPDATE cajageneral SET saldo = saldo + ? WHERE idCajaGeneral = 1"; // Asumiendo que solo hay una caja general
//
//        try {
//            Connection connection = con.getConexion();
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setDouble(1, monto);
//            ps.executeUpdate();
//            ps.close();
//        } catch (SQLException ex) {
//            System.out.println("Error al actualizar el saldo de la caja general: " + ex.getMessage());
//        }
//    }
    
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
    
   public boolean registrarIngreso(MovimientoCaja movimientoCaja) {
    String sql = "INSERT INTO cajageneral (monto, tipoMovimiento, fechaMovimiento) VALUES (?, ?, ?)";
    
    try (Connection connection = con.getConexion();
         PreparedStatement ps = connection.prepareStatement(sql)) {

        ps.setDouble(1, movimientoCaja.getMonto());
        ps.setString(2, movimientoCaja.getDescripcion());
        ps.setDate(3, new java.sql.Date(movimientoCaja.getFecha().getTime()));

        ps.executeUpdate();
        return true;

    } catch (SQLException ex) {
        System.out.println("Error al registrar ingreso en la caja general: " + ex.getMessage());
        return false;
    }
}
   
   public boolean registrarEgreso(MovimientoCaja movimientoCaja) {
    String sql = "INSERT INTO cajageneral (monto, tipoMovimiento, fechaMovimiento) VALUES (?, ?, ?)";
    
    try (Connection connection = con.getConexion();
         PreparedStatement ps = connection.prepareStatement(sql)) {

        ps.setDouble(1, movimientoCaja.getMonto());
        ps.setString(2, movimientoCaja.getDescripcion());
        ps.setDate(3, new java.sql.Date(movimientoCaja.getFecha().getTime()));

        ps.executeUpdate();
        return true;

    } catch (SQLException ex) {
        System.out.println("Error al registrar egreso en la caja general: " + ex.getMessage());
        return false;
    }
}
   
  public List<TipoPago> listarTipoPago() {
        List<TipoPago> tipoPagos = new ArrayList<>();
        try {
             Connection connection = con.getConexion(); // Obtener la conexión de la instancia de Conexion
            String sql = "SELECT * FROM tipopago";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idTipoPago	 = resultSet.getInt("idTipoPago");
                String nombre = resultSet.getString("nombre");                
                
                TipoPago tip = new TipoPago(idTipoPago,nombre);
                tipoPagos.add(tip);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tipoPagos;
    }


}
