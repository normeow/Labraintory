package californiacybertales.labraintory.database;

import java.util.ArrayList;

import californiacybertales.labraintory.tasks.Task;

/**
 * Created by Tatiana on 31/07/2016.
 */
public class Lesson {
    private ArrayList<Task> tasks;
    private int maxScores;
    private int curScores;

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public Lesson(){
        tasks = null;

    }

    public Lesson(ArrayList<Task> tasks){
        this.tasks = tasks;
        //todo scores
    }

}
