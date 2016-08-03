package californiacybertales.labraintory.database;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;

import californiacybertales.labraintory.App;
import californiacybertales.labraintory.R;
import californiacybertales.labraintory.tasks.*;

/**
 * Created by Tatiana on 12/07/2016.
 */
public class Section {
    private int id;
    private String name;
    private int subj_id;
    private ArrayList<Lesson> lessons;

    private Bitmap icon;

    public Bitmap getIcon() {
        return icon;
    }

    public void setIcon(Bitmap icon) {
        this.icon = icon;
    }

    public void setIcon(String iconPath) {
        Bitmap icon = BitmapFactory.decodeFile(iconPath);
        this.icon = icon;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSubj_id() {
        return subj_id;
    }

    public void setSubj_id(int subj_id) {
        this.subj_id = subj_id;
    }

    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

    public void setTasks(ArrayList<Lesson> lessons) {
        this.lessons = lessons;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Section(){
        id = -1;
    }

    public Section(int id, int subj_id, String name, ArrayList<Lesson> lessons, String icon_path){
        this.id = id;
        this.name = name;
        this.lessons = lessons;
        this.setIcon(icon_path);
    }

    public Section(int id, int subj_id, String name, ArrayList<Lesson> lessons){
        this.id = id;
        this.name = name;
        this.lessons = lessons;
        this.setIcon(BitmapFactory.decodeResource(App.getContext().getResources(), R.drawable.default_image));
    }
}
