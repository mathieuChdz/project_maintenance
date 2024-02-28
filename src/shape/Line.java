package shape;

public class Line extends Shape{

    Point p1;

    public Line(int parId, int parX, int parY,  Point parP1) {
        super(parId, 1, parX, parY);
        p1 = parP1;
    }

    public String toString(){
        String str;
        str = "Line"+ "p1:" + p1.getX()+":"+p1.getY() + "p2:" + getX()+":"+getY();
        return str;
    }


    public Point getP1(){
        return p1;
    }

}
