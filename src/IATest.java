import org.testng.Assert;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by Josu on 18/03/2017.
 */
public class IATest {

    IA iaFacil, iaMedio, iaDificil;

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

        iaFacil = new IA(fl,larmas,"facil");
        iaMedio = new IA(fl, larmas, "medio");
        iaDificil = new IA(fl, larmas, "dificil");
    }

    @org.testng.annotations.AfterMethod
    public void tearDown() throws Exception {
        iaFacil = null;
        iaMedio = null;
        iaDificil = null;
    }

    @org.testng.annotations.Test
    public void getDificil() throws Exception{
        Assert.assertEquals(iaFacil.getDificultad(), "facil", "La dificultad deberia ser facil");
        Assert.assertEquals(iaMedio.getDificultad(), "medio", "La dificultad deberia ser medio");
        Assert.assertEquals(iaDificil.getDificultad(), "dificil", "La dificultad deberia ser dificil");
    }

    @org.testng.annotations.Test
    public void testJugarTurnoIA() throws Exception {


    }

    @org.testng.annotations.Test
    public void testColocarBarcosIA() throws Exception {

    }

}