package Componentes;

import Modelo.Computadora;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelComputadora extends JPanel {

    public PanelComputadora(Computadora pc) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(120, 150));

        JLabel icono = new JLabel(new ImageIcon("imagenes/home.png")); // o rojo si ocupada
        JLabel etiquetaNumero = new JLabel("PC " + pc.getNumero());
        JLabel etiquetaTiempo = new JLabel("00:15"); // temporal

        add(icono);
        add(etiquetaNumero);
        add(etiquetaTiempo);
    }
}
