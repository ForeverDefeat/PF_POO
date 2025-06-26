
package Componentes;

import Modelo.Computadora;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelComputadora extends JPanel{
    public PanelComputadora(Computadora pc) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(120, 150));
        setBackground(Color.DARK_GRAY);

        String iconPath = pc.getEstado().equals("OCUPADA") ? "img/pc_roja.png" : "img/pc_verde.png";
        JLabel icono = new JLabel(new ImageIcon(iconPath));
        JLabel nombre = new JLabel("PC " + pc.getNumero());
        JLabel tiempo = new JLabel("00:15");

        add(icono);
        add(nombre);
        add(tiempo);
    }
}
