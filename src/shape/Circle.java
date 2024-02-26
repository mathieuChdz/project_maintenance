package shape;

public class Circle extends Shape{

    public int radius;

    public Circle(int parId, float parThickness, boolean parVisible, int parX, int parY, Color parColor, int parRadius) {
        super(parId, parThickness, parX, parY, parColor);
        radius = parRadius;
    }

    public String toString(){
        String str;
        str = "Circle "+ getX()+":"+getY() + "rad:" +radius;
    }

    public int getId(){
        return id;
    }
    
}
