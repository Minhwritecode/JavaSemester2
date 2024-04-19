package OOPExercise61;

public class ShapeTest {
    public static void main(String[] args) {
        Shape circle = new Circle("Red", true, 5.0);
        System.out.println(circle); // Output: Circle{color='Red', filled=true, radius=5.0}
        System.out.println("Area: " + circle.getArea()); // Output: Area: 78.53981633974483
        System.out.println("Perimeter: " + circle.getPerimeter()); // Output: Perimeter: 31.41592653589793

        Shape rectangle = new Rectangle("Blue", false, 4.0, 6.0);
        System.out.println(rectangle); // Output: Rectangle{color='Blue', filled=false, width=4.0, length=6.0}
        System.out.println("Area: " + rectangle.getArea()); // Output: Area: 24.0
        System.out.println("Perimeter: " + rectangle.getPerimeter()); // Output: Perimeter: 20.0

        Shape square = new Square("Green", true, 3.0);
        System.out.println(square); // Output: Square{color='Green', filled=true, side=3.0}
        System.out.println("Area: " + square.getArea()); // Output: Area: 9.0
        System.out.println("Perimeter: " + square.getPerimeter()); // Output: Perimeter: 12.0
    }
}
