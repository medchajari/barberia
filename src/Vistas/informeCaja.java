/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Entidades.Barbero;
import Entidades.CajaBarbero;
import Entidades.CajaGeneral;
import Metodos.BarberoData;
import Metodos.CajaData;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MeD
 */
public class informeCaja extends javax.swing.JFrame {

   private Barbero barbero;
   private BarberoData barberoData;
 
    public informeCaja() {
        initComponents();
         barbero = new Barbero();
         barberoData = new BarberoData();
         llenarComboBoxBarberos();
        
//        btnMostrar.addActionListener(new ActionListener() {
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        Date desde = dcDesde.getDate();
//        Date hasta = dcHasta.getDate();
//
//        boolean incluirCajaGeneral = ckCajaGeneral.isSelected();
//        boolean incluirBarberoEspecifico = ckBarbero.isSelected();
//        boolean incluirTodosBarberos = ckTodos.isSelected();
//        
//        List<CajaGeneral> cajasGenerales = new ArrayList<>();
//        List<CajaBarbero> cajasBarberos = new ArrayList<>();
//
//        if (incluirCajaGeneral) {
//            CajaData cajaData = new CajaData();
//            cajasGenerales = cajaData.listarCajaGeneralPorFecha(desde, hasta);
//        }
//
//        if (incluirBarberoEspecifico || incluirTodosBarberos) {
//            CajaData cajaBarberoData = new CajaData();
//            Integer idBarbero = null;
//
//            if (incluirBarberoEspecifico) {
//                Barbero barberoSeleccionado = (Barbero) cbxBarbero.getSelectedItem();
//                idBarbero = barberoSeleccionado != null ? barberoSeleccionado.getIdBarbero() : null;
//            }
//
//            cajasBarberos = cajaBarberoData.listarCajaBarberoPorFecha(desde, hasta, idBarbero);
//        }
//
//        // Aquí combinarás ambas listas en una sola lista para llenar la tabla
//        llenarTablaCajas(cajasGenerales, cajasBarberos);
//         sumarColumnaYMostrarEnTxtTotal();
//    }
//});
        
  btnMostrar.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        Barbero barberoSeleccionado = (Barbero) cbxBarbero.getSelectedItem();
        boolean incluirTodosBarberos = ckTodos.isSelected();

        // Verificar si se selecciona el barbero "Agustin Rivero 6" o si se selecciona ckTodos
        if ((barberoSeleccionado != null && barberoSeleccionado.getNombreBarbero().equals("Agustin Rivero") && barberoSeleccionado.getIdBarbero() == 6) || incluirTodosBarberos) {
            // Solicitar contraseña
            String password = JOptionPane.showInputDialog(null, "Ingrese la contraseña para ver los resultados:", "Contraseña requerida", JOptionPane.PLAIN_MESSAGE);

            if (!"medchajari".equals(password)) {
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta. No se pueden mostrar los resultados.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Termina la ejecución del listener si la contraseña es incorrecta
            }
        }

        Date desde = dcDesde.getDate();
        Date hasta = dcHasta.getDate();

        boolean incluirCajaGeneral = ckCajaGeneral.isSelected();
        boolean incluirBarberoEspecifico = ckBarbero.isSelected();

        List<CajaGeneral> cajasGenerales = new ArrayList<>();
        List<CajaBarbero> cajasBarberos = new ArrayList<>();

        if (incluirCajaGeneral) {
            CajaData cajaData = new CajaData();
            cajasGenerales = cajaData.listarCajaGeneralPorFecha(desde, hasta);
        }

        if (incluirBarberoEspecifico || incluirTodosBarberos) {
            CajaData cajaBarberoData = new CajaData();
            Integer idBarbero = null;

            if (incluirBarberoEspecifico) {
                idBarbero = barberoSeleccionado != null ? barberoSeleccionado.getIdBarbero() : null;
            }

            cajasBarberos = cajaBarberoData.listarCajaBarberoPorFecha(desde, hasta, idBarbero);
        }

        // Aquí combinarás ambas listas en una sola lista para llenar la tabla
        llenarTablaCajas(cajasGenerales, cajasBarberos);
        sumarColumnaYMostrarEnTxtTotal();
    }
});

        llenarCbxPorcentaje();

// Llamar a este método después de llenar la tabla con datos


