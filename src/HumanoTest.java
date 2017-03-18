import org.testng.Assert;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by Josu on 18/03/2017.
 */
public class HumanoTest {

    Humano h1, h2;

    @org.testng.annotations.BeforeMethod
    public void setUp() throws Exception {
        Flota fl = new Flota(new Portaaviones("portaaviones"),new Submarino("sub1"),new Submarino("sub2"),new Destructor("destr1"),new Destructor("destr2"),new Destructor("destr3"),new Fragata("frag1"),new Fragata("frag2"),new Fragata("frag3"),new Fragata("frag4"));

        HashMap<String, Stack<Arma>> larmas = new HashMap<>();
        Stack<Arma> stackMisil = new Stack<>();
        stackMisil.push(new Misil());
        Stack<Arma> stackMisildir = new Stack<>();
        stackMisildir.push(new MisilDir());
        Stack<Arma> stackBomba = new Stack<>();
        stackBomba.push(new Bomba());
        larmas.put("misil", stackMisil);
        larmas.put("misilDir", stackMisildir);
        larmas.put("bomba",stackBomba);

        h1 = new Humano(fl,larmas,"Josu");
        Stack<Arma> stackRadar = new Stack<>();
        stackRadar.push(new Radar());
        h2 = new Humano(fl, larmas, "David");
    }

    @org.testng.annotations.AfterMethod
    public void tearDown() throws Exception {
        h1 = null;
        h2 = null;
    }

    @org.testng.annotations.Test
    public void testGetNombre() throws Exception {
        Assert.assertEquals(h1.getNombre(), "Josu", "El nombre deberia de ser -Josu-");
        Assert.assertEquals(h2.getNombre(), "David", "El nombre deberia de ser -David-");
    }

    @org.testng.annotations.Test
    public void testJugarTurno() throws Exception {

    }

    @org.testng.annotations.Test
    public void testColocarBarcos() throws Exception {

    }

}