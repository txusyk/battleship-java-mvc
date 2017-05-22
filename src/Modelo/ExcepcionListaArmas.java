package Modelo;

/**
 * Created by Josu on 22/05/2017.
 */
public class ExcepcionListaArmas extends Exception {

    public ExcepcionListaArmas() {
        super("No se ha podido añadir el elemento, revise la configuración de la ListaArmas");
    }

}
