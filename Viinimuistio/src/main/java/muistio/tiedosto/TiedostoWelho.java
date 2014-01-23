/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muistio.tiedosto;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Sonja
 */
public class TiedostoWelho {
    
    public TiedostoWelho(File tiedosto) {
        
    }
    
    public void lue(File tiedosto) throws Exception {
        Scanner lukija = new Scanner(tiedosto);
        
        while(lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            System.out.println(rivi);
        }
        lukija.close();
    }
    
    public void kirjoita(File tiedosto) {
        
    }
    
}
