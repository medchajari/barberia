
package Vistas;

import Entidades.Almacen;
import Entidades.Local;
import Entidades.Producto;
import Metodos.AlmacenData;
import Metodos.Conexion;
import Metodos.LocalData;
import Metodos.ProductoData;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import Entidades.Stock;
import Metodos.StockData;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Stocks extends javax.swing.JFrame {
 private Conexion con;
    private Almacen almacen;
    private AlmacenData almacenData;
    private Local local;
    private LocalData localData;    
    private Producto producto;
    private ProductoData productoData;
   private StockData stockData;
   
    public Stocks() {
        initComponents();
          con = new Conexion(); // Inicializas la conexión        
        almacen = new Almacen();
        almacenData = new AlmacenData();
         local = new Local();
         localData = new LocalData();
          producto = new Producto();
          productoData = new ProductoData();
          stockData = new StockData();
          llenarComboBoxAlamcen();
          llenarComboBoxLocal();
          llenarComboBoxProducto();
          
   txtCod.addKeyListener(new KeyAdapter() {
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            String codigo = txtCod.getText().trim();
            seleccionarProductoPorCodigo(codigo);
        }
    }
});
       
          
btnAgregar.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Obtener los valores seleccionados en los JComboBox
        Local localSeleccionado = (Local) cbxLocal.getSelectedItem();
        Producto productoSeleccionado = (Producto) cbxProducto.getSelectedItem();
        Almacen almacenSeleccionado = (Almacen) cbxAlmacen.getSelectedItem();
        
        // Obtener la cantidad desde el campo de texto
        String cantidadTexto = txtCantidad.getText();
        
        // Validar si la cantidad es un número
        int cantidad;
        try {
            cantidad = Integer.parseInt(cantidadTexto);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese una cantidad válida.");
            return;
        }

        // Crear una instancia de Stock
        Stock nuevoStock = new Stock();
        nuevoStock.setAlmacen(almacenSeleccionado);
        nuevoStock.setLocal(localSeleccionado);
        nuevoStock.setProducto(productoSeleccionado);
        nuevoStock.setCantidad(cantidad);

        // Llamar al método agregarStock sin verificar retorno
        stockData.agregarStock(nuevoStock);

        // Mostrar mensaje de éxito (o manejar error dentro del método)
        JOptionPane.showMessageDialog(null, "Stock agregado exitosamente.");
    }
});

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbxAlmacen = new javax.swing.JComboBox<>();
        cbxLocal = new javax.swing.JComboBox<>();
        cbxProducto = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        txtCod = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1022, 470));

        fondo.setBackground(new java.awt.Color(255, 255, 255));
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondos/2.jpg"))); // NOI18N
        fondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 510));

        fondo.add(cbxAlmacen, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 210, 270, 40));

        fondo.add(cbxLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 280, 270, 40));

        fondo.add(cbxProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 140, 270, 40));

        jLabel2.setText("Ingrese Codigo de Barras");
        fondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 40, -1, -1));

        jLabel3.setText("Almacen");
        fondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 190, -1, -1));

        jLabel4.setText("Local");
        fondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 260, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/32/boton.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        fondo.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 390, 90, 50));

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/32/espuma-para-el-cabello.png"))); // NOI18N
        btnAgregar.setText("AGREGAR STOCK");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        fondo.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 390, 180, 50));

        jLabel5.setText("Cantidad :");
        fondo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 340, 60, 20));
        fondo.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 330, 100, 40));
        fondo.add(txtCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 62, 270, 40));

        jLabel6.setText("Producto");
        fondo.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 120, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed

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
            java.util.logging.Logger.getLogger(Stocks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Stocks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Stocks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Stocks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Stocks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JComboBox<Almacen> cbxAlmacen;
    private javax.swing.JComboBox<Local> cbxLocal;
    private javax.swing.JComboBox<Producto> cbxProducto;
    private javax.swing.JPanel fondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCod;
    // End of variables declaration//GEN-END:variables

private void llenarComboBoxLocal() {
    List<Local> loc = localData.listarLocal();
    DefaultComboBoxModel<Local> model = new DefaultComboBoxModel<>();

    // Agregar un elemento vacío al inicio
    model.addElement(null);

    for (Local local : loc) {
        model.addElement(local);
    }

    cbxLocal.setModel(model);

    // Configurar el renderizado del JComboBox para mostrar apellido, nombre
    cbxLocal.setRenderer(new javax.swing.DefaultListCellRenderer() {
        @Override
        public java.awt.Component getListCellRendererComponent(
                javax.swing.JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            if (value instanceof Local) {
                Local local = (Local) value;
                value = local.getNombreLocal();
                
            } else if (value == null) {
                value = ""; // Mostrar una cadena vacía para el elemento vacío
            }
            return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        }
    });
}

private void llenarComboBoxProducto() {
    List<Producto> prod = productoData.listarProductos();
    DefaultComboBoxModel<Producto> model = new DefaultComboBoxModel<>();

    // Agregar un elemento vacío al inicio
    model.addElement(null);

    for (Producto product : prod) {
        model.addElement(product);
    }

    cbxProducto.setModel(model);

    // Configurar el renderizado del JComboBox para mostrar apellido, nombre
    cbxProducto.setRenderer(new javax.swing.DefaultListCellRenderer() {
        @Override
        public java.awt.Component getListCellRendererComponent(
                javax.swing.JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            if (value instanceof Producto) {
                Producto producto = (Producto) value;
                value = producto.getDescripcion();
                
            } else if (value == null) {
                value = ""; // Mostrar una cadena vacía para el elemento vacío
            }
            return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        }
    });
}

private void llenarComboBoxAlamcen() {
    List<Almacen> alm = almacenData.listarAmacen();
    DefaultComboBoxModel<Almacen> model = new DefaultComboBoxModel<>();

    // Agregar un elemento vacío al inicio
    model.addElement(null);

    for (Almacen almacen : alm) {
        model.addElement(almacen);
    }

    cbxAlmacen.setModel(model);

    // Configurar el renderizado del JComboBox para mostrar apellido, nombre
    cbxAlmacen.setRenderer(new javax.swing.DefaultListCellRenderer() {
        @Override
        public java.awt.Component getListCellRendererComponent(
                javax.swing.JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            if (value instanceof Almacen) {
                Almacen almacen = (Almacen) value;
                value = almacen.getNombre();
                
            } else if (value == null) {
                value = ""; // Mostrar una cadena vacía para el elemento vacío
            }
            return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        }
    });
}

private void seleccionarProductoPorCodigo(String codigoBarra) {
    for (int i = 0; i < cbxProducto.getItemCount(); i++) {
        Producto producto = cbxProducto.getItemAt(i);
        if (producto != null && codigoBarra.equalsIgnoreCase(producto.getCodigo_barra())) {
            cbxProducto.setSelectedIndex(i);
            return;
        }
    }

    // Si no se encontró, mostrar mensaje o limpiar selección
    JOptionPane.showMessageDialog(this, "Producto no encontrado");
    cbxProducto.setSelectedIndex(0); // o -1 si querés dejarlo sin selección
}


}
