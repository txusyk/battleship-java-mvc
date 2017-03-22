import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Stack;

import static org.testng.Assert.*;

/**
 * Created by Josu on 19/03/2017.
 */
public class IATest {

    IA ia1,ia2;

    @BeforeMethod
    public void setUp() throws Exception {
        Portaaviones p = new Portaaviones("portaaviones");
        Submarino s1 = new Submarino("sub1");
        Submarino s2 = new Submarino("sub2");
        Destructor d1 = new Destructor("destruc1");
        Destructor d2 = new Destructor("destruc2");
        Destructor d3 = new Destructor("destruc3");
        Fragata frag1 = new Fragata("frag1");
        Fragata frag2 = new Fragata("frag2");
        Fragata frag3 = new Fragata("frag3");
        Fragata frag4 = new Fragata("frag4");
        Flota fl = new Flota(p,s1,s2,d1,d2,d3,frag1,frag2,frag3,frag4);

        HashMap<String, Stack<Arma>> larmas = new HashMap<>();
        Radar r1 = new Radar();
        Stack<Arma> armas = new Stack<>();
        armas.push(r1);
        larmas.put("radar", armas);

        ia1 = new IA(fl,larmas);

        armas = new Stack<>();
        Misil m1 = new Misil();
        Misil m2 = new Misil();
        armas.push(m1);
        armas.push(m2);
        larmas.put("misil", armas);

        ia2 = new IA(fl,larmas);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        ia1 = null;
        ia2 = null;
    }

    @Test
    public void testGetDificultad() throws Exception {
        Assert.assertEquals("facil", ia1.getDificultad(), "La dificiltad deberia de ser 'facil'");
        Assert.assertEquals("dificil",ia2.getDificultad(), "La dificultad deberia de ser 'dificil'");
    }

    @Test
    public void testJugarTurnoIA() throws Exception {


    }

    @Test
    public void testColocarBarcosIA() throws Exception {

    }

}