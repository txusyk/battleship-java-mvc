package Modelo;

import java.util.Stack;

/**
 * Created by Josu on 22/04/2017.
 */
public class StackArmas extends Stack {

    private int maxSize, actSize;
    private Stack<HerramientasJuego> stack;

    public StackArmas(int maxSize) {
        this.maxSize = maxSize;
        this.actSize = 0;
        stack = new Stack<>();
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getActSize() {
        return actSize;
    }

    public void add(HerramientasJuego pArma) {
        this.stack.add(pArma);
    }
}
