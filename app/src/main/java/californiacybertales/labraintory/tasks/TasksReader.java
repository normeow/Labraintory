package californiacybertales.labraintory.tasks;


import android.os.AsyncTask;

public class TasksReader extends AsyncTask<String, Void, Task[]>
{

    /**
     * Override this method to perform a computation on a background thread. The
     * specified parameters are the parameters passed to {@link #execute}
     * by the caller of this task.
     * <p/>
     * This method can call {@link #publishProgress} to publish updates
     * on the UI thread.
     *
     * @param params The parameters of the task.
     * @return A result, defined by the subclass of this task.
     * @see #onPreExecute()
     * @see #onPostExecute
     * @see #publishProgress
     */
    @Override
    protected Task[] doInBackground(String... params) {
        return new Task[0];
    }
}
