package Modelo;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

/**
 * Created by Josu on 18/04/2017.
 */
public class GestorFicherosTest {

    @BeforeClass
    public void setUp() throws TransformerException, ParserConfigurationException {
        GestorFicheros.getMyGestorFicheros().añadirUsuario("josu", "0000".toCharArray());
        GestorFicheros.getMyGestorFicheros().añadirUsuario("josu", "1111".toCharArray());
    }

    @Test
    public void testGetMyGestorFicheros() throws Exception {
        Assert.assertNotNull(GestorFicheros.getMyGestorFicheros());
    }

    @Test
    public void añadirUsuario() throws Exception {
        Assert.assertTrue(GestorFicheros.getMyGestorFicheros().estaUsuario("josu"));
        Assert.assertTrue(GestorFicheros.getMyGestorFicheros().comprobarLogin("josu", "0000".toCharArray()));
        Assert.assertFalse(GestorFicheros.getMyGestorFicheros().comprobarLogin("josu", "1111".toCharArray()));
    }

    @Test
    public void eliminarUsuario() throws Exception {
        Assert.assertTrue(GestorFicheros.getMyGestorFicheros().estaUsuario("josu"));
        GestorFicheros.getMyGestorFicheros().eliminarJugadorXML("josu");
        Assert.assertFalse(GestorFicheros.getMyGestorFicheros().estaUsuario("josu"));
    }

    @Test
    public void testComprobarLogin() throws Exception {
        Assert.assertTrue(GestorFicheros.getMyGestorFicheros().comprobarLogin("admin", "1234".toCharArray()));
        Assert.assertFalse(GestorFicheros.getMyGestorFicheros().comprobarLogin("admin", "4321".toCharArray()));
    }

    @Test
    public void testEstaUsuario() throws Exception {
        Assert.assertTrue(GestorFicheros.getMyGestorFicheros().estaUsuario("admin"));
        Assert.assertFalse(GestorFicheros.getMyGestorFicheros().estaUsuario("pepe"));
    }

}