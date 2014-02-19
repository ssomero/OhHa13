/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import muistio.tiedosto.TiedostoWelho;

/**
 *
 * @author Sonja
 */
public class ValikkoPanel extends JPanel {
    
    private TiedostoWelho tw;

    public ValikkoPanel(TiedostoWelho tw) {
        super(new GridLayout(1, 3));
        this.tw = tw;
        luoKomponentit();
    }

    private void luoKomponentit() {
        
        JButton hae = new JButton("Hae");
        JButton lisaa = new JButton("Lisää viini");    
        JButton arvioi = new JButton("Arvioi muistion viini");
        add(hae);
        add(lisaa);
        add(arvioi);
        HakemisenKuuntelija hkuuntelija = new HakemisenKuuntelija(tw, hae);
        hae.addActionListener(hkuuntelija);
        LisaamisenKuuntelija lkuuntelija = new LisaamisenKuuntelija(tw, lisaa);
        lisaa.addActionListener(lkuuntelija);
        ArvioimisenKuuntelija akuuntelija = new ArvioimisenKuuntelija(tw, arvioi);
        arvioi.addActionListener(akuuntelija);        
    }
}
