package shape;

public class Point extends Shape{

    public Point(int parId, int parX, int parY) {
        super(parId, 1, parX, parY);
    }



    public String toString(){
        String str;
        str = "Point"+ getX()+":"+getY();
        return str;
    }



}
