package layer_area;

import java.util.ArrayList;
import java.util.HashMap;

import shape.Shape;

public class Layer {

    public ArrayList<Layer> listLayers;
    public HashMap<Layer, Shape> mapShapes;
    public int id;
    public String name;
    public boolean visible;

    public Layer(int parId, String parName){
        id = parId;
        name = parName;
        visible = false; //pas visible de base
        listLayers = new ArrayList<>();
        mapShapes = new HashMap<>();
    }

    public void add_layer_to_list(int parId, String parName){
        Layer new_layer = new Layer(parId, parName);
        listLayers.add(new_layer);
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

    public void add_shape_to_layer(Shape parShape, Layer parLayer){
        // je ne suis pas sur de si il faut deja avoir créer la shape ou si il faut faire un new shape
        // sinon : 
        // Shape new_shape = new Shape(int parId, float parThickness, int parX, int parY, Color parColor);
        // listShapes.add(new_shape);
        mapShapes.put(parLayer, parShape);
    }

    public boolean delete_shape_to_layer(int parId){
        for (Layer layer : mapShapes.keySet()) {
            Shape shape = mapShapes.get(layer);
            if (shape.getId() == parId) {
                mapShapes.remove(layer);
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

    public boolean set_shape_visibility(int parShapeId){
        for (Shape shape : mapShapes.values()) {
            if (shape.getId() == parShapeId) {
                shape.set_shape_visibility();
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

}
