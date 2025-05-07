
package Vistas;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.Box;
import javax.swing.JMenuBar;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;


public class Secundario extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Secundario() {
         // Configuración de los colores de selección en el menú
        UIManager.put("Menu.selectionBackground", new ColorUIResource(150, 0, 0)); // Fondo rojo oscuro
        UIManager.put("Menu.selectionForeground", new ColorUIResource(255, 255, 255)); // Texto blanco
        UIManager.put("MenuItem.selectionBackground", new ColorUIResource(45, 45, 45)); // Fondo rojo oscuro en items
        UIManager.put("MenuItem.selectionForeground", new ColorUIResource(255, 255, 255)); // Texto blanco en items

        // Inicialización de componentes
        initComponents();

        // Configuración del JMenuBar con fondo degradado
        menuPrincipal = new JMenuBar() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                int width = getWidth();
                int height = getHeight();

                // Crear un degradado de marrón claro a marrón oscuro
                Color color1 = new Color(150, 75, 0);  // Marrón claro
                Color color2 = new Color(90, 45, 0);   // Marrón oscuro
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, height, color2);

                g2d.setPaint(gp);
                g2d.fillRect(0, 0, width, height);
            }
        };
        
         // Ajustar la altura del JMenuBar
        menuPrincipal.setPreferredSize(new java.awt.Dimension(getWidth(), 50)); // Establece la altura a 70 píxeles
        menuPrincipal.setMinimumSize(new java.awt.Dimension(getWidth(), 50));
        menuPrincipal.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 50));
         // Asigna el JMenuBar personalizado
        setJMenuBar(menuPrincipal);

        // Añade un espacio flexible para empujar los menús a la derecha
        menuPrincipal.add(Box.createHorizontalGlue());

       

        // Agrega los menús después de configurar el JMenuBar personalizado
        menuPrincipal.add(jMenu1);  
        menuPrincipal.add(jMenu7);
       
        menuPrincipal.add(jMenu4);        
        menuPrincipal.add(jMenu6);
      
     

        // Configurar el color de los textos de los menús si es necesario
        jMenu1.setForeground(new Color(255, 255, 255)); // Texto blanco en el primer menú
        jMenu7.setForeground(new Color(255, 255, 255)); // Texto blanco en el primer menú
      
        jMenu4.setForeground(new Color(255, 255, 255)); // Texto blanco en el segundo menú
        
        jMenu6.setForeground(new Color(255, 255, 255)); // Texto blanco en el segundo menú
       
        // Repite para los demás menús si es necesario
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();
        menuPrincipal = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/32/boton.png"))); // NOI18N
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 410, 110, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondos/barbershop-men-hairdresser-rusty-plate-vector.jpg"))); // NOI18N
        jPanel1.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 510));

        menuPrincipal.setForeground(new java.awt.Color(107, 62, 19));
        menuPrincipal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        menuPrincipal.setMargin(new java.awt.Insets(0, 250, 0, 20));
        menuPrincipal.setMinimumSize(new java.awt.Dimension(70, 53));
        menuPrincipal.setPreferredSize(new java.awt.Dimension(70, 53));

        jMenu1.setForeground(new java.awt.Color(107, 62, 19));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/22/cronograma.png"))); // NOI18N
        jMenu1.setText("Agenda");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenu1.setMargin(new java.awt.Insets(3, 20, 3, 6));
        jMenu1.setMinimumSize(new java.awt.Dimension(110, 38));
        jMenu1.setPreferredSize(new java.awt.Dimension(110, 38));
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/22/peluqueria.png"))); // NOI18N
        jMenuItem1.setText("Turnos");
        jMenuItem1.setPreferredSize(new java.awt.Dimension(146, 38));
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        menuPrincipal.add(jMenu1);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/22/maquinilla-de-afeitar (1).png"))); // NOI18N
        jMenu7.setText("Caja");
        jMenu7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenu7.setMaximumSize(new java.awt.Dimension(100, 32767));
        jMenu7.setMinimumSize(new java.awt.Dimension(100, 28));
        jMenu7.setPreferredSize(new java.awt.Dimension(70, 28));

        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/22/monedas.png"))); // NOI18N
        jMenuItem11.setText("Cajas");
        jMenuItem11.setPreferredSize(new java.awt.Dimension(106, 38));
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem11);

        menuPrincipal.add(jMenu7);

        jMenu4.setForeground(new java.awt.Color(107, 62, 19));
        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/22/carretilla.png"))); // NOI18N
        jMenu4.setText("Ventas");
        jMenu4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenu4.setMargin(new java.awt.Insets(3, 20, 3, 6));
        jMenu4.setMinimumSize(new java.awt.Dimension(100, 28));
        jMenu4.setPreferredSize(new java.awt.Dimension(100, 28));
        jMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu4ActionPerformed(evt);
            }
        });
        jMenu4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMenu4KeyPressed(evt);
            }
        });

        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/22/carretilla.png"))); // NOI18N
        jMenuItem10.setText("Realizar una Venta");
        jMenuItem10.setPreferredSize(new java.awt.Dimension(165, 38));
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem10);

        menuPrincipal.add(jMenu4);

        jMenu6.setForeground(new java.awt.Color(107, 62, 19));
        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/22/foto.png"))); // NOI18N
        jMenu6.setText("Clientes");
        jMenu6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenu6.setMargin(new java.awt.Insets(3, 20, 3, 6));

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/22/agregar-contacto.png"))); // NOI18N
        jMenuItem7.setText("Nuevo Cliente");
        jMenuItem7.setPreferredSize(new java.awt.Dimension(146, 38));
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem7);

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/22/pagar.png"))); // NOI18N
        jMenuItem8.setText("Cuenta Corriente");
        jMenuItem8.setPreferredSize(new java.awt.Dimension(146, 38));
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem8);

        menuPrincipal.add(jMenu6);

        setJMenuBar(menuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1024, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
      dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
     
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
      Clientes clie = new Clientes();
              clie.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       Turno tur = new Turno();
        tur.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu4ActionPerformed
       
    }//GEN-LAST:event_jMenu4ActionPerformed

    private void jMenu4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu4KeyPressed
        
    }//GEN-LAST:event_jMenu4KeyPressed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        NuevaVenta vta = new NuevaVenta();
      vta.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
AbrirCaja ac = new AbrirCaja();
ac.setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
       CueCorriente cc = new CueCorriente();
cc.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

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
            java.util.logging.Logger.getLogger(Secundario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Secundario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Secundario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Secundario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Secundario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel fondo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuBar menuPrincipal;
    // End of variables declaration//GEN-END:variables
}
