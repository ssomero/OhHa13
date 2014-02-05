/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import muistio.tiedosto.TiedostoWelho;
import muistio.viinimuistio.Viini;
import muistio.viinimuistio.ViiniKellari;

/**
 *
 * @author Sonja
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private TiedostoWelho tw;
    private ViiniKellari kellari;

    public Kayttoliittyma(TiedostoWelho tw) throws Exception {
        this.tw = tw;
        this.kellari = tw.lueViinit();
    }

    @Override
    public void run() {
        frame = new JFrame("Viinimuistio");
        frame.setPreferredSize(new Dimension(600, 700));



        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        JLabel tervetuloa = new JLabel("<html>Tervetuloa viinimuistioon!<br>"
                + "Täällä voit selata talletettuja viinejä, sekä lisätä uusia viinejä<br><br>"
                + "Muistioon talletetut viinit:</html>");
        JLabel mitatehdaan = new JLabel("<html><br>Mitä haluat tehdä?</html>");

        String viinit = "";
        for (Viini vk : kellari.listaaViinit()) {
            viinit += vk.getNimi() + " " + vk.getVuosi();
        }
        JTextField listaus = new JTextField(viinit);

        JRadioButton lisaa = new JRadioButton("Lisää viini");
        JRadioButton hae = new JRadioButton("Hae");
        ButtonGroup group1 = new ButtonGroup();
        group1.add(lisaa);
        group1.add(hae);

        container.add(tervetuloa);
        container.add(listaus);
        container.add(mitatehdaan);
        container.add(lisaa);
        container.add(hae);











    }

    public JFrame getFrame() {
        return frame;
    }
}
