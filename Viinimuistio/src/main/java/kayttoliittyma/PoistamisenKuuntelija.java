/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import muistio.tiedosto.TiedostoWelho;

/**
 *
 * @author Sonja
 */
public class PoistamisenKuuntelija implements ActionListener{
    
    private JButton poista;
    private TiedostoWelho tw;
    private TiedostoWelhonPoistamisenKuuntelija twk;
    
    public PoistamisenKuuntelija(TiedostoWelho tw, JButton poista) {
        this.tw = tw;
        this.poista = poista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            JFrame newFrame = new JFrame("Poista");
            newFrame.setPreferredSize(new Dimension(700, 500));
            newFrame.pack();
            newFrame.setVisible(true);
            teePoisto(newFrame.getContentPane(), newFrame);
        } catch (Exception ex) {
            Logger.getLogger(ArvioimisenKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void teePoisto(Container contentPane, JFrame newFrame) throws Exception {
        GridLayout layout = new GridLayout(4, 1);
        contentPane.setLayout(layout); 
        
        JComboBox viinit = new JComboBox(tw.lueViinit().viinienNimet());        
        JLabel alkuTeksti = new JLabel("Valitse listasta viini, jonka haluat poistaa.");
        
        JButton lisaaNappi = new JButton("Poista viini!");
        TiedostoWelhonPoistamisenKuuntelija kuuntelija = new TiedostoWelhonPoistamisenKuuntelija(tw, viinit, newFrame);
        lisaaNappi.addActionListener(kuuntelija);
        
        contentPane.add(alkuTeksti);
        contentPane.add(viinit);
        contentPane.add(lisaaNappi);
    }
    
}
