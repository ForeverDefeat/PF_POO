package Componentes;

import javax.swing.*;
import java.awt.*;
import Modelo.Computadora;
import java.net.URL;

public class PanelComputadora extends JPanel {

    private JLabel icono;
    private JLabel etiquetaNumero;
    private JLabel etiquetaTiempo;

    public PanelComputadora(Computadora pc) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        setPreferredSize(new Dimension(120, 150));
        setBackground(Color.DARK_GRAY);

        // Cargar icono dependiendo del estado
        String rutaIcono = pc.getEstado().equalsIgnoreCase("OCUPADA")
                ? "/Images/ComputadoraOcupada.png"
                : "/Images/ComputadoraLibre.png";
        // Cargar imagen desde classpath
        URL ruta = getClass().getResource(rutaIcono);
        if (ruta != null) {
            ImageIcon iconoImg = new ImageIcon(ruta);
            icono = new JLabel(iconoImg);
        } else {
            System.out.println("Imagen no encontrada en: " + rutaIcono);
            icono = new JLabel("Sin imagen");
        }

        etiquetaNumero = new JLabel("PC " + pc.getNumero());
        etiquetaNumero.setForeground(Color.WHITE);
        etiquetaNumero.setAlignmentX(CENTER_ALIGNMENT);

        etiquetaTiempo = new JLabel("--:--");
        etiquetaTiempo.setForeground(Color.LIGHT_GRAY);
        etiquetaTiempo.setAlignmentX(CENTER_ALIGNMENT);

        add(Box.createVerticalStrut(10));
        add(icono);
        add(Box.createVerticalStrut(5));
        add(etiquetaNumero);
        add(Box.createVerticalStrut(5));
        add(etiquetaTiempo);
    }

    public void actualizarEstado(boolean ocupada, String tiempo) {
        String rutaIcono = ocupada
                ? "/Images/ComputadoraOcupada.png"
                : "/Images/ComputadoraLibre.png";

        URL ruta = getClass().getResource(rutaIcono);
        if (ruta != null) {
            icono.setIcon(new ImageIcon(ruta));
        }

        etiquetaTiempo.setText(tiempo);
    }
}
