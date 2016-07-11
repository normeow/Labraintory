package californiacybertales.labraintory.Tasks;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by romach on 23.04.16.
 */
public class ImageCheckTask extends Task
{
    private Drawable image = null;

    public Drawable getImage() {
        return image;
    }

    public int getUser_reply() {
        return user_reply;
    }

    public void setUser_reply(int user_reply) {
        this.user_reply = user_reply;
    }

    private int user_reply = -1;

    public ArrayList<String> getMixed() {
        return mixed;
    }

    private int correct_num = 0;
    private ArrayList<String> mixed = null;

    public ImageCheckTask(String id, int Scores, String Description, ArrayList<String> Corrects,
                          ArrayList<String> Wrongs, Drawable image) {
        super(id, Scores, Description, Corrects, Wrongs);
        this.image = image;

        mixed = MixAnswers();
    }

    private ArrayList<String> MixAnswers()
    {
        ArrayList<String> res = new ArrayList<String>(4);
        Random rd = new Random();
        correct_num = RandInt(rd, 0, 3);

        ArrayList<Integer> ind = new ArrayList<Integer>(this.wrong_answers.size());
        for(int i = 0; i < ind.size(); ++i)
            ind.set(i, i);

        // random shuffle
        for (int i = ind.size() - 1; i > 0; i--)
        {
            int index = rd.nextInt(i + 1);
            // Simple swap
            int a = ind.get(index);
            ind.set(index, ind.get(i));
            ind.set(i, a);
        }

        for(int i = 0; i < 4; ++i)
            res.set(i, this.wrong_answers.get(ind.get(i)));

        res.set(correct_num, this.correct_answers.get(0));

        return  res;
    }

    @Override
    public boolean checkTask() {
        if(user_reply == -1)
            return false;

        return correct_num == user_reply;
    }

    @Override
    protected boolean checkCorrect() {
        boolean isCorrect = checkTask();
        if(!isCorrect)
        {
            this.user_reply = -1;
            this.mixed = MixAnswers();
        }

        return isCorrect;
    }
}
