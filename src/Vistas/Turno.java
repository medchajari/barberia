
package Vistas;

import Metodos.LocalData;
import Metodos.BarberoData;
import Metodos.ClienteData;
import Metodos.ServicioData;
import javax.swing.JOptionPane;
import Entidades.Servicio;  
import Entidades.Barbero;
import Entidades.Cliente;
import Entidades.Local;
import Entidades.Servicio;
import Entidades.Turnos;
import Metodos.Conexion;
import Metodos.turnosData;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;


public class Turno extends javax.swing.JFrame {
    private Conexion con;
    private ServicioData servicioData;
    private BarberoData barberoData;
    private LocalData localData;
    private ClienteData clienteData;
    private Servicio servicio;
    private turnosData turnosData;
    
    
    public Turno() {
        initComponents();
          con = new Conexion(); // Inicializas la conexión
        servicioData = new ServicioData();
        barberoData = new BarberoData();
        localData = new LocalData();
        clienteData = new ClienteData();
        servicio = new Servicio();
        turnosData = new turnosData();
        llenarComboBoxServicio();
        llenarComboBoxBarberos();
        llenarComboBoxClientes();
        llenarComboBoxLocal();
       
        
btnEliminar.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Verificar si hay un turno seleccionado en la tabla
        int selectedRow = tableServicios.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione un turno para eliminar.");
            return;
        }

        // Obtener el idTurno del turno seleccionado
        int idTurno = (int) tableServicios.getValueAt(selectedRow, 0); // Asumiendo que la primera columna contiene el idTurno

        // Confirmación antes de eliminar
        int confirm = JOptionPane.showConfirmDialog(null, 
            "¿Está seguro que desea eliminar este turno?", 
            "Confirmar Eliminación", 
            JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            // Llamar al método eliminarTurno
            boolean eliminado = turnosData.eliminarTurno(idTurno);
            
            if (eliminado) {
                // Si se eliminó correctamente, actualizar la tabla
                ((DefaultTableModel) tableServicios.getModel()).removeRow(selectedRow);
                JOptionPane.showMessageDialog(null, "Turno eliminado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar el turno.");
            }
        }
    }
});

btnAgregar.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Obtener los valores seleccionados en los JComboBox
        Local localSeleccionado = (Local) cbxLocal.getSelectedItem();
        Barbero barberoSeleccionado = (Barbero) cbxBarbero.getSelectedItem();
        Cliente clienteSeleccionado = (Cliente) cbxCliente.getSelectedItem();
        Servicio servicioSeleccionado = (Servicio) cbxServicio.getSelectedItem();
        
        // Obtener la hora desde el campo de texto
        String hora = txtHora.getText();

        // Obtener la fecha seleccionada desde dcFecha
        Date fechaSeleccionada = dcFecha.getDate();

        // Validar que se haya seleccionado una fecha
        if (fechaSeleccionada == null) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una fecha.");
            return;
        }

        // Crear una instancia de Turnos
        Turnos nuevoTurno = new Turnos();
        nuevoTurno.setNombreLocal(localSeleccionado);
        nuevoTurno.setNombreBarbero(barberoSeleccionado);
        nuevoTurno.setNombre(clienteSeleccionado);
        nuevoTurno.setServicio(servicioSeleccionado.getNombre());
        nuevoTurno.setFecha(fechaSeleccionada);
        nuevoTurno.setHora(hora);

        // Llamar al método agregarTurno en turnosData
        if (turnosData.agregarTurno(nuevoTurno)) {
            JOptionPane.showMessageDialog(null, "Turno agregado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Error al agregar el turno.");
        }
    }
});


