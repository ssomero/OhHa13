/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTextField;
import muistio.tiedosto.TiedostoWelho;
import muistio.viinimuistio.Arvostelu;
import muistio.viinimuistio.Viini;

/**
 *
 * @author Sonja
 */
public class TiedostoWelhonKuuntelija implements ActionListener {

    private TiedostoWelho tw;
    private JTextField tyyppiKentta;
    private JTextField nimiKentta;
    private JTextField lajikeKentta;
    private JTextField maaKentta;
    private JTextField vuosiKentta;
    private JTextField arvosanaKentta;
    private JTextField arvioKentta;

    public TiedostoWelhonKuuntelija(TiedostoWelho tw, JTextField tyyppiKentta, JTextField nimiKentta, JTextField lajikeKentta, JTextField maaKentta, JTextField vuosiKentta, JTextField arvosanaKentta, JTextField arvioKentta) {
        this.tw = tw;
        this.tyyppiKentta = tyyppiKentta;
        this.nimiKentta = nimiKentta;
        this.lajikeKentta = lajikeKentta;
        this.maaKentta = maaKentta;
        this.vuosiKentta = vuosiKentta;
        this.arvosanaKentta = arvosanaKentta;
        this.arvioKentta = arvioKentta;
    }    

    @Override
    public void actionPerformed(ActionEvent e) {
        Viini viini = new Viini(tyyppiKentta.getText(), nimiKentta.getText(), lajikeKentta.getText(), maaKentta.getText(), vuosiKentta.getText());
        Arvostelu arvio = new Arvostelu(Integer.parseInt(arvosanaKentta.getText()));
        arvio.setKommentti(arvioKentta.getText());
        try {        
            if (!onkoViiniOlemassa()) {                
                    tw.lueViinit().lisaaViini(viini);
                    tw.kirjoitaViini();
                    tw.lueArvostelut().getViini(viini).lisaaArvostelu(arvio);
                    tw.kirjoitaArvostelu();
                     } 
        } catch (Exception ex) {
            Logger.getLogger(TiedostoWelhonKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean onkoViiniOlemassa() throws Exception {
        Viini v = new Viini(tyyppiKentta.getText(), nimiKentta.getText(), lajikeKentta.getText(), maaKentta.getText(), vuosiKentta.getText());
        for (Viini viini : tw.lueViinit().listaaViinit()) {
            if (viini.equals(v)) {
                return true;
            }
        }
        return false;
    }
}
