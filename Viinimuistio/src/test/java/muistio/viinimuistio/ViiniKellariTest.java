/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muistio.viinimuistio;

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
    public void lisaaViiniLisaaViininListaan() {
        vk.lisaaViini(new Viini("tyyppi", "nimi", "laji", "maa", "vuosi"));
        vk.lisaaViini(new Viini("tyyppi2", "nimi2", "laji2", "maa2", "vuosi2"));
        assertEquals(2, this.vk.listaaViinit().size());
    }
    
    @Test
    public void lisaaViiniLisaaLisaamattomatViinitListaan () {
        vk.lisaaViini(new Viini("tyyppi", "nimi", "laji", "maa", "vuosi"));
        vk.lisaaViini(new Viini("tyyppi2", "nimi2", "laji2", "maa2", "vuosi2"));
        vk.lisaaViini(new Viini("tyyppi", "nimi", "laji", "maa", "vuosi"));
        assertEquals(2, this.vk.listaaViinit().size());
    }
    
//     @Test
//     public void haeNimenMukaanToimii() {
//         vk.lisaaViini(new Viini("tyyppi", "nimi", "laji", "maa", "vuosi"));
//         vk.lisaaViini(new Viini("tyyppi2", "nimi2", "laji2", "maa2", "vuosi2"));
//         vk.lisaaViini(new Viini("tyyppi1", "nimi2", "laji3", "maa2", "vuosi2"));         
//         assertEquals(, this.vk.haeNimenMukaan("nimi2"));
//     }
}
