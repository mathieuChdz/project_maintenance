package shape;

public class Rectangle extends Shape{

    public int widht;
    public int height;

    public Rectangle(int parId, int parX, int parY, int parWidht, int parHeight) {
        super(parId, 1, parX, parY);
        widht = parWidht;
        height = parHeight;
    }


    public String toString(){
        String str;
        str = getId()+" Rectangle "+ getX()+":"+getY() + " --- W-H:" + widht + ":" + height;
        return str;
    }



    public int getWidht(){
        return widht;
    }

    public int getHeight(){
        return height;
    }

}
