package geometricShapes;

import java.text.DecimalFormat;

public abstract class Shapes implements Comparable<Shapes> {



    private Point centre;

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

    public static final DecimalFormat df=new DecimalFormat("0.00");


    @Override
    public int compareTo(Shapes shapes) {
        return comparableByInstance(this,shapes);
    }

    public static int comparableByInstance(Shapes s1,Shapes s2){

        if(s1 instanceof Rectangle r1 && s2 instanceof  Rectangle r2){
            return r1.getWidth()==r2.getWidth() ? Double.compare(r1.getHeight(),r2.getHeight())
                    : Double.compare(r1.getWidth(),r2.getWidth());
        }else if(s1 instanceof Rectangle && s2 instanceof Ellipse){
            return -1;
        }else if(s1 instanceof Ellipse && s2 instanceof Rectangle){
            return 1;
        }else if (s1 instanceof Ellipse e1 && s2 instanceof Ellipse e2) {

            return e1.getA() == e2.getA() ? Double.compare(e1.getB(), e2.getB())
                    : Double.compare(e1.getA(), e2.getA());
        }else if(s1 instanceof Rectangle && s2 instanceof  Triangle) {
            return -1;
        }else if(s1 instanceof Triangle && s2 instanceof  Rectangle) {
            return 1;
        }else if(s1 instanceof Ellipse && s2 instanceof  Triangle) {
            return -1;
        }else if(s1 instanceof Triangle && s2 instanceof  Ellipse) {
            return 1;
        }else {
            Triangle t1 = (Triangle) s1;
            Triangle t2 = (Triangle) s2;

            return Double.compare(t1.getArea(), t2.getArea());
        }
    }
}
