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
public class ArvosteluTest {
    Arvostelu arvio;
    
    public ArvosteluTest() {
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
    
    
    
    @Test(expected=IllegalArgumentException.class) 
    public void konstruktoriEiAsetaLaitontaArvosanaa() {
        arvio = new Arvostelu(-40);        
    }
    
    @Test
    public void konstruktoriAsettaaParametrinOikein() {
        arvio = new Arvostelu(100);
        assertEquals(100, this.arvio.getArvosana());
    }
    
    @Test
    public void getTiedostomuotoToimii() {
        arvio = new Arvostelu(40);
        arvio.setKommentti("aivan liian makea, juomakelvoton");
        assertEquals("40:aivan liian makea, juomakelvoton", this.arvio.getTiedostomuoto());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
