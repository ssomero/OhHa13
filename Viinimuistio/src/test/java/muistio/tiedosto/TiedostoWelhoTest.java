/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muistio.tiedosto;

import muistio.viinimuistio.Viini;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Sonja
 */
public class TiedostoWelhoTest {

    TiedostoWelho tw;

    public TiedostoWelhoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        tw = new TiedostoWelho();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void tiedostoonKirjoittaminenOnnistuu() throws Exception {
        Viini viini = new Viini("tyyppi", "nimi", "lajike6", "maa", "vuosi");
       
        int alkukoko = tw.lueViinit().listaaViinit().size();
        tw.lueViinit().lisaaViini(viini);
        tw.kirjoitaViini();      
        int uusikoko = tw.lueViinit().listaaViinit().size();
        assertEquals(alkukoko + 1, uusikoko);
      tw.lueViinit().poistaViini(viini);
        tw.kirjoitaViini();
    }
}
