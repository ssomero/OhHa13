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
    
    public Arvostelu(int arvosana) {
        if(arvosana<40 || arvosana>100) {
            throw new IllegalArgumentException("Arvosanan tulee olla väliltä 40-100.");
        }
        this.arvosana = arvosana;        
    }

    public int getArvosana() {
        return arvosana;
    }

    public String getKommentti() {
        return kommentti;
    }

    public void setKommentti(String kommentti) {
        this.kommentti = kommentti;
    }
    
    public String getTiedostomuoto() {
        return this.arvosana+":"+this.kommentti;
    }
    
    
}
