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

import californiacybertales.labraintory.R;
import californiacybertales.labraintory.adapters.SectionAdapter;
import californiacybertales.labraintory.database.Section;
import californiacybertales.labraintory.database.Subject;

/**
 * Created by Tatiana on 31/07/2016.
 */
public class SectionsFragment extends Fragment {
    private static String TAG = "SectionsFragment";

    public interface OnSectionFragmentListener {
        void onReloadSectionsList();
        void onSectionClicked(Subject s);
    }
    private ArrayList<Section> sections;
    private ListView mListView;
    private SectionAdapter adapter;
    OnSectionFragmentListener listener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.listview_layout, container, false);
        listener.onReloadSectionsList();
        mListView = (ListView)view.findViewById(R.id.lview);
        adapter = new SectionAdapter(getContext(), R.layout.list_item1, sections);
        mListView.setAdapter(adapter);
        Log.v(TAG, "view created");
        return view;
    }

    @Override
    public void onAttach(Context context) {
        listener = (OnSectionFragmentListener)context;
        super.onAttach(context);
    }
    //TODO why don't request DB directly? How about other pattenrs? Do we actually need use listener as a presenter?
    public void setSectionsList(ArrayList<Section> sections){
        this.sections = sections;
    }

}
