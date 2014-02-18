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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import muistio.tiedosto.TiedostoWelho;

/**
 *
 * @author Sonja
 */
public class LisaamisenKuuntelija implements ActionListener {

    private JButton lisaa;
    private TiedostoWelho tw;
    private TiedostoWelhonLisaamisenKuuntelija twk;

    public LisaamisenKuuntelija(TiedostoWelho tw, JButton lisaa) {
        this.tw = tw;
        this.lisaa = lisaa;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame newFrame = new JFrame("Viinin lisääminen");
        newFrame.setPreferredSize(new Dimension(700, 500));
        
        newFrame.pack();
        newFrame.setVisible(true);
        luoViininLisays(newFrame.getContentPane(), newFrame);        
    }
    
    public void luoViininLisays(Container container, JFrame newFrame) {
        GridLayout layout = new GridLayout(15, 1);
        container.setLayout(layout);
        
        
        JLabel alkuTeksti = new JLabel("Tähdellä (*) merkityt tiedot ovat pakollisia");
        JLabel tyhja = new JLabel("");
        
        String[] viinit = {"punaviini", "valkoviini"} ;
        JComboBox viiniTyyppi = new JComboBox(viinit);

        JLabel tyyppiTeksti = new JLabel("");
        
        JLabel nimiTeksti = new JLabel("* Nimi:");
        JTextField nimiKentta = new JTextField();
        JLabel lajikeTeksti = new JLabel("* Lajike:");
        JTextField lajikeKentta = new JTextField();
        JLabel maaTeksti = new JLabel("* Maa:");
        JTextField maaKentta = new JTextField();
        JLabel vuosiTeksti = new JLabel("* Vuosi:");
        JTextField vuosiKentta = new JTextField();
        JLabel arvosanaTeksti = new JLabel("* Arvosana (40-100):");
        JTextField arvosanaKentta = new JTextField();
        JLabel arvioTeksti = new JLabel("Kommentti:");
        JTextField arvioKentta = new JTextField();

        JButton lisaaNappi = new JButton("Lisää viini!");
        TiedostoWelhonLisaamisenKuuntelija kuuntelija = new TiedostoWelhonLisaamisenKuuntelija(tw, viiniTyyppi, nimiKentta, lajikeKentta, maaKentta, vuosiKentta, arvosanaKentta, arvioKentta, newFrame);
        lisaaNappi.addActionListener(kuuntelija);
        container.add(alkuTeksti);
        container.add(tyhja);
        container.add(tyyppiTeksti);
        container.add(viiniTyyppi);
        container.add(nimiTeksti);
        container.add(nimiKentta);
        container.add(lajikeTeksti);
        container.add(lajikeKentta);
        container.add(maaTeksti);
        container.add(maaKentta);
        container.add(vuosiTeksti);
        container.add(vuosiKentta);
        container.add(arvosanaTeksti);
        container.add(arvosanaKentta);
        container.add(arvioTeksti);
        container.add(arvioKentta);
        container.add(new JLabel(""));
        container.add(lisaaNappi);
    }    
}
