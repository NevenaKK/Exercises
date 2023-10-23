package geometricShapes;

import java.text.DecimalFormat;

public class Triangle extends Shapes{

    DecimalFormat df=new DecimalFormat("#.##");
    private Point a,b,c;

    public Triangle(Point a, Point b, Point c) {
        init(a,b,c);
    }

    public Triangle(Point centre, Point a, Point b, Point c) {
        super(centre);
        init(a,b,c);
    }

    private void init(Point a,Point b,Point c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Point getC() {
        return c;
    }

    public double getAB(){
        return Double.parseDouble(df.format(a.distance(b)));
    }
    public double getAC(){
        return Double.parseDouble(df.format(a.distance(c)));
    }
    public double getBC(){
        return Double.parseDouble(df.format(c.distance(b)));
    }


    @Override
    public double getArea() {
        double s=(getAB()+getBC()+getAC())/2.0;
        double tmp= Math.sqrt(s*(s-getAC())*(s-getBC())*(s-getAB()));

        return (double) Math.round(tmp*100)/100;
    }

    @Override
    public double getPerimeter() {
        return getAB()+getAC()+getBC();
    }

    @Override
    public String toString() {
        return super.toString()+ " | Triangle : a = "+ getBC()+" b = "+getAC()+" c = "+getAB();
    }


}
