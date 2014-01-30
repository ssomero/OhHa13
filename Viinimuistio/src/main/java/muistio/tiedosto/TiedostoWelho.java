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
        vk = tw.lueViinit();
        Viini vino = vk.haeNimenMukaan("Blue nun").get(0);
        tw.lueArvostelut();
        System.out.println(vino.stringArvostelut());
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

    //liian pitkä metodi, yritetään pilkkoa! jos esim pelkkä lue()? foresta oma metodi?
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
