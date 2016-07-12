package californiacybertales.labraintory.database;

import java.util.ArrayList;

import californiacybertales.labraintory.tasks.*;

/**
 * Created by Tatiana on 12/07/2016.
 */
public class Node {
    private int id;
    private String name;
    private int subj_id;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSubj_id() {
        return subj_id;
    }

    public void setSubj_id(int subj_id) {
        this.subj_id = subj_id;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

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

    public Node(int id, int subj_id, String name, ArrayList<Task> tasks){
        this.id = id;
        this.name = name;
        this.tasks = tasks;
    }
}
