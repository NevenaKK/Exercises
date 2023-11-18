package geometricShapes;

import java.util.Comparator;

public class Point {

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


    public static boolean equals(Point p1,Point p2){
        return p1.x==p2.x && p1.y== p2.y;
    }

    public boolean equals(Point point) {
        return equals(this,point);
    }

    public static double distance(Point p1,Point p2){
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    public double distance(Point point) {
        return distance(this,point);
    }


    public void translate(double dx,double dy) {
        this.x+=dx;
        this.y+=dy;
    }

    @Override
    public String toString() {
        return "( " + x + " , " + y + " )";
    }


    public static Comparator<Point> comparatorByXthenY =new Comparator<Point>() {
        @Override
        public int compare(Point p1, Point p2) {
            return p1.x==p2.x ? Double.compare(p1.y,p2.y) : Double.compare(p1.x,p2.x);
        }
    };

    public static Comparator<Point> comparatorByYthenX =new Comparator<Point>() {
        @Override
        public int compare(Point p1, Point p2) {
            return p1.y==p2.y ? Double.compare(p1.x,p2.x) : Double.compare(p1.y,p2.y);
        }
    };


}
