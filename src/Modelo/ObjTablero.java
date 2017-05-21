package Modelo;

import java.util.Observable;

/**
 * Created by Josu on 14/04/2017.
 */
public class ObjTablero extends Observable {

    protected boolean visible;

    protected int x, y;

    public ObjTablero() {
        this.visible = false;
    }

    public boolean getVisible(){
        return this.visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
        System.out.println(this.countObservers());
        setChanged();
        notifyObservers();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

