package nyc.c4q.ashiquechowdhury.androidnekoproject.usehero;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.nightonke.boommenu.BoomButtons.TextInsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.OnBoomListenerAdapter;

import nyc.c4q.ashiquechowdhury.androidnekoproject.R;
import nyc.c4q.ashiquechowdhury.androidnekoproject.usehero.model.Hero;
import nyc.c4q.ashiquechowdhury.androidnekoproject.util.MySharedPreferences;
import nyc.c4q.ashiquechowdhury.androidnekoproject.util.RandomNumberChooser;

/**
 * Created by ashiquechowdhury on 12/17/16.
 */

public class UseHeroesActivity extends AppCompatActivity {
    MySharedPreferences sharedPrefs;
    TextView topTextView;
    BoomMenuButton nineMenuButton;
    BoomMenuButton oneMeneButton;
    int[] heroDrawableArray;
    String[] heroStringKeyArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boommenu_spinner);

        Hero[] myHeroes = new Hero[16];
        myHeroes[0] = new Hero("AQUAMAN", R.drawable.aquaman);
        myHeroes[1] = new Hero("BATMAN", R.drawable.aquaman);
        myHeroes[2] = new Hero("BLACKWIDOW", R.drawable.blackwidow);
        myHeroes[3] = new Hero("CAPTAINAMERICA", R.drawable.captainamerica);
        myHeroes[4] = new Hero("CYBORG", R.drawable.aquaman);
        myHeroes[5] = new Hero("DAREDEVIL", R.drawable.daredevil);
        myHeroes[6] = new Hero("HAWKEYE", R.drawable.hawkeye);
        myHeroes[7] = new Hero("GREENLANTERN", R.drawable.greenlantern);
        myHeroes[8] = new Hero("FLASH", R.drawable.flash);
        myHeroes[9] = new Hero("NICKFURY", R.drawable.nickfury);
        myHeroes[10] = new Hero("WONDERWOMAN", R.drawable.wonderwoman);
        myHeroes[11] = new Hero("THOR", R.drawable.thor);
        myHeroes[12] = new Hero("SUPERMAN", R.drawable.superman);
        myHeroes[13] = new Hero("SPIDERMAN", R.drawable.spiderman);
        myHeroes[14] = new Hero("GREENARROW", R.drawable.greenarrow);
        myHeroes[15] = new Hero("HULK", R.drawable.hulk);

        topTextView = (TextView) findViewById(R.id.total_spin_tView);
        nineMenuButton = (BoomMenuButton) findViewById(R.id.bmb);
        oneMeneButton = (BoomMenuButton) findViewById(R.id.bmb2);

        sharedPrefs = MySharedPreferences.getInstance(getApplicationContext());

        setText(topTextView, sharedPrefs.getTotalHeroCount());

        for (int i = 0; i < nineMenuButton.getPiecePlaceEnum().pieceNumber(); i++) {
            int randNum = RandomNumberChooser.chooseRandomNumber(15);
            Hero randomHero = myHeroes[randNum];

            TextInsideCircleButton.Builder builder = new TextInsideCircleButton.Builder()
                    .normalImageRes(randomHero.getDrawable())
                    .buttonRadius(100)
                    .normalText("Hero Earned!");
            nineMenuButton.addBuilder(builder);
        }

        for (int i = 0; i < oneMeneButton.getPiecePlaceEnum().pieceNumber(); i++) {
            int randNum = RandomNumberChooser.chooseRandomNumber(15);
            Hero randomHero = myHeroes[randNum];
            TextInsideCircleButton.Builder builder = new TextInsideCircleButton.Builder()
                    .normalImageRes(randomHero.getDrawable())
                    .normalText("Hero Earned!");
            oneMeneButton.addBuilder(builder);
        }


        nineMenuButton.setOnBoomListener(new OnBoomListenerAdapter() {
            @Override
            public void onBoomWillShow() {
                super.onBoomWillShow();
                sharedPrefs.decreaseTotalHeroCount(1);
                setText(topTextView, sharedPrefs.getTotalHeroCount());
            }
        });

        oneMeneButton.setOnBoomListener(new OnBoomListenerAdapter() {
            @Override
            public void onBoomWillShow() {
                super.onBoomWillShow();
                sharedPrefs.decreaseTotalHeroCount(9);
                setText(topTextView, sharedPrefs.getTotalHeroCount());
            }
        });
    }

    private void setText(TextView myTextView, int spinCount) {
        String totalSpinCount = String.valueOf(
                spinCount
        );
        myTextView.setText(totalSpinCount + " HEROES LEFT");
    }
}