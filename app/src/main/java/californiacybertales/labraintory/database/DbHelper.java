package californiacybertales.labraintory.database;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import californiacybertales.labraintory.tasks.*;

/**
 * Created by Tatiana on 12/07/2016.
 */
public class DbHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "labraintorydb";

    private static final String NAME_TABLE_SUBJECTS = "subjects";
    private static final String NAME_TABLE_NODES = "nodes";
    private static final String NAME_TABLE_BINDED_NODES = "binded_nodes";
    private static final String NAME_TABLE_TASKS = "tasks";

    private static final String KEY_SUBJ_ID = "id";
    private static final String KEY_SUBJ_NAME = "subj_name";

    private static final String KEY_NODE_ID = "id";
    private static final String KEY_NODE_NAME = "node_name";
    private static final String KEY_FOREIGN_TOSUBJECTS = "f_key_subj";

    private static final String KEY_TASK_ID = "id";

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

    //returns id of the Subject
    public int addSubject(Subject subject){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_SUBJ_NAME, subject.getName());
        int id = Integer.parseInt(String.valueOf(db.insert(NAME_TABLE_SUBJECTS, null, contentValues)));
        db.close();
        return id;
    }



    public int addNode(Node node){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NODE_NAME, node.getName());
        contentValues.put(KEY_FOREIGN_TOSUBJECTS, node.getSubj_id());
        int id = Integer.parseInt(String.valueOf(db.insert(NAME_TABLE_NODES, null, contentValues)));
        db.close();
        return id;
    }

    public int addTask(Task task){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        if (task instanceof TextCheckTask){

        }
        int id = Integer.parseInt(String.valueOf(db.insert(NAME_TABLE_TASKS, null, contentValues)));
        db.close();
        return id;
    }

    public ArrayList<Subject> getSubjects(String SubjectName){
        ArrayList<Node> phys = new ArrayList<Node>();
        phys.add(new Node(1, 0, "Кинематика", null));
        phys.add(new Node(2, 0, "Кинематика2", null));
        phys.add(new Node(3, 0, "Кинематика3", null));
        phys.add(new Node(4, 0, "Кинематика4", null));
        Subject s = new Subject(0, "Physics", phys);

        ArrayList<Subject> res = new ArrayList<>();
        res.add(s);
        return res;
    }


}
