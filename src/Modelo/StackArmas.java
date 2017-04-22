package Modelo;

/**
 * Created by Josu on 22/04/2017.
 */
public class StackArmas<T> {

    private int maxSize;
    private T[] stackArray;
    private int top;


    public StackArmas(int maxSize) {
        this.maxSize = maxSize;
        this.stackArray = (T[]) (new Object[maxSize]);
        top = -1;
    }

    public void push(T elem) {
        stackArray[++top] = elem;
    }

    public T pop() {
        return stackArray[top--];
    }

    public T peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public int size() {
        return (1 + top);
    }

    public int getMaxSize() {
        return maxSize;
    }
}
