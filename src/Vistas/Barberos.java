
package Vistas;

import Metodos.BarberoData;
import javax.swing.JOptionPane;
import Entidades.Barbero;  
import Metodos.Conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;


public class Barberos extends javax.swing.JFrame {
private Conexion con;
    private BarberoData barberoData;
    
    
    public Barberos() {
        initComponents();
          con = new Conexion(); // Inicializas la conexión
        barberoData = new BarberoData();
        llenarComboBoxBarberos();
        
btnEliminar.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        Barbero barberoSeleccionado = (Barbero) cbxBarbero.getSelectedItem();
        if (barberoSeleccionado != null) {
            int confirmacion = JOptionPane.showConfirmDialog(null, 
                "¿Estás seguro de que deseas eliminar a " + barberoSeleccionado.getNombreBarbero() + "?", 
                "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                barberoData.eliminarBarbero(barberoSeleccionado.getIdBarbero()+ barberoSeleccionado.getIdBarbero());
                JOptionPane.showMessageDialog(null, "Barbero eliminado exitosamente.");
                cbxBarbero.removeItem(barberoSeleccionado.getIdBarbero()); // Eliminar del ComboBox
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecciona un barbero.");
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
        tableBarbero = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtNombre = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        cbxBarbero = new javax.swing.JComboBox<>();
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

        tableBarbero.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableBarbero);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 650, 320));

        jLabel2.setText("Nombre y Apellido");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 60, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 120, 190, 10));

        txtNombre.setBorder(null);
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 80, 190, 40));

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/22/silla-de-barbero.png"))); // NOI18N
        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 140, 190, 50));

        jPanel1.add(cbxBarbero, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 300, 190, 40));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/22/basura.png"))); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 390, 70, 50));

        jLabel1.setText("Seleccione Barbero");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 260, -1, -1));

        jTextField1.setBackground(new java.awt.Color(214, 183, 153));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setText("  BARBEROS");
        jTextField1.setBorder(null);
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 170, 40));

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
        Barbero barbero = new Barbero();
        barbero.setNombreBarbero(nombre);

        // Llamar al método para agregar el barbero en la base de datos
        barberoData.agregarBarbero(barbero);

        // Limpiar el campo de texto después de agregar
        txtNombre.setText("");

        JOptionPane.showMessageDialog(this, "Barbero agregado exitosamente.");
        llenarComboBoxBarberos();
    }
    
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(Barberos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Barberos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Barberos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Barberos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Barberos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<Barbero> cbxBarbero;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tableBarbero;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

private void llenarComboBoxBarberos() {
    List<Barbero> barb = barberoData.listarBarberos();
    DefaultComboBoxModel<Barbero> model = new DefaultComboBoxModel<>();

    // Agregar un elemento vacío al inicio
    model.addElement(null);

    for (Barbero barbero : barb) {
        model.addElement(barbero);
    }

    cbxBarbero.setModel(model);

    // Configurar el renderizado del JComboBox para mostrar apellido, nombre
    cbxBarbero.setRenderer(new javax.swing.DefaultListCellRenderer() {
        @Override
        public java.awt.Component getListCellRendererComponent(
                javax.swing.JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            if (value instanceof Barbero) {
                Barbero barbero = (Barbero) value;
                value = barbero.getNombreBarbero();
                
            } else if (value == null) {
                value = ""; // Mostrar una cadena vacía para el elemento vacío
            }
            return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        }
    });
}

}
