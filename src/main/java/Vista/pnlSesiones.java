package Vista;

import Logica.SesionServicio;
import Modelo.Computadora;
import DAO.ComputadoraDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Timer;

public class pnlSesiones extends javax.swing.JPanel {

    private SesionServicio sesionServicio = new SesionServicio();
    private Timer timer;
    private int idComputadoraSeleccionada = -1;
    private long tiempoInicioMillis;

    public pnlSesiones() {
        initComponents();
        cargarComputadoras();
        cargarComputadorasEnCombo();
    }

    private void cargarComputadoras() {
        List<Computadora> pcs = ComputadoraDAO.obtenerTodas();
        cmbComputadoras.removeAllItems();
        for (Computadora pc : pcs) {
            cmbComputadoras.addItem("PC " + pc.getNumero() + " (ID: " + pc.getId() + ")");
        }
    }

    private void cargarComputadorasEnCombo() {
        cmbComputadoras.removeAllItems(); // Limpia primero

        List<Computadora> pcs = ComputadoraDAO.obtenerTodas();

        for (Computadora pc : pcs) {
            String texto = "PC " + pc.getNumero() + " - " + pc.getEstado();
            cmbComputadoras.addItem(texto);
        }
    }

    private void iniciarContador() {
        tiempoInicioMillis = System.currentTimeMillis(); // guarda la hora actual

        if (timer != null) {
            timer.stop(); // evita múltiples timers
        }

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long ahora = System.currentTimeMillis();
                long segundos = (ahora - tiempoInicioMillis) / 1000;
                long minutos = segundos / 60;
                long segundosRestantes = segundos % 60;
                lblTiempoUso.setText(String.format("%02d:%02d", minutos, segundosRestantes));
            }
        });

        timer.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        cmbComputadoras = new javax.swing.JComboBox<>();
        btnIniciarSesion = new javax.swing.JButton();
        btnFinalizarSesion = new javax.swing.JButton();
        lblEstado = new javax.swing.JLabel();
        lblTiempoUso = new javax.swing.JLabel();
        lblComputadora = new javax.swing.JLabel();
        lblTiempoLabel = new javax.swing.JLabel();
        lblEstadoLabel = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        setLayout(new java.awt.GridBagLayout());

        cmbComputadoras.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(106, 26, 0, 209);
        add(cmbComputadoras, gridBagConstraints);

        btnIniciarSesion.setText("Iniciar");
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(106, 18, 503, 0);
        add(btnIniciarSesion, gridBagConstraints);

        btnFinalizarSesion.setText("Finalizar");
        btnFinalizarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarSesionActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(106, 187, 503, 0);
        add(btnFinalizarSesion, gridBagConstraints);

        lblEstado.setText("Estado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(109, 215, 0, 0);
        add(lblEstado, gridBagConstraints);

        lblTiempoUso.setText("Tiempo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(109, 71, 0, 0);
        add(lblTiempoUso, gridBagConstraints);

        lblComputadora.setText("lblComputadoras");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(lblComputadora, gridBagConstraints);

        lblTiempoLabel.setText("TiempoLabel");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(lblTiempoLabel, gridBagConstraints);

        lblEstadoLabel.setText("EstadoLabel");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(lblEstadoLabel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinalizarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarSesionActionPerformed
        // TODO add your handling code here:
        if (idComputadoraSeleccionada != -1) {
            boolean ok = sesionServicio.finalizarSesion(idComputadoraSeleccionada);
            if (ok) {
                lblEstado.setText("Libre");
                lblTiempoUso.setText("--:--");
                if (timer != null) {
                    timer.stop();
                }
            }
        }
    }//GEN-LAST:event_btnFinalizarSesionActionPerformed

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        // TODO add your handling code here:
        int index = cmbComputadoras.getSelectedIndex();
        if (index != -1) {
            Computadora pc = ComputadoraDAO.obtenerTodas().get(index);
            idComputadoraSeleccionada = pc.getId();

            boolean ok = sesionServicio.iniciarSesion(idComputadoraSeleccionada);
            if (ok) {
                lblEstado.setText("Ocupada");
                iniciarContador();
            }
        }
    }//GEN-LAST:event_btnIniciarSesionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinalizarSesion;
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JComboBox<String> cmbComputadoras;
    private javax.swing.JLabel lblComputadora;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblEstadoLabel;
    private javax.swing.JLabel lblTiempoLabel;
    private javax.swing.JLabel lblTiempoUso;
    // End of variables declaration//GEN-END:variables
}
