/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingUtilities;
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
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);        
    }
    
    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(4, 1);
        container.setLayout(layout);
        JLabel tervetuloa = new JLabel("<html>Tervetuloa viinimuistioon!<br>"
                + "Täällä voit selata talletettuja viinejä, sekä lisätä uusia viinejä<br><br>"
                + "Muistioon talletetut viinit:</html>");
        JLabel mitatehdaan = new JLabel("Mitä haluat tehdä?");
        
        
        JList viinilista = new JList();
        
        

//        String viinit = "";
//        for (Viini vk : kellari.listaaViinit()) {
//            viinit += vk.getNimi() + " " + vk.getVuosi();
//        }
//        JTextField listaus = new JTextField(viinit);        

        
        
        container.add(tervetuloa);
        container.add(viinilista);
//        container.add(listaus);
        container.add(mitatehdaan);
        
        
        container.add(new ValikkoPanel(tw), BorderLayout.SOUTH);
        
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
    public void muistionViinit() {
        String lista [] = null;
        for (Viini viini : kellari.haeParhausjarjestyksessa()) {
            
        }
    }
}
