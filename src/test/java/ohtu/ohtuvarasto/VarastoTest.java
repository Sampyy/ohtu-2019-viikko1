package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
    @Test
    public void tilavuusEiYlity() {
        varasto.lisaaVarastoon(8);
        varasto.lisaaVarastoon(8);
        assertEquals(0, varasto.paljonkoMahtuu(),vertailuTarkkuus);
    }
    
    @Test
    public void tilavuusEiYlity2() {
        varasto.lisaaVarastoon(15);
        assertEquals(0, varasto.paljonkoMahtuu(),vertailuTarkkuus);
    }
    
    @Test
    public void otaEnemmanKuinOn() {
        varasto.lisaaVarastoon(5);
        assertEquals(5, varasto.otaVarastosta(15), vertailuTarkkuus);
    }
    
    @Test
    public void otaVarastostaNegatiivinen() {
        assertEquals(0, varasto.otaVarastosta(-5), vertailuTarkkuus);
    }
    
    @Test
    public void lisaaVarastoonNegatiivinen() {
        varasto.lisaaVarastoon(-5);
        assertEquals(10, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
    @Test
    public void varastonLisaaminenToimii()  {
        Varasto varvasto = new Varasto(10,0);
        assertEquals(10, varvasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
    @Test
    public void varastonAlkusaldoToimii() {
        Varasto varvasto = new Varasto(10, 5);
        assertEquals(5, varvasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
    @Test
    public void varastonAlkutilavuusEiPositiivinen() {
        Varasto varvasto = new Varasto(-5);
        assertEquals(0, varvasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
    @Test
    public void varastonAlkutilavuusEiPositiivinen2() {
        Varasto varvasto = new Varasto(-5, 0);
        assertEquals(0, varvasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
    @Test
    public void varastonAlkuSaldoEiPositiivinen() {
        Varasto varvasto = new Varasto(10, -5);
        assertEquals(10, varvasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
    @Test
    public void varastonAlkusaldoSuurempiKuinTilavuus()     {
        Varasto varvasto = new Varasto(5, 10);
        assertEquals(0, varvasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
   
    @Test
    public void toStringToimii() {
        assertEquals("saldo = 0.0, vielä tilaa 10.0", varasto.toString());
    }
    

}