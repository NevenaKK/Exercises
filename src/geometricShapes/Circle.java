package geometricShapes;

import java.text.DecimalFormat;

public class Circle extends Ellipse {

    DecimalFormat df =new DecimalFormat("0.00");

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
    public double getArea() {
        String str=df.format(getR()*getR()*Math.PI);
        return Double.parseDouble(str);
    }

    @Override
    public double getPerimeter() {
        String str=df.format(2*getR()*Math.PI);
        return Double.parseDouble(str);
    }

    @Override
    public String toString() {
        return  "Centre : "+getCentre().toString()+ " | Circle : r = "+getR() ;
    }
}