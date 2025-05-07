
package Vistas;

import Entidades.Servicio;  
import Metodos.ServicioData;
import javax.swing.DefaultComboBoxModel;
import Entidades.ResultadoBusqueda;
import Metodos.Conexion;
import Metodos.ProductoData;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Servicios extends javax.swing.JFrame {
private Conexion con;
    private ServicioData servicioData;
     private ProductoData productoData;
    
    public Servicios() {
        initComponents();
          con = new Conexion(); // Inicializas la conexión
        servicioData = new ServicioData();
         productoData = new ProductoData();
        llenarComboBoxServicio();
        
btnEliminar.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        Servicio servicioSeleccionado = (Servicio) cbxServicio.getSelectedItem();
        if (servicioSeleccionado != null) {
            int confirmacion = JOptionPane.showConfirmDialog(null, 
                "¿Estás seguro de que deseas eliminar a " + servicioSeleccionado.getNombre() + servicioSeleccionado.getIdServicio()+ "?", 
                "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                servicioData.eliminarServicio(servicioSeleccionado.getIdServicio());
                JOptionPane.showMessageDialog(null, "Sucursal eliminada exitosamente.");
                cbxServicio.removeItem(servicioSeleccionado); // Eliminar del ComboBox
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecciona una Sucursal.");
        }
    }
});


btnBuscar.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        realizarBusqueda();
    }
});



//    btnBuscar.addActionListener(new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            String criterioBusqueda = txtBuscar.getText().trim();
//            
//            if (!criterioBusqueda.isEmpty()) {
//                List<ResultadoBusqueda> resultados = productoData.buscarProductoYServicio(criterioBusqueda);
//                mostrarResultadosEnTabla(resultados);
//            } else {
//                JOptionPane.showMessageDialog(null, "Por favor, ingrese un criterio de búsqueda.");
//            }
//        }
//    });
          
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




DefaultTableModel modeloBuscar = new DefaultTableModel(new Object[]{"id","Tipo", "Nombre", "Descripción", "Precio"}, 0) {
    @Override
    public boolean isCellEditable(int row, int column) {
        return false; // Todas las celdas no son editables
      
    }
};
tableServicios.setModel(modeloBuscar);


//mover los datos a los campos

