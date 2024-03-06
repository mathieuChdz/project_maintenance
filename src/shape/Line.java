package shape;

public class Line extends Shape{

    Point p1;

    public Line(int parId, int parX, int parY,  int parX2, int parY2) {
        super(parId, 1, parX2, parY2);
        p1 = new Point(parX, parY);
    }

    public String toString(){
        String str;
        str = getId()+" Line "+ "p1:" + p1.getX()+":"+p1.getY() + " p2:" + getX()+":"+getY();
        return str;
    }


    public Point getP1(){
        return p1;
    }

}
