package geometricShapes;

public class Circle extends Ellipse {


    public Circle(double r) {
        super(r,r);
    }

    public Circle(Point centre, double r) {
        super(centre, r,r);
    }

    public double getR(){
        return getA();
    }

    @Override
    public String toString() {
        return  "Centre : "+getCentre().toString()+ " | Circle : r = "+getR() ;
    }
}