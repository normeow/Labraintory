package californiacybertales.labraintory.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import californiacybertales.labraintory.tasks.*;

/**
 * Created by Tatiana on 12/07/2016.
 */
public class DbHelper extends SQLiteOpenHelper {

    //local db doesn't keep language code and translations
    //there is no autoincrement - all information is taken from server
    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "labraintorydb";
    private static final String KEY_ID = "id";

    private static final String NAME_TABLE_SUBJECTS = "subjects";
    private static final String KEY_SUBJ_NAME = "subj_name";

    private static final String NAME_TABLE_SECTIONS = "sections";
    private static final String KEY_SCORES_TO_OPEN = "open_scores";
    private static final String KEY_SECT_NAME = "sect_name";
    private static final String KEY_FOREIGN_SUBJ_ID = "f_key_subj_id";

    private static final String NAME_TABLE_LESSONS = "lessons";
    private static final String KEY_LESSON_NAME = "lesson_name";
    private static final String KEY_FOREIGN_SECT_ID = "f_key_sect_id";

    private static final String NAME_TABLE_TYPE_TASK = "types_tasks";
    private static final String KEY_TASK_TYPE = "type";

    private static final String NAME_TABLE_TASKS = "tasks";
    private static final String KEY_FOREIGN_LESSON_ID = "f_key_section_id";
    private static final String KEY_FOREIGN_TASK_TYPE_ID = "type_id";
    private static final String KEY_TASK_DESCIPTION = "description";
    private static final String KEY_MAXSCORES = "max_scores";
    private static final String KEY_TASK_CURSCORES = "cur_scores";

    private static final String NAME_TABLE_CHOICE_RIGHT_ANSWER = "choice_right_ans";
    private static final String NAME_TABLE_CHOICE_WRONG_ANSWER = "choice_wrong_ans";
    private static final String NAME_TABLE_LECTURES = "lectures";
    private static final String NAME_TABLE_WRITTEN_QUESTIONS = "written_quest";
    private static final String NAME_TABLE_WRITTEN_ANSWERS = "writtena_ans";
    private static final String NAME_TABLE_COMPARSION_LEFT = "comparsion_left";
    private static final String NAME_TABLE_COMPARSION_RIGHT = "comparsion_right";

    private static final String KEY_FOREIGN_LEFT_ID = "f_key_left_id";
    private static final String KEY_QUESTION = "question";

    private static final String KEY_FOREIGN_TASK_ID = "f_key_task_id";
    private static final String KEY_IMAGE = "is_image";
    private static final String KEY_ANSWER = "ans";

