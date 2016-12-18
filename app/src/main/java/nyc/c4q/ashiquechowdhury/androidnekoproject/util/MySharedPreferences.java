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
    private static final String SPINCOUNT = "nyc.c4q.ashiquechowdhury.SPINCOUNT";
    private static final String AQUAMAN = "nyc.c4q.ashiquechowdhury.AQUAMAN";
    private static final String BATMAN = "nyc.c4q.ashiquechowdhury.BATMAN";
    private static final String BLACKSTAR = "nyc.c4q.ashiquechowdhury.BLACKSTAR";
    private static final String BLACKWIDOW = "nyc.c4q.ashiquechowdhury.BLACKWIDOW";
    private static final String CAPTAINAMERICA = "nyc.c4q.ashiquechowdhury.CAPTAINAMERICA";
    private static final String CYBORG = "nyc.c4q.ashiquechowdhury.CYBORG";
    private static final String DAREDEVIL = "nyc.c4q.ashiquechowdhury.DAREDEVIL";
    private static final String FLASHCOUNT = "nyc.c4q.ashiquechowdhury.FLASHCOUNT";
    private static final String GREENARROWCOUNT = "nyc.c4q.ashiquechowdhury.GREENARROW";
    private static final String GREENLANTERNCOUNT = "nyc.c4q.ashiquechowdhury.GREENLANTERN";
    private static final String HAWKEYECOUNT = "nyc.c4q.ashiquechowdhury.HAWKEYE";
    private static final String HULKCOUNT = "nyc.c4q.ashiquechowdhury.HULK";
    private static final String SPIDERMANCOUNT = "nyc.c4q.ashiquechowdhury.SPIDERMAN";
    private static final String SUPERMANCOUNT = "nyc.c4q.ashiquechowdhury.SUPERMAN";
    private static final String THORCOUNT = "nyc.c4q.ashiquechowdhury.THOR";
    private static final String WONDERWOMANCOUNT = "nyc.c4q.ashiquechowdhury.WONDERWOMAN";
    private static final String NICKFURYCOUNT = "nyc.c4q.ashiquechowdhury.NICKFURY";



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
