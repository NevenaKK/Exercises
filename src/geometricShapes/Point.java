package geometricShapes;

import java.util.Comparator;

public class Point {

    public final static Comparator<Point> comaratorByXthenY =new Comparator<Point>() {
        @Override
        public int compare(Point point, Point point1) {
            return point.x==point1.x ? Double.compare(point.y,point1.y) : Double.compare(point.x,point1.x);
        }
    };

    public final static Comparator<Point> comaratorByYthenX =new Comparator<Point>() {
        @Override
        public int compare(Point point, Point point1) {
            return point.y==point1.y ? Double.compare(point.x,point1.x) : Double.compare(point.y,point1.y);
        }
    };
    private double x, y;

    public Point() {
        this(0, 0);
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point point) {
        this(point.x, point.y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }


    public boolean equals(Point point) {
        return equals(this,point);
    }
    public static boolean equals(Point p1,Point p2){
        return p1.x==p2.x && p1.y== p2.y;
    }

    public double distance(Point point) {
        return distance(this,point);
    }
    public static double distance(Point p1,Point p2){
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    public void translate(double dx,double dy) {
        this.x+=dx;
        this.y+=dy;
    }


    @Override
    public String toString() {
        return "( " + x + " , " + y + " )";
    }

}
