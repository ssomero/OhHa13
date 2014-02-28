/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import muistio.tiedosto.TiedostoWelho;
import muistio.viinimuistio.Viini;

/**
 *
 * @author Sonja
 */
public class TiedostoWelhonPoistamisenKuuntelija implements ActionListener{
    private TiedostoWelho tw;
    private JComboBox viinit;
    private JFrame newFrame;
    
    public TiedostoWelhonPoistamisenKuuntelija(TiedostoWelho tw, JComboBox viinit, JFrame newFrame) {
        this.tw = tw;
        this.viinit = viinit;
        this.newFrame = newFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Viini poistettava = tw.lueViinit().haeNimenMukaan((String) viinit.getSelectedItem()).get(0);
                tw.lueViinit().poistaViini(poistettava);
                tw.kirjoitaViini();
                tw.kirjoitaArvostelu();
                JFrame frame = new JFrame("Onnistui");
            JOptionPane.showMessageDialog(frame, "Viinin poistaminen onnistui");
            newFrame.setVisible(false);
        } catch (Exception ex) {
            Logger.getLogger(TiedostoWelhonPoistamisenKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
