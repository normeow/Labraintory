package californiacybertales.labraintory.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import californiacybertales.labraintory.database.Lesson;
import californiacybertales.labraintory.database.Subject;

/**
 * Created by Tatiana on 31/07/2016.
 */
public class LessonAdapter extends ArrayAdapter<Lesson> {
    public LessonAdapter(Context context, int resource, ArrayList<Lesson> lessons) {
        super(context, resource, lessons);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //todo
        return super.getView(position, convertView, parent);
    }
}
