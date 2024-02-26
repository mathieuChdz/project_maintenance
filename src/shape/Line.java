package shape;

public class Line extends Shape{

    Point p1;

    public Line(int parId, float parThickness, boolean parVisible, int parX, int parY, Color parColor, Point parP1) {
        super(parId, parThickness, parX, parY, parColor);
        p1 = parP1;
    }
    
    public Point getP1(){
        return p1;
    }

}
