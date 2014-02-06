/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
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
        GridLayout layout = new GridLayout(8, 1);
        container.setLayout(layout);
        JLabel tervetuloa = new JLabel("<html>Tervetuloa viinimuistioon!<br>"
                + "Täällä voit selata talletettuja viinejä, sekä lisätä uusia viinejä<br><br>"
                + "Muistioon talletetut viinit:</html>");
        JLabel mitatehdaan = new JLabel("<html><br>Mitä haluat tehdä?</html>");

//        String viinit = "";
//        for (Viini vk : kellari.listaaViinit()) {
//            viinit += vk.getNimi() + " " + vk.getVuosi();
//        }
//        JTextField listaus = new JTextField(viinit);        

        JLabel lisays = new JLabel("Lisää viini:");

        container.add(tervetuloa);
//        container.add(listaus);
        container.add(mitatehdaan);
        
        container.add(lisays);
        container.add(new ValikkoPanel(), BorderLayout.SOUTH);
        luoViininLisays(container);
    }
    
    public void luoViininLisays(Container container) {
        GridLayout layout = new GridLayout(5, 2);
        container.setLayout(layout);
        
        JLabel tyyppiTeksti = new JLabel("Tyyppi (valko- tai punaviini):");
        JTextField tyyppiKentta = new JTextField();
        JLabel nimiTeksti = new JLabel("Nimi:");
        JTextField nimiKentta = new JTextField();
        JLabel lajikeTeksti = new JLabel("Lajike:");
        JTextField lajikeKentta = new JTextField();
        JLabel maaTeksti = new JLabel("Maa:");
        JTextField maaKentta = new JTextField();
        JLabel vuosiTeksti = new JLabel("Vuosi:");
        JTextField vuosiKentta = new JTextField();
        JLabel arvosanaTeksti = new JLabel("Arvosana (40-100):");
        JTextField arvosanaKentta = new JTextField();
        JLabel arvioTeksti = new JLabel("Kommentti:");
        JTextField arvioKentta = new JTextField();
        
        
        JButton lisaaNappi = new JButton("Lisää viini!");
        TiedostoWelhonKuuntelija kuuntelija = new TiedostoWelhonKuuntelija(tw, tyyppiKentta, nimiKentta, lajikeKentta, maaKentta, vuosiKentta, arvosanaKentta, arvioKentta);
        lisaaNappi.addActionListener(kuuntelija);
        
        container.add(tyyppiTeksti);
        container.add(tyyppiKentta);
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
    
    
    

    public JFrame getFrame() {
        return frame;
    }
}
