package Modelo;

/**
 * Created by Josu on 03/04/2017.
 */
public abstract class Arma extends HerramientasJuego {

    protected int daño;

    public Arma(){

    }

    public abstract void disparar(int x, int y);
}
