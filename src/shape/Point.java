package shape;

public class Point {

    public Point(int parId, float parThickness, boolean parVisible, int parX, int parY, Color parColor) {
        super(parId, parThickness, parX, parY, parColor);
    }

    public String toString(){
        String str;
        str = "Point"+ getX()+":"+getY();
    }



}
