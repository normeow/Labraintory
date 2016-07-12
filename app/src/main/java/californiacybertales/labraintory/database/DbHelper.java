package californiacybertales.labraintory.database;

import android.content.Context;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Tatiana on 12/07/2016.
 */
public class DbHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "labraintorydb";

    private static final String NAME_TABLE_SUBJECTS = "subjects";
    private static final String NAME_TABLE_NODES = "nodes";
    private static final String NAME_TABLE_BINDED_NODES = "binded_nodes";

    private static final String KEY_SUBJ_ID = "id";
    private static final String KEY_SUBJ_NAME = "subj_name";

    private static final String KEY_NODE_ID = "id";
    private static final String KEY_NODE_NAME = "node_name";
    private static final String KEY_FOREIGN_TOSUBJECTS = "f_key_subj";

    //todo KEY_LOCALE

    public DbHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_SUBJECT_TABLE =
                "CREATE TABLE " + NAME_TABLE_SUBJECTS + " (" +
                KEY_SUBJ_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                KEY_SUBJ_NAME + "TEXT)";


        String CREATE_NODES_TABLE =
                "CREATE TABLE " + NAME_TABLE_NODES + " (" +
                KEY_NODE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                KEY_NODE_NAME + "TEXT " +
                KEY_FOREIGN_TOSUBJECTS + " INTEGER, " +
                "FOREIGN KEY(" + KEY_FOREIGN_TOSUBJECTS + ") REFERENCES " + NAME_TABLE_SUBJECTS + " (" + KEY_SUBJ_ID + ") )";

        db.execSQL(CREATE_SUBJECT_TABLE);
        db.execSQL(CREATE_NODES_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + NAME_TABLE_SUBJECTS);
        db.execSQL("DROP TABLE IF EXISTS" + NAME_TABLE_NODES);
        // create fresh table
        this.onCreate(db);
    }

    public ArrayList<Subject> getSubjects(String SubjectName){
        ArrayList<Node> phys = new ArrayList<Node>();
        phys.add(new Node(1, "Кинематика", null));
        phys.add(new Node(2, "Кинематика2", null));
        phys.add(new Node(3, "Кинематика3", null));
        phys.add(new Node(4, "Кинематика4", null));
        Subject s = new Subject(0, "Physics", phys);

        return null;
    }


}
