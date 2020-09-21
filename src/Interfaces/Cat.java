package Interfaces;

public class Cat implements Movable {
    @Override
    public void run() {
        System.out.println("Cat run");
    }

    @Override
    public void jump() {
        System.out.println("Cat jump");
    }
}
