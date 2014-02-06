/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.CheckboxGroup;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Sonja
 */
public class HakemisenKuuntelija implements ActionListener {

    JButton haku;

    public HakemisenKuuntelija(JButton haku) {
        this.haku = haku;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame newFrame = new JFrame("Haku");
        newFrame.setPreferredSize(new Dimension(700, 500));
        newFrame.pack();
        newFrame.setVisible(true);
        luoHaku(newFrame.getContentPane());

    }

    public void luoHaku(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);

        JLabel hakusanaTeksti = new JLabel("Hakusana:");
        JTextField hakusanaKentta = new JTextField();
        JLabel tyhjaLoppuun = new JLabel("<html><br></html>");

        ButtonGroup boxGroup = new ButtonGroup();
        JRadioButton hakuNimella = new JRadioButton("Nimi");
        JRadioButton hakuMaalla = new JRadioButton("Maa");
        JRadioButton hakuTyypila = new JRadioButton("Tyyppi");
        boxGroup.add(hakuNimella);
        boxGroup.add(hakuMaalla);
        boxGroup.add(hakuTyypila);

        JButton hakuNappi = new JButton("Hae!");

        container.add(hakusanaTeksti);
        container.add(hakusanaKentta);
        container.add(hakuNimella);
        container.add(hakuMaalla);
        container.add(hakuTyypila);
        container.add(hakuNappi);
        container.add(tyhjaLoppuun);
    }
}
