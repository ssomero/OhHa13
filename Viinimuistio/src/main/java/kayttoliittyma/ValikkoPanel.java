/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Sonja
 */
public class ValikkoPanel extends JPanel {

    public ValikkoPanel() {
        super(new GridLayout(1, 3));
        luoKomponentit();
    }

    private void luoKomponentit() {
        add(new JButton("Hae"));
        add(new JButton("Lisää viini"));
    }
}
