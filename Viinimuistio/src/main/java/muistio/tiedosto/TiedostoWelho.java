/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muistio.tiedosto;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import muistio.viinimuistio.Viini;
import muistio.viinimuistio.ViiniKellari;

/**
 *
 * @author Sonja
 */
public class TiedostoWelho {
    
    public static void main (String[] args) throws Exception {
        ViiniKellari vk = new ViiniKellari();
        TiedostoWelho tw = new TiedostoWelho();
        tw.lueViinit();
    }
    private ViiniKellari viinikellari;
    private File tiedosto;
    
    public TiedostoWelho() {
        this.viinikellari = new ViiniKellari();
        this.tiedosto = new File("viinit.txt");
    }
    
    public ViiniKellari lueViinit() throws Exception {
        try (Scanner lukija = new Scanner(tiedosto)) {
            while(lukija.hasNextLine()) {
                String rivi = lukija.nextLine();                
                String[] osat = rivi.split(":");
                String tyyppi = osat[0];
                String nimi = osat[1];
                String lajike = osat[2];
                String vuosi = osat[3];
                String maa = osat[4];
                Viini viini = new Viini(tyyppi, nimi, lajike, vuosi, maa);
                viinikellari.lisaaViini(viini);                
            }
        } return viinikellari;
        
    }
    
    public void kirjoita() throws Exception{
        try {
            FileWriter kirjoittaja = new FileWriter("viinit.txt");
        } catch (IOException ex) {
            ;
        }
        
    }
    
}
