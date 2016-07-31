package californiacybertales.labraintory.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import californiacybertales.labraintory.database.Section;
import californiacybertales.labraintory.database.Subject;

/**
 * Created by Tatiana on 31/07/2016.
 */
public class SectionAdapter extends ArrayAdapter<Section> {
    public SectionAdapter(Context context, int resource, ArrayList<Section> sections) {
        super(context, resource, sections);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //todo
        return super.getView(position, convertView, parent);
    }
}
