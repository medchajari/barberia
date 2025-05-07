
package Vistas;

import Metodos.LocalData;
import javax.swing.JOptionPane;
import Entidades.Local;  
import Metodos.Conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;


public class Sucursal extends javax.swing.JFrame {
private Conexion con;
    private LocalData localData;
    
    
    public Sucursal() {
        initComponents();
          con = new Conexion(); // Inicializas la conexión
        localData = new LocalData();
        llenarComboBoxLocal();
        
btnEliminar.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        Local localSeleccionado = (Local) cbxLocal.getSelectedItem();
        if (localSeleccionado != null) {
            int confirmacion = JOptionPane.showConfirmDialog(null, 
                "¿Estás seguro de que deseas eliminar a " + localSeleccionado.getNombreLocal() + localSeleccionado.getIdLocal()+"?", 
                "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                localData.eliminarLocal(localSeleccionado.getIdLocal());
                JOptionPane.showMessageDialog(null, "Sucursal eliminada exitosamente.");
                cbxLocal.removeItem(localSeleccionado); // Eliminar del ComboBox
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecciona una Sucursal.");
        }
    }
});
    
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSucursal = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtNombre = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        cbxLocal = new javax.swing.JComboBox<>();
        btnEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1020, 470));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/32/boton.png"))); // NOI18N
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 390, 110, 50));

        tableSucursal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableSucursal);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 650, 350));

        jLabel2.setText("Nombre de Sucursal");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 60, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 120, 190, 10));

        txtNombre.setBorder(null);
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 80, 190, 40));

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/22/peluqueria (1).png"))); // NOI18N
        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 140, 190, 50));

        jPanel1.add(cbxLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 300, 190, 40));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/22/basura.png"))); // NOI18N
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 390, 70, 50));

        jLabel1.setText("Seleccione Sucursal");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 260, -1, -1));

        jTextField1.setBackground(new java.awt.Color(214, 183, 153));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setText("  SUCURSAL");
        jTextField1.setBorder(null);
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 160, 40));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondos/4a70fde3f0078df378f92edf14eaaf2a.jpg"))); // NOI18N
        fondo.setPreferredSize(new java.awt.Dimension(500, 1020));
        jPanel1.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 470));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
       dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
      
       // Recopilar los datos del barbero desde el campo de texto y eliminar espacios en blanco
    String nombre = txtNombre.getText().trim();

    // Validar que el campo no esté vacío
    if (nombre.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        // Crear un objeto Barbero y asignar el nombre
        Local local = new Local();
        local.setNombreLocal(nombre);

        // Llamar al método para agregar el barbero en la base de datos
        localData.agregarLocal(local);

        // Limpiar el campo de texto después de agregar
        txtNombre.setText("");

        JOptionPane.showMessageDialog(this, "Local agregado exitosamente.");
        llenarComboBoxLocal();
    }
    
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
            java.util.logging.Logger.getLogger(Local.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Local.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Local.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Local.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sucursal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<Local> cbxLocal;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tableSucursal;
    private javax.swing.JTextField txtNombre;
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

}
