package shape;

public abstract class Shape{

    public int id;
    public float thickness;
    public boolean visible;
    public int x;
    public int y;
    public Color color;


    public Shape(int parId, float parThickness, int parX, int parY){
        id = parId;
        thickness = parThickness;
        visible = true; //visible de base
        x = parX;
        y = parY;
        color = null;
        //pour x, y et color, on peut faire une classe Pixel avec ces attributs dedans, mais je préfère comme cela
    }

    public Shape(float parThickness, int parX, int parY){
        id=0;
        thickness = parThickness;
        visible = true; //visible de base
        x = parX;
        y = parY;
        color = null;
        //pour x, y et color, on peut faire une classe Pixel avec ces attributs dedans, mais je préfère comme cela
    }

    public void set_shape_visibility(){
        if (getVisible()) {
            visible = false;
        }
        else{
            visible = true;
        }
    }

    public int getId(){
        return id;
    }

    public float getThickness(){
        return thickness;
    }

    public boolean getVisible(){
        return visible;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public Color getColor(){
        return color;
    }

}