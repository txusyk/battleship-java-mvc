package Modelo;

/**
 * Created by Josu on 22/05/2017.
 */
public class ExcepcionFicheros extends Exception {

    public ExcepcionFicheros() {
        super("El fichero que tratas de abrir no existe, trata de copiar en la ruta correcta el fichero entregado con el ejecutable");
    }

    public ExcepcionFicheros(Throwable cause) {
        super(cause);
    }

    public ExcepcionFicheros(String message, Throwable cause) {
        super(message, cause);
    }
}