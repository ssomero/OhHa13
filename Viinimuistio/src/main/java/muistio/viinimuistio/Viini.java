/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muistio.viinimuistio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Sonja
 */
public class Viini implements Comparable<Viini> {

    private String nimi;
    private String lajike;
    private String maa;
    private String vuosi;
    private String tyyppi;
    private List<Arvostelu> arvostelut;

    public Viini(String tyyppi, String nimi, String lajike, String maa, String vuosi) {
        this.tyyppi = tyyppi;
        this.nimi = nimi;
        this.lajike = lajike;
        this.maa = maa;
        this.vuosi = vuosi;
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

    public String getVuosi() {
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

    public void setVuosi(String vuosi) {
        this.vuosi = vuosi;
    }

    public String getTiedostomuoto() {
        return this.tyyppi + ":" + this.nimi + ":" + this.lajike + ":" + this.maa + ":" + this.vuosi;
    }

    public String getNimiJaArvosteluTiedostomuoto() {
        String arviot = "";
        for (Arvostelu a : arvostelut) {
            if(arvostelut.size()>1) {
            arviot += this.nimi + ":" + a.getTiedostomuoto() + "\n";
            } else if(arvostelut.size()==1) {
                arviot = this.nimi + ":" + a.getTiedostomuoto();
            } 
            }
        return arviot;
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
