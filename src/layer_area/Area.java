package layer_area;

import shape.Shape;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Area {

//    public ArrayList<Area> listAreas;
    public ArrayList<Layer> listLayers;

    public int widht;
    public int height;
    public int id;
    public String name;
    
    public Area(int parWidht, int parHeight, int parId, String parName){
        widht = parWidht;
        height = parHeight;
        id = parId;
        name = parName;
//        listAreas = new ArrayList<>();
        listLayers = new ArrayList<>();
    }

    public void add_layer_to_list(Layer parLayer){
        listLayers.add(parLayer);
    }

    public boolean delete_layer_to_list(int parId){
        for (int i=0; i<listLayers.size(); i++){
            int layer_id_actu = listLayers.get(i).getId();
            if (parId == layer_id_actu){
                listLayers.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean getLayerExist(int parId){
        for (int i=0; i<listLayers.size(); i++){
            int layer_id_actu = listLayers.get(i).getId();
            if (parId == layer_id_actu){
                return true;
            }
        }
        return false;
    }

    public Layer getLayer(int parId){
        for (int i=0; i<listLayers.size(); i++){
            Layer layer_actu = listLayers.get(i);
            if (parId == layer_actu.getId()){
                return layer_actu;
            }
        }
        return null;
    }

    public void draw(){


        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("draw.txt"));

            writer.write(this.getName() + " (" + this.getWidht() + "x" + this.getHeight() + ") \n");
            for (Layer l : this.listLayers){
                if (l.getVisible()){
                    writer.write("|--->" + l.name + "\n");

                    for (Shape s: l.getListShapes()){

                        if (s.getVisible()){
                            writer.write("|------>" + s.toString() + "\n");

                        }

                    }

                }

            }

            writer.close();

        } catch (IOException e) {

        }

    }


    public Layer getLayerLast(){
        return listLayers.get(listLayers.size()-1);
    }

    public int getLayerListLenght(){
        return listLayers.size();
    }

    public void getListLayer(){
        System.out.println("----- "+this.getName()+" -----");
        for (Layer layer : listLayers) {
            System.out.println(layer.toString());
        }
    }

    public int getWidht(){
        return widht;
    }

    public int getHeight(){
        return height;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

}
