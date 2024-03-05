import java.util.Objects;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        boolean run = true;
        Scanner scanner = new Scanner(System.in);

        while (run){
            System.out.print("Command : ");
            String shape = scanner.nextLine();

            String[] valeurs = shape.split(" ");

            if (valeurs.length == 1){
                //considerer les shapes point (car quand on créer point on fait : point id x y (donc 4 'mots')

                if (Objects.equals(valeurs[0], "stop")){
                    run = false;
                }

            }

            if (valeurs.length == 4){
                //considerer les shapes point (car quand on créer point on fait : point id x y (donc 4 'mots')

                System.out.println("Shape : " + valeurs[0] + " id : "+valeurs[1]+" x : "+valeurs[2]+ " y : "+valeurs[3]);

            }

            else if (valeurs.length == 5){
                //considerer les shapes circle (car quand on créer circle on fait : circle id x y radius (donc 5 'mots')
                //                      square (car quand on créer square on fait : square id x y lenght (donc 5 'mots')
                if (Objects.equals(valeurs[0], "circle")){
                    System.out.println("Shape : " + valeurs[0] + " id : "+valeurs[1]+" x : "+valeurs[2]+ " y : "+valeurs[3]+" radius "+valeurs[4]);
                }
                else if (Objects.equals(valeurs[0], "square")){
                    System.out.println("Shape : " + valeurs[0] + " id : "+valeurs[1]+" x : "+valeurs[2]+ " y : "+valeurs[3]+" lenght "+valeurs[4]);
                }
            }

            else if (valeurs.length == 7){
                //considerer les shapes line (car quand on créer line on fait : line id x1 y1 idNewPoint x2 y2 (donc 7 'mots')
                System.out.println("Shape : " + valeurs[0] + " id : "+valeurs[1]+" x1 : "+valeurs[2]+ " y1 : "+valeurs[3]+" id new point "+valeurs[4]+" x2 : "+valeurs[5]+ " y2 : "+valeurs[6]);
            }

        }

        scanner.close();
    }

}
