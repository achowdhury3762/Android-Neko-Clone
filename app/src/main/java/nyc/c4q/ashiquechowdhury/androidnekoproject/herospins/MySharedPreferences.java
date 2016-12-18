package nyc.c4q.ashiquechowdhury.androidnekoproject.herospins;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by ashiquechowdhury on 12/17/16.
 */
public class MySharedPreferences {
    public static MySharedPreferences instance = null;
    SharedPreferences sharedPrefs;
    private static final String SPINCOUNT = "nyc.c4q.ashiquechowdhury.SPINCOUNT";

    private MySharedPreferences(Context context){
        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static MySharedPreferences getInstance(Context context){
        if (instance == null) {
            instance = new MySharedPreferences(context);
        }
        return instance;
    }

    public int getSpinCount(){
        return sharedPrefs.getInt(SPINCOUNT, 0);
    }

    public void increaseSpinCount(int number){
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putInt(SPINCOUNT, getSpinCount() + number);
        editor.commit();
    }
}
