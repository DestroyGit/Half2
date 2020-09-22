package Interfaces;

public class Robot implements Movable {
    private int run;
    private double jump;

    public Robot(int run, double jump) {
        this.run = run;
        this.jump = jump;
    }

    @Override
    public boolean run(int let) {
        if (this.run >= let) {
            System.out.printf("Робот со способностью пробежать %d метров пробежал %d метров\n", this.run, let);
            return true;
        } else{
            System.out.printf("Робот со способностью пробежать %d метров НЕ СМОГ пробежать %d метров и сходит с дистанции\n", this.run, let);
            return false;
        }
    }

    @Override
    public boolean jump(double let) {
        if (this.jump >= let) {
            System.out.printf("Робот с прыжком %.1f метров перепрыгнул через стену в %.1f метров\n", this.jump, let);
            return true;
        } else {
            System.out.printf("Робот с прыжком %.1f метров НЕ СМОГ перепрыгнуть через стену в %.1f метров и сходит с дистанции\n", this.jump, let);
            return false;
        }
    }
}
