package OOPExercise65;

public class TestResizableCircle {
    public static void main(String[] args) {
        ResizableCircle resizableCircle = new ResizableCircle(10);
        System.out.println("Original Area: " + resizableCircle.getArea());
        resizableCircle.resize(50);
        System.out.println("Resized Area: " + resizableCircle.getArea());
    }
}
