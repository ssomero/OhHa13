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
        viini = new Viini("valkoviini", "EstEstEst", "laji", "suomi", "2012");
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
    public void konstruktoriAsettaaParametriinOikeanLajikkeen() {
        assertEquals("laji", viini.getLajike());
    }

    @Test
    public void konstruktoriAsettaaParametriinOikeanVuoden() {
        assertEquals("2012", viini.getVuosi());
    }

    @Test
    public void konstruktoriAsettaaParametriinOikeanMaan() {
        assertEquals("suomi", viini.getMaa());
    }

    @Test
    public void konstruktoriLuoViinilleTyhjanArvostelulistan() {
        assertTrue(viini.getArvostelut().isEmpty());
    }

    @Test
    public void toStringToimii() {

        assertEquals("\nTyyppi: valkoviini\nNimi: EstEstEst\nLajike: laji\nMaa: suomi\nVuosi: 2012\n", viini.toString());
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
        Viini viini2 = new Viini("valkoviini", "Blue Nun", "laji2", "italia", "2001");
        viini2.lisaaArvostelu(new Arvostelu(89));
        viini2.lisaaArvostelu(new Arvostelu(70));
        viini.lisaaArvostelu(new Arvostelu(70));
        viini.lisaaArvostelu(new Arvostelu(100));
        assertEquals(-1, viini.compareTo(viini2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void compareToToimii2() {
        Viini viini2 = new Viini("valkoviini", "Blue Nun", "laji2", "italia", "2001");
        viini2.lisaaArvostelu(new Arvostelu(50));
        viini2.lisaaArvostelu(new Arvostelu(50));
        viini2.lisaaArvostelu(new Arvostelu(10));
        viini.lisaaArvostelu(new Arvostelu(50));
        viini.lisaaArvostelu(new Arvostelu(50));
        assertEquals(0, viini.compareTo(viini2));
    }

    @Test
    public void getTiedostomuotoToimii() {
        assertEquals("valkoviini:EstEstEst:laji:suomi:2012\n", this.viini.getTiedostomuoto());
    }

    @Test
    public void getNimiJaArvosteluTiedostomuotoToimii() {
        Arvostelu a = new Arvostelu(66);
        a.setKommentti("mukavan kuiva maku");
        this.viini.lisaaArvostelu(a);
        assertEquals("EstEstEst:66:mukavan kuiva maku\n", this.viini.getNimiJaArvosteluTiedostomuoto());
    }

    @Test
    public void getNimiJaArvosteluTiedostomuotoToimiiJosEiArvosteluja() {

        assertEquals("", this.viini.getNimiJaArvosteluTiedostomuoto());
    }
}
