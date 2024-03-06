package shape;

import java.util.ArrayList;

public class Polygone extends Shape{

    Point p2;
    Point p3;

    ArrayList<Point> listPoints =  new ArrayList<>();

    public Polygone(int parId, int parX1, int parY1, int parX2, int parY2, int parX3, int parY3, Integer[] points) {
        super(parId, 1, parX1, parY1);
        p2 = new Point(parX2, parY2);
        p3 = new Point(parX3, parY3);


        for (int i = 0; i < points.length-1; i+=2) {

            listPoints.add(new Point(points[i],points[i+1]));
        }



    } //on considère ici que c'est le premier point qui est herité, car on ne connait pas le dernier

    public String toString(){
        String str;
        str = getId()+" Polygon "+ "p1: " + getX()+":"+getY() + " --- p2: " + p2.getX()+":"+p2.getY() + " --- p3: " + p3.getX()+":"+p3.getY();

        for (int i = 0; i < listPoints.size(); i++) {


            str+="p" + Integer.valueOf(i+3) + ": "+ Integer.valueOf(listPoints.get(i).getX())+":"+Integer.valueOf(listPoints.get(i).getY());


        }

        return str;
    }


    public Point getP1(){
        return new Point(getX(),getY());
    }

    public Point getP2(){
        return p2;
    }

    public Point getP3(){
        return p3;
    }
}
