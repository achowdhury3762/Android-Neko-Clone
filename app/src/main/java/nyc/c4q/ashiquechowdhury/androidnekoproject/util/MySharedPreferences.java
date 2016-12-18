package nyc.c4q.ashiquechowdhury.androidnekoproject.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by ashiquechowdhury on 12/17/16.
 */
public class MySharedPreferences {
    public static MySharedPreferences instance = null;
    SharedPreferences sharedPrefs;
    public static final String SPINCOUNT = "nyc.c4q.ashiquechowdhury.SPINCOUNT";
    public static final String AQUAMAN = "nyc.c4q.ashiquechowdhury.AQUAMAN";
    public static final String BATMAN = "nyc.c4q.ashiquechowdhury.BATMAN";
    public static final String BLACKWIDOWCOUNT = "nyc.c4q.ashiquechowdhury.BLACKWIDOW";
    public static final String CAPTAINAMERICACOUNT = "nyc.c4q.ashiquechowdhury.CAPTAINAMERICA";
    public static final String CYBORGCOUNT = "nyc.c4q.ashiquechowdhury.CYBORG";
    public static final String DAREDEVILCOUNT = "nyc.c4q.ashiquechowdhury.DAREDEVIL";
    public static final String FLASHCOUNT = "nyc.c4q.ashiquechowdhury.FLASHCOUNT";
    public static final String GREENARROWCOUNT = "nyc.c4q.ashiquechowdhury.GREENARROW";
    public static final String GREENLANTERNCOUNT = "nyc.c4q.ashiquechowdhury.GREENLANTERN";
    public static final String HAWKEYECOUNT = "nyc.c4q.ashiquechowdhury.HAWKEYE";
    public static final String HULKCOUNT = "nyc.c4q.ashiquechowdhury.HULK";
    public static final String SPIDERMANCOUNT = "nyc.c4q.ashiquechowdhury.SPIDERMAN";
    public static final String SUPERMANCOUNT = "nyc.c4q.ashiquechowdhury.SUPERMAN";
    public static final String THORCOUNT = "nyc.c4q.ashiquechowdhury.THOR";
    public static final String WONDERWOMANCOUNT = "nyc.c4q.ashiquechowdhury.WONDERWOMAN";
    public static final String NICKFURYCOUNT = "nyc.c4q.ashiquechowdhury.NICKFURY";


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
    public int getHeroCount(String sharedPrefKey){
        return sharedPrefs.getInt(sharedPrefKey, 0);
    }

    public void increaseSpinCount(int number){
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putInt(SPINCOUNT, getSpinCount() + number);
        editor.commit();
    }

    public void decreaseSpinCount(int number) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putInt(SPINCOUNT, getSpinCount() - number);
        editor.commit();
    }

    public void increaseHeroCount(String SharedPrefKey){
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putInt(SharedPrefKey, getHeroCount(SharedPrefKey));
        editor.commit();
    }
}