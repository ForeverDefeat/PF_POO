package Vista;

import Logica.SesionServicio;
import Modelo.Computadora;
import DAO.ComputadoraDAO;
import DAO.SesionDAO;
import Modelo.Sesion;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
//import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class pnlSesiones extends javax.swing.JPanel {

    private DefaultTableModel modeloSesiones;
    private Timer timer;

    public pnlSesiones() {
        initComponents();
        cargarSesionesDesdeBD();
        cargarComputadorasEnCombo();
        timer = new Timer(1000, e -> {
            for (int i = 0; i < modeloSesiones.getRowCount(); i++) {
                Timestamp inicio = (Timestamp) modeloSesiones.getValueAt(i, 1); // columna horaInicio
                long minutos = Duration.between(inicio.toInstant(), Instant.now()).toMinutes();
                long segundos = Duration.between(inicio.toInstant(), Instant.now()).toSeconds() % 60;

                String tiempo = String.format("%02d:%02d", minutos, segundos);
                modeloSesiones.setValueAt(tiempo, i, 2); // columna tiempoTranscurrido
            }
        });
        timer.start();
    }

    private void cargarSesionesDesdeBD() {
        String[] columnas = {"Número PC", "Hora Inicio", "Tiempo Transcurrido", "Estado"};
        modeloSesiones = new DefaultTableModel(columnas, 0);
        tblSesiones.setModel(modeloSesiones);

        List<Computadora> pcs = ComputadoraDAO.obtenerTodas();

        for (Computadora pc : pcs) {
            Sesion sesionActiva = SesionDAO.obtenerSesionActiva(pc.getId());

            String horaInicio = (sesionActiva != null) ? sesionActiva.getHoraInicio().toLocalDateTime().toString() : "--:--";
            String tiempo = (sesionActiva != null)
                    ? calcularTiempoTranscurrido(sesionActiva.getHoraInicio(), sesionActiva.getHoraFin())
                    : "--:--";

            modeloSesiones.addRow(new Object[]{
                pc.getNumero(), horaInicio, tiempo, pc.getEstado()
            });
        }
    }

    private String calcularTiempoTranscurrido(Timestamp inicio, Timestamp fin) {
        if (inicio == null) {
            return "--:--";
        }
        Instant finInstant = (fin != null) ? fin.toInstant() : Instant.now();
        Duration duracion = Duration.between(inicio.toInstant(), finInstant);
        long minutos = duracion.toMinutes();
        long segundos = duracion.minusMinutes(minutos).getSeconds();
        return String.format("%02d:%02d", minutos, segundos);
    }

    private void cargarComputadorasEnCombo() {
        cmbComputadora.removeAllItems(); // Limpiar combo
        List<Computadora> lista = ComputadoraDAO.obtenerTodas();
        for (Computadora pc : lista) {
            cmbComputadora.addItem(pc.getNumero());
        }
    }

    private void actualizarTablaSesiones() {
        List<Sesion> sesiones = SesionDAO.obtenerTodas();

        modeloSesiones.setRowCount(0); // limpiar tabla

        for (Sesion s : sesiones) {
            String numeroPC = ComputadoraDAO.obtenerNumeroPorId(s.getIdComputadora());
            String estado = s.getEstado();
            String tiempo = calcularTiempoTranscurrido(s.getHoraInicio(), s.getHoraFin());

            modeloSesiones.addRow(new Object[]{
                numeroPC,
                s.getHoraInicio(),
                tiempo,
                estado
            });
        }

        tblSesiones.clearSelection();
        modeloSesiones.fireTableDataChanged();
        tblSesiones.revalidate();
        tblSesiones.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        btnIniciarSesion = new javax.swing.JButton();
        btnFinalizarSesion = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSesiones = new javax.swing.JTable();
        cmbComputadora = new javax.swing.JComboBox<>();

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        setLayout(new java.awt.GridBagLayout());

        btnIniciarSesion.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnIniciarSesion.setText("Iniciar Sesion");
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 5);
        add(btnIniciarSesion, gridBagConstraints);

        btnFinalizarSesion.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnFinalizarSesion.setText("Finalizar Sesion");
        btnFinalizarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarSesionActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 10, 10);
        add(btnFinalizarSesion, gridBagConstraints);

        tblSesiones.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tblSesiones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Numero PC", "Hora Inicio", "Tiempo", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblSesiones);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        add(jScrollPane1, gridBagConstraints);

        cmbComputadora.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cmbComputadora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbComputadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbComputadoraActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 10, 10);
        add(cmbComputadora, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinalizarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarSesionActionPerformed
        // TODO add your handling code here:
        String numeroSeleccionado = (String) cmbComputadora.getSelectedItem();
        if (numeroSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Seleccione una computadora.");
            return;
        }

        int id = ComputadoraDAO.obtenerIdPorNumero(numeroSeleccionado);
        boolean ok = new SesionServicio().finalizarSesion(id);

        if (ok) {
            JOptionPane.showMessageDialog(this, "Sesión finalizada.");
            actualizarTablaSesiones();
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo finalizar la sesión.");
        }
    }//GEN-LAST:event_btnFinalizarSesionActionPerformed

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        // TODO add your handling code here:
        String numeroSeleccionado = (String) cmbComputadora.getSelectedItem();
        if (numeroSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Seleccione una computadora.");
            return;
        }

        int id = ComputadoraDAO.obtenerIdPorNumero(numeroSeleccionado);
        boolean ok = new SesionServicio().iniciarSesion(id);

        if (ok) {
            JOptionPane.showMessageDialog(this, "Sesión iniciada.");
            actualizarTablaSesiones();
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo iniciar la sesión.");
        }
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void cmbComputadoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbComputadoraActionPerformed
        // TODO add your handling code here:
        cmbComputadora.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String numeroSeleccionado = (String) cmbComputadora.getSelectedItem();

                    for (int i = 0; i < tblSesiones.getRowCount(); i++) {
                        String numeroTabla = tblSesiones.getValueAt(i, 0).toString();
                        if (numeroTabla.equalsIgnoreCase(numeroSeleccionado)) {
                            tblSesiones.setRowSelectionInterval(i, i); // selecciona esa fila
                            break;
                        }
                    }
                }
            }
        });
    }//GEN-LAST:event_cmbComputadoraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinalizarSesion;
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JComboBox<String> cmbComputadora;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSesiones;
    // End of variables declaration//GEN-END:variables
}
