package geometricShapes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println();
        System.out.println("Array of shapes : ");
        System.out.println();

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
        shapes.add(new Rectangle(new Point(3, 6), 3, 3));
        shapes.add(new Circle(new Point(3, 9), 7));
        shapes.add(new Rectangle(new Point(3, 4), 7, 3));
        shapes.add(new Circle(new Point(2, 9), 6));
        shapes.add(new Circle(new Point(2, 9), 3));
        shapes.add(new Rectangle(new Point(1, 1), 3, 9));

        System.out.println();
        System.out.println("Sorted shapes : ");
        System.out.println();

        Collections.sort(shapes);
        for (Shapes el : shapes)
            System.out.println(el);

        System.out.println();
        System.out.println("Sorted points (centre of shapes) : ");
        System.out.println();

        List<Point> points = new ArrayList<>();
        for (int i = 0; i < shapes.size(); i++) {
            points.add(shapes.get(i).getCentre());
        }

        Collections.sort(points, Point.comaratorByYthenX);
        for (Point el : points)
            System.out.println(el);


    }


}
