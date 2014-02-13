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
        
    }

    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriAsettaaParametriinOikeanNimen() {
        viini = new Viini("valkoviini", "EstEstEst", "laji", "suomi", "2012");
        assertEquals("EstEstEst", viini.getNimi());
    }

    @Test
    public void konstruktoriAsettaaParametriinOikeanTyypin() {
        viini = new Viini("valkoviini", "EstEstEst", "laji", "suomi", "2012");
        assertEquals("valkoviini", viini.getTyyppi());
    }

    @Test
    public void konstruktoriAsettaaParametriinOikeanLajikkeen() {
        viini = new Viini("valkoviini", "EstEstEst", "laji", "suomi", "2012");
        assertEquals("laji", viini.getLajike());
    }

    @Test
    public void konstruktoriAsettaaParametriinOikeanVuoden() {
        viini = new Viini("valkoviini", "EstEstEst", "laji", "suomi", "2012");
        assertEquals("2012", viini.getVuosi());
    }

    @Test
    public void konstruktoriAsettaaParametriinOikeanMaan() {
        viini = new Viini("valkoviini", "EstEstEst", "laji", "suomi", "2012");
        assertEquals("suomi", viini.getMaa());
    }

    @Test
    public void konstruktoriLuoViinilleTyhjanArvostelulistan() {
        viini = new Viini("valkoviini", "EstEstEst", "laji", "suomi", "2012");
        assertTrue(viini.getArvostelut().isEmpty());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void konstruktoriIlmoittaaPuuttuvistaTiedoista() {
        viini = new Viini(null, "nimi2", "lajike2", "maa2", "vuosi2");
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void konstruktoriIlmoittaaPuuttuvistaTiedoista2() {
        viini = new Viini("tyyppi", null, "lajike2", "maa2", "vuosi2");
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void konstruktoriIlmoittaaPuuttuvistaTiedoista3() {
        viini = new Viini("tyyppi", "nimi2", null, "maa2", "vuosi2");
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void konstruktoriIlmoittaaPuuttuvistaTiedoista4() {
        viini = new Viini("tyyppi", "nimi2", "lajike2", null, "vuosi2");
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void konstruktoriIlmoittaaPuuttuvistaTiedoista5() {
        viini = new Viini("tyyppi", "nimi2", "lajike2", "maa2", null);
    }

    @Test
    public void toStringToimii() {
        viini = new Viini("valkoviini", "EstEstEst", "laji", "suomi", "2012");
        assertEquals("\nTyyppi: valkoviini\nNimi: EstEstEst\nLajike: laji\nMaa: suomi\nVuosi: 2012\n", viini.toString());
    }

    @Test
    public void metodiLisaaArvosteluLisaaArvostelunListaan() {
        viini = new Viini("valkoviini", "EstEstEst", "laji", "suomi", "2012");
        viini.lisaaArvostelu(new Arvostelu(70));
        viini.lisaaArvostelu(new Arvostelu(40));
        viini.lisaaArvostelu(new Arvostelu(100));
        assertEquals(3, viini.getArvostelut().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void metodiLisaaArvosteluLisaaLuvattomanArvostelunListaan() {
        viini = new Viini("valkoviini", "EstEstEst", "laji", "suomi", "2012");
        viini.lisaaArvostelu(new Arvostelu(10));
        viini.lisaaArvostelu(new Arvostelu(50));
        assertEquals(1, viini.getArvostelut().size());
    }

    @Test
    public void getKeskiarvoToimii() {
        viini = new Viini("valkoviini", "EstEstEst", "laji", "suomi", "2012");
        viini.lisaaArvostelu(new Arvostelu(40));
        viini.lisaaArvostelu(new Arvostelu(100));
        viini.lisaaArvostelu(new Arvostelu(60));
        assertEquals(66.7, viini.getKeskiarvo(), 0.1);
    }

    @Test
    public void compareToToimii1() {
        viini = new Viini("valkoviini", "EstEstEst", "laji", "suomi", "2012");
        Viini viini2 = new Viini("valkoviini", "Blue Nun", "laji2", "italia", "2001");
        viini2.lisaaArvostelu(new Arvostelu(89));
        viini2.lisaaArvostelu(new Arvostelu(70));
        viini.lisaaArvostelu(new Arvostelu(70));
        viini.lisaaArvostelu(new Arvostelu(100));
        assertEquals(-1, viini.compareTo(viini2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void compareToToimii2() {
        viini = new Viini("valkoviini", "EstEstEst", "laji", "suomi", "2012");
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
        viini = new Viini("valkoviini", "EstEstEst", "laji", "suomi", "2012");
        assertEquals("valkoviini:EstEstEst:laji:suomi:2012\n", this.viini.getTiedostomuoto());
    }

    @Test
    public void getNimiJaArvosteluTiedostomuotoToimii() {
        viini = new Viini("valkoviini", "EstEstEst", "laji", "suomi", "2012");
        Arvostelu a = new Arvostelu(66);
        a.setKommentti("mukavan kuiva maku");
        this.viini.lisaaArvostelu(a);
        assertEquals("EstEstEst:66:mukavan kuiva maku\n", this.viini.getNimiJaArvosteluTiedostomuoto());
    }
    
    public void getNimiJaArvosteluTiedostomuotoToimii2() {
        viini = new Viini("valkoviini", "EstEstEst", "laji", "suomi", "2012");
        Arvostelu a = new Arvostelu(66);
        a.setKommentti("mukavan kuiva maku");
        this.viini.lisaaArvostelu(a);
        Arvostelu arvio = new Arvostelu(88);
        arvio.setKommentti("pirskahteleva");
        this.viini.lisaaArvostelu(arvio);
        assertEquals("EstEstEst:66:mukavan kuiva maku\nEstEstEst:88:pirskahteleva\n", this.viini.getNimiJaArvosteluTiedostomuoto());
    }

    @Test
    public void getNimiJaArvosteluTiedostomuotoToimiiJosEiArvosteluja() {
        viini = new Viini("valkoviini", "EstEstEst", "laji", "suomi", "2012");
        assertEquals("", this.viini.getNimiJaArvosteluTiedostomuoto());
    }
    
    @Test
    public void stringArvostelutToimii() {
        viini = new Viini("valkoviini", "EstEstEst", "laji", "suomi", "2012");
        Arvostelu arvio = new Arvostelu(79);
        arvio.setKommentti("hedelmäinen");
        viini.lisaaArvostelu(arvio);
        assertEquals("Arvosana: 79\nKommentti: hedelmäinen\n\n", viini.stringArvostelut());
    }
}
