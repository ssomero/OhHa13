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

    public TiedostoWelhonArvioimisenKuuntelija(TiedostoWelho tw, JComboBox viinit, JTextField arvosanaKentta, JTextField arvioKentta) {
        this.tw = tw;
        this.viinit = viinit;
        this.arvosanaKentta = arvosanaKentta;
        this.arvioKentta = arvioKentta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            ViiniKellari kellari = tw.lueArvostelut();
            Arvostelu arvio = new Arvostelu(Integer.parseInt(arvosanaKentta.getText()));
            arvio.setKommentti(arvioKentta.getText());

            Viini viini = kellari.haeNimenMukaan((String) viinit.getSelectedItem()).get(0);

            kellari.getViini(viini).lisaaArvostelu(arvio);
            tw.kirjoitaArvostelu();         
        } catch (IOException ex) {
            Logger.getLogger(TiedostoWelhonArvioimisenKuuntelija.class.getName()).log(Level.SEVERE, null, ex);







        }
    }
}