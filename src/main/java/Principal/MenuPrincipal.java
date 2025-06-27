package Principal;

import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.Timer;
import rsbuttom.RSButtonMetro;

public class MenuPrincipal extends javax.swing.JFrame {

    int x, y;
    private final Color colorSeleccionado = new Color(239, 238, 244);
    private final Color colorHoverYPress = new Color(204, 204, 204);
    private RSButtonMetro[] botonesMenu;

    public MenuPrincipal() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(this);
        // CambiarPanel
        this.btnComputadoras.setSelected(true);
        new CambiarPanel(pnlPrincipal, new Vista.pnlSesiones());
        // Cambiar Color
        botonesMenu = new RSButtonMetro[]{
            btnConfiguracion,
            btnComputadoras,
            btnSesiones,
            btnConsumo,
            btnFacturacion
        };
        // Colocar Fecha y Hora
        // Formato personalizado
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy  HH:mm:ss");
        // Timer que actualiza el JLabel cada segundo
        Timer timer = new Timer(1000, e -> {
            String fechaHoraActual = LocalDateTime.now().format(formato);
            lblFecha.setText(fechaHoraActual);
        });
        timer.start(); // Iniciar el reloj
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        pnlTop = new javax.swing.JPanel();
        btnMenu = new javax.swing.JToggleButton();
        lblTitulo = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        menuLat = new javax.swing.JPanel();
        btnSesiones = new rsbuttom.RSButtonMetro();
        btnConsumo = new rsbuttom.RSButtonMetro();
        btnFacturacion = new rsbuttom.RSButtonMetro();
        btnComputadoras = new rsbuttom.RSButtonMetro();
        btnConfiguracion = new rsbuttom.RSButtonMetro();
        pnlPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestion Lan Center");
        setBackground(new java.awt.Color(230, 221, 221));
        setPreferredSize(new java.awt.Dimension(960, 650));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1500, 1000));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        pnlTop.setBackground(new java.awt.Color(204, 255, 255));
        pnlTop.setMaximumSize(new java.awt.Dimension(32767, 50));
        pnlTop.setMinimumSize(new java.awt.Dimension(349, 50));
        pnlTop.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlTopMouseDragged(evt);
            }
        });
        pnlTop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlTopMousePressed(evt);
            }
        });
        pnlTop.setLayout(new java.awt.GridLayout(1, 0));

        btnMenu.setBackground(new java.awt.Color(204, 255, 255));
        btnMenu.setForeground(new java.awt.Color(204, 255, 255));
        btnMenu.setIcon(new javax.swing.ImageIcon("I:\\PF_POO\\GestionLanCenter\\src\\Imagenes\\menu.png")); // NOI18N
        btnMenu.setBorder(null);
        btnMenu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        pnlTop.add(btnMenu);

        lblTitulo.setFont(new java.awt.Font("Mongolian Baiti", 3, 36)); // NOI18N
        lblTitulo.setText("Gestion Lan Center");
        pnlTop.add(lblTitulo);

        lblFecha.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblFecha.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pnlTop.add(lblFecha);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.01;
        jPanel1.add(pnlTop, gridBagConstraints);

        menuLat.setBackground(new java.awt.Color(204, 204, 204));
        menuLat.setPreferredSize(new java.awt.Dimension(100, 900));

        btnSesiones.setIcon(new javax.swing.ImageIcon("I:\\PF_POO\\GestionLanCenter\\src\\Imagenes\\Sesiones.png")); // NOI18N
        btnSesiones.setText("Sesiones");
        btnSesiones.setColorBorde(null);
        btnSesiones.setColorNormal(new java.awt.Color(240, 240, 240));
        btnSesiones.setColorTextHover(new java.awt.Color(153, 153, 153));
        btnSesiones.setColorTextNormal(new java.awt.Color(0, 0, 0));
        btnSesiones.setColorTextPressed(new java.awt.Color(153, 153, 153));
        btnSesiones.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnSesiones.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSesiones.setOpaque(false);
        btnSesiones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSesionesMousePressed(evt);
            }
        });
        btnSesiones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSesionesActionPerformed(evt);
            }
        });

        btnConsumo.setIcon(new javax.swing.ImageIcon("I:\\PF_POO\\GestionLanCenter\\src\\Imagenes\\Consumo.png")); // NOI18N
        btnConsumo.setText("Consumo");
        btnConsumo.setColorBorde(null);
        btnConsumo.setColorNormal(new java.awt.Color(240, 240, 240));
        btnConsumo.setColorTextHover(new java.awt.Color(153, 153, 153));
        btnConsumo.setColorTextNormal(new java.awt.Color(0, 0, 0));
        btnConsumo.setColorTextPressed(new java.awt.Color(153, 153, 153));
        btnConsumo.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnConsumo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnConsumo.setOpaque(false);
        btnConsumo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnConsumoMousePressed(evt);
            }
        });
        btnConsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsumoActionPerformed(evt);
            }
        });

        btnFacturacion.setIcon(new javax.swing.ImageIcon("I:\\PF_POO\\GestionLanCenter\\src\\Imagenes\\Factura.png")); // NOI18N
        btnFacturacion.setText("Facturacion");
        btnFacturacion.setColorBorde(null);
        btnFacturacion.setColorNormal(new java.awt.Color(240, 240, 240));
        btnFacturacion.setColorTextHover(new java.awt.Color(153, 153, 153));
        btnFacturacion.setColorTextNormal(new java.awt.Color(0, 0, 0));
        btnFacturacion.setColorTextPressed(new java.awt.Color(153, 153, 153));
        btnFacturacion.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnFacturacion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnFacturacion.setOpaque(false);
        btnFacturacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnFacturacionMousePressed(evt);
            }
        });
        btnFacturacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturacionActionPerformed(evt);
            }
        });

        btnComputadoras.setIcon(new javax.swing.ImageIcon("I:\\PF_POO\\GestionLanCenter\\src\\Imagenes\\Computadoras.png")); // NOI18N
        btnComputadoras.setText("Computadoras");
        btnComputadoras.setColorBorde(null);
        btnComputadoras.setColorNormal(new java.awt.Color(240, 240, 240));
        btnComputadoras.setColorTextHover(new java.awt.Color(153, 153, 153));
        btnComputadoras.setColorTextNormal(new java.awt.Color(0, 0, 0));
        btnComputadoras.setColorTextPressed(new java.awt.Color(153, 153, 153));
        btnComputadoras.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnComputadoras.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnComputadoras.setOpaque(false);
        btnComputadoras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnComputadorasMousePressed(evt);
            }
        });
        btnComputadoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComputadorasActionPerformed(evt);
            }
        });

        btnConfiguracion.setIcon(new javax.swing.ImageIcon("I:\\PF_POO\\GestionLanCenter\\src\\Imagenes\\Configuracion.png")); // NOI18N
        btnConfiguracion.setText("Configuracion");
        btnConfiguracion.setColorBorde(null);
        btnConfiguracion.setColorNormal(new java.awt.Color(240, 240, 240));
        btnConfiguracion.setColorTextHover(new java.awt.Color(153, 153, 153));
        btnConfiguracion.setColorTextNormal(new java.awt.Color(0, 0, 0));
        btnConfiguracion.setColorTextPressed(new java.awt.Color(153, 153, 153));
        btnConfiguracion.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnConfiguracion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnConfiguracion.setOpaque(false);
        btnConfiguracion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnConfiguracionMousePressed(evt);
            }
        });
        btnConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfiguracionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuLatLayout = new javax.swing.GroupLayout(menuLat);
        menuLat.setLayout(menuLatLayout);
        menuLatLayout.setHorizontalGroup(
            menuLatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuLatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuLatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuLatLayout.createSequentialGroup()
                            .addComponent(btnFacturacion, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27))
                        .addComponent(btnComputadoras, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuLatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnSesiones, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnConfiguracion, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 34, Short.MAX_VALUE))
        );
        menuLatLayout.setVerticalGroup(
            menuLatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLatLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(btnSesiones, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(btnFacturacion, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnComputadoras, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(btnConfiguracion, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(menuLat, gridBagConstraints);

        pnlPrincipal.setLayout(new java.awt.GridLayout(1, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(pnlPrincipal, gridBagConstraints);

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
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        // TODO add your handling code here:
        int posicion = menuLat.getX();
        if (posicion > -1) {
            Animacion.Animacion.mover_izquierda(0, -264, 2, 2, menuLat);
        } else {
            Animacion.Animacion.mover_derecha(-264, 0, 2, 2, menuLat);
        }
    }//GEN-LAST:event_btnMenuActionPerformed

    private void pnlTopMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTopMouseDragged
        // TODO add your handling code here:
        Point mueve = MouseInfo.getPointerInfo().getLocation();
        this.setLocation(mueve.x - x, mueve.y - y);
    }//GEN-LAST:event_pnlTopMouseDragged

    private void pnlTopMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTopMousePressed
        // TODO add your handling code here:
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_pnlTopMousePressed

    private void btnConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfiguracionActionPerformed
        // TODO add your handling code here:
        new CambiarPanel(pnlPrincipal, new Vista.pnlConfiguracion());
        if (btnConfiguracion.isSelected()) {
            for (RSButtonMetro btn : botonesMenu) {
                if (btn == btnConfiguracion) {
                    btn.setColorNormal(colorSeleccionado);
                } else {
                    btn.setColorNormal(colorHoverYPress);
                }
                btn.setColorHover(colorHoverYPress);
                btn.setColorPressed(colorHoverYPress);
            }
        } else {
            btnConfiguracion.setColorNormal(colorSeleccionado);
            btnConfiguracion.setColorHover(colorHoverYPress);
            btnConfiguracion.setColorPressed(colorHoverYPress);
        }
    }//GEN-LAST:event_btnConfiguracionActionPerformed

    private void btnConfiguracionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfiguracionMousePressed
        // TODO add your handling code here:
        this.btnComputadoras.setSelected(false);
        this.btnSesiones.setSelected(false);
        this.btnConsumo.setSelected(false);
        this.btnFacturacion.setSelected(false);
        this.btnConfiguracion.setSelected(true);
    }//GEN-LAST:event_btnConfiguracionMousePressed

    private void btnComputadorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComputadorasActionPerformed
        // TODO add your handling code here:
        new CambiarPanel(pnlPrincipal, new Vista.pnlComputadoras());
        if (btnComputadoras.isSelected()) {
            for (RSButtonMetro btn : botonesMenu) {
                if (btn == btnComputadoras) {
                    btn.setColorNormal(colorSeleccionado);
                } else {
                    btn.setColorNormal(colorHoverYPress);
                }
                btn.setColorHover(colorHoverYPress);
                btn.setColorPressed(colorHoverYPress);
            }
        } else {
            btnComputadoras.setColorNormal(colorSeleccionado);
            btnComputadoras.setColorHover(colorHoverYPress);
            btnComputadoras.setColorPressed(colorHoverYPress);
        }
    }//GEN-LAST:event_btnComputadorasActionPerformed

    private void btnComputadorasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnComputadorasMousePressed
        // TODO add your handling code here:
        this.btnComputadoras.setSelected(true);
        this.btnSesiones.setSelected(false);
        this.btnConsumo.setSelected(false);
        this.btnFacturacion.setSelected(false);
        this.btnConfiguracion.setSelected(false);
    }//GEN-LAST:event_btnComputadorasMousePressed

    private void btnFacturacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturacionActionPerformed
        // TODO add your handling code here:
        new CambiarPanel(pnlPrincipal, new Vista.pnlFacturacion());
        if (btnFacturacion.isSelected()) {
            for (RSButtonMetro btn : botonesMenu) {
                if (btn == btnFacturacion) {
                    btn.setColorNormal(colorSeleccionado);
                } else {
                    btn.setColorNormal(colorHoverYPress);
                }
                btn.setColorHover(colorHoverYPress);
                btn.setColorPressed(colorHoverYPress);
            }
        } else {
            btnFacturacion.setColorNormal(colorSeleccionado);
            btnFacturacion.setColorHover(colorHoverYPress);
            btnFacturacion.setColorPressed(colorHoverYPress);
        }
    }//GEN-LAST:event_btnFacturacionActionPerformed

    private void btnFacturacionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFacturacionMousePressed
        // TODO add your handling code here:
        this.btnComputadoras.setSelected(false);
        this.btnSesiones.setSelected(false);
        this.btnConsumo.setSelected(false);
        this.btnFacturacion.setSelected(true);
        this.btnConfiguracion.setSelected(false);
    }//GEN-LAST:event_btnFacturacionMousePressed

    private void btnConsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsumoActionPerformed
        // TODO add your handling code here:
        btnConsumo.setBorder(new EmptyBorder(10, 0, 10, 0));
        new CambiarPanel(pnlPrincipal, new Vista.pnlConsumo());
        if (btnConsumo.isSelected()) {
            for (RSButtonMetro btn : botonesMenu) {
                if (btn == btnConsumo) {
                    btn.setColorNormal(colorSeleccionado);
                } else {
                    btn.setColorNormal(colorHoverYPress);
                }
                btn.setColorHover(colorHoverYPress);
                btn.setColorPressed(colorHoverYPress);
            }
        } else {
            btnConsumo.setColorNormal(colorSeleccionado);
            btnConsumo.setColorHover(colorHoverYPress);
            btnConsumo.setColorPressed(colorHoverYPress);
        }
    }//GEN-LAST:event_btnConsumoActionPerformed

    private void btnConsumoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsumoMousePressed
        // TODO add your handling code here:
        this.btnComputadoras.setSelected(false);
        this.btnSesiones.setSelected(false);
        this.btnConsumo.setSelected(true);
        this.btnFacturacion.setSelected(false);
        this.btnConfiguracion.setSelected(false);
    }//GEN-LAST:event_btnConsumoMousePressed

    private void btnSesionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSesionesActionPerformed
        // TODO add your handling code here:
        new CambiarPanel(pnlPrincipal, new Vista.pnlSesiones());
        if (btnSesiones.isSelected()) {
            for (RSButtonMetro btn : botonesMenu) {
                if (btn == btnSesiones) {
                    btn.setColorNormal(colorSeleccionado);
                } else {
                    btn.setColorNormal(colorHoverYPress);
                }
                btn.setColorHover(colorHoverYPress);
                btn.setColorPressed(colorHoverYPress);
            }
        } else {
            btnSesiones.setColorNormal(colorSeleccionado);
            btnSesiones.setColorHover(colorHoverYPress);
            btnSesiones.setColorPressed(colorHoverYPress);
        }
    }//GEN-LAST:event_btnSesionesActionPerformed

    private void btnSesionesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSesionesMousePressed
        // TODO add your handling code here:
        this.btnComputadoras.setSelected(false);
        this.btnSesiones.setSelected(true);
        this.btnConsumo.setSelected(false);
        this.btnFacturacion.setSelected(false);
        this.btnConfiguracion.setSelected(false);
    }//GEN-LAST:event_btnSesionesMousePressed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    new MenuPrincipal().setVisible(true);
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rsbuttom.RSButtonMetro btnComputadoras;
    private rsbuttom.RSButtonMetro btnConfiguracion;
    private rsbuttom.RSButtonMetro btnConsumo;
    private rsbuttom.RSButtonMetro btnFacturacion;
    private javax.swing.JToggleButton btnMenu;
    private rsbuttom.RSButtonMetro btnSesiones;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel menuLat;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPanel pnlTop;
    // End of variables declaration//GEN-END:variables
}
