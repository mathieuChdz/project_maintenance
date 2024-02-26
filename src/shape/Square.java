package shape;

public class Square extends Shape{

    int lenght;

    public Square(int parId, float parThickness, boolean parVisible, int parX, int parY, Color parColor, int parLenght) {
        super(parId, parThickness, parX, parY, parColor);
        lenght = parLenght;     
    }
    
    public int getLenght(){
        return lenght;
    }

}
