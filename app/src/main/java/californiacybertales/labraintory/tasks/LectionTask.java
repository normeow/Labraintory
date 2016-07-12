package californiacybertales.labraintory.tasks;

/**
 * Created by romach on 24.04.16.
 */
public class LectionTask extends Task {
    public LectionTask(String id, String Description) {
        super(id, 0, Description, null, null);
    }

    @Override
    public boolean checkTask() {
        return true;
    }

    @Override
    protected boolean checkCorrect() {
        return true;
    }
}
