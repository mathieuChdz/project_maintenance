package shape;

public class Line extends Shape{

    int x2;
    int y2;

    public Line(int parId, int parX, int parY,  int parX2, int parY2) {
        super(parId, 1, parX, parY);
        x2 = parX2;
        y2 = parY2;
    }

    public String toString(){
        String str;
        str = "Line "+ "p1:" + x2+":"+y2 + " p2:" + getX()+":"+getY();
        return str;
    }


    /*public Point getP1(){
        return p1;
    }*/

}
