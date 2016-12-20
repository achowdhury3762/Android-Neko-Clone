package nyc.c4q.ashiquechowdhury.androidnekoproject.usehero;


import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.nightonke.boommenu.BoomButtons.TextInsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.OnBoomListenerAdapter;
import com.nightonke.boommenu.Util;

import butterknife.BindView;
import butterknife.ButterKnife;
import nyc.c4q.ashiquechowdhury.androidnekoproject.R;
import nyc.c4q.ashiquechowdhury.androidnekoproject.usehero.model.Hero;
import nyc.c4q.ashiquechowdhury.androidnekoproject.util.MySharedPreferences;
import nyc.c4q.ashiquechowdhury.androidnekoproject.util.RandomNumberChooser;

/**
 * Created by ashiquechowdhury on 12/17/16.
 */

public class UseHeroesActivity extends AppCompatActivity {
    @BindView(R.id.total_hero_tView)
    TextView totalHeroesTView;
    @BindView(R.id.bmb)
    BoomMenuButton nineMenuButton;
    @BindView(R.id.bmb2)
    BoomMenuButton oneMenuButton;
    private MySharedPreferences sharedPrefs;
    private Hero[] myHeroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boommenu_spinner);
        ButterKnife.bind(this);
        sharedPrefs = MySharedPreferences.getInstance(getApplicationContext());

        myHeroes = new Hero[16];
        myHeroes[0] = new Hero("AQUAMAN", R.drawable.aquaman_icon);
        myHeroes[1] = new Hero("BATMAN", R.drawable.aquaman_icon);
        myHeroes[2] = new Hero("BLACKWIDOW", R.drawable.blackwidow_icon);
        myHeroes[3] = new Hero("CAPTAINAMERICA", R.drawable.captainamerica_icon);
        myHeroes[4] = new Hero("CYBORG", R.drawable.aquaman_icon);
        myHeroes[5] = new Hero("DAREDEVIL", R.drawable.daredevil_icon);
        myHeroes[6] = new Hero("HAWKEYE", R.drawable.hawkeye_icon);
        myHeroes[7] = new Hero("GREENLANTERN", R.drawable.greenlantern_icon);
        myHeroes[8] = new Hero("FLASH", R.drawable.flash_icon);
        myHeroes[9] = new Hero("NICKFURY", R.drawable.nickfury_icon);
        myHeroes[10] = new Hero("WONDERWOMAN", R.drawable.wonderwoman_icon);
        myHeroes[11] = new Hero("THOR", R.drawable.thor_icon);
        myHeroes[12] = new Hero("SUPERMAN", R.drawable.superman_icon);
        myHeroes[13] = new Hero("SPIDERMAN", R.drawable.spiderman_icon);
        myHeroes[14] = new Hero("GREENARROW", R.drawable.greenarrow_icon);
        myHeroes[15] = new Hero("HULK", R.drawable.hulk_icon);

        setTotalHeroText(totalHeroesTView, sharedPrefs.getTotalHeroCount());

        setUpNineHeroClickedButton();
        setUpOneHeroClickedButton();

        nineMenuButton.setOnBoomListener(new OnBoomListenerAdapter() {
            @Override
            public void onBoomWillShow() {
                super.onBoomWillShow();
                sharedPrefs.decreaseTotalHeroCount(9);
                setTotalHeroText(totalHeroesTView, sharedPrefs.getTotalHeroCount());
            }

            @Override
            public void onBoomDidHide() {
                super.onBoomDidHide();
                recreate();
            }
        });

        oneMenuButton.setOnBoomListener(new OnBoomListenerAdapter() {
            @Override
            public void onBoomWillShow() {
                super.onBoomWillShow();
                sharedPrefs.decreaseTotalHeroCount(1);
                setTotalHeroText(totalHeroesTView, sharedPrefs.getTotalHeroCount());
            }

            @Override
            public void onBoomDidHide() {
                super.onBoomDidHide();
                recreate();
            }
        });

    }

    private void setUpOneHeroClickedButton() {
        nineMenuButton.setCacheOptimization(false);
        oneMenuButton.setCacheOptimization(false);
        for (int i = 0; i < oneMenuButton.getPiecePlaceEnum().pieceNumber(); i++) {
            int randNum = RandomNumberChooser.chooseRandomNumber(15);
            Hero randomHero = myHeroes[randNum];
            TextInsideCircleButton.Builder builder = new TextInsideCircleButton.Builder()
                    .normalImageRes(randomHero.getDrawable())
                    .buttonRadius(Util.dp2px(100))
                    .imageRect(new Rect(Util.dp2px(0), Util.dp2px(0), Util.dp2px(200), Util.dp2px(200)))
                    .imagePadding(new Rect(Util.dp2px(15), Util.dp2px(15), Util.dp2px(15), Util.dp2px(15)));
            oneMenuButton.addBuilder(builder);
        }
    }

    private void setUpNineHeroClickedButton() {
        for (int i = 0; i < nineMenuButton.getPiecePlaceEnum().pieceNumber(); i++) {
            int randNum = RandomNumberChooser.chooseRandomNumber(15);
            Hero randomHero = myHeroes[randNum];

            TextInsideCircleButton.Builder builder = new TextInsideCircleButton.Builder()
                    .normalImageRes(randomHero.getDrawable())
                    .buttonRadius(Util.dp2px(40));
            nineMenuButton.addBuilder(builder);
        }
    }

    private void setTotalHeroText(TextView myTextView, int spinCount) {
        String totalSpinCount = String.valueOf(
                spinCount
        );
        myTextView.setText(totalSpinCount + " HEROES LEFT");
    }
}