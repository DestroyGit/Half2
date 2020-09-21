package Interfaces;

public class Man implements Movable{
    @Override
    public void run() {
        System.out.println("Man run");
    }

    @Override
    public void jump() {
        System.out.println("Man jump");
    }
}
