/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muistio.viinimuistio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *ViiniKellariin talletetaan kaikki viinit listana. Viinien arvosteluihin pääsee 
 * myös käsiksi viinien kautta. Samaa viini-oliota ei voi lisätä kahta kertaa kellariin.
 * @author Sonja
 */
public class ViiniKellari {

    private List<Viini> viinit;

    /**
     * Konstruktorissa luodaan tyhjäviinilista, joka toimii viinikellarin
     * pohjana ja jonne viinit lisätään.
     */
    public ViiniKellari() {
        this.viinit = new ArrayList<>();
    }

    /**
     * Metodi lisää parametrinna annetun viinin viinikellarin viineihin.
     *
     * @param v
     */
    public void lisaaViini(Viini v) {
        boolean loytyy = false;
        for (Viini viini : viinit) {
            if(viini.equals(v)) {
                loytyy = true;
            }            
        } if(!loytyy) {
            this.viinit.add(v);
        }
    }

    /**
     * Metodi antaa listan viineistä, joiden nimi vastaa parametrina annettua
     * viintä.
     *
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
    public List<Viini> haeParhausjarjestyksessa() {
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
       Iterator<Viini> iteraattori = viinit.iterator();
       while(iteraattori.hasNext()) {
           if(iteraattori.next().equals(viini)) {
               iteraattori.remove();
           }
       }
//        for (Iterator<Viini> v = viinit.iterator(); v.hasNext();) {
//            Viini vino = v.next();
//            if (vino.equals(viini)) {
//                v.remove();
//            }
//        }
    }

    public Viini getViini(Viini viini) {
        for (Viini viini1 : viinit) {
            if (viini1.equals(viini)) {
                return viini1;
            }
        }
        return null;
    }
    public String[] viinienNimet() {
        String[] nimet = new String[viinit.size()];
        
            for (int i = 0; i < viinit.size(); i++) {
            nimet[i] = viinit.get(i).getNimi();
        }
         return nimet;
    }    
}
