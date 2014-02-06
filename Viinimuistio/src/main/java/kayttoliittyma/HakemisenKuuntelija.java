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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Sonja
 */
public class HakemisenKuuntelija implements ActionListener {

    JButton haku;

    public HakemisenKuuntelija(JButton haku) {
        this.haku = haku;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame newFrame = new JFrame("Haku");
        newFrame.setPreferredSize(new Dimension(700, 500));
        newFrame.pack();
        newFrame.setVisible(true);
        
    }
    
    
}
