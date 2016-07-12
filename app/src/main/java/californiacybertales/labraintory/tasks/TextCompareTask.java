package californiacybertales.labraintory.tasks;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by romach on 23.04.16.
 * Задание на сопоставление колонок
 */
public class TextCompareTask extends Task
{
    public ArrayList<String> getFirst() {
        return first;
    }

    public ArrayList<String> getSecond() {
        return second;
    }

    private ArrayList<String> first  = null;
    private ArrayList<String> second = null;

    // ********************
    private ArrayList<String> mixed = null;

    public ArrayList<String> getUser_reply() {
        return user_reply;
    }

    public void setUser_reply(ArrayList<String> user_reply) {
        this.user_reply = user_reply;
    }

    private ArrayList<String> user_reply = null;

    // ********************

    public TextCompareTask(String id, int Scores, String Description, ArrayList<String> First, ArrayList<String> Second)
    {
        super(id, Scores, Description, null, null);

        if(First.size() != Second.size()) // ну тут говно. было бы странно, если
            throw new IllegalArgumentException();

        this.first = First;
        this.second = Second;
        mixed = mix_answers();
    }

    private ArrayList<String> mix_answers()
    {
        ArrayList<String> res = new ArrayList<>();

        ArrayList<Integer> ind = new ArrayList<>();
        for(int i = 0; i < 4; ++i)
            ind.add(i);

        Random rd = new Random();
        // random shuffle
        for (int i = ind.size() - 1; i > 0; i--)
        {
            int index = rd.nextInt(i + 1);
            // Simple swap
            int a = ind.get(index);
            ind.set(index, ind.get(i));
            ind.set(i, a);
        }

        for(int i = 0; i < ind.size(); ++i)
            res.add(this.second.get(ind.get(i)));

        return  res;
    }

    @Override
    public boolean checkTask() {
        if(user_reply == null)
            return false;

        return mixed.equals(user_reply);
    }

    @Override
    protected boolean checkCorrect() {
        boolean isCorrect = checkTask();
        if(!isCorrect)
        {
            this.user_reply = null;
        }

        return isCorrect;
    }
}
