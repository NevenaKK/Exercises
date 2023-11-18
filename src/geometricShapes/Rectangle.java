package geometricShapes;

public class Rectangle extends Shapes {
    private double width, height;

    public Rectangle(double width, double height) {
        init(width, height);
    }

    public Rectangle(Point centre, double width, double height) {
        super(centre);
        init(width, height);
    }

    private void init(double width, double height) {
        this.width = width;
        this.height = height;
    }


    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return super.toString() + " | Rectangle : a = " + width + " , b = " + height;


    }






}
