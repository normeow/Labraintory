package californiacybertales.labraintory.tasks;

import java.util.ArrayList;
import java.util.Random;

/**
 * Текстовое задание с выбором одного правильного ответа
 */
public class TextCheckTask extends Task
{
    public int getCorrect_num() {
        return correct_num;
    }

    public ArrayList<String> getMixed() {
        return mixed;
    }

    private int correct_num = 0;
    private ArrayList<String> mixed = null;

    public int getUser_reply() {
        return user_reply;
    }

    public void setUser_reply(int user_reply) {
        this.user_reply = user_reply;
    }

    private int user_reply = -1;

    public TextCheckTask(String id, int Scores, String Description, ArrayList<String> Corrects, ArrayList<String> Wrongs)
    {
        super(id, Scores, Description, Corrects, Wrongs);
    }

    public ArrayList<String> mix_answers()
    {
        ArrayList<String> res = new ArrayList<>();
        res.add(this.correct_answers.get(0));
        for (int i = 0; i < 3; ++i)
            res.add(this.wrong_answers.get(i));

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

        ArrayList<String> res1 = new ArrayList<>();

        for(int i = 0; i < 4; ++i)
        {
            String tmp = res.get(ind.get(i));
            res1.add(tmp);
            if (tmp.equals(this.correct_answers.get(0))) {
                correct_num = i;
            }
        }

        return  res1;
    }

    // проверка на совпадение перемешенного вопроса с ответом пользователя
    @Override
    protected boolean checkCorrect()
    {
        if(user_reply == -1)
            return false;

        return correct_num == user_reply;
    }

    // проверка правильности решения
    @Override
    public boolean checkTask()
    {
        boolean isCorrect = checkCorrect();
        if(!isCorrect)
        {
            this.user_reply = -1;
            //this.mixed = mix_answers();
        }

        // вот тут добавить scores

        return isCorrect;
    }
}
