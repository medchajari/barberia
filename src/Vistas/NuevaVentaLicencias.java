
package Vistas;

import Entidades.Barbero;
import Entidades.Cliente;
import Entidades.DetalleVenta;
import Entidades.MovimientoCaja;
import Entidades.Producto;
import Entidades.ResultadoBusqueda;
import Entidades.TipoPago;
import Entidades.Venta;
import Metodos.BarberoData;
import Metodos.Conexion;
import Metodos.ProductoData;
import Metodos.StockData;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import Metodos.CajaGeneralData;
import Metodos.ClienteData;
import Metodos.VentaData;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import Metodos.CajaData;
import Metodos.LocalData;
import Entidades.Local;


public class NuevaVentaLicencias extends javax.swing.JFrame {

    private Conexion con;
    private Producto producto;
    private ProductoData productoData;
   private StockData stockData;
   private TipoPago tipoPago;
   private Cliente cliente;
   private ClienteData clienteData;
   private Barbero barbero;
   private BarberoData barberoData;
   private CajaGeneralData cajaGeneralData;
   private CajaData cajaData;
   private LocalData localData;
   private Local local;
   double Totalpagar = 0.00;
   
   
    public NuevaVentaLicencias() {
        initComponents();
         producto = new Producto();
         productoData = new ProductoData();
         tipoPago = new TipoPago();
         cliente = new Cliente();
          clienteData = new ClienteData();
         barbero = new Barbero();
         barberoData = new BarberoData();
          cajaGeneralData = new CajaGeneralData();
          cajaData = new CajaData();
          localData = new LocalData();
          local = new Local();
//          llenarComboBoxLocal();
//          llenarComboBoxBarberos();
          llenarComboBoxClientes();
          llenarComboBoxFormadePago();
         
          
          btnBuscar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String criterioBusqueda = txtBuscar.getText().trim();
            
            if (!criterioBusqueda.isEmpty()) {
                List<ResultadoBusqueda> resultados = productoData.buscarProductoYServicio(criterioBusqueda);
                mostrarResultadosEnTabla(resultados);
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un criterio de búsqueda.");
            }
        }
    });
          
          // Listener para el botón de buscar
btnBuscar.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        realizarBusqueda();
    }
});

// Listener para el campo de texto (txtBuscar) para detectar Enter
txtBuscar.addKeyListener(new KeyAdapter() {
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            realizarBusqueda();
        }
    }
});


txtCod.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        agregarProductoAlCarrito();
          TotalPagar();
    }
});


// Agregar un MouseListener a tableBuscar para manejar el doble clic
tableBuscar.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 2) {
            int filaSeleccionada = tableBuscar.getSelectedRow();
            if (filaSeleccionada != -1) {
                // Desactiva la edición en el doble clic
                tableBuscar.clearSelection(); 

                // Obtener los valores de la fila seleccionada
                 int id = (int) tableBuscar.getValueAt(filaSeleccionada, 0);
                String tipo = (String) tableBuscar.getValueAt(filaSeleccionada, 1);
                String nombre = (String) tableBuscar.getValueAt(filaSeleccionada, 2);
                String descripcion = (String) tableBuscar.getValueAt(filaSeleccionada, 3);
                double precio = (double) tableBuscar.getValueAt(filaSeleccionada, 4);

                // Agregar la fila seleccionada a tableCarrito
                DefaultTableModel modeloCarrito = (DefaultTableModel) tableCarrito.getModel();
                Object[] fila = {id,tipo, nombre, descripcion, precio};
                modeloCarrito.addRow(fila);
                  TotalPagar();
            }
        }
    }
});

    // Configuración de la tabla
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.addColumn("id");
    modelo.addColumn("Tipo");
    modelo.addColumn("Nombre");
    modelo.addColumn("Descripción");
    modelo.addColumn("precio");
    tableBuscar.setModel(modelo);
    
    
