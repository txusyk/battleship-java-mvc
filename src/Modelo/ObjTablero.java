package Modelo;

import java.util.Observable;

/**
 * Created by Josu on 14/04/2017.
 */
public class ObjTablero extends Observable {

    protected boolean visible = false;

    public ObjTablero() {
    }

    public boolean getVisible(){
        return this.visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
        setChanged();
        notifyObservers();
    }
}
