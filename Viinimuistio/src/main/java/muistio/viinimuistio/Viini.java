/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muistio.viinimuistio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *Tämä on viinin luokka. Jokaiselle viinin ilmentymälle luodaan oma arvostelulista,
 * johon voidaan lisätä kyseisen viinin arvosteluja. Lisäksi viinejä voi verrata
 * compareTo-metodilla siten, että verrattavat ovat samoja ainoastaan, 
 * jos viineille annetuista parametreista kaikki ovat samat.
 * @author Sonja
 */
public class Viini implements Comparable<Viini> {

    private String nimi;
    private String lajike;
    private String maa;
    private String vuosi;
    private String tyyppi;
    private List<Arvostelu> arvostelut;

    /**
     * Kosntruktorissa luodaan viini-olio, ja tarkastetaan, että kaikki parametrit on syötetty.
     * 
     *Viinin tyyppi, puna- tai valkoviini 
     * @param tyyppi
     * 
     * Viinin nimi
     * @param nimi
     * 
     * Viinin rypälelajike
     * @param lajike
     * 
     * Viinin valmistusmaa
     * @param maa
     * 
     * Viinin valmistusvuosi
     * @param vuosi
     */
    public Viini(String tyyppi, String nimi, String lajike, String maa, String vuosi) {
        if (tyyppi==null || nimi==null || lajike==null || maa==null || vuosi==null) {
            throw new IllegalArgumentException("Viinille tulee syöttää kaikki tiedot!");
        }
        this.tyyppi = tyyppi;
        this.nimi = nimi;
        this.lajike = lajike;
        this.maa = maa;
        this.vuosi = vuosi;
        this.arvostelut = new ArrayList<>();
    }

    /**
     *Metodi lisää parametrina olleen arvostelun viinin arvosteluihin.
     * @param a
     */
    public void lisaaArvostelu(Arvostelu a) {
        this.arvostelut.add(a);
    }
    

    /**
     *
     * @return
     */
    public List<Arvostelu> getArvostelut() {
        return arvostelut;
    }
    
    /**
     *Metodi palauttaa viinin saamat arviot (arvosanat ja niihin liittyvät kommentit).
     * @return
     */
    public String stringArvostelut() {
        String arviot = "";
        for (Arvostelu arvostelu : arvostelut) {
            arviot += arvostelu.toString()+"\n\n";
        } return arviot;
    }

    /**
     *Metodi palauttaa viinin saamien arvostelujen keskiarvon.
     * @return
     */
    public double getKeskiarvo() {
        int summa = 0;
        for (Arvostelu a : arvostelut) {
            summa += a.getArvosana();
        }
        return (double) summa / arvostelut.size();
    }

    /**
     *Metodi palauttaa viinin nimen.
     * @return
     */
    public String getNimi() {
        return nimi;
    }

    /**
     *Metodi palauttaa viinin rypälelajikkeen.
     * @return
     */
    public String getLajike() {
        return lajike;
    }

    /**
     *Metodi palauttaa viinin valmistusmaan.
     * @return
     */
    public String getMaa() {
        return maa;
    }

    /**
     *Metodi palauttaa viinin valmistusvuoden.
     * @return
     */
    public String getVuosi() {
        return vuosi;
    }

    /**
     *Metodi palauttaa viinin tyypin (puna- tai valkoviini).
     * @return
     */
    public String getTyyppi() {
        return tyyppi;
    }
   

    /**
     *Metodi palauttaa viinin tiedot sellaisessa muodossa, että viini voidaan tallentaa tiedostoon.
     * @return
     */
    public String getTiedostomuoto() {
        return this.tyyppi + ":" + this.nimi + ":" + this.lajike + ":" + this.maa + ":" + this.vuosi+"\n";
    }

    /**
     *Metodi palauttaa viinin nimen ja arvostelut sellaisessa muodossa, että ne voidaan tallentaa tiedostoon.
     * @return
     */
    public String getNimiJaArvosteluTiedostomuoto() {
        String arviot = "";
        for (Arvostelu a : arvostelut) {
            if(arvostelut.size()>1) {
            arviot += this.nimi + ":" + a.getTiedostomuoto() + "\n";
            } else  {
                arviot = this.nimi + ":" + a.getTiedostomuoto()+"\n";
            } 
            }
        return arviot;
    }

    @Override
    public int compareTo(Viini verrattava) {
        if (verrattava.getKeskiarvo() > this.getKeskiarvo()) {
            return 1;
        } else if (verrattava.getKeskiarvo() < this.getKeskiarvo()) {
            return -1;
        } else {
            return 0;
        }
    }    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Viini other = (Viini) obj;
        
        if (!Objects.equals(this.nimi, other.nimi)) {
            return false;
        }
        if (!Objects.equals(this.lajike, other.lajike)) {
            return false;
        }
        if (!Objects.equals(this.maa, other.maa)) {
            return false;
        }
        if (!Objects.equals(this.vuosi, other.vuosi)) {
            return false;
        }
        if (!Objects.equals(this.tyyppi, other.tyyppi)) {
            return false;
        }
        return true;
    }
    
   

    @Override
    public String toString() {
        return "\nTyyppi: " + this.tyyppi + "\n" + "Nimi: " + this.nimi + "\n" + "Lajike: " + this.lajike + "\n" + "Maa: " + this.maa + "\n" + "Vuosi: " + this.vuosi+"\n";
    }
}
