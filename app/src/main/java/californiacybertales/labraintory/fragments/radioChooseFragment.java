package californiacybertales.labraintory.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import java.util.ArrayList;

import californiacybertales.labraintory.R;

/**
 * Created by romach on 15.07.16.
 */
public class radioChooseFragment extends Fragment
{
    /**
     * Called to do initial creation of a fragment.  This is called after
     * {@link #onAttach(Activity)} and before
     * {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.
     * <p>
     * <p>Note that this can be called while the fragment's activity is
     * still in the process of being created.  As such, you can not rely
     * on things like the activity's content view hierarchy being initialized
     * at this point.  If you want to do work once the activity itself is
     * created, see {@link #onActivityCreated(Bundle)}.
     *
     * @param savedInstanceState If the fragment is being re-created from
     *                           a previous saved state, this is the state.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private ArrayList<RadioButton> buttons;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.radio_choise_fragment, container, false);

        // Horrible. Just to test, sure to rewrite
        buttons = new ArrayList<>();
        buttons.add((RadioButton)view.findViewById(R.id.radioButton0));
        buttons.add((RadioButton)view.findViewById(R.id.radioButton1));
        buttons.add((RadioButton)view.findViewById(R.id.radioButton2));
        buttons.add((RadioButton)view.findViewById(R.id.radioButton3));

        for (int i = 0; i < buttons.size(); ++i) {
            final int finalI = i;
            buttons.get(i).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked) {
                        changeAllButtons(finalI);
                    }
                    else
                        buttons.get(finalI).setChecked(false);
                }
            });
        }

        return view;
    }

    // just to test
    private void changeAllButtons(int id){
        for (int i = 0; i < buttons.size(); ++i)
        {
            if(i != id)
                buttons.get(i).setChecked(false);
            else
                buttons.get(i).setChecked(true);
        }
    }

}
