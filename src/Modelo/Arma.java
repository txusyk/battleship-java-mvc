package Modelo;

/**
 * Created by Josu on 03/04/2017.
 */
public abstract class Arma extends HerramientasJuego {

    protected int daño;

    public Arma(int pPrecio){
        super(pPrecio);
    }

    public abstract int disparar(ParteBarco pPos, Flota pFlota);
}
