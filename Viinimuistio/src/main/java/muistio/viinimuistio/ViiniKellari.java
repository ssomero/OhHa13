/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muistio.viinimuistio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Sonja
 */
public class ViiniKellari {

    private List<Viini> viinit;

    /**
     *Konstruktorissa luodaan tyhjäviinilista, joka toimii viinikellarin pohjana ja jonne viinit lisätään.
     */
    public ViiniKellari() {
        this.viinit = new ArrayList<>();
    }

    /**
     *Metodi lisää parametrinna annetun viinin viinikellarin viineihin.
     * @param v
     */
    public void lisaaViini(Viini v) {
        if(!viinit.contains(v)) {
            this.viinit.add(v);
        }         
    }       

    /**
     *Metodi antaa listan viineistä, joiden nimi vastaa parametrina annettua viintä.
     * @param nimi
     * @return
     */
    public List<Viini> haeNimenMukaan(String nimi) {
        ArrayList<Viini> lista = new ArrayList<>();
        for (Viini v : viinit) {
            if (v.getNimi().trim().equalsIgnoreCase(nimi.trim())) {
                lista.add(v);
            }
        }
        return lista;
    }

    /**
     *
     * @param maa
     * @return
     */
    public List<Viini> haeMaanMukaan(String maa) {
        ArrayList<Viini> lista = new ArrayList<>();
        for (Viini v : viinit) {
            if (v.getMaa().trim().equalsIgnoreCase(maa.trim())) {
                lista.add(v);
            }
        } 
        return lista;
        
    }

    /**
     *
     * @param tyyppi
     * @return
     */
    public List<Viini> haeTyypinMukaan(String tyyppi) {
        ArrayList<Viini> lista = new ArrayList<>();
        for (Viini v : viinit) {
            if (v.getTyyppi().trim().equalsIgnoreCase(tyyppi.trim())) {
                lista.add(v);
            }
        }
        return lista;
    }

    /**
     *
     * @return
     */
    public List<Viini> haeParhausjärjestyksessa() {
        Collections.sort(viinit);
        return viinit;
    }

    /**
     *
     * @return
     */
    public List<Viini> listaaViinit() {
        return viinit;
    }
    
    /**
     *
     * @param viini
     */
    public void poistaViini(Viini viini) {
        for (Viini v : viinit) {
            if(v.equals(viini)) {
                viinit.remove(v);
            }
        }
    }
}
