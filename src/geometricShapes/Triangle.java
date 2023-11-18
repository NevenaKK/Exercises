package geometricShapes;

public class Triangle extends Shapes{

    private Point A,B,C;

    public Triangle(Point A,Point B,Point C) {
        init(A,B,C);
    }

    public Triangle(Point centre, Point a, Point b, Point c) {
        super(centre);
        init(a,b,c);
    }

    private void init(Point A,Point B,Point C){
        this.A = A;
        this.B = B;
        this.C = C;
    }

    public Point getA() {
        return A;
    }

    public Point getB() {
        return B;
    }

    public Point getC() {
        return C;
    }

    public double getAB(){
        return Double.parseDouble(df.format(A.distance(B)));
    }
    public double getAC(){
        return Double.parseDouble(df.format(A.distance(C)));
    }
    public double getBC(){
        return Double.parseDouble(df.format(C.distance(B)));
    }


    @Override
    public double getArea() {
        double s=(getAB()+getBC()+getAC())/2.0;
        double tmp= Math.sqrt(s*(s-getAC())*(s-getBC())*(s-getAB()));

        return Double.parseDouble(df.format(tmp));
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
