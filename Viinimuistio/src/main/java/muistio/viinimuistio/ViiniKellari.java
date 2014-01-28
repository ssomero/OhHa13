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
    
    public ViiniKellari() {
        this.viinit = new ArrayList<>();
    }
    
    public void lisaaViini(Viini v) {
        this.viinit.add(v);
    }
    
    public List<Viini> haeNimenMukaan(String nimi) {
        ArrayList<Viini> lista = new ArrayList<>();
        for (Viini v : viinit) {
            if(v.getNimi().trim().equalsIgnoreCase(nimi.trim())) {
                lista.add(v);
            }
        } return lista;
    }
    
    public List<Viini> haeMaanMukaan(String maa) {
        ArrayList<Viini> lista = new ArrayList<>();
        for (Viini v : viinit) {
            if(v.getMaa().trim().equalsIgnoreCase(maa.trim())) {
                lista.add(v);
            }
        } return lista;
    }
    
    public List<Viini> haeTyypinMukaan(String tyyppi) {
        ArrayList<Viini> lista = new ArrayList<>();
        for (Viini v : viinit) {
            if(v.getTyyppi().trim().equalsIgnoreCase(tyyppi.trim())) {
                lista.add(v);
            }
        } return lista;
    }
    
    public List<Viini> haeParhausjärjestyksessa() {
        Collections.sort(viinit);
        return viinit;        
    }
}
