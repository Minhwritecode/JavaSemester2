package OOPExercise64;

public class MovableCircle extends MovablePoint {
    private int radius;
    private int center;

    // Constructor
    public MovableCircle(int x, int y, int radius, int center) {
        super(x, y, radius, radius);
        this.radius = radius;
        this.center = center;
    }

    @Override
    public String toString() {
        return "MovableCircle: center = (" + getX() + ", " + getY() + "), radius = " + radius;
    }

	private String getX() {
		// TODO Auto-generated method stub
		return null;
	}

	private String getY() {
		// TODO Auto-generated method stub
		return null;
	}
}
