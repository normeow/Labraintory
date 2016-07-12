package californiacybertales.labraintory.database;

import java.util.ArrayList;

import californiacybertales.labraintory.tasks.*;

/**
 * Created by Tatiana on 12/07/2016.
 */
public class Node {
    private int id;
    private String name;
    //todo add scores
    private ArrayList<Task> tasks;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Node(){
        id = -1;
    }

    public Node(int id, String name, ArrayList<Task> tasks){
        this.id = id;
        this.name = name;
        this.tasks = tasks;
    }
}
