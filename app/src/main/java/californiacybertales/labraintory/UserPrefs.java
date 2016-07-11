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

}

