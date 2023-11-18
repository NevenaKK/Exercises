package geometricShapes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("\nArray of shapes : ");

        Shapes[] niz = {
                new Rectangle(2, 3),
                new Square(new Point(3, 4), 7),
                new Ellipse(new Point(3, 9), 5, 7),
                new Circle(4),
                new Triangle(new Point(1, 3), new Point(3, 5), new Point(7, 3))
        };

        for (Shapes el : niz)
            System.out.println(el);


        List<Shapes> shapes = new ArrayList<>();
        shapes.add(new Rectangle(2, 3));
        shapes.add(new Square(new Point(3, 6), 1));
        shapes.add(new Circle(new Point(3, 9), 1));
        shapes.add(new Rectangle(new Point(3, 4), 7, 3));
        shapes.add(new Circle(new Point(2, 9), 6));
        shapes.add(new Ellipse(new Point(2, 9), 9,2));
        shapes.add(new Rectangle(new Point(1, 1), 3, 9));
        shapes.add(new Triangle(new Point(1, 3), new Point(3, 5), new Point(7, 3)));


        System.out.println("\nSorted shapes : ");

        Collections.sort(shapes);
        for (Shapes el : shapes)
            System.out.println(el);


        System.out.println("\nSorted points (centre of shapes) : ");


        List<Point> points = new ArrayList<>();
        for (Shapes s : shapes)
            points.add(s.getCentre());

        Collections.sort(points,Point.comparatorByXthenY);
        for(Point p:points)
            System.out.println(p);


    }







}

