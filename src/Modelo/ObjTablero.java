package Modelo;

/**
 * Created by Josu on 14/04/2017.
 */
public class ObjTablero {

    protected boolean visible;

    public ObjTablero() {
        this.visible = false;
    }

    public boolean getVisible(){
        return this.visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
