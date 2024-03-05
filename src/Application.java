import java.util.Objects;
import java.util.Scanner;
import shape.*;
import layer_area.*;


public class Application {

    public static void main(String[] args) {
        boolean run = true;
        int layer_id = 1;
        int shape_id = 1;

        Scanner scanner = new Scanner(System.in);
        Area area1 = new Area(50,50,1,"area1");
        Layer layer1 = new Layer(layer_id,"layer1");
        area1.add_layer_to_list(layer1);

        layer_id++;


        while (run){
            System.out.print("Command : ");
            String shape = scanner.nextLine();

            String[] valeurs = shape.split(" ");

            if (valeurs.length == 1){
                //considerer les shapes point (car quand on créer point on fait : point id x y (donc 4 'mots')

                if (Objects.equals(valeurs[0], "stop")){
                    run = false;
                }

                else if (Objects.equals(valeurs[0], "list")){
                    layer1.getListShape();
                }

                else if (Objects.equals(valeurs[0], "help")){
                    System.out.println(
                            "Voici les différentes commandes disponibles :\n\n" +
                            "---------------- LAYER ----------------\n" +
                            "layer \033[3mnom_du_layer\033[0m : Création d'un nouveau layer\n" +
                            "delete layer \033[3mlayer_id\033[0m : Suppression d'un layer choisi\n" +
                            "select layer \033[3mlayer_id\033[0m : Choix du layer à utiliser\n" +
                            "visibility layer \033[3mlayer_id\033[0m : Changement de la visibilité d'un layer choisi\n\n" +
                            "---------------- SHAPES ----------------\n" +
                            "point \033[3mx y\033[0m : Création d'un point\n" +
                            "line \033[3mx1 y1 x2 y2\033[0m : Création d'une ligne\n" +
                            "circle \033[3mx y radius\033[0m : Création d'un cercle\n" +
                            "square \033[3mx y lenght\033[0m : Création d'un carré\n" +
                            "rectangle \033[3mx y widht height\033[0m : Création d'un rectangle\n" +
                            "curve \033[3mx1 y1 x2 y2 x3 y3 x4 y4\033[0m : Création d'une courbe\n" +
                            "delete shape \033[3mshape_id\033[0m : Suppression d'une shape choisie\n" +
                            "visibility shape \033[3mshape_id\033[0m : Changement de la visibilité d'une shape choisie"
                    );
                }

                else{
                    System.out.println("Mauvaise commande --> Tapez help pour afficher toutes les commandes");
                }

            }

            if (valeurs.length == 2){
                if (Objects.equals(valeurs[0], "layer")){
                    Layer new_layer = new Layer(layer_id, valeurs[1]);
                    area1.add_layer_to_list(new_layer);
                    layer_id++;
                }

                else if (Objects.equals(valeurs[0], "list")){
                    if (Objects.equals(valeurs[1], "layer")){
                        area1.getListLayer();
                    }
                }

            }

            if (valeurs.length == 3){
                //considerer les shapes point (car quand on créer point on fait : point id x y (donc 4 'mots')
                if (Objects.equals(valeurs[0], "point")){
                    System.out.println("Shape:" + valeurs[0] + " id:"+shape_id+" x:"+valeurs[1]+ " y:"+valeurs[2]);
                    Point point = new Point(shape_id,Integer.valueOf(valeurs[1]),Integer.valueOf(valeurs[2]));
                    layer1.add_shape_to_list(point);
                    shape_id++;
                }

                else if (Objects.equals(valeurs[0], "delete")){

                    if (Objects.equals(valeurs[1], "layer")){
                        area1.delete_layer_to_list(Integer.valueOf(valeurs[2]));
                    }
                    else if (Objects.equals(valeurs[1], "shape")){
                        layer1.delete_shape_to_list(Integer.valueOf(valeurs[2]));
                    }
                    else{
                        System.out.println("Mauvaise commande --> Tapez help pour afficher toutes les commandes");
                    }
                }
                else{
                    System.out.println("Mauvaise commande --> Tapez help pour afficher toutes les commandes");
                }
            }

            else if (valeurs.length == 4){
                //considerer les shapes circle (car quand on créer circle on fait : circle id x y radius (donc 5 'mots')
                //                      square (car quand on créer square on fait : square id x y lenght (donc 5 'mots')
                if (Objects.equals(valeurs[0], "circle")){
                    System.out.println("Shape:" + valeurs[0] + " id:"+shape_id+" x : "+valeurs[1]+ " y:"+valeurs[2]+" radius:"+valeurs[3]);
                    Circle circle = new Circle(shape_id,Integer.valueOf(valeurs[1]),Integer.valueOf(valeurs[2]),Integer.valueOf(valeurs[3]));
                    layer1.add_shape_to_list(circle);
                    shape_id++;
                }
                else if (Objects.equals(valeurs[0], "square")){
                    System.out.println("Shape:" + valeurs[0] + " id:"+shape_id+" x:"+valeurs[1]+ " y:"+valeurs[2]+" lenght:"+valeurs[3]);
                    Square square = new Square(shape_id,Integer.valueOf(valeurs[1]),Integer.valueOf(valeurs[2]),Integer.valueOf(valeurs[3]));
                    layer1.add_shape_to_list(square);
                    shape_id++;
                }
                else{
                    System.out.println("Mauvaise commande --> Tapez help pour afficher toutes les commandes");
                }

            }

            else if (valeurs.length == 5){
                //considerer les shapes line (car quand on créer line on fait : line id x1 y1 x2 y2 (donc 6 'mots')
                if (Objects.equals(valeurs[0], "rectangle")){
                    System.out.println("Shape:" + valeurs[0] + " id:"+shape_id+" x1:"+valeurs[1]+ " y1:"+valeurs[2] + " x2:"+valeurs[3]+ " y2:"+valeurs[4]);
                    Line line = new Line(shape_id,Integer.valueOf(valeurs[1]),Integer.valueOf(valeurs[2]),Integer.valueOf(valeurs[3]),Integer.valueOf(valeurs[4]));
                    layer1.add_shape_to_list(line);
                    shape_id++;
                }
                else{
                    System.out.println("Mauvaise commande --> Tapez help pour afficher toutes les commandes");
                }
            }

        }

        scanner.close();
    }

}
