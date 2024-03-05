package shape;

public class Curve extends Shape{

    Point p1;
    Point p2;
    Point p3;

    public Curve(int parId, int parX, int parY,  Point parP1, Point parP2, Point parP3) {
        super(parId, 1, parX, parY);
        p1 = parP1;
        p2 = parP2;
        p3 = parP3;
    }

    public String toString(){
        String str;
        str = getId()+" Curve "+ "p1 : " + getX()+"/"+getY() + " --- p2 : " + p1.getX()+"/"+p1.getY() + " --- p3 : " + p2.getX()+"/"+p2.getY() + " --- p4 : " + p3.getX()+"/"+p3.getY();
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
