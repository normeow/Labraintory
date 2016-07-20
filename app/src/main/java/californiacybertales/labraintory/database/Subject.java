package californiacybertales.labraintory.database;

import java.util.ArrayList;

/**
 * Created by Tatiana on 12/07/2016.
 */
public class Subject {
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNodes(ArrayList<Section> nodes) {
        this.nodes = nodes;
    }

    private String name;

    public String getName() {
        return name;
    }

    public ArrayList<Section> getNodes() {
        return nodes;
    }

    public int getId() {
        return id;
    }

    private ArrayList<Section> nodes;

    public Subject(){
        id = -1;
    }

    public Subject(int id, String name, ArrayList<Section> nodes){
        this.id = id;
        this.name = name;
        this.nodes = nodes;
    }


}
