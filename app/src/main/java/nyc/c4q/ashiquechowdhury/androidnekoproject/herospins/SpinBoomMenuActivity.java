package nyc.c4q.ashiquechowdhury.androidnekoproject.herospins;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.nightonke.boommenu.BoomButtons.TextInsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.OnBoomListenerAdapter;

import java.util.HashMap;
import java.util.Map;

import nyc.c4q.ashiquechowdhury.androidnekoproject.R;
import nyc.c4q.ashiquechowdhury.androidnekoproject.util.HeroDatabaseHelper;
import nyc.c4q.ashiquechowdhury.androidnekoproject.util.MySharedPreferences;
import nyc.c4q.ashiquechowdhury.androidnekoproject.util.RandomNumberChooser;

/**
 * Created by ashiquechowdhury on 12/17/16.
 */

public class SpinBoomMenuActivity extends AppCompatActivity {
    MySharedPreferences sharedPrefs;
    TextView topTextView;
    BoomMenuButton bmb9;
    BoomMenuButton bmb1;
    private SQLiteDatabase db;
    int[] heroDrawableArray;
    String[] heroStringKeyArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boommenu_spinner);

        heroDrawableArray = new int[]{
                R.drawable.aquaman,
                R.drawable.batman,
                R.drawable.blackwidow,
                R.drawable.captainamerica,
                R.drawable.cyborg,
                R.drawable.daredevil,
                R.drawable.hawkeye,
                R.drawable.greenlantern,
                R.drawable.flash,
                R.drawable.nickfury,
                R.drawable.wonderwoman,
                R.drawable.thor,
                R.drawable.superman,
                R.drawable.spiderman,
                R.drawable.greenarrow,
                R.drawable.hulk
        };

        heroStringKeyArray = new String[]{
                MySharedPreferences.AQUAMANCOUNT,
                MySharedPreferences.BATMANCOUNT,
                MySharedPreferences.BLACKWIDOWCOUNT,
                MySharedPreferences.CAPTAINAMERICACOUNT,
                MySharedPreferences.CYBORGCOUNT,
                MySharedPreferences.DAREDEVILCOUNT,
                MySharedPreferences.HAWKEYECOUNT,
                MySharedPreferences.GREENLANTERNCOUNT,
                MySharedPreferences.FLASHCOUNT,
                MySharedPreferences.NICKFURYCOUNT,
                MySharedPreferences.WONDERWOMANCOUNT,
                MySharedPreferences.THORCOUNT,
                MySharedPreferences.SUPERMANCOUNT,
                MySharedPreferences.SPIDERMANCOUNT,
                MySharedPreferences.GREENARROWCOUNT,
                MySharedPreferences.HULKCOUNT
        };

        Map<Integer, String> heroDrawableMap = new HashMap<>();
        for (int i = 0; i < heroDrawableArray.length; i++) {
            heroDrawableMap.put(heroDrawableArray[i], heroStringKeyArray[i]);
        }

        startSQLDataBase();

        topTextView = (TextView) findViewById(R.id.total_spin_tView);
        bmb9 = (BoomMenuButton) findViewById(R.id.bmb);
        bmb1 = (BoomMenuButton) findViewById(R.id.bmb2);

        sharedPrefs = MySharedPreferences.getInstance(getApplicationContext());

        setText(topTextView, sharedPrefs.getSpinCount());

        for (int i = 0; i < bmb9.getPiecePlaceEnum().pieceNumber(); i++) {
            int randNum = RandomNumberChooser.chooseRandomNumber(13);
            int randomHeroDrawable = heroDrawableArray[randNum];
            String randomHeroStringKey = heroStringKeyArray[randNum];
            sharedPrefs.increaseHeroCount(randomHeroStringKey);

            Toast.makeText(SpinBoomMenuActivity.this, String.valueOf(sharedPrefs.getHeroCount(randomHeroStringKey)), Toast.LENGTH_LONG).show();

            TextInsideCircleButton.Builder builder = new TextInsideCircleButton.Builder()
                    .normalImageRes(randomHeroDrawable)
                    .buttonRadius(100)
                    .normalText("Hero Earned!");
            bmb9.addBuilder(builder);
        }

        for (int i = 0; i < bmb1.getPiecePlaceEnum().pieceNumber(); i++) {
            int randNum = RandomNumberChooser.chooseRandomNumber(13);
            TextInsideCircleButton.Builder builder = new TextInsideCircleButton.Builder()
                    .normalImageRes(heroDrawableArray[randNum])
                    .normalText("Hero Earned!");
            bmb1.addBuilder(builder);
        }


        bmb9.setOnBoomListener(new OnBoomListenerAdapter() {
            @Override
            public void onBoomWillShow() {
                super.onBoomWillShow();
                sharedPrefs.decreaseSpinCount(1);
                setText(topTextView, sharedPrefs.getSpinCount());
            }
        });

        bmb1.setOnBoomListener(new OnBoomListenerAdapter() {
            @Override
            public void onBoomWillShow() {
                super.onBoomWillShow();
                sharedPrefs.decreaseSpinCount(9);
                setText(topTextView, sharedPrefs.getSpinCount());
            }
        });
    }

    private void startSQLDataBase() {
        HeroDatabaseHelper dbHelper = HeroDatabaseHelper.getInstance(this);
        db = dbHelper.getWritableDatabase();
    }

    private void setText(TextView myTextView, int spinCount) {
        String totalSpinCount = String.valueOf(
                spinCount
        );
        myTextView.setText(totalSpinCount + " SPINS");
    }
}