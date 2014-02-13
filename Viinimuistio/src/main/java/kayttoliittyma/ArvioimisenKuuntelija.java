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
import javax.swing.JTextField;
import muistio.tiedosto.TiedostoWelho;

/**
 *
 * @author Sonja
 */
public class ArvioimisenKuuntelija implements ActionListener{
    private JButton arvioi;
    private TiedostoWelho tw;
    
    public ArvioimisenKuuntelija(TiedostoWelho tw, JButton arvioi) {
        this.tw = tw;
        this.arvioi = arvioi;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            JFrame newFrame = new JFrame("Arvio");
            newFrame.setPreferredSize(new Dimension(700, 500));
            newFrame.pack();
            newFrame.setVisible(true);
            luoArvio(newFrame.getContentPane(), newFrame);
        } catch (Exception ex) {
            Logger.getLogger(ArvioimisenKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void luoArvio(Container container, JFrame newFrame) throws Exception {
        GridLayout layout = new GridLayout(15, 1);
        container.setLayout(layout); 
        
        JComboBox viinit = new JComboBox(tw.lueViinit().viinienNimet());
        
        
//        JLabel tyyppiTeksti = new JLabel("Tyyppi (valko- tai punaviini):");
//        JTextField tyyppiKentta = new JTextField();
//        JLabel nimiTeksti = new JLabel("Nimi:");
//        JTextField nimiKentta = new JTextField();
//        JLabel lajikeTeksti = new JLabel("Lajike:");
//        JTextField lajikeKentta = new JTextField();
//        JLabel maaTeksti = new JLabel("Maa:");
//        JTextField maaKentta = new JTextField();
//        JLabel vuosiTeksti = new JLabel("Vuosi:");
//        JTextField vuosiKentta = new JTextField();
        JLabel arvosanaTeksti = new JLabel("Arvosana (40-100):");
        JTextField arvosanaKentta = new JTextField();
        JLabel arvioTeksti = new JLabel("Kommentti:");
        JTextField arvioKentta = new JTextField();
        JLabel tyhja = new JLabel("");

        JButton lisaaNappi = new JButton("Lisää arvio!");
        TiedostoWelhonArvioimisenKuuntelija kuuntelija = new TiedostoWelhonArvioimisenKuuntelija(tw, viinit, arvosanaKentta, arvioKentta, newFrame);
        lisaaNappi.addActionListener(kuuntelija);
        
        container.add(viinit);
        container.add(tyhja);
//        container.add(tyyppiTeksti);
//        container.add(tyyppiKentta);
//        container.add(nimiTeksti);
//        container.add(nimiKentta);
//        container.add(lajikeTeksti);
//        container.add(lajikeKentta);
//        container.add(maaTeksti);
//        container.add(maaKentta);
//        container.add(vuosiTeksti);
//        container.add(vuosiKentta);
        container.add(arvosanaTeksti);
        container.add(arvosanaKentta);
        container.add(arvioTeksti);
        container.add(arvioKentta);
        container.add(new JLabel(""));
        container.add(lisaaNappi);
    }
    
}
