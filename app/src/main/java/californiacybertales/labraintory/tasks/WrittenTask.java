package californiacybertales.labraintory.tasks;

import java.util.ArrayList;

/**
 * Created by romach on 23.04.16
 */
public class WrittenTask extends Task
{
    private String user_reply;

    public void setUser_reply(String user_reply) {
        this.user_reply = user_reply;
    }

    public WrittenTask(String id, int Scores, String Description, ArrayList<String> Corrects) {
        super(id, Scores, Description, Corrects, null);
        user_reply = "";
    }

    @Override
    public boolean checkTask()
    {
        return user_reply != "" && this.correct_answers.contains(user_reply);
    }

    @Override
    public boolean checkCorrect() {
        boolean check = checkTask();
        if(!check)
        {
            user_reply = "";
        }

        return check;
    }
}
