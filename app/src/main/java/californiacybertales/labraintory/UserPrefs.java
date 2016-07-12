package californiacybertales.labraintory;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Tatiana on 11/07/2016.
 */
public class UserPrefs {

    private static final String USER_EMAIL = "UserEmail";
    private static final String USER_DETAILS = "UserDetails";
    private static final String USER_NAME = "Username";
    private static final String CURRENT_SUBJECT = "CurrentSubjectId";

    public static String getUserEmail(){
        Context c = App.getContext();
        SharedPreferences prefs = c.getSharedPreferences(USER_DETAILS, Context.MODE_PRIVATE);
        if (prefs != null)
            return prefs.getString(USER_EMAIL, null);
        else
            return "";
    }

    public static void setStartDefault(){
        SharedPreferences prefs = App.getContext().getSharedPreferences(USER_DETAILS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(USER_EMAIL, "");
    }

    public static void setUserDetails(String name, String email){
        SharedPreferences prefs = App.getContext().getSharedPreferences(USER_DETAILS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(USER_EMAIL, email);
        editor.putString(USER_NAME, name);
    }

    // Устанавливает id дисциплины, которую в текущий момент изучает пользователь
    public static void setCurrentSubjectId(int idSubject)
    {
        SharedPreferences prefs = App.getContext().getSharedPreferences(USER_DETAILS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(CURRENT_SUBJECT, idSubject);
    }

    public static int getCurrentSubjectId()
    {
        Context c = App.getContext();
        SharedPreferences prefs = c.getSharedPreferences(USER_DETAILS, Context.MODE_PRIVATE);
        if (prefs != null)
            return prefs.getInt(CURRENT_SUBJECT, -1);
        else
            return -1;
    }
}

