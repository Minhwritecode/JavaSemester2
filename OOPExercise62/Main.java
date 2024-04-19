package OOPExercise62;

public class Main {
    public static void main(String[] args) {
        double m = 6.0;
        Circle circle = new Circle(m);
        System.out.println(circle.toString());  // Output: Circle[ radius=5.0 ]
        System.out.println("Area: " + circle.getArea());  // Output: Area: 78.53981633974483
        System.out.println("Perimeter: " + circle.getPerimeter());  // Output: Perimeter: 31.41592653589793

        double a = 2.0;
        double b = 4.0;
        Rectangle rectangle = new Rectangle(a, b);
        System.out.println(rectangle.toString());  // Output: Rectangle [width=4.0, length=3.0]
        System.out.println("Area: " + rectangle.getArea());  // Output: Area: 12.0
        System.out.println("Perimeter: " + rectangle.getPerimeter());  // Output: Perimeter: 14.0
    }
}