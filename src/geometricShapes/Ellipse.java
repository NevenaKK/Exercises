package geometricShapes;

public class Ellipse extends Shapes{
    private double a,b;

    public Ellipse(double a, double b) {
       init(a,b);
    }



    public Ellipse(Point centre, double a, double b) {
        super(centre);
       init(a,b);
    }

    private void init(double a,double b){
        this.a =a;
        this.b =b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    @Override
    public double getArea() {
        double tmp =a*b*Math.PI;
        return Double.parseDouble(df.format(tmp));
    }

    @Override
    public double getPerimeter() {
        double tmp =Math.PI*(3*(a+b)-Math.sqrt((3*a+b)*(a+3*b)));
        return Double.parseDouble(df.format(tmp));
    }

    @Override
    public String toString() {
        return super.toString()+ " | Ellipse : a = "+a+" , b = "+b;
    }
}
