package Interfaces;

public class Main {
    public static void main(String[] args) {

        Movable [] movables = {
                new Cat(120, 2),
                new Robot(300, 0.7),
                new Man(500, 1.5),
                new Cat(160, 1),
                new Robot(50, 0.2),
                new Man(110, 1.3),
                new Cat(300, 2.5),
                new Robot(1000, 6),
                new Man(250, 1)
        };
        Let [] lets = {
                new Wall(0.5),
                new Treadmill(100),
                new Wall(1.2),
                new Treadmill(200),
                new Wall(1.5),
                new Treadmill(300)
        };
        for (Movable m : movables) {
            for (Let l : lets) {
                if(l instanceof Wall && !m.jump(((Wall) l).getHeight())){
                    break;
                }
                if(l instanceof Treadmill && !m.run(((Treadmill) l).getLength())){
                    break;
                }

            }
            System.out.println();

        }

    }
}
