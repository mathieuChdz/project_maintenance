import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import shape.*;
import layer_area.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Application {

    public static void main(String[] args) {
        boolean run = true;
        int layer_id = 1;
        int shape_id = 1;

        Scanner scanner = new Scanner(System.in);
        Area area1 = new Area(50,50,1,"area1");
        Layer layer1 = new Layer(layer_id,"layer1");
        area1.add_layer_to_list(layer1);

        Layer layer_actu = layer1;

        layer_id++;


        while (run){
            area1.draw();
            System.out.print("Commande : ");
            String shape = scanner.nextLine();

            String[] valeurs = shape.split(" ");

            if (valeurs.length == 1){
                //considerer les shapes point (car quand on créer point on fait : point id x y (donc 4 'mots')

                if (Objects.equals(valeurs[0], "stop")){
                    run = false;
                }

                else if (Objects.equals(valeurs[0], "list")){
                    layer_actu.printListShape();
                }

                else if (Objects.equals(valeurs[0], "help")){
                    System.out.println(
                            "Voici les différentes commandes disponibles :\n\n" +
                            "---------------- LAYER ----------------\n" +
                            "layer \033[3mnom_du_layer\033[0m : Création d'un nouveau layer\n" +
                            "delete layer \033[3mlayer_id\033[0m : Suppression d'un layer choisi\n" +
                            "select layer \033[3mlayer_id\033[0m : Choix du layer à utiliser\n" +
                            "visibility layer \033[3mlayer_id\033[0m change : Changement de la visibilité d'un layer choisi\n\n" +
                            "---------------- SHAPES ----------------\n" +
                            "point \033[3mx y\033[0m : Création d'un point\n" +
                            "line \033[3mx1 y1 x2 y2\033[0m : Création d'une ligne\n" +
                            "circle \033[3mx y radius\033[0m : Création d'un cercle\n" +
                            "square \033[3mx y lenght\033[0m : Création d'un carré\n" +
                            "rectangle \033[3mx y widht height\033[0m : Création d'un rectangle\n" +
                            "curve \033[3mx1 y1 x2 y2 x3 y3 x4 y4\033[0m : Création d'une courbe\n" +
                            "polygon \033[3mx1 y1 x2 y2 x3 y3 ...\033[0m : Création d'un polygone\n" +
                            "delete shape \033[3mshape_id\033[0m : Suppression d'une shape choisie\n" +
                            "visibility shape \033[3mshape_id\033[0m change : Changement de la visibilité d'une shape choisie\n\n" +
                            "---------------- DIVERS ----------------\n" +
                            "list : liste des shapes du layer actuel\n" +
                            "list layer : liste des layers existants\n" +
                            "stop : quitte l'application\n"

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
                //considerer les shapes point (car quand on créer point on fait : point x y (donc 3 'mots')
                if (Objects.equals(valeurs[0], "point")){
                    System.out.println("Shape:" + valeurs[0] + " id:"+shape_id+" x:"+valeurs[1]+ " y:"+valeurs[2]);
                    Point point = new Point(shape_id,Integer.valueOf(valeurs[1]),Integer.valueOf(valeurs[2]));
                    layer_actu.add_shape_to_list(point);
                    shape_id++;
                }

                else if (Objects.equals(valeurs[0], "delete")){

                    if (Objects.equals(valeurs[1], "layer")){
                        if (area1.getLayerExist(Integer.valueOf(valeurs[2]))){
                            if (area1.getLayerListLenght() > 1){
                                if (Objects.equals(layer_actu.getId(), Integer.valueOf(valeurs[2]))){
                                    //on change de layer actu car ici on supp le layer actu
                                    area1.delete_layer_to_list(Integer.valueOf(valeurs[2]));
                                    layer_actu = area1.getLayerLast();
                                }
                                else{
                                    area1.delete_layer_to_list(Integer.valueOf(valeurs[2]));
                                }

                            }
                            else{
                                System.out.println("Action annulée -->Le layer <<"+ layer_actu.getName()+">> avec l'id "+layer_actu.getId()+" est le seul layer existant");
//                            System.out.println("Le layer : "+layer_actu.toString()+" est le seul layer existant --> souhaitez-vous le supprimer (Y/N) ?");
//                            String yes_no = scanner.nextLine();
//                            if (Objects.equals(yes_no, "Y")){
//                                area1.delete_layer_to_list(Integer.valueOf(valeurs[2]));
//                            }
//                            else{
//                                System.out.println("Action annulée");
//                            }
                            }
                        }
                        else{
                            System.out.println("Le layer avec l'id "+Integer.valueOf(valeurs[2])+" n'existe pas --> tapez \033[3mlist layer\033[0m pour en savoir plus sur les layers");
                        }

                    }
                    else if (Objects.equals(valeurs[1], "shape")){
                        if (layer_actu.getShapeExist(Integer.valueOf(valeurs[2]))){
                            layer_actu.delete_shape_to_list(Integer.valueOf(valeurs[2]));
                        }
                        else{
                            System.out.println("La shape n'existe pas ou n'est pas dans le layer <<"+ layer_actu.getName()+">> avec l'id "+layer_actu.getId());
                        }

                    }
                    else{
                        System.out.println("Mauvaise commande --> Tapez help pour afficher toutes les commandes");
                    }
                }

                else if (Objects.equals(valeurs[0], "select")){
                    if (Objects.equals(valeurs[1], "layer")){
                        Layer layer_selected = area1.getLayer(Integer.valueOf(valeurs[2]));
                        if (Objects.equals(layer_selected, null)){
                            System.out.println("Le layer avec l'id "+Integer.valueOf(valeurs[2])+" n'existe pas --> tapez \033[3mlist layer\033[0m pour en savoir plus sur les layers");
                        }
                        else{
                            layer_actu = layer_selected;
                        }

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
                //considerer les shapes circle (car quand on créer circle on fait : circle x y radius (donc 4 'mots')
                //                      square (car quand on créer square on fait : square x y lenght (donc 4 'mots')
                if (Objects.equals(valeurs[0], "circle")){
                    System.out.println("Shape:" + valeurs[0] + " id:"+shape_id+" x : "+valeurs[1]+ " y:"+valeurs[2]+" radius:"+valeurs[3]);
                    Circle circle = new Circle(shape_id,Integer.valueOf(valeurs[1]),Integer.valueOf(valeurs[2]),Integer.valueOf(valeurs[3]));
                    layer_actu.add_shape_to_list(circle);
                    shape_id++;
                }

                else if (Objects.equals(valeurs[0], "square")){
                    System.out.println("Shape:" + valeurs[0] + " id:"+shape_id+" x:"+valeurs[1]+ " y:"+valeurs[2]+" lenght:"+valeurs[3]);
                    Square square = new Square(shape_id,Integer.valueOf(valeurs[1]),Integer.valueOf(valeurs[2]),Integer.valueOf(valeurs[3]));
                    layer_actu.add_shape_to_list(square);
                    shape_id++;
                }

                else if (Objects.equals(valeurs[0], "visibility")){

                    if (Objects.equals(valeurs[1], "layer")){

                        if (area1.getLayerExist(Integer.valueOf(valeurs[2]))){

                            if (Objects.equals(valeurs[3], "get")){

                                if (area1.getLayer(Integer.valueOf(valeurs[2])).getVisible()){
                                    System.out.println("Le layer avec l'id "+Integer.valueOf(valeurs[2])+" est VISIBLE");
                                }
                                else{
                                    System.out.println("Le layer avec l'id "+Integer.valueOf(valeurs[2])+" est NON VISIBLE");
                                }

                            }
                            else if (Objects.equals(valeurs[3], "change")){
                                layer_actu.set_layer_visibility();
                            }
                            else{
                                System.out.println("Mauvaise commande --> Tapez help pour afficher toutes les commandes");
                            }
                        }
                        else{
                            System.out.println("Le layer avec l'id "+Integer.valueOf(valeurs[2])+" n'existe pas --> tapez \033[3mlist layer\033[0m pour en savoir plus sur les layers");
                        }
                    }

                    else if (Objects.equals(valeurs[1], "shape")){
                        if (layer_actu.getShapeExist(Integer.valueOf(valeurs[2]))){
                            if (Objects.equals(valeurs[3], "get")){

                                if (layer_actu.getShapeExist(Integer.valueOf(valeurs[2]))){
                                    System.out.println("La shape avec l'id "+Integer.valueOf(valeurs[2])+" est VISIBLE");
                                }
                                else{
                                    System.out.println("La shape avec l'id "+Integer.valueOf(valeurs[2])+" est NON VISIBLE");
                                }

                            }
                            else if (Objects.equals(valeurs[3], "change")){
                                layer_actu.set_shape_visibility(Integer.valueOf(valeurs[2]));
                            }
                            else{
                                System.out.println("Mauvaise commande --> Tapez help pour afficher toutes les commandes");
                            }
                        }
                        else{
                            System.out.println("La shape n'existe pas ou n'est pas dans le layer <<"+ layer_actu.getName()+">> avec l'id "+layer_actu.getId());
                        }
                    }
                    else{
                        System.out.println("Mauvaise commande --> Tapez help pour afficher toutes les commandes");
                    }
                }

                else{
                    System.out.println("Mauvaise commande --> Tapez help pour afficher toutes les commandes");
                }

            }

            else if (valeurs.length == 5){
                //considerer les shapes line (car quand on créer line on fait : line x1 y1 x2 y2 (donc 5 'mots')
                if (Objects.equals(valeurs[0], "line")){
                    System.out.println("Shape:" + valeurs[0] + " id:"+shape_id+" x1:"+valeurs[1]+ " y1:"+valeurs[2] + " x2:"+valeurs[3]+ " y2:"+valeurs[4]);
                    Line line = new Line(shape_id,Integer.valueOf(valeurs[1]),Integer.valueOf(valeurs[2]),Integer.valueOf(valeurs[3]),Integer.valueOf(valeurs[4]));
                    layer_actu.add_shape_to_list(line);
                    shape_id++;
                }
                else if (Objects.equals(valeurs[0], "rectangle")){
                    //considerer les shapes rectangle (car quand on créer rectangle on fait : rectangle x y widht height (donc 5 'mots')
                    System.out.println("Shape:" + valeurs[0] + " id:"+shape_id+" x:"+valeurs[1]+ " y:"+valeurs[2]+" widht:"+valeurs[3]+" height:"+valeurs[4]);
                    Rectangle rectangle = new Rectangle(shape_id,Integer.valueOf(valeurs[1]),Integer.valueOf(valeurs[2]),Integer.valueOf(valeurs[3]),Integer.valueOf(valeurs[4]));
                    layer_actu.add_shape_to_list(rectangle);
                    shape_id++;
                }
                else{
                    System.out.println("Mauvaise commande --> Tapez help pour afficher toutes les commandes");
                }
            }

            else if (valeurs.length >= 7 && valeurs.length%2 == 1 && !Objects.equals(valeurs[0], "curve")) {

                if (Objects.equals(valeurs[0], "polygon")) {

                    String retour ="Shape:" + valeurs[0] + " id:"+shape_id+" x1:"+valeurs[1]+ " y1:"+valeurs[2] + " x2:"+valeurs[3]+ " y2:"+valeurs[4]+
                            " x3:"+valeurs[5]+ " y3:"+valeurs[6];


                    for (int i = 7; i < valeurs.length; i++) {

                        if (i%2 == 1){
                            retour += " x" + Integer.valueOf((i+1)/2) + ":" + Integer.valueOf(valeurs[i]);
                        }
                        else{
                            retour += " y" + Integer.valueOf(i/2) + ":" + Integer.valueOf(valeurs[i]);
                        }

                    }
                    System.out.println(retour);


                    Integer[] params = new Integer[valeurs.length-7];

                    int i =0;
                    for (int s = 7; s < valeurs.length; s++) {

                        params[i] = (Integer.valueOf(s));
                        i+=1;
                    }


                    Polygone polygone = new Polygone(shape_id,Integer.valueOf(valeurs[2]),Integer.valueOf(valeurs[2]),Integer.valueOf(valeurs[3]),
                            Integer.valueOf(valeurs[4]),Integer.valueOf(valeurs[5]),Integer.valueOf(valeurs[6]), params);

                    layer_actu.add_shape_to_list(polygone);
                    shape_id++;
                }

                else {
                    System.out.println("Mauvaise commande --> Tapez help pour afficher toutes les commandes");
                }

            }


            else if (valeurs.length == 9){
                if (Objects.equals(valeurs[0], "curve")){
                    //considerer les shapes curve (car quand on créer curve on fait : curve x1 y1 x2 y2 x3 y3 x4 y4 (donc 9 'mots')
                    System.out.println("Shape:" + valeurs[0] + " id:"+shape_id+" x1:"+valeurs[1]+ " y1:"+valeurs[2] + " x2:"+valeurs[3]+ " y2:"+valeurs[4]+
                                                                               " x3:"+valeurs[5]+ " y3:"+valeurs[6] + " x4:"+valeurs[7]+ " y4:"+valeurs[8]);
                    Curve curve = new Curve(shape_id,Integer.valueOf(valeurs[1]),Integer.valueOf(valeurs[2]),Integer.valueOf(valeurs[3]),Integer.valueOf(valeurs[4]),
                                                     Integer.valueOf(valeurs[5]),Integer.valueOf(valeurs[6]),Integer.valueOf(valeurs[7]),Integer.valueOf(valeurs[8]));
                    layer_actu.add_shape_to_list(curve);
                    shape_id++;
                }
            }














        }

        scanner.close();






//        System.out.println(area1.name);
//        for (Layer l : area1.listLayers){
//            if (l.getVisible()){
//                System.out.println("|--->" + l.name);
//
//                for (Shape s: l.listShapes){
//
//                    if (s.getVisible()){
//                        System.out.println("|------>" + s.toString());
//
//                    }
//
//                }
//
//            }
//
//        }




    }

}
