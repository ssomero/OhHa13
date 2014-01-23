/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muistio.viinimuistio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sonja
 */
public class Viini implements Comparable<Viini> {

    private String nimi;
    private String lajike;
    private String maa;
    private int vuosi;
    private String tyyppi;
    private List<Arvostelu> arvostelut;

    public Viini(String nimi, String tyyppi) {
        this.nimi = nimi;
        this.tyyppi = tyyppi;
        this.arvostelut = new ArrayList<>();
    }

    public void lisaaArvostelu(Arvostelu a) {
        this.arvostelut.add(a);
    }

    public List<Arvostelu> getArvostelut() {
        return arvostelut;
    }

    public double getKeskiarvo() {
        int summa = 0;
        for (Arvostelu a : arvostelut) {
            summa += a.getArvosana();
        }
        return (double) summa / arvostelut.size();
    }

    public String getNimi() {
        return nimi;
    }

    public String getLajike() {
        return lajike;
    }

    public String getMaa() {
        return maa;
    }

    public int getVuosi() {
        return vuosi;
    }

    public String getTyyppi() {
        return tyyppi;
    }

    public void setLajike(String lajike) {
        this.lajike = lajike;
    }

    public void setMaa(String maa) {
        this.maa = maa;
    }

    public void setVuosi(int vuosi) {
        this.vuosi = vuosi;
    }

    @Override
    public int compareTo(Viini verrattava) {
        if (verrattava.getKeskiarvo() > this.getKeskiarvo()) {
            return -1;
        } else if (verrattava.getKeskiarvo() < this.getKeskiarvo()) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Tyyppi: " + this.tyyppi + "\n" + "Nimi: " + this.nimi + "\n" + "Lajike: " + this.lajike + "\n" + "Vuosi: " + this.vuosi;
    }
}
