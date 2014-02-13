/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
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
        frame.setPreferredSize(new Dimension(900, 700));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        try {
            luoKomponentit(frame.getContentPane());
        } catch (Exception ex) {
            Logger.getLogger(Kayttoliittyma.class.getName()).log(Level.SEVERE, null, ex);
        }
        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) throws Exception {
        GridLayout layout = new GridLayout(4, 1);
        container.setLayout(layout);
        JLabel tervetuloa = new JLabel("<html>Tervetuloa viinimuistioon!<br>"
                + "Täällä voit selata talletettuja viinejä, sekä lisätä uusia viinejä<br><br>"
                + "Muistioon talletetut viinit:</html>");
        JLabel mitatehdaan = new JLabel("Mitä haluat tehdä?");

        String viinit = "";
        for (Viini vk : kellari.listaaViinit()) {
            viinit += vk.getNimi() + " " + vk.getVuosi() + "\n";
        }
        JTextArea listaus = new JTextArea(viinit);
        listaus.setEditable(false);
        JScrollPane scroll = new JScrollPane(listaus);

        container.add(tervetuloa);
        container.add(scroll);
        container.add(mitatehdaan);
        container.add(new ValikkoPanel(tw), BorderLayout.SOUTH);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void muistionViinit() {
        String lista[] = null;
        for (Viini viini : kellari.haeParhausjarjestyksessa()) {
        }
    }
}
