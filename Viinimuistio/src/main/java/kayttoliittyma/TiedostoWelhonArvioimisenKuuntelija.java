/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import muistio.tiedosto.TiedostoWelho;
import muistio.viinimuistio.Arvostelu;
import muistio.viinimuistio.Viini;
import muistio.viinimuistio.ViiniKellari;

/**
 *
 * @author Sonja
 */
public class TiedostoWelhonArvioimisenKuuntelija implements ActionListener {

    private TiedostoWelho tw;
    private JComboBox viinit;
    private JTextField arvosanaKentta;
    private JTextField arvioKentta;
    private JFrame frame;

    public TiedostoWelhonArvioimisenKuuntelija(TiedostoWelho tw, JComboBox viinit, JTextField arvosanaKentta, JTextField arvioKentta, JFrame frame) {
        this.tw = tw;
        this.viinit = viinit;
        this.arvosanaKentta = arvosanaKentta;
        this.arvioKentta = arvioKentta;
        this.frame = frame;
    }
    
        

    @Override
    public void actionPerformed(ActionEvent e) {
        if(arvosanaKentta.getText().equals("") || Integer.parseInt(arvosanaKentta.getText())>100 ||
                Integer.parseInt(arvosanaKentta.getText())<40 ) {
            JOptionPane.showMessageDialog(frame, "Syötä arvosana väliltä 40-100!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
        try {
            Arvostelu arvio = new Arvostelu(Integer.parseInt(arvosanaKentta.getText()));
            arvio.setKommentti(arvioKentta.getText());
            Viini viini = tw.lueViinit().haeNimenMukaan((String) viinit.getSelectedItem()).get(0);
            tw.lueViinit().getViini(viini).lisaaArvostelu(arvio);
            tw.kirjoitaArvostelu();
            JFrame newFrame = new JFrame("Onnistui");
            JOptionPane.showMessageDialog(newFrame, "Arvostelun lisääminen onnistui!");
            frame.setVisible(false);
        } catch (Exception ex) {
            Logger.getLogger(TiedostoWelhonArvioimisenKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
    
    
   
}