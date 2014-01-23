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
public class ViiniTest {
    Viini viini;
    
    public ViiniTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        viini = new Viini("EstEstEst", "valkoviini");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void konstruktoriAsettaaParametriinOikeanNimen() {
        assertEquals("EstEstEst", viini.getNimi());
    }
    
    @Test
    public void konstruktoriAsettaaParametriinOikeanTyypin() {
        assertEquals("valkoviini", viini.getTyyppi());
    }
    
    @Test
    public void konstruktoriLuoViinilleTyhjanArvostelulistan() {
        assertTrue(viini.getArvostelut().isEmpty());
    }
    
    @Test
    public void toStringToimii() {
        viini.setLajike("chardonnay");
        viini.setMaa("Italia");
        viini.setVuosi(2012);
        assertEquals("Tyyppi: valkoviini\nNimi: EstEstEst\nLajike: chardonnay\nVuosi: 2012", viini.toString());
    }
    
    @Test
    public void metodiLisaaArvosteluLisaaArvostelunListaan() {
        viini.lisaaArvostelu(new Arvostelu(70));
        viini.lisaaArvostelu(new Arvostelu(40));
        viini.lisaaArvostelu(new Arvostelu(100));
        
        assertEquals(3, viini.getArvostelut().size());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void metodiLisaaArvosteluLisaaLuvattomanArvostelunListaan() {
        viini.lisaaArvostelu(new Arvostelu(10));
        viini.lisaaArvostelu(new Arvostelu(50));        
        assertEquals(1, viini.getArvostelut().size());
    }
    
    @Test
    public void getKeskiarvoToimii() {
        viini.lisaaArvostelu(new Arvostelu(40));
        viini.lisaaArvostelu(new Arvostelu(100));
        viini.lisaaArvostelu(new Arvostelu(60));
        assertEquals(66.7, viini.getKeskiarvo(), 0.1);
    }
    
    @Test
    public void compareToToimii1() {
        Viini viini2 = new Viini("Blue Nun", "valkoviini");
        viini2.lisaaArvostelu(new Arvostelu(89));
        viini2.lisaaArvostelu(new Arvostelu(70));
        viini.lisaaArvostelu(new Arvostelu(70));
        viini.lisaaArvostelu(new Arvostelu(100));
        assertEquals(1, viini.compareTo(viini2));
    }
    @Test(expected=IllegalArgumentException.class)
    public void compareToToimii2() {
        Viini viini2 = new Viini("Blue Nun", "valkoviini");
        viini2.lisaaArvostelu(new Arvostelu(50));
        viini2.lisaaArvostelu(new Arvostelu(50));
        viini2.lisaaArvostelu(new Arvostelu(10));
        viini.lisaaArvostelu(new Arvostelu(50));
        viini.lisaaArvostelu(new Arvostelu(50));
        assertEquals(0, viini.compareTo(viini2));
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
