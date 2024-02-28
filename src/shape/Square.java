package shape;

public class Square extends Shape{

    int lenght;

    public Square(int parId, int parX, int parY, int parLenght) {
        super(parId, 1, parX, parY);
        lenght = parLenght;     
    }

    public String toString(){
        String str;
        str = "Square"+ getX()+":"+getY() + "lenght: " + lenght;
        return str;
    }


    public int getLenght(){
        return lenght;
    }

}
