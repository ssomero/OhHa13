/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muistio.viinimuistio;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sonja
 */
public class ViiniKellariTest {
    ViiniKellari vk;
    
    public ViiniKellariTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        vk = new ViiniKellari();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void konstruktoriLuoTyhjanViinilistan() {
        assertEquals(0, this.vk.listaaViinit().size());
    }
    
    @Test
    public void lisaaViiniToimii() {
        vk.lisaaViini(new Viini("tyyppi", "nimi", "laji", "maa", "vuosi"));
        vk.lisaaViini(new Viini("tyyppi2", "nimi2", "laji2", "maa2", "vuosi2"));
        assertEquals(2, this.vk.listaaViinit().size());
    }
    
    @Test
    public void lisaaViiniToimii2 () {
        vk.lisaaViini(new Viini("tyyppi", "nimi", "laji", "maa", "vuosi"));
        vk.lisaaViini(new Viini("tyyppi2", "nimi2", "laji2", "maa2", "vuosi2"));
        vk.lisaaViini(new Viini("tyyppi", "nimi", "laji", "maa", "vuosi"));
        assertEquals(2, this.vk.listaaViinit().size());
    }
    
    @Test
    public void poistaViiniToimii() {
        Viini viini1 = new Viini("tyyppi", "nimi", "laji", "maa", "vuosi");
        Viini viini2 = new Viini("tyyppi2", "nimi2", "laji2", "maa2", "vuosi2");
        vk.lisaaViini(viini1);
        vk.lisaaViini(viini2);
        vk.poistaViini(viini1);
        assertEquals(1, vk.listaaViinit().size());
    }
    
     @Test
     public void haeNimenMukaanToimii() {
         vk.lisaaViini(new Viini("tyyppi", "nimi", "laji", "maa", "vuosi"));
         vk.lisaaViini(new Viini("tyyppi2", "nimi2", "laji2", "maa2", "vuosi2"));
         vk.lisaaViini(new Viini("tyyppi1", "nimi2", "laji3", "maa2", "vuosi2"));         
         assertEquals("nimi2", this.vk.haeNimenMukaan("nimi2").get(0).getNimi());
     }
     
     @Test
     public void haeMaanMukaanToimii() {
         vk.lisaaViini(new Viini("tyyppi", "nimi", "laji", "maa", "vuosi"));
         vk.lisaaViini(new Viini("tyyppi2", "nimi2", "laji2", "maa2", "vuosi2"));
         vk.lisaaViini(new Viini("tyyppi1", "nimi2", "laji3", "maa2", "vuosi2"));         
         assertEquals("maa2", this.vk.haeMaanMukaan("maa2").get(1).getMaa());
     }
     
//     @Test
//     public void haeTyypinMukaanToimii() {
//         vk.lisaaViini(new Viini("tyyppi", "nimi", "laji", "maa", "vuosi"));
//         vk.lisaaViini(new Viini("tyyppi2", "nimi2", "laji2", "maa2", "vuosi2"));
//         vk.lisaaViini(new Viini("tyyppi1", "nimi2", "laji3", "maa2", "vuosi2"));         
//         assertEquals(new List<Viini>(), this.vk.haeTyypinMukaan("tyyppi3"));
//     }
}
