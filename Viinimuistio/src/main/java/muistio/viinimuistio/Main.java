package muistio.viinimuistio;


import javax.swing.SwingUtilities;
import kayttoliittyma.Kayttoliittyma;
import muistio.tiedosto.TiedostoWelho;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sonja
 */
public class Main {
    public static void main(String[] args) throws Exception {
        TiedostoWelho tw = new TiedostoWelho();
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(tw);
        SwingUtilities.invokeLater(kayttoliittyma);
    }    
}
