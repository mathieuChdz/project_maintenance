package layer_area;

import java.util.ArrayList;
import java.util.HashMap;

import shape.Shape;

public class Layer {

//    public ArrayList<Layer> listLayers;
//    public HashMap<Integer, ArrayList<Shape>> mapShapes;
    public ArrayList<Shape> listShapes;

    public int id;
    public String name;
    public boolean visible;

    public Layer(int parId, String parName){
        id = parId;
        name = parName;
        visible = true; //visible de base
//        listLayers = new ArrayList<>();
//        mapShapes = new HashMap<>();
        listShapes = new ArrayList<>();
    }

//    public void add_layer_to_list(int parId, String parName){
//        Layer new_layer = new Layer(parId, parName);
//        listLayers.add(new_layer);
//    }
//
//    public boolean delete_layer_to_list(int parId){
//        for (int i=0; i<listLayers.size(); i++){
//            int layer_id_actu = listLayers.get(i).getId();
//            if (parId == layer_id_actu){
//                listLayers.remove(i);
//                return true;
//            }
//        }
//        return false;
//    }

//    public void add_shape_to_layer(Shape parShape, int parLayerId){
//        // je ne suis pas sur de si il faut deja avoir créer la shape ou si il faut faire un new shape
//        // sinon :
//        // Shape new_shape = new Shape(int parId, float parThickness, int parX, int parY, Color parColor);
//        // listShapes.add(new_shape);
//        if (mapShapes.containsKey(parLayerId)){
//            mapShapes.get(parLayerId).add(parShape);
//        }
//        else {
//            ArrayList<Shape> listShape = new ArrayList<>();
//            listShape.add(parShape);
//            mapShapes.put(parLayerId,listShape);
//        }
//        //mapShapes.put(parLayerId, parShape);
//    }
//
//    public boolean delete_shape_to_layer(int parId){
//        for (int layerId : mapShapes.keySet()) {
//            ArrayList listShape = mapShapes.get(layerId);
//            for (Shape shape : listShape) {
//                Shape shape = mapShapes.get(layerId);
//                if (shape.getId() == parId) {
//                    mapShapes.get(layerId).remove(shape);
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    public void add_shape_to_list(Shape parShape){
        listShapes.add(parShape);
    }

    public boolean delete_shape_to_list(int parId){
        for (int i=0; i<listShapes.size(); i++){
            int shape_id_actu = listShapes.get(i).getId();
            if (parId == shape_id_actu){
                listShapes.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean getShapeExist(int parId){
        for (int i=0; i<listShapes.size(); i++){
            int shape_id_actu = listShapes.get(i).getId();
            if (parId == shape_id_actu){
                return true;
            }
        }
        return false;
    }

    public void set_layer_visibility(){
        if (getVisible()) {
            visible = false;
        }
        else{
            visible = true;
        }
    }

//    public boolean set_shape_visibility(int parShapeId){
//        for (ArrayList listShape : mapShapes.values()) {
//            for (Shape shape : listShape){
//                if (shape.getId() == parShapeId) {
//                    shape.set_shape_visibility();
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    public boolean set_shape_visibility(int parShapeId){

        for (int i=0; i<listShapes.size(); i++){
            Shape shape_id_actu = listShapes.get(i);
            if (shape_id_actu.getId() == parShapeId) {
                shape_id_actu.set_shape_visibility();
                return true;
            }
        }
        return false;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public boolean getVisible(){
        return visible;
    }
    public String toString(){
        String str;
        str = getId()+" Layer " + getName();
        return str;
    }

    public void printListShape(){
        System.out.println("----- "+this.getName()+" -----");
        for (Shape shape : listShapes) {
            System.out.println(shape.toString());
        }
    }

    public ArrayList<Shape> getListShapes(){
        return listShapes;
    }



}
