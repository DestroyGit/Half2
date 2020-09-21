package Interfaces;

public class Robot implements Movable {
    @Override
    public void run() {
        System.out.println("Robot run");
    }

    @Override
    public void jump() {
        System.out.println("Robot jump");
    }
}
