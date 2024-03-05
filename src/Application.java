import java.util.Objects;
import java.util.Scanner;
import shape.*;
import layer_area.*;


public class Application {

    public static void main(String[] args) {
        boolean run = true;
        Scanner scanner = new Scanner(System.in);
        Area area1 = new Area(50,50,1,"area1");
        Layer layer1 = new Layer(1,"layer1");
        area1.add_layer_to_list(layer1);

        while (run){
            System.out.print("Command : ");
            String shape = scanner.nextLine();

            String[] valeurs = shape.split(" ");

            if (valeurs.length == 1){
                //considerer les shapes point (car quand on créer point on fait : point id x y (donc 4 'mots')

                if (Objects.equals(valeurs[0], "stop")){
                    run = false;
                }

                if (Objects.equals(valeurs[0], "list")){
                    layer1.getListShape();
                }

            }

            if (valeurs.length == 4){
                //considerer les shapes point (car quand on créer point on fait : point id x y (donc 4 'mots')

                System.out.println("Shape:" + valeurs[0] + " id:"+valeurs[1]+" x:"+valeurs[2]+ " y:"+valeurs[3]);
                Point point = new Point(Integer.valueOf(valeurs[1]),Integer.valueOf(valeurs[2]),Integer.valueOf(valeurs[3]));
                layer1.add_shape_to_list(point);

            }

            else if (valeurs.length == 5){
                //considerer les shapes circle (car quand on créer circle on fait : circle id x y radius (donc 5 'mots')
                //                      square (car quand on créer square on fait : square id x y lenght (donc 5 'mots')
                if (Objects.equals(valeurs[0], "circle")){
                    System.out.println("Shape:" + valeurs[0] + " id:"+valeurs[1]+" x : "+valeurs[2]+ " y:"+valeurs[3]+" radius:"+valeurs[4]);
                    Circle circle = new Circle(Integer.valueOf(valeurs[1]),Integer.valueOf(valeurs[2]),Integer.valueOf(valeurs[3]),Integer.valueOf(valeurs[4]));
                    layer1.add_shape_to_list(circle);
                }
                else if (Objects.equals(valeurs[0], "square")){
                    System.out.println("Shape:" + valeurs[0] + " id:"+valeurs[1]+" x:"+valeurs[2]+ " y:"+valeurs[3]+" lenght:"+valeurs[4]);
                    Square square = new Square(Integer.valueOf(valeurs[1]),Integer.valueOf(valeurs[2]),Integer.valueOf(valeurs[3]),Integer.valueOf(valeurs[4]));
                    layer1.add_shape_to_list(square);
                }

            }

            else if (valeurs.length == 6){
                //considerer les shapes line (car quand on créer line on fait : line id x1 y1 x2 y2 (donc 6 'mots')
                System.out.println("Shape:" + valeurs[0] + " id:"+valeurs[1]+" x1:"+valeurs[2]+ " y1:"+valeurs[3] + " x2:"+valeurs[4]+ " y2:"+valeurs[5]);
                Line line = new Line(Integer.valueOf(valeurs[1]),Integer.valueOf(valeurs[2]),Integer.valueOf(valeurs[3]),Integer.valueOf(valeurs[4]),Integer.valueOf(valeurs[5]));
                layer1.add_shape_to_list(line);
            }

        }

        scanner.close();
    }

}
