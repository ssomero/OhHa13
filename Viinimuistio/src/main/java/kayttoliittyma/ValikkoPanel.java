/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import muistio.tiedosto.TiedostoWelho;

/**
 *
 * @author Sonja
 */
public class ValikkoPanel extends JPanel {
    private JButton haku;
    private TiedostoWelho tw;

    public ValikkoPanel(TiedostoWelho tw) {
        super(new GridLayout(1, 3));
        this.tw = tw;
        luoKomponentit();
    }

    private void luoKomponentit() {
        
        JButton hae = new JButton("Hae");
        JButton lisaa = new JButton("Lisää viini");        
        add(hae);
        add(lisaa);
        HakemisenKuuntelija hkuuntelija = new HakemisenKuuntelija(hae);
        hae.addActionListener(hkuuntelija);
        LisaamisenKuuntelija lkuuntelija = new LisaamisenKuuntelija(tw, lisaa);
        lisaa.addActionListener(lkuuntelija);
        
    }
}
