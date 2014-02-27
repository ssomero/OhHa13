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
import muistio.tiedosto.TiedostoWelho;

/**
 *
 * @author Sonja
 */
public class HakemisenKuuntelija implements ActionListener {

    private JButton haku;
    private TiedostoWelho tw;

    public HakemisenKuuntelija(TiedostoWelho tw, JButton haku) {
        this.tw = tw;
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
        JRadioButton hakuNimella = new JRadioButton("Nimi", true);
        JRadioButton hakuMaalla = new JRadioButton("Maa");
        JRadioButton hakuValkkarit = new JRadioButton("Hae kaikki valkoviinit");
        JRadioButton hakuPunkut = new JRadioButton("Hae kaikki punaviinit");
        boxGroup.add(hakuNimella);
        boxGroup.add(hakuMaalla);
        boxGroup.add(hakuValkkarit);
        boxGroup.add(hakuPunkut);

        JButton hakuNappi = new JButton("Hae!");
        TiedostoWelhonHakuKuuntelija kuuntelija = new TiedostoWelhonHakuKuuntelija(tw, boxGroup, hakusanaKentta);
        hakuNappi.addActionListener(kuuntelija);

        container.add(hakusanaTeksti);
        container.add(hakusanaKentta);
        container.add(hakuNimella);
        container.add(hakuMaalla);
        container.add(hakuValkkarit);
        container.add(hakuPunkut);
        container.add(hakuNappi);
        container.add(tyhjaLoppuun);
    }
}
