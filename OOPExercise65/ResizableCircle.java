package OOPExercise65;

public class ResizableCircle extends Circle implements Resizable {
    public ResizableCircle(double radius) {
        super(radius);
    }

    @Override
    public double resize(int percent) {
        double resizeFactor = (double) percent / 100;
        radius *= resizeFactor;
        return getArea();
    }
}