// Agregar el ActionListener al botón para calcular el porcentaje
btnCalcular.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        calcularTotalPorcentaje();
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCaja = new javax.swing.JTable();
        cbxBarbero = new javax.swing.JComboBox<>();
        dcHasta = new com.toedter.calendar.JDateChooser();
        dcDesde = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        ckTodos = new javax.swing.JCheckBox();
        ckBarbero = new javax.swing.JCheckBox();
        ckCajaGeneral = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        txtTotalPorcentaje = new javax.swing.JTextField();
        cbxPorcentaje = new javax.swing.JComboBox<>();
        btnCalcular = new javax.swing.JButton();
        txtTotal = new javax.swing.JTextField();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1020, 436));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1020, 436));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaCaja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo de Caja", "Fecha", "Monto", "Barbero"
            }
        ));
        jScrollPane1.setViewportView(tablaCaja);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 540, 300));

        cbxBarbero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxBarberoActionPerformed(evt);
            }
        });
        jPanel1.add(cbxBarbero, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 150, 340, 40));
        jPanel1.add(dcHasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 270, 160, 50));
        jPanel1.add(dcDesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 270, 170, 50));

        jLabel2.setText("Seleccione rango de fecha");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 240, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/32/boton.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 370, 150, 60));

        btnMostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/22/papel.png"))); // NOI18N
        btnMostrar.setText("MOSTRAR");
        jPanel1.add(btnMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 370, 190, 60));

        ckTodos.setText("Todos");
        jPanel1.add(ckTodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 100, -1, -1));

        ckBarbero.setText("Por Barbero");
        jPanel1.add(ckBarbero, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 100, -1, -1));

        ckCajaGeneral.setText("Caja General");
        jPanel1.add(ckCajaGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Mostrar informes de Caja");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 50, -1, -1));
        jPanel1.add(txtTotalPorcentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 390, 120, 40));

        jPanel1.add(cbxPorcentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 390, 120, 40));

        btnCalcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/22/pos-terminal.png"))); // NOI18N
        btnCalcular.setText("CALCULAR");
        jPanel1.add(btnCalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, 120, 40));
        jPanel1.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 150, 40));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondos/78.jpg"))); // NOI18N
        jPanel1.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 450));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbxBarberoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxBarberoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxBarberoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(informeCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(informeCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(informeCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(informeCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new informeCaja().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JComboBox<Barbero> cbxBarbero;
    private javax.swing.JComboBox<Integer> cbxPorcentaje;
    private javax.swing.JCheckBox ckBarbero;
    private javax.swing.JCheckBox ckCajaGeneral;
    private javax.swing.JCheckBox ckTodos;
    private com.toedter.calendar.JDateChooser dcDesde;
    private com.toedter.calendar.JDateChooser dcHasta;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaCaja;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTotalPorcentaje;
    // End of variables declaration//GEN-END:variables



private void llenarTablaCajas(List<CajaGeneral> cajasGenerales, List<CajaBarbero> cajasBarberos) {
    DefaultTableModel model = (DefaultTableModel) tablaCaja.getModel();
    model.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos

    // Llenar con datos de CajaGeneral
    for (CajaGeneral cajaGeneral : cajasGenerales) {
        Object[] rowData = {
            "Caja General",
            cajaGeneral.getFecha(),
            cajaGeneral.getSaldo(),
            "Todos", // Columna vacía para Barbero
        };
        model.addRow(rowData);
    }

    // Llenar con datos de CajaBarbero
    for (CajaBarbero cajaBarbero : cajasBarberos) {
        Object[] rowData = {
            "Caja Barbero",
            cajaBarbero.getFecha(),
            cajaBarbero.getSaldo(),
            cajaBarbero.getNombreBarbero() // Mostrar el nombre del barbero
        };
        model.addRow(rowData);
       
    }
}

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
                value = barbero.getNombreBarbero()+" "+ barbero.getIdBarbero();
                
            } else if (value == null) {
                value = ""; // Mostrar una cadena vacía para el elemento vacío
            }
            return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        }
    });
}


private void sumarColumnaYMostrarEnTxtTotal() {
    double total = 0;
    DefaultTableModel model = (DefaultTableModel) tablaCaja.getModel();
    
    for (int i = 0; i < model.getRowCount(); i++) {
        Object valor = model.getValueAt(i, 2); // Columna 2 contiene los saldos
        
        if (valor != null && valor instanceof Number) {
            total += ((Number) valor).doubleValue();
        }
    }
    
    txtTotal.setText(String.valueOf(total));
}

private void llenarCbxPorcentaje() {
    for (int i = 1; i <= 100; i++) {
        cbxPorcentaje.addItem(i);
    }
}

private void calcularTotalPorcentaje() {
    double total = Double.parseDouble(txtTotal.getText());
    int porcentajeSeleccionado = (int) cbxPorcentaje.getSelectedItem();
    
    double totalPorcentaje = total * porcentajeSeleccionado / 100;
    txtTotalPorcentaje.setText(String.valueOf(totalPorcentaje));
}

}
