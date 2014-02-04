/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import muistio.tiedosto.TiedostoWelho;

/**
 *
 * @author Sonja
 */
public class Kayttoliittyma implements Runnable{
    
    
    
    private JFrame frame;
    
    public Kayttoliittyma(TiedostoWelho tw) {
        
    }

    @Override
    public void run() {
        frame = new JFrame("Viinimuistio");
        frame.setPreferredSize(new Dimension(600, 700));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    private void luoKomponentit(Container container) {
        
        JLabel tervetuloa = new JLabel("Tervetuloa viinimuistioon! Täällä voit selata tallennettuja viinejä, sekä lisätä uusia viinejä");
        
        container.add(tervetuloa, BorderLayout.NORTH);
        
        
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
}
