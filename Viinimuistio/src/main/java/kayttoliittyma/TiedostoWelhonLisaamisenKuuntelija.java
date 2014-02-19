/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import muistio.tiedosto.TiedostoWelho;
import muistio.viinimuistio.Arvostelu;
import muistio.viinimuistio.Viini;

/**
 *
 * @author Sonja
 */
public class TiedostoWelhonLisaamisenKuuntelija implements ActionListener {

    private TiedostoWelho tw;
    private JComboBox viiniTyyppi;
    private JTextField nimiKentta;
    private JTextField lajikeKentta;
    private JTextField maaKentta;
    private JTextField vuosiKentta;
    private JTextField arvosanaKentta;
    private JTextField arvioKentta;
    private JFrame frame;

    public TiedostoWelhonLisaamisenKuuntelija(TiedostoWelho tw, JComboBox viiniTyyppi, JTextField nimiKentta, JTextField lajikeKentta, JTextField maaKentta, JTextField vuosiKentta, JTextField arvosanaKentta, JTextField arvioKentta, JFrame frame) {
        this.tw = tw;
        this.viiniTyyppi = viiniTyyppi;
        this.nimiKentta = nimiKentta;
        this.lajikeKentta = lajikeKentta;
        this.maaKentta = maaKentta;
        this.vuosiKentta = vuosiKentta;
        this.arvosanaKentta = arvosanaKentta;
        this.arvioKentta = arvioKentta;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (viiniTyyppi.getSelectedItem().toString().equals("") || nimiKentta.getText().equals("")
                || lajikeKentta.getText().equals("") || maaKentta.getText().equals("") || vuosiKentta.getText().equals("")) {
            JOptionPane.showMessageDialog(frame, "Viinille tulee syöttää kaikki tiedot!", "Error", JOptionPane.ERROR_MESSAGE);

        } else {
            Viini viini = new Viini(viiniTyyppi.getSelectedItem().toString(), nimiKentta.getText(), lajikeKentta.getText(), maaKentta.getText(), vuosiKentta.getText());
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

                Logger.getLogger(TiedostoWelhonLisaamisenKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
            }


            JFrame newFrame = new JFrame("Onnistui");
            JOptionPane.showMessageDialog(newFrame, "Viinin lisääminen onnistui!");
            frame.setVisible(false);
            
        }


    }

    public boolean onkoViiniOlemassa() throws Exception {
        Viini v = new Viini(viiniTyyppi.getSelectedItem().toString(), nimiKentta.getText(), lajikeKentta.getText(), maaKentta.getText(), vuosiKentta.getText());
        for (Viini viini : tw.lueViinit().listaaViinit()) {
            if (viini.equals(v)) {
                return true;
            }
        }
        return false;
    }
}
