/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Sonja
 */
public class LisaamisenKuuntelija implements ActionListener{
    
    private JButton lisaa;
    
    public LisaamisenKuuntelija(JButton lisaa) {
        this.lisaa = lisaa;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame newFrame = new JFrame("Viinin lisääminen");
            newFrame.pack();
            newFrame.setVisible(true);
    }
    
}
