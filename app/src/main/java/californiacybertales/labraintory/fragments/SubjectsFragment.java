package californiacybertales.labraintory.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import californiacybertales.labraintory.MainActivity;
import californiacybertales.labraintory.R;
import californiacybertales.labraintory.adapters.SubjectAdapter;
import californiacybertales.labraintory.database.Subject;

/**
 * Created by Tatiana on 31/07/2016.
 */
public class SubjectsFragment extends Fragment {
    public interface OnSubjectFragmentListener{
        void onReloadSubjectList();
        void onSubjectClicked(Subject s);
    }
    private ArrayList<Subject> subjects;
    private ListView mListView;
    private SubjectAdapter adapter;
    OnSubjectFragmentListener listener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.listview_layout, container, false);
        listener.onReloadSubjectList();
        mListView = (ListView)view.findViewById(R.id.lview);
        adapter = new SubjectAdapter(getContext(), R.layout.list_item1, subjects);
        mListView.setAdapter(adapter);
        Log.v("SubjectFragment", "view created");
        return view;
    }

    @Override
    public void onAttach(Context context) {
        listener = (OnSubjectFragmentListener)context;
        super.onAttach(context);
    }

    public void setSubjectsList(ArrayList<Subject> subjects){
        this.subjects = subjects;
    }

}
