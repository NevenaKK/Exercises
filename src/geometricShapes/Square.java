package geometricShapes;

public class Square extends Rectangle {

    public Square(double size) {
        super(size, size);
    }

    public Square(Point centre, double size) {
        super(centre, size, size);
    }

    public double getSize(){
        return getHeight();
    }

    public String toString(){
        return  "Centre : "+getCentre().toString()+ " | Square : a = "+getSize() ;
    }


}
