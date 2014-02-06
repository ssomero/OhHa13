/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Sonja
 */
public class ValikkoPanel extends JPanel {
    private JButton haku;

    public ValikkoPanel() {
        super(new GridLayout(1, 3));
        luoKomponentit();
    }

    private void luoKomponentit() {
        
        JButton hae = new JButton("Hae");
        JButton lisaa = new JButton("Lisää viini");        
        add(hae);
        add(lisaa);
        HakemisenKuuntelija hkuuntelija = new HakemisenKuuntelija(hae);
        hae.addActionListener(hkuuntelija);
        LisaamisenKuuntelija lkuuntelija = new LisaamisenKuuntelija(lisaa);
        lisaa.addActionListener(lkuuntelija);
        
    }
}
