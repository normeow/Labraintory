package californiacybertales.labraintory.tasks;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by romach on 23.04.16.
 */

public class Task
{
    public String id;
    public int scores;
    public String description;
    public ArrayList<String> correct_answers;
    public ArrayList<String> wrong_answers;

    public Task(String id, int Scores, String Description, ArrayList<String> Corrects, ArrayList<String> Wrongs)
    {
        this.id = id;
        this.scores = Scores;
        this.description = Description;
        this.correct_answers = Corrects;
        this.wrong_answers = Wrongs;
    }

    public boolean checkTask() {return false; }

    protected boolean checkCorrect() {return false; }

    protected int rand_int(Random rd, int min, int max)
    {
        return rd.nextInt(max - min) + min;
    }
}

