/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muistio.viinimuistio;

/**
 *
 * @author Sonja
 */
public class Arvostelu {

    private int arvosana;
    private String kommentti;

    /**
     * Arvostelun arvosana.
     * @param arvosana
     */
    public Arvostelu(int arvosana) {
        if (arvosana < 40 || arvosana > 100) {
            throw new IllegalArgumentException("Arvosanan tulee olla väliltä 40-100.");
        }
        this.arvosana = arvosana;
    }

    /**
     *Palauttaa arvostelun arvosanan.
     * @return
     */
    public int getArvosana() {
        return arvosana;
    }

    /**
     *Palauttaa tekstuaalisen arvostelun eli arvostelun kommentin.
     * @return
     */
    public String getKommentti() {
        return kommentti;
    }

    /**
     *Asettaa parametrina annetun kommentin arvostelun kommentiksi.
     * @param kommentti
     */
    public void setKommentti(String kommentti) {
        this.kommentti = kommentti;
    }

    /**
     *Palauttaa arvostelun sellaisessa muodossa, että se voidaan tallentaa tiedostoon.
     * @return
     */
    public String getTiedostomuoto() {
        return this.arvosana + ":" + this.kommentti;
    }
    
    @Override
    public String toString() {
        String arvio="";
        if(getKommentti()==null) {
            arvio += "Arvosana: "+this.arvosana+"\nKommentti: ";
        } else {
            arvio += "Arvosana: "+this.arvosana+"\nKommentti: "+this.kommentti;
        } return arvio;
    }
}
