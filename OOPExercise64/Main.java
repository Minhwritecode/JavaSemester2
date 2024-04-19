package OOPExercise64;

public class Main {
    public static void main(String[] args) {
        MovablePoint point = new MovablePoint(0, 0, 0, 0);
        MovableCircle circle = new MovableCircle(3, 4, 5, 0);

        System.out.println("Initial state:");
        System.out.println(point);
        System.out.println(circle);

        System.out.println("Moving up...");
        point.moveUp();
        circle.moveUp();

        System.out.println("After moving up:");
        System.out.println(point);
        System.out.println(circle);

        System.out.println("Moving left...");
        point.moveLeft();
        circle.moveLeft();

        System.out.println("After moving left:");
        System.out.println(point);
        System.out.println(circle);
    }
}