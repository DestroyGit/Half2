package Exceptions;

public class MyArraySizeException  extends RuntimeException{
    private int n;

    public int getN() {
        return n;
    }

    public MyArraySizeException(int n) {
        this.n = n;
    }

    public MyArraySizeException(String message, int n) {
        super(message);
        this.n = n;
    }
}
