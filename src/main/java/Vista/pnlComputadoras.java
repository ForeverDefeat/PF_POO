package Vista;

import Componentes.PanelComputadora;
import DAO.ComputadoraDAO;
import DAO.SesionDAO;
import Modelo.Computadora;
import Modelo.Sesion;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;

public class pnlComputadoras extends javax.swing.JPanel {

    private List<PanelComputadora> tarjetas = new ArrayList<>();

    public pnlComputadoras() {
        initComponents();

        List<Computadora> pcs = ComputadoraDAO.obtenerTodas();
        for (Computadora pc : pcs) {
            PanelComputadora tarjeta = new PanelComputadora(pc);
            tarjetas.add(tarjeta);
            JPanelContenedorPCs.add(tarjeta);
        }

        Timer refresco = new Timer(5000, e -> actualizarTarjetas());
        refresco.start();
    }

    private void actualizarComputadoras() {
        JPanelContenedorPCs.removeAll(); // Limpiar tarjetas anteriores

        List<Computadora> pcs = ComputadoraDAO.obtenerTodas();
        for (Computadora pc : pcs) {
            PanelComputadora tarjeta = new PanelComputadora(pc);
            JPanelContenedorPCs.add(tarjeta);
        }

        JPanelContenedorPCs.revalidate();
        JPanelContenedorPCs.repaint();
    }

    private void actualizarTarjetas() {
        List<Computadora> pcs = ComputadoraDAO.obtenerTodas();
        for (int i = 0; i < pcs.size(); i++) {
            Computadora pc = pcs.get(i);
            PanelComputadora tarjeta = tarjetas.get(i);

            boolean ocupada = pc.getEstado().equalsIgnoreCase("OCUPADA");
            String tiempo = obtenerTiempoUso(pc.getId()); // Método que debes implementar
            tarjeta.actualizarEstado(ocupada, tiempo);
        }
    }

    private String obtenerTiempoUso(int idComputadora) {
        Sesion sesion = SesionDAO.obtenerSesionActiva(idComputadora);
        if (sesion != null && sesion.getHoraInicio() != null) {
            long minutos = Duration.between(sesion.getHoraInicio().toInstant(), Instant.now()).toMinutes();
            long segundos = Duration.between(sesion.getHoraInicio().toInstant(), Instant.now()).getSeconds() % 60;
            return String.format("%02d:%02d", minutos, segundos);
        }
        return "--:--";
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanelContenedorPCs = new javax.swing.JPanel();

        JPanelContenedorPCs.setLayout(new java.awt.GridLayout(4, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(JPanelContenedorPCs, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(JPanelContenedorPCs, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanelContenedorPCs;
    // End of variables declaration//GEN-END:variables
}
