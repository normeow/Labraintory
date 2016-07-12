package californiacybertales.labraintory.database;

import java.util.ArrayList;

/**
 * Created by Tatiana on 12/07/2016.
 */
public class Subject {
    private int id;
    private String name;

    public String getName() {
        return name;
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public int getId() {
        return id;
    }

    private ArrayList<Node> nodes;

    public Subject(){
        id = -1;
    }

    public Subject(int id, String name, ArrayList<Node> nodes){
        this.id = id;
        this.name = name;
        this.nodes = nodes;
    }


}
