package shape;

public class Circle extends Shape{

    public int radius;

    public Circle(int parId, int parX, int parY, int parRadius) {
        super(parId, 1, parX, parY);
        radius = parRadius;
    }

    public String toString(){
        String str;
        str = getId()+" Circle "+ getX()+":"+getY() + " rad:" +radius;
        return str;
    }

    public int getRadius(){
        return radius;
    }

    public int getId(){
        return id;
    }
    
}
