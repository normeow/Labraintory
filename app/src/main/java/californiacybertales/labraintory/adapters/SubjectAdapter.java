package californiacybertales.labraintory.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import californiacybertales.labraintory.R;
import californiacybertales.labraintory.database.Subject;

/**
 * Created by Tatiana on 31/07/2016.
 */
public class SubjectAdapter extends ArrayAdapter<Subject> {
    public SubjectAdapter(Context context, int resource, ArrayList<Subject> subjects) {
        super(context, resource, subjects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Subject subject = getItem(position);
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item1, null);
        ((ImageView)convertView.findViewById(R.id.icon_imview)).setImageBitmap(subject.getIcon());
        ((TextView)convertView.findViewById(R.id.textview_subname)).setText(subject.getName());
        return convertView;
    }
}
