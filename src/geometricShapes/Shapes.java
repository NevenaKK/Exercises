package geometricShapes;

public abstract class Shapes implements Comparable<Shapes> {


    private final Point centre;

    public Shapes() {
        this(new Point());
    }

    public Shapes(double x, double y) {
        this.centre = new Point(x, y);
    }

    public Shapes(Point centre) {
        this.centre = centre;
    }


    public Point getCentre() {
        return centre;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    @Override
    public String toString() {
        return "Centre : " + centre.toString();
    }

    @Override
    public int compareTo(Shapes shapes) {
        return compareByInstance(this,shapes);
    }

    public static int compareByInstance(Shapes s, Shapes shapes) {
        if (s instanceof Rectangle r1 && shapes instanceof Rectangle r2) {
            return  r1.getWidth() == r2.getWidth() ?
                    (int) (r1.getHeight() - r2.getHeight()) :
                    (int) (r1.getWidth() - r2.getWidth());

        }
        else if (s instanceof Rectangle && shapes instanceof Ellipse) {
            return -1;
        } else if (s instanceof Ellipse && shapes instanceof Rectangle) {
            return 1;
        } else {

            Circle c1 = (Circle) s;
            Circle c2 = (Circle) shapes;

            return Double.compare(c1.getR(),c2.getR());

        }

}
}