    public DbHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        createSubjTable(db);
        createSectionTable(db);
        createLessonsTable(db);
        createTypeTaskTable(db);
        createTaskTable(db);
        createChoiceRightAnsTable(db);
        createChoiceWrongAnsTable(db);
        createLecturesTable(db);
        createWrittenQuestionTable(db);
        createWrittenAnswerTable(db);
        createComparsionLeftTable(db);
        createComparsionRightTable(db);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + NAME_TABLE_SUBJECTS);
        db.execSQL("DROP TABLE IF EXISTS" + NAME_TABLE_SECTIONS);
        // create fresh table
        this.onCreate(db);
    }


    public  void dropTable(SQLiteDatabase db, String tableName){
        db.execSQL("DROP TABLE IF EXISTS" + tableName);
    }

    public  void createSubjTable(SQLiteDatabase db){
        String query = "CREATE_TABLE " + NAME_TABLE_SUBJECTS + " (" + KEY_ID + " INTEGER " +
                KEY_SUBJ_NAME + " VARCHAR(20) " + ")";
        db.execSQL(query);
    }

    public  void createSectionTable(SQLiteDatabase db){
        String query = "CREATE_TABLE " + NAME_TABLE_SECTIONS + " (" + KEY_ID + " INTEGER " +
                KEY_SECT_NAME + " VARCHAR(50) " +
                KEY_SCORES_TO_OPEN + " INTEGER " +
                "FOREIGN KEY(" + KEY_FOREIGN_SUBJ_ID + ") REFERENCES " + NAME_TABLE_SUBJECTS + " (" + KEY_ID + ")"+
                ")";
        db.execSQL(query);
    }

    public  void createTypeTaskTable(SQLiteDatabase db){
        String query = "CREATE_TABLE " + NAME_TABLE_SECTIONS + " (" + KEY_ID + " INTEGER " +
                KEY_SECT_NAME + " VARCHAR(50) " +
                KEY_SCORES_TO_OPEN + " INTEGER " +
                "FOREIGN KEY(" + KEY_FOREIGN_SUBJ_ID + ") REFERENCES " + NAME_TABLE_SUBJECTS + " (" + KEY_ID + ")"+
                ")";
        db.execSQL(query);
    }

    public void createLessonsTable(SQLiteDatabase db){
        String query = "CREATE_TABLE " + NAME_TABLE_LESSONS + " (" + KEY_ID + " INTEGER " +
                KEY_LESSON_NAME + " TEXT " +
                "FOREIGN KEY(" + KEY_FOREIGN_SECT_ID + ") REFERENCES " + NAME_TABLE_SECTIONS + " (" + KEY_ID + ")"+
                ")";
        db.execSQL(query);
    }

    public void createTaskTable(SQLiteDatabase db){
        String query = "CREATE_TABLE " + NAME_TABLE_TASKS + " (" + KEY_ID + " INTEGER " +
                KEY_TASK_DESCIPTION + " TEXT " +
                KEY_MAXSCORES + " INTEGER " +
                KEY_TASK_CURSCORES + " INTEGER " +
                "FOREIGN KEY(" + KEY_FOREIGN_LESSON_ID + ") REFERENCES " + NAME_TABLE_SECTIONS + " (" + KEY_ID + ")"+
                "FOREIGN KEY(" + KEY_FOREIGN_TASK_TYPE_ID + ") REFERENCES " + NAME_TABLE_TYPE_TASK + " (" + KEY_ID + ")"+
                ")";
        db.execSQL(query);
    }

    public void createChoiceRightAnsTable(SQLiteDatabase db){
        String query = "CREATE_TABLE " + NAME_TABLE_CHOICE_RIGHT_ANSWER + " (" + KEY_ID + " INTEGER " +
                KEY_ANSWER + " TEXT " +
                KEY_IMAGE + " BINARY " +
                "FOREIGN KEY(" + KEY_FOREIGN_TASK_ID + ") REFERENCES " + NAME_TABLE_TASKS + " (" + KEY_ID + ")"+
                ")";
        db.execSQL(query);
    }

    public void createChoiceWrongAnsTable(SQLiteDatabase db){
        String query = "CREATE_TABLE " + NAME_TABLE_CHOICE_WRONG_ANSWER + " (" + KEY_ID + " INTEGER " +
                KEY_ANSWER + " TEXT " +
                KEY_IMAGE + " BINARY " +
                "FOREIGN KEY(" + KEY_FOREIGN_TASK_ID + ") REFERENCES " + NAME_TABLE_TASKS + " (" + KEY_ID + ")"+
                ")";
        db.execSQL(query);
    }

    public void createLecturesTable(SQLiteDatabase db){
        String query = "CREATE_TABLE " + NAME_TABLE_LECTURES + " (" + KEY_ID + " INTEGER " +
                KEY_ANSWER + " TEXT " +
                "FOREIGN KEY(" + KEY_FOREIGN_TASK_ID + ") REFERENCES " + NAME_TABLE_TASKS + " (" + KEY_ID + ")"+
                ")";
        db.execSQL(query);
    }

    public void createWrittenQuestionTable(SQLiteDatabase db){
        String query = "CREATE_TABLE " + NAME_TABLE_WRITTEN_QUESTIONS + " (" + KEY_ID + " INTEGER " +
                KEY_QUESTION + " TEXT " +
                "FOREIGN KEY(" + KEY_FOREIGN_TASK_ID + ") REFERENCES " + NAME_TABLE_TASKS + " (" + KEY_ID + ")"+
                ")";
        db.execSQL(query);
    }

    public void createWrittenAnswerTable(SQLiteDatabase db){
        String query = "CREATE_TABLE " + NAME_TABLE_WRITTEN_ANSWERS + " (" + KEY_ID + " INTEGER " +
                KEY_ANSWER + " TEXT " +
                "FOREIGN KEY(" + KEY_FOREIGN_TASK_ID + ") REFERENCES " + NAME_TABLE_TASKS + " (" + KEY_ID + ")"+
                ")";
        db.execSQL(query);
    }

    public void createComparsionLeftTable(SQLiteDatabase db){
        String query = "CREATE_TABLE " + NAME_TABLE_COMPARSION_LEFT+ " (" + KEY_ID + " INTEGER " +
                KEY_IMAGE + " BINARY " +
                KEY_ANSWER + " TEXT " +
                "FOREIGN KEY(" + KEY_FOREIGN_TASK_ID + ") REFERENCES " + NAME_TABLE_TASKS + " (" + KEY_ID + ")"+
                ")";
        db.execSQL(query);
    }


    public void createComparsionRightTable(SQLiteDatabase db){
        String query = "CREATE_TABLE " + NAME_TABLE_COMPARSION_RIGHT + " (" + KEY_ID + " INTEGER " +
                KEY_IMAGE + " BINARY " +
                KEY_ANSWER + " TEXT " +
                "FOREIGN KEY(" + KEY_FOREIGN_TASK_ID + ") REFERENCES " + NAME_TABLE_TASKS + " (" + KEY_ID + ")"+
                "FOREIGN KEY(" + KEY_FOREIGN_LEFT_ID + ") REFERENCES " + NAME_TABLE_COMPARSION_LEFT + " (" + KEY_ID + ")"+
                ")";
        db.execSQL(query);
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


//we don't need this actually, coz' it's abut server-side
    public int addSection(Section section){

        /*SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NODE_NAME, section.getName());
        contentValues.put(KEY_FOREIGN_TOSUBJECTS, section.getSubj_id());
        int id = Integer.parseInt(String.valueOf(db.insert(NAME_TABLE_SECTIONS, null, contentValues)));
        db.close();*/
        return -1;
    }

    public int addTask(Task task){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        if (task instanceof radioChoiceTask){

        }
        int id = Integer.parseInt(String.valueOf(db.insert(NAME_TABLE_TASKS, null, contentValues)));
        db.close();
        return id;
    }

    public ArrayList<Subject> getSubjects(String SubjectName){
        ArrayList<Section> phys = new ArrayList<Section>();
        phys.add(new Section(1, 0, "Кинематика", null));
        phys.add(new Section(2, 0, "Кинематика2", null));
        phys.add(new Section(3, 0, "Кинематика3", null));
        phys.add(new Section(4, 0, "Кинематика4", null));
        Subject s = new Subject(0, "Physics", phys);

        ArrayList<Subject> res = new ArrayList<>();
        res.add(s);
        return res;
    }


}
