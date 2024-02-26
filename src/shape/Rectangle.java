package shape;

public class Rectangle extends Shape{

    public int widht;
    public int height;

    public Rectangle(int parId, float parThickness, boolean parVisible, int parX, int parY, Color parColor, int parWidht, int parHeight) {
        super(parId, parThickness, parX, parY, parColor);
        widht = parWidht;
        height = parHeight;
    }
    
    public int getWidht(){
        return widht;
    }

    public int getHeight(){
        return height;
    }

}
