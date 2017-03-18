import junit.framework.Assert;


/**
 * Created by Josu on 18/03/2017.
 */
class KeyboardTest{

    @org.junit.jupiter.api.Test
    void getMyKeyboard() {
        Assert.assertNotNull(Keyboard.getMyKeyboard());
    }

    @org.junit.jupiter.api.Test
    void getInt() {
        System.out.println("Introduciremos un 2 para la siguiente prueba");
        Assert.assertEquals(Keyboard.getMyKeyboard().getInt(),2);
    }

    @org.junit.jupiter.api.Test
    void getString() {
        System.out.println("Introduciremos 'prueba' para el test");
        Assert.assertEquals(Keyboard.getMyKeyboard().getString(), "prueba", "Deberia ser 'prueba'");
    }

    @org.junit.jupiter.api.Test
    void getOptionFromRange() {
        System.out.println("Introduciremos 5. Que es el numero medio entre 0 y 10. Que es el rango establecido para el test");
        Assert.assertEquals(Keyboard.getMyKeyboard().getOptionFromRange(0,10),5);
    }

    @org.junit.jupiter.api.Test
    void catchYesNo() {
        System.out.println("Introduciremos 'Y' para la primera prueba");
        Assert.assertTrue(Keyboard.getMyKeyboard().catchYesNo());

        System.out.println("Introduciremos 'N' para la segunda prueba");
        Assert.assertFalse(Keyboard.getMyKeyboard().catchYesNo());
    }

}