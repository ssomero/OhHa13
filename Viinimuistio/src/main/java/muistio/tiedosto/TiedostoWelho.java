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
import muistio.viinimuistio.Arvostelu;
import muistio.viinimuistio.Viini;
import muistio.viinimuistio.ViiniKellari;

/**
 *TiedostoWelho lukee ViiniKellaria ja kirjoittaa sinne.
 * @author Sonja
 */
public class TiedostoWelho {

    /**
     *
     * @param args
     * @throws Exception
     */
      
    private ViiniKellari viinikellari;
    private File viinitiedosto;
    private File arviotiedosto;

    /**
     * Konstruktorissa luodaan viinikellari sekä otetaan mukaan viini- ja
     * arviotiedostot.
     */
    public TiedostoWelho() {
        this.viinikellari = new ViiniKellari();
        this.viinitiedosto = new File("viinit.txt");
        this.arviotiedosto = new File("arvostelut.txt");
    }

    /**
     *
     * @return @throws Exception
     */
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

    //liian pitkä metodi, yritetään pilkkoa! jos esim pelkkä lue()? foresta oma metodi?
    /**
     *
     * @return @throws FileNotFoundException
     */
    public ViiniKellari lueArvostelut() throws FileNotFoundException {
        Scanner lukija = new Scanner(arviotiedosto);
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            String[] osat = rivi.split(":");
            String nimi = osat[0];
            String arvosanastring = osat[1];
            String kommentti = "";
            if (osat.length > 2) {
                kommentti = osat[2];
            }
            Viini arvosteltava = null;
            for (Viini viini : viinikellari.listaaViinit()) {
                if (viini.getNimi().equals(nimi)) {
                    arvosteltava = viini;
                }
            }
            if (arvosteltava == null) {
                continue;
            }

            Arvostelu arvostelu = new Arvostelu(Integer.parseInt(arvosanastring));
            if (kommentti.isEmpty()) {
                arvostelu.setKommentti("");
            } else {
                arvostelu.setKommentti(kommentti);
            }
            arvosteltava.lisaaArvostelu(arvostelu);
        }
        return viinikellari;
    }
    
    
    /**
     *
     * @throws IOException
     */
    public void kirjoitaViini() throws IOException {

        FileWriter kirjoittaja = new FileWriter("viinit.txt");

        for (Viini viini : viinikellari.listaaViinit()) {
            kirjoittaja.write(viini.getTiedostomuoto());
        }
        kirjoittaja.close();
    }

    /**
     *
     * @throws IOException
     */
    public void kirjoitaArvostelu() throws IOException {
        FileWriter kirjoittaja = new FileWriter("arvostelut.txt");        
        for (Viini viinit : viinikellari.listaaViinit()) {
            kirjoittaja.write(viinit.getNimiJaArvosteluTiedostomuoto());
        }        
        kirjoittaja.close();
    }
}