btnBuscar.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Obtener los valores seleccionados en los JComboBox y la fecha
        Local localSeleccionado = (Local) cbxLocal.getSelectedItem();
        Barbero barberoSeleccionado = (Barbero) cbxBarbero.getSelectedItem();
        Date fechaSeleccionada = dcFecha.getDate();

        // Validar que se hayan seleccionado los valores necesarios
        if (localSeleccionado == null || barberoSeleccionado == null || fechaSeleccionada == null) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione un local, un barbero y una fecha.");
            return;
        }

        // Llamar al método de búsqueda en turnosData
        List<Turnos> turnosEncontrados = turnosData.buscarTurnos(
                localSeleccionado.getIdLocal(),
                barberoSeleccionado.getIdBarbero(),
                fechaSeleccionada
        );

        // Llenar la tabla con los resultados
        DefaultTableModel model = (DefaultTableModel) tableServicios.getModel();
        model.setRowCount(0); // Limpiar la tabla antes de agregar los nuevos datos

        for (Turnos turno : turnosEncontrados) {
            model.addRow(new Object[]{
                turno.getIdTurno(),
                    turno.getNombre().getNombre(), // Nombre del cliente
                    turno.getServicio(),           // Servicio
                    turno.getFecha(),              // Fecha
                    turno.getHora()                // Hora
                    
                    
            });
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
        tableServicios = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        cbxCliente = new javax.swing.JComboBox<>();
        btnEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        cbxLocal = new javax.swing.JComboBox<>();
        cbxBarbero = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        cbxServicio = new javax.swing.JComboBox<>();
        dcFecha = new com.toedter.calendar.JDateChooser();
        jTextField3 = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnAgregarCliente = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
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
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 400, 140, 40));

        tableServicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Cliente", "Servicio", "Fecha", "Hora"
            }
        ));
        jScrollPane1.setViewportView(tableServicios);
        if (tableServicios.getColumnModel().getColumnCount() > 0) {
            tableServicios.getColumnModel().getColumn(0).setMinWidth(30);
            tableServicios.getColumnModel().getColumn(0).setPreferredWidth(30);
            tableServicios.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 650, 290));

        jLabel2.setText("Servicio");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, 100, -1));

        btnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/22/agregar.png"))); // NOI18N
        btnAgregar.setText("  AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 340, 220, 30));

        jPanel1.add(cbxCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 120, 220, 30));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/22/basura.png"))); // NOI18N
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 400, 70, 40));

        jLabel1.setText("Cliente");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 90, -1, -1));

        jLabel3.setText("Hora");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 230, 50, -1));

        txtHora.setBorder(null);
        jPanel1.add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 250, 220, 30));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 280, 220, 10));

        jPanel1.add(cbxLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 210, 40));

        jPanel1.add(cbxBarbero, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 210, 40));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/22/lupa (1).png"))); // NOI18N
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, 60, 40));

        jTextField1.setBackground(new java.awt.Color(214, 183, 153));
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setText("FECHA");
        jTextField1.setBorder(null);
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 110, -1));

        jTextField2.setBackground(new java.awt.Color(214, 183, 153));
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setText("SUCURSAL");
        jTextField2.setBorder(null);
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 110, -1));

        jPanel1.add(cbxServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 40, 220, 30));
        jPanel1.add(dcFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, 140, 40));

        jTextField3.setBackground(new java.awt.Color(214, 183, 153));
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));
        jTextField3.setText("BARBERO");
        jTextField3.setBorder(null);
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 110, -1));

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/22/garrapata.png"))); // NOI18N
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 160, 100, 30));

        btnAgregarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/22/agregar-contacto.png"))); // NOI18N
        btnAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarClienteActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 160, 100, 30));

        jTextField4.setBackground(new java.awt.Color(214, 183, 153));
        jTextField4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));
        jTextField4.setText("  TURNOS");
        jTextField4.setBorder(null);
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 140, 30));

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
      
    
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        llenarComboBoxServicio();
        llenarComboBoxBarberos();
        llenarComboBoxClientes();
        llenarComboBoxLocal();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarClienteActionPerformed
     Clientes clie = new Clientes();
     clie.setVisible(true);
    }//GEN-LAST:event_btnAgregarClienteActionPerformed

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
            java.util.logging.Logger.getLogger(Turno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Turno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Turno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Turno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Turno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregarCliente;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<Barbero> cbxBarbero;
    private javax.swing.JComboBox<Cliente> cbxCliente;
    private javax.swing.JComboBox<Local> cbxLocal;
    private javax.swing.JComboBox<Servicio> cbxServicio;
    private com.toedter.calendar.JDateChooser dcFecha;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTable tableServicios;
    private javax.swing.JTextField txtHora;
    // End of variables declaration//GEN-END:variables

private void llenarComboBoxServicio() {
    List<Servicio> ser = servicioData.listarServicio();
    DefaultComboBoxModel<Servicio> model = new DefaultComboBoxModel<>();

    // Agregar un elemento vacío al inicio
    model.addElement(null);

    for (Servicio servi : ser) {
        model.addElement(servi);
    }

    cbxServicio.setModel(model);

    // Configurar el renderizado del JComboBox para mostrar apellido, nombre
    cbxServicio.setRenderer(new javax.swing.DefaultListCellRenderer() {
        @Override
        public java.awt.Component getListCellRendererComponent(
                javax.swing.JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            if (value instanceof Servicio) {
                Servicio servicio = (Servicio) value;
                value = servicio.getNombre();
                
            } else if (value == null) {
                value = ""; // Mostrar una cadena vacía para el elemento vacío
            }
            return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        }
    });
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
                value = barbero.getNombreBarbero();
                
            } else if (value == null) {
                value = ""; // Mostrar una cadena vacía para el elemento vacío
            }
            return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        }
    });
}

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
private void llenarComboBoxClientes() {
    List<Cliente> clie = clienteData.listarCliente();
    DefaultComboBoxModel<Cliente> model = new DefaultComboBoxModel<>();

    // Agregar un elemento vacío al inicio
    model.addElement(null);

    for (Cliente cliente : clie) {
        model.addElement(cliente);
    }

    cbxCliente.setModel(model);

    // Configurar el renderizado del JComboBox para mostrar apellido, nombre
    cbxCliente.setRenderer(new javax.swing.DefaultListCellRenderer() {
        @Override
        public java.awt.Component getListCellRendererComponent(
                javax.swing.JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            if (value instanceof Cliente) {
                Cliente cliente = (Cliente) value;
                value = cliente.getNombre();
                
            } else if (value == null) {
                value = ""; // Mostrar una cadena vacía para el elemento vacío
            }
            return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        }
    });
}




}
