package californiacybertales.labraintory.database;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;

import californiacybertales.labraintory.App;
import californiacybertales.labraintory.R;

/**
 * Created by Tatiana on 12/07/2016.
 */
public class Subject {
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

    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSections(ArrayList<Section> sections) {
        this.sections = sections;
    }

    private String name;

    public String getName() {
        return name;
    }

    public ArrayList<Section> getSections() {
        return sections;
    }

    public int getId() {
        return id;
    }

    private ArrayList<Section> sections;

    public Subject(){
        id = -1;
    }

    public Subject(int id, String name, ArrayList<Section> sections, String icon_path){
        this.id = id;
        this.name = name;
        this.sections = sections;
        this.setIcon(icon_path);
    }

    public Subject(int id, String name, ArrayList<Section> sections){
        this.id = id;
        this.name = name;
        this.sections = sections;
        this.setIcon(BitmapFactory.decodeResource(App.getContext().getResources(), R.drawable.default_image));
    }


}