//tableServicios.addMouseListener(new MouseAdapter() {
//    @Override
//    public void mouseClicked(MouseEvent e) {
//        if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 2) {
//            int filaSeleccionada = tableServicios.getSelectedRow();
//            if (filaSeleccionada != -1) {
//                tableServicios.clearSelection(); 
//
//                // Obtener el idServicio correctamente si es un servicio
//                ResultadoBusqueda resultado = (ResultadoBusqueda) tableServicios.getValueAt(filaSeleccionada, 0);
//
//                if ("Servicio".equals(resultado.getTipo())) {
//                    int idServicio = resultado.getIdServicio();
//                    txtID.setText(String.valueOf(idServicio)); 
//                } else {
//                    int idServicio = resultado.getIdServicio();
//                    txtID.setText(String.valueOf(idServicio));
//                }
//
//                // Llenar otros campos de texto
//                txtNombre.setText(resultado.getNombre());
//                txtDetalle.setText(resultado.getDescripcion());
//                txtPrecio.setText(String.valueOf(resultado.getPrecio()));
//            }
//        }
//    }
//});
 tableServicios.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 2) {
            int filaSeleccionada = tableServicios.getSelectedRow();
            if (filaSeleccionada != -1) {
                // Desactiva la edición en el doble clic
                tableServicios.clearSelection(); 

                // Obtener el ID (int) desde la primera columna de la fila seleccionada
                int id = (int) tableServicios.getValueAt(filaSeleccionada, 0);
                
                // Suponiendo que tienes un método en servicioData para obtener el servicio por ID
                Servicio servicio = servicioData.obtenerServicioPorId(id);

                if (servicio != null) {
                    // Llenar los campos de texto con los valores obtenidos
                    txtID.setText(String.valueOf(servicio.getIdServicio()));
                    txtNombre.setText(servicio.getNombre());
                    txtDetalle.setText(servicio.getDescripcion());
                    txtPrecio.setText(String.valueOf(servicio.getPrecio()));
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró el servicio.");
                }
            }
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
        jSeparator1 = new javax.swing.JSeparator();
        txtNombre = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        cbxServicio = new javax.swing.JComboBox<>();
        btnEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txtPrecio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDetalle = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jTextField1 = new javax.swing.JTextField();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        txtID = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
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

        tableServicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jScrollPane1.setViewportView(tableServicios);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 650, 320));

        jLabel2.setText("Servicio");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 40, 100, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 90, 190, 10));

        txtNombre.setBorder(null);
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 60, 190, 30));

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/22/boton-mas.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 260, 60, 50));

        jPanel1.add(cbxServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 320, 190, 30));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/22/basura.png"))); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 390, 70, 50));

        jLabel1.setText("Precio");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 110, -1, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 160, 190, 10));

        txtPrecio.setBorder(null);
        jPanel1.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 130, 190, 30));

        jLabel3.setText("Detalle");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 180, -1, -1));

        txtDetalle.setBorder(null);
        jPanel1.add(txtDetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 200, 190, 30));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 230, 190, 10));

        jTextField1.setBackground(new java.awt.Color(214, 183, 153));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setText("  SERVICIOS");
        jTextField1.setBorder(null);
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 170, 40));
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 280, 40));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/22/lupa (1).png"))); // NOI18N
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, 60, 40));
        jPanel1.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 430, 30, 20));

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/22/garrapata.png"))); // NOI18N
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 260, 50, 50));

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/22/edicion.png"))); // NOI18N
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 260, 60, 50));

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
      
        
    // Recopilar los datos del servicio desde el campo de texto y eliminar espacios en blanco
    String nombre = txtNombre.getText().trim();
    String detalle = txtDetalle.getText().trim();
    double precio = 0.0;
    
    // Validar que los campos no estén vacíos
    if (nombre.isEmpty() || txtPrecio.getText().trim().isEmpty() || detalle.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        // Convertir el texto del campo de precio a un double
        precio = Double.parseDouble(txtPrecio.getText().trim());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Por favor ingresa un precio válido.", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Salir del método si el precio no es válido
    }

    // Crear un objeto Servicio y asignar los valores
    Servicio servicio = new Servicio();
    servicio.setNombre(nombre);
    servicio.setPrecio(precio);
    servicio.setDescripcion(detalle);

    // Llamar al método para agregar el servicio en la base de datos
    servicioData.agregarServicio(servicio);

    // Limpiar los campos de texto después de agregar
    txtNombre.setText("");
    txtPrecio.setText("");
    txtDetalle.setText("");

    JOptionPane.showMessageDialog(this, "Servicio agregado exitosamente.");
    llenarComboBoxServicio();
    
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
         String nombre = txtNombre.getText().trim();
    String descripcion = txtDetalle.getText().trim();
    double precio = 0.0;
    int idServicio = Integer.parseInt(txtID.getText().trim()); // Asegúrate de tener el ID del producto

    // Validar que los campos no estén vacíos
    if (nombre.isEmpty() || txtPrecio.getText().trim().isEmpty() || descripcion.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        // Convertir el texto del campo de precio a un double
        precio = Double.parseDouble(txtPrecio.getText().trim());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Por favor ingresa un precio válido.", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Salir del método si el precio no es válido
    }

    Servicio servicio = new Servicio();
    servicio.setIdServicio(idServicio); // Establece el ID del producto
    servicio.setNombre(nombre);
    servicio.setPrecio(precio);
    servicio.setDescripcion(descripcion);

    // Modificar el producto usando el método en productoData
    boolean resultado = servicioData.modificarServicio(servicio);

    if (resultado) {
        JOptionPane.showMessageDialog(this, "Servicio modificado exitosamente.");
        // Limpiar los campos de texto después de modificar
        txtNombre.setText("");
        txtPrecio.setText("");
        txtDetalle.setText("");
        txtID.setText("");
    } else {
        JOptionPane.showMessageDialog(this, "No se encontró el producto a modificar.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
      limpiarCamposTexto();
      limpiarTabla();
      llenarComboBoxServicio();
    }//GEN-LAST:event_btnActualizarActionPerformed

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
            java.util.logging.Logger.getLogger(Servicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Servicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Servicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Servicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Servicios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<Servicio> cbxServicio;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tableServicios;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDetalle;
    private javax.swing.JLabel txtID;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
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
                Servicio local = (Servicio) value;
                value = local.getNombre();
                
            } else if (value == null) {
                value = ""; // Mostrar una cadena vacía para el elemento vacío
            }
            return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        }
    });
}
//private void realizarBusqueda() {
//    String criterioBusqueda = txtBuscar.getText().trim();
//    
//    if (!criterioBusqueda.isEmpty()) {
//        List<ResultadoBusqueda> resultados = productoData.buscarProductoYServicio(criterioBusqueda);
//        mostrarResultadosEnTabla(resultados);
//    } else {
//        JOptionPane.showMessageDialog(null, "Por favor, ingrese un criterio de búsqueda.");
//    }
//}


//private void mostrarResultadosEnTabla(List<ResultadoBusqueda> resultados) {
//    DefaultTableModel modelo = (DefaultTableModel) tableServicios.getModel();
//    modelo.setRowCount(0);  // Limpiar la tabla antes de mostrar los nuevos resultados
//
//    for (ResultadoBusqueda resultado : resultados) {
//        Object[] fila = {
//            resultado.getIdServicio(),
//            resultado.getTipo(),
//            resultado.getNombre(),
//            resultado.getDescripcion(),
//            resultado.getPrecio()  
//                
//        };
//        modelo.addRow(fila);
//    }
//}

private void mostrarResultadosEnTabla(List<ResultadoBusqueda> resultados) {
    DefaultTableModel modelo = (DefaultTableModel) tableServicios.getModel();
    modelo.setRowCount(0); // Limpiar la tabla antes de llenar con nuevos resultados
    
    for (ResultadoBusqueda resultado : resultados) {
        // Dependiendo si es un producto o servicio, usarás idProducto o idServicio
        int id = resultado.getProducto() != null ? resultado.getIdProducto() : resultado.getIdServicio();

        modelo.addRow(new Object[]{
            id,                        // ID del producto o servicio
            resultado.getNombre(),     // Nombre del producto o servicio
            resultado.getDescripcion(),// Descripción
            resultado.getPrecio()      // Precio
        });
    }
}


private void limpiarCamposTexto() {
    txtID.setText("");
    txtNombre.setText("");
    txtDetalle.setText("");
    txtPrecio.setText("");
}
private void limpiarTabla() {
    DefaultTableModel modelo = (DefaultTableModel) tableServicios.getModel();
    modelo.setRowCount(0); // Establecer la cantidad de filas en 0 para vaciar la tabla
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

}
