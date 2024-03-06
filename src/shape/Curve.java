package shape;

public class Curve extends Shape{

    Point p1;
    Point p2;
    Point p3;

    public Curve(int parId, int parX, int parY, int parX2, int parY2, int parX3, int parY3, int parX4, int parY4) {
        super(parId, 1, parX4, parY4);
        p1 = new Point(parX, parY);
        p2 = new Point(parX2, parY2);
        p3 = new Point(parX3, parY3);
    }

    public String toString(){
        String str;
        str = getId()+" Curve "+ "p1 : " + p1.getX()+"/"+p1.getY() + " --- p2 : " + p2.getX()+"/"+p2.getY() + " --- p3 : " + p3.getX()+"/"+p3.getY() + " --- p4 : " + getX()+"/"+getY();
        return str;
    }


    public Point getP1(){
        return p1;
    }

    public Point getP2(){
        return p2;
    }

    public Point getP3(){
        return p3;
    }
}