DefaultTableModel modeloBuscar = new DefaultTableModel(new Object[]{"id","Tipo", "Nombre", "Descripción", "Precio"}, 0) {
    @Override
    public boolean isCellEditable(int row, int column) {
        return false; // Todas las celdas no son editables
      
    }
};
tableBuscar.setModel(modeloBuscar);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cbxTipoPago = new javax.swing.JComboBox<>();
        btnAgregarACarrito = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBuscar = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        btnAbonar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cbxClientes = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableCarrito = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnAgregarCliente = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtLocal = new javax.swing.JTextField();
        txtBarbero = new javax.swing.JTextField();
        txtCod = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCant = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1020, 470));
        jPanel1.setPreferredSize(new java.awt.Dimension(1020, 470));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.add(cbxTipoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 300, 30));

        btnAgregarACarrito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/32/carretilla.png"))); // NOI18N
        btnAgregarACarrito.setText("   AGREGAR A CARRITO");
        jPanel1.add(btnAgregarACarrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 350, 60));

        tableBuscar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableBuscar);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 630, 110));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 20, 110));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Cliente");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, -1, -1));

        btnAbonar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAbonar.setForeground(new java.awt.Color(0, 102, 102));
        btnAbonar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/32/monedas.png"))); // NOI18N
        btnAbonar.setText("  ABONAR");
        btnAbonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbonarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAbonar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 360, 310, 70));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Forma de Pago");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, -1, -1));

        jPanel1.add(cbxClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 300, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Codigo de Barras");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        tableCarrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Precio"
            }
        ));
        jScrollPane2.setViewportView(tableCarrito);
        if (tableCarrito.getColumnModel().getColumnCount() > 0) {
            tableCarrito.getColumnModel().getColumn(0).setMinWidth(20);
            tableCarrito.getColumnModel().getColumn(0).setPreferredWidth(20);
            tableCarrito.getColumnModel().getColumn(0).setMaxWidth(20);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 80, 310, 200));
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 220, 40));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/22/lupa (1).png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 50, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("TOTAL");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 300, -1, -1));

        txtTotal.setBackground(new java.awt.Color(0, 153, 153));
        txtTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 290, 130, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Carrito de Venta");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 60, -1, -1));

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/32/boton.png"))); // NOI18N
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 370, 60, 60));

        btnAgregarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/32/agregar-contacto.png"))); // NOI18N
        btnAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarClienteActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 370, 60, 60));

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/32/garrapata.png"))); // NOI18N
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 370, 60, 60));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/22/basura.png"))); // NOI18N
        btnEliminar.setBorder(null);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(948, 40, 30, 30));

        txtLocal.setText("Licencias");
        jPanel1.add(txtLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        txtBarbero.setText("Turno1");
        jPanel1.add(txtBarbero, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, -1, -1));
        jPanel1.add(txtCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 220, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Buscar Producto o Servicio");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        txtCant.setText("1");
        jPanel1.add(txtCant, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 50, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
     dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarClienteActionPerformed
        Clientes clie = new Clientes();
              clie.setVisible(true);
    }//GEN-LAST:event_btnAgregarClienteActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        
//        llenarComboBoxBarberos();
        llenarComboBoxClientes();
      
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
       eliminarFilaSeleccionada();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAbonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbonarActionPerformed

//
//    // Verificar que se haya seleccionado un barbero, cliente, tipo de pago y local
//     String nombre = txtBarbero.getText().trim();
//     String Local = txtLocal.getText().trim();
//     Cliente clienteSeleccionado = (Cliente) cbxClientes.getSelectedItem();
//    TipoPago tipoPagoSeleccionado = (TipoPago) cbxTipoPago.getSelectedItem();
//
//    if (nombre == null || clienteSeleccionado == null || tipoPagoSeleccionado == null || Local == null) {
//        JOptionPane.showMessageDialog(this, "Por favor selecciona un barbero, un cliente, un tipo de pago y un local.", "Error", JOptionPane.ERROR_MESSAGE);
//        return;
//    }
//
//    if (Totalpagar <= 0) {
//        JOptionPane.showMessageDialog(this, "El monto a abonar debe ser mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
//        return;
//    }
//
//    String montoAbonoStr = JOptionPane.showInputDialog(this, "Ingresa el monto del abono:", "Monto de Abono", JOptionPane.PLAIN_MESSAGE);
//    if (montoAbonoStr == null || montoAbonoStr.trim().isEmpty()) {
//        JOptionPane.showMessageDialog(this, "Debes ingresar un monto válido.", "Error", JOptionPane.ERROR_MESSAGE);
//        return;
//    }
//
//    double montoAbono = 0.0;
//    try {
//        montoAbono = Double.parseDouble(montoAbonoStr.trim());
//    } catch (NumberFormatException e) {
//        JOptionPane.showMessageDialog(this, "Por favor ingresa un monto válido.", "Error", JOptionPane.ERROR_MESSAGE);
//        return;
//    }
//
//    StockData stockData = new StockData();
//    int numFilas = tableCarrito.getRowCount();
//    
//    for (int i = 0; i < numFilas; i++) {
//        int idProducto = (int) tableCarrito.getValueAt(i, 0); // Asumiendo que el ID del producto está en la columna 0
//        int cantidad = 1; // Como mencionaste, la cantidad siempre será 1
//
//        // Verificar si hay suficiente stock en el local
//        boolean hayStock = stockData.hayStockEnLocal(idProducto, 9, cantidad);
//
//        if (!hayStock) {
//            JOptionPane.showMessageDialog(this, "No hay suficiente stock en el local seleccionado para el producto con ID: " + idProducto, "Error", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//
//        // Descontar el stock del local
//        stockData.descontarStockDeLocal(idProducto, 9, cantidad);
//    }
//
//    CajaData cajaData = new CajaData();
//    int idCajaGeneral = cajaData.obtenerCajaDelDia();
//
//    if (idCajaGeneral == -1) {
//        idCajaGeneral = cajaData.abrirCajaDelDia(0.00); // Si no hay una caja general abierta, abre una nueva
//    }
//
//    int idCajaBarbero = cajaData.obtenerCajaBarberoDelDia(9);
//    if (idCajaBarbero == -1) {
//        idCajaBarbero = cajaData.abrirCajaBarbero(9, idCajaGeneral); // Si no hay una caja del barbero, abre una nueva
////      cajaData.actualizarSaldoBarbero(barberoSeleccionado.getIdBarbero(), montoAbono);
//    }
//
//    MovimientoCaja movimiento = new MovimientoCaja();
//    movimiento.setDescripcion("Abono de " + clienteSeleccionado.getNombre());
//    movimiento.setMonto(montoAbono);
//    movimiento.setFecha(new Date());
//    movimiento.setEsIngreso(true);
//    movimiento.setIdCajaGeneral(idCajaGeneral);
//    movimiento.setIdCajaBarbero(idCajaBarbero);
//
//    int idMovimiento = cajaData.registrarMovimientoCaja(movimiento);
//
//    cajaData.actualizarSaldoBarbero(9, montoAbono);
//    cajaData.actualizarSaldoGeneral(montoAbono, idCajaGeneral);
//
//    JOptionPane.showMessageDialog(this, "Abono registrado exitosamente.");

    String nombre = txtBarbero.getText().trim();
    String Local = txtLocal.getText().trim();
    Cliente clienteSeleccionado = (Cliente) cbxClientes.getSelectedItem();
    TipoPago tipoPagoSeleccionado = (TipoPago) cbxTipoPago.getSelectedItem();

    if (nombre.isEmpty() || clienteSeleccionado == null || tipoPagoSeleccionado == null || Local.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor selecciona un barbero, un cliente, un tipo de pago y un local.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (Totalpagar <= 0) {
        JOptionPane.showMessageDialog(this, "El monto a abonar debe ser mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    StockData stockData = new StockData();
    int numFilas = tableCarrito.getRowCount();

    for (int i = 0; i < numFilas; i++) {
        int idProducto = (int) tableCarrito.getValueAt(i, 0); // Columna 0 = ID
        int cantidad = 1; // Ajustar si necesitás manejar cantidades reales

        boolean hayStock = stockData.hayStockEnLocal(idProducto, 9, cantidad);
        if (!hayStock) {
            JOptionPane.showMessageDialog(this, "No hay suficiente stock en el local seleccionado para el producto con ID: " + idProducto, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        stockData.descontarStockDeLocal(idProducto, 9, cantidad);
    }

    CajaData cajaData = new CajaData();
    int idCajaGeneral = cajaData.obtenerCajaDelDia();
    if (idCajaGeneral == -1) {
        idCajaGeneral = cajaData.abrirCajaDelDia(0.00);
    }

    int idCajaBarbero = cajaData.obtenerCajaBarberoDelDia(9);
    if (idCajaBarbero == -1) {
        idCajaBarbero = cajaData.abrirCajaBarbero(9, idCajaGeneral);
    }

    MovimientoCaja movimiento = new MovimientoCaja();
    movimiento.setDescripcion("Abono de " + clienteSeleccionado.getNombre());
    movimiento.setMonto(Totalpagar);
    movimiento.setFecha(new Date());
    movimiento.setEsIngreso(true);
    movimiento.setIdCajaGeneral(idCajaGeneral);
    movimiento.setIdCajaBarbero(idCajaBarbero);

    int idMovimiento = cajaData.registrarMovimientoCaja(movimiento);

    cajaData.actualizarSaldoBarbero(9, Totalpagar);
    cajaData.actualizarSaldoGeneral(Totalpagar, idCajaGeneral);

    JOptionPane.showMessageDialog(this, "Abono registrado exitosamente.");
    }//GEN-LAST:event_btnAbonarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NuevaVentaLicencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevaVentaLicencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevaVentaLicencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevaVentaLicencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevaVentaLicencias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbonar;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregarACarrito;
    private javax.swing.JButton btnAgregarCliente;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<Cliente> cbxClientes;
    private javax.swing.JComboBox<TipoPago> cbxTipoPago;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tableBuscar;
    private javax.swing.JTable tableCarrito;
    private javax.swing.JTextField txtBarbero;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCant;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtLocal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

//private void llenarComboBoxFormadePago() {
//    List<TipoPago> tpp = cajaGeneralData.listarTipoPago();
//    DefaultComboBoxModel<TipoPago> model = new DefaultComboBoxModel<>();
//
//    // Agregar un elemento vacío al inicio
//    model.addElement(null);
//
//    for (TipoPago tipop : tpp) {
//        model.addElement(tipop);
//    }
//
//    cbxTipoPago.setModel(model);
//
//    // Configurar el renderizado del JComboBox para mostrar apellido, nombre
//    cbxTipoPago.setRenderer(new javax.swing.DefaultListCellRenderer() {
//        @Override
//        public java.awt.Component getListCellRendererComponent(
//                javax.swing.JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
//            if (value instanceof TipoPago) {
//                TipoPago tipopa = (TipoPago) value;
//                value = tipopa.getNombre();
//                
//            } else if (value == null) {
//                value = ""; // Mostrar una cadena vacía para el elemento vacío
//            }
//            return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
//        }
//    });
//}
private void llenarComboBoxFormadePago() {
    List<TipoPago> tpp = cajaGeneralData.listarTipoPago();
    DefaultComboBoxModel<TipoPago> model = new DefaultComboBoxModel<>();

    model.addElement(null); // Elemento vacío opcional

    TipoPago efectivo = null;

    for (TipoPago tipop : tpp) {
        model.addElement(tipop);
        if (tipop.getNombre().equalsIgnoreCase("Efectivo")) {
            efectivo = tipop;
        }
    }

    cbxTipoPago.setModel(model);

    // Setear por defecto "Efectivo"
    if (efectivo != null) {
        cbxTipoPago.setSelectedItem(efectivo);
    }

    cbxTipoPago.setRenderer(new javax.swing.DefaultListCellRenderer() {
        @Override
        public java.awt.Component getListCellRendererComponent(
                javax.swing.JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            if (value instanceof TipoPago) {
                TipoPago tipopa = (TipoPago) value;
                value = tipopa.getNombre();
            } else if (value == null) {
                value = "";
            }
            return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        }
    });
}

//private void llenarComboBoxBarberos() {
//    List<Barbero> barb = barberoData.listarBarberos();
//    DefaultComboBoxModel<Barbero> model = new DefaultComboBoxModel<>();
//
//    // Agregar un elemento vacío al inicio
//    model.addElement(null);
//
//    for (Barbero barbero : barb) {
//        model.addElement(barbero);
//    }
//
//    txtBarbero.setModel(model);
//
//    // Configurar el renderizado del JComboBox para mostrar apellido, nombre
//    txtBarbero.setRenderer(new javax.swing.DefaultListCellRenderer() {
//        @Override
//        public java.awt.Component getListCellRendererComponent(
//                javax.swing.JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
//            if (value instanceof Barbero) {
//                Barbero barbero = (Barbero) value;
//                value = barbero.getNombreBarbero();
//                
//            } else if (value == null) {
//                value = ""; // Mostrar una cadena vacía para el elemento vacío
//            }
//            return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
//        }
//    });
//}

//private void llenarComboBoxClientes() {
//    List<Cliente> clie = clienteData.listarCliente();
//    DefaultComboBoxModel<Cliente> model = new DefaultComboBoxModel<>();
//
//    // Agregar un elemento vacío al inicio
//    model.addElement(null);
//
//    for (Cliente cliente : clie) {
//        model.addElement(cliente);
//    }
//
//    cbxClientes.setModel(model);
//
//    // Configurar el renderizado del JComboBox para mostrar apellido, nombre
//    cbxClientes.setRenderer(new javax.swing.DefaultListCellRenderer() {
//        @Override
//        public java.awt.Component getListCellRendererComponent(
//                javax.swing.JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
//            if (value instanceof Cliente) {
//                Cliente cliente = (Cliente) value;
//                value = cliente.getNombre();
//                
//            } else if (value == null) {
//                value = ""; // Mostrar una cadena vacía para el elemento vacío
//            }
//            return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
//        }
//    });
//}
private void llenarComboBoxClientes() {
    List<Cliente> clie = clienteData.listarCliente();
    DefaultComboBoxModel<Cliente> model = new DefaultComboBoxModel<>();

    model.addElement(null); // Elemento vacío opcional

    Cliente consumidorFinal = null;

    for (Cliente cliente : clie) {
        model.addElement(cliente);
        if (cliente.getNombre().equalsIgnoreCase("Consumidor Final")) {
            consumidorFinal = cliente;
        }
    }

    cbxClientes.setModel(model);

    // Setear por defecto "Consumidor Final"
    if (consumidorFinal != null) {
        cbxClientes.setSelectedItem(consumidorFinal);
    }

    cbxClientes.setRenderer(new javax.swing.DefaultListCellRenderer() {
        @Override
        public java.awt.Component getListCellRendererComponent(
                javax.swing.JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            if (value instanceof Cliente) {
                Cliente cliente = (Cliente) value;
                value = cliente.getNombre();
            } else if (value == null) {
                value = "";
            }
            return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        }
    });
}


private void mostrarResultadosEnTabla(List<ResultadoBusqueda> resultados) {
    DefaultTableModel modelo = (DefaultTableModel) tableBuscar.getModel();
    modelo.setRowCount(0);  // Limpiar la tabla antes de mostrar los nuevos resultados

    for (ResultadoBusqueda resultado : resultados) {
        Object[] fila = {
            resultado.getIdProducto(),
            resultado.getTipo(),
            resultado.getNombre(),
            resultado.getDescripcion(),
            resultado.getPrecio()  
                
        };
        modelo.addRow(fila);
    }
}

private void realizarBusqueda() {
    String criterioBusqueda = txtBuscar.getText().trim();
    
    if (!criterioBusqueda.isEmpty()) {
        List<ResultadoBusqueda> resultados = productoData.buscarProductoYServicio(criterioBusqueda);
        mostrarResultadosEnTabla(resultados);
    } else {
        JOptionPane.showMessageDialog(null, "Por favor, ingrese un criterio de búsqueda.");
    }
}


private void TotalPagar() {
        Totalpagar = 0.00;
    int numFila = tableCarrito.getRowCount();
    for (int i = 0; i < numFila; i++) {
        double cal = Double.parseDouble(String.valueOf(tableCarrito.getModel().getValueAt(i, 4)));
        Totalpagar = Totalpagar + cal;
    }
    txtTotal.setText(String.format("%.2f", Totalpagar));

   
    }
private void eliminarFilaSeleccionada() {
    int filaSeleccionada = tableCarrito.getSelectedRow();

    if (filaSeleccionada >= 0) { // Verifica si se ha seleccionado alguna fila
        DefaultTableModel model = (DefaultTableModel) tableCarrito.getModel();
        model.removeRow(filaSeleccionada);

        // Aquí puedes realizar cualquier acción adicional necesaria después de eliminar la fila

        // Por ejemplo, si deseas recalcular el total después de eliminar la fila
        TotalPagar();
    }
}



public void realizarVenta(Venta venta, List<DetalleVenta> detalles, int idBarbero, int idLocal) {
    VentaData ventaData = new VentaData();
    CajaData cajaData = new CajaData();
    CajaGeneralData cajaGeneralData = new CajaGeneralData();
    StockData stockData = new StockData();

    // Registrar la venta
    int idVenta = ventaData.registrarVenta(venta);

    // Registrar cada detalle de la venta y descontar del stock en el local
    for (DetalleVenta detalle : detalles) {
        detalle.setIdVenta(idVenta);
        ventaData.registrarDetalleVenta(detalle);
        stockData.descontarStockDeLocal(detalle.getIdProducto(), idLocal, detalle.getCantidad());
    }

    // Registrar movimiento de caja
    MovimientoCaja movimiento = new MovimientoCaja();
    movimiento.setDescripcion("Venta de productos");
    movimiento.setMonto(venta.getMontoTotal());
    movimiento.setFecha(new Date());
    movimiento.setEsIngreso(true);
    movimiento.setIdCajaBarbero(idBarbero);
    int idMovimiento = cajaData.registrarMovimientoCaja(movimiento);

    // Actualizar saldos en caja
    cajaData.actualizarSaldoBarbero(idBarbero, venta.getMontoTotal());
    cajaData.actualizarSaldoGeneral(Totalpagar, idVenta);
}


//private void llenarComboBoxLocal() {
//    List<Local> loc = localData.listarLocal();
//    DefaultComboBoxModel<Local> model = new DefaultComboBoxModel<>();
//
//    // Agregar un elemento vacío al inicio
//    model.addElement(null);
//
//    for (Local local : loc) {
//        model.addElement(local);
//    }
//
//    txtLocal.setModel(model);
//
//    // Configurar el renderizado del JComboBox para mostrar apellido, nombre
//    txtLocal.setRenderer(new javax.swing.DefaultListCellRenderer() {
//        @Override
//        public java.awt.Component getListCellRendererComponent(
//                javax.swing.JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
//            if (value instanceof Local) {
//                Local local = (Local) value;
//                value = local.getNombreLocal();
//                
//            } else if (value == null) {
//                value = ""; // Mostrar una cadena vacía para el elemento vacío
//            }
//            return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
//        }
//    });
//}

private void agregarProductoAlCarrito() {
    String codigo = txtCod.getText().trim();
    int cantidad;

    try {
        cantidad = Integer.parseInt(txtCant.getText().trim());
        if (cantidad <= 0) throw new NumberFormatException();
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Cantidad inválida");
        return;
    }

    Producto producto = productoData.buscarPorCodigoBarra(codigo);

    if (producto == null) {
        JOptionPane.showMessageDialog(this, "Producto no encontrado");
        return;
    }

    DefaultTableModel modelo = (DefaultTableModel) tableCarrito.getModel();

    for (int i = 0; i < cantidad; i++) {
        Object[] fila = {
            producto.getIdProducto(),
            "Producto",
            producto.getNombre(),
            producto.getDescripcion(),
            producto.getPrecio()
        };
        modelo.addRow(fila);
    }
    

    // Limpiar campos
    txtCod.setText("");
    txtCant.setText("1");
    txtCod.requestFocus();
}


}
