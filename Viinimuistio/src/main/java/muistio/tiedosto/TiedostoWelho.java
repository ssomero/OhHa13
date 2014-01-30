/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muistio.tiedosto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import muistio.viinimuistio.Arvostelu;
import muistio.viinimuistio.Viini;
import muistio.viinimuistio.ViiniKellari;

/**
 *
 * @author Sonja
 */
public class TiedostoWelho {

    public static void main(String[] args) throws Exception {
        ViiniKellari vk = new ViiniKellari();
        TiedostoWelho tw = new TiedostoWelho();
        tw.lueViinit();
    }
    private ViiniKellari viinikellari;
    private File viinitiedosto;
    private File arviotiedosto;
    

    public TiedostoWelho() {
        this.viinikellari = new ViiniKellari();
        this.viinitiedosto = new File("viinit.txt");
        this.arviotiedosto = new File("arvostelut.txt");
    }

    public ViiniKellari lueViinit() throws Exception {
        Scanner lukija = new Scanner(viinitiedosto);
            while (lukija.hasNextLine()) {
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
        return viinikellari;

    }
    
//    public ViiniKellari lueArvostelut() throws FileNotFoundException {
//        Scanner lukija = new Scanner(arviotiedosto);
//            while (lukija.hasNextLine()) {
//                String rivi = lukija.nextLine();
//                String[] osat = rivi.split(":");
//                String nimi = osat[0];
//                String arvosanastring = osat[1];
//                int arvosana = Integer.parseInt(arvosanastring);
//                String kommentti = osat[2];
//                Arvostelu arvostelu = new Arvostelu(arvosana);
//                if(kommentti.isEmpty()) {
//                    arvostelu.setKommentti("");
//                } else {
//                arvostelu.setKommentti(kommentti);
//                }
//                
//            }
//    }
        
               

    //mitä jos kommenttikenttä on tyhjä? kirjottaessa/lukiessa tutkitaan jos on tyhjä ja esim. laitetaan tyhjä merkkijono
    
    //luetaanko arvosanat tiedostossa int vai String muuttujina? voi muuttaa splitissä tms int:ksi.(integer.parseInt)
//    
    public void kirjoitaViini() throws IOException {

        FileWriter kirjoittaja = new FileWriter("viinit.txt");

        for (Viini viini : viinikellari.listaaViinit()) {
            kirjoittaja.write(viini.getTiedostomuoto());
        }
        kirjoittaja.close();

    }

    
    
    public void kirjoitaArvostelu() throws IOException {
        FileWriter kirjoittaja = new FileWriter("arvostelut.txt");
        for (Viini viinit : viinikellari.listaaViinit()) {
            kirjoittaja.write(viinit.getNimiJaArvosteluTiedostomuoto());
        }
        kirjoittaja.close();
    }
}
