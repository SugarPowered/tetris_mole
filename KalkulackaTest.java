

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class KalkulackaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class KalkulackaTest {
    private Kalkulacka kalkulac1;

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        kalkulac1 = new Kalkulacka();
    }
    
    @Test
    public void zadavanieCisla() {
        double cislo = 1.0;
        this.kalkulac1.zadajCislo(cislo);
        assertEquals(this.kalkulac1.getOperand(),cislo, 0.0);
    }
    
    @Test
    public void zadavanieOperacie() {
        char operacia = '2';
        this.kalkulac1.zadajCislo(3);
        this.kalkulac1.zadajOperaciu(operacia);
        assertEquals(this.kalkulac1.getVysledok(), 9, 0.0);
    }
    
    @Test
    public void delenieNulou() {
        this.kalkulac1.zadajCislo(6);
        this.kalkulac1.zadajOperaciu('/');
        this.kalkulac1.zadajCislo(0);
        boolean vysledok = this.kalkulac1.zadajOperaciu('=');
        assertFalse(vysledok);
    }
    
    @Test
    public void operaciaDelenia() {
        this.kalkulac1.zadajCislo(1);
        this.kalkulac1.zadajOperaciu('/');
        this.kalkulac1.zadajCislo(5);
        this.kalkulac1.zadajOperaciu('=');
        double vysledok = this.kalkulac1.getVysledok();
        assertEquals(vysledok, 0.2, 0.0);
    }
    
    @Test
    public void operaciaScitania() {
        this.kalkulac1.zadajCislo(1);
        this.kalkulac1.zadajOperaciu('+');
        this.kalkulac1.zadajCislo(5);
        this.kalkulac1.zadajOperaciu('=');
        double vysledok = this.kalkulac1.getVysledok();
        assertEquals(vysledok, 6, 0);
    }
    
    @Test
    public void operaciaOdcitania() {
        this.kalkulac1.zadajCislo(5);
        this.kalkulac1.zadajOperaciu('-');
        this.kalkulac1.zadajCislo(2);
        this.kalkulac1.zadajOperaciu('=');
        double vysledok = this.kalkulac1.getVysledok();
        assertEquals(vysledok, 3, 0);
    }
    
    @Test
    public void operaciaNasobenie() {
        this.kalkulac1.zadajCislo(3);
        this.kalkulac1.zadajOperaciu('*');
        this.kalkulac1.zadajCislo(3);
        this.kalkulac1.zadajOperaciu('=');
        double vysledok = this.kalkulac1.getVysledok();
        assertEquals(vysledok, 9, 0);
    }
    
    @Test
    public void faktorial() {
        this.kalkulac1.zadajCislo(-6);
        this.kalkulac1.zadajOperaciu('!');
        boolean vysledok = this.kalkulac1.zadajOperaciu('=');
        System.out.println(this.kalkulac1.getVysledok());
        assertTrue(vysledok);
    }
}
