package layer_area;

import java.util.ArrayList;

public class Area {

    public ArrayList<Area> listAreas;
    public int widht;
    public int height;
    public int id;
    public String name;
    
    public Area(int parWidht, int parHeight, int parId, String parName){
        widht = parWidht;
        height = parHeight;
        id = parId;
        name = parName;
        listAreas = new ArrayList<>();
    }

    public void add_Area_to_list(int parWidht, int parHeight, int parId, String parName){
        Area new_Area = new Area(parWidht, parHeight, parId, parName);
        listAreas.add(new_Area);
    }

    public boolean delete_Area_to_list(int parId){
        for (int i=0; i<listAreas.size(); i++){
            int Area_id_actu = listAreas.get(i).getId();
            if (parId == Area_id_actu){
                listAreas.remove(i);
                return true;
            }
        }
        return false;
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
