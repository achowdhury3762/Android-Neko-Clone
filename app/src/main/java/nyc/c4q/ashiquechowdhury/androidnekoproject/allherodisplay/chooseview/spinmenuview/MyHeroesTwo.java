package nyc.c4q.ashiquechowdhury.androidnekoproject.allherodisplay.chooseview.spinmenuview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;

import com.hitomi.smlibrary.OnSpinMenuStateChangeListener;
import com.hitomi.smlibrary.SpinMenu;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.ashiquechowdhury.androidnekoproject.R;
import nyc.c4q.ashiquechowdhury.androidnekoproject.allherodisplay.chooseview.spinmenuview.herofragments.Cyborg;
import nyc.c4q.ashiquechowdhury.androidnekoproject.allherodisplay.chooseview.spinmenuview.herofragments.DareDevil;
import nyc.c4q.ashiquechowdhury.androidnekoproject.allherodisplay.chooseview.spinmenuview.herofragments.GreenArrow;
import nyc.c4q.ashiquechowdhury.androidnekoproject.allherodisplay.chooseview.spinmenuview.herofragments.GreenLantern;
import nyc.c4q.ashiquechowdhury.androidnekoproject.allherodisplay.chooseview.spinmenuview.herofragments.HawkEye;
import nyc.c4q.ashiquechowdhury.androidnekoproject.allherodisplay.chooseview.spinmenuview.herofragments.Hulk;
import nyc.c4q.ashiquechowdhury.androidnekoproject.allherodisplay.chooseview.spinmenuview.herofragments.Spiderman;
import nyc.c4q.ashiquechowdhury.androidnekoproject.allherodisplay.chooseview.spinmenuview.herofragments.TheFlash;

/**
 * Created by Hyun on 12/29/16.
 */
public class MyHeroesTwo extends AppCompatActivity {

    private SpinMenu spinMenu2;
    private FragmentPagerAdapter fragmentPagerAdapter2;
    private List<String> heroesMenu2 = new ArrayList<>();
    private final List<Fragment> fragmentList2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondview_layout);

        initViews();
        addHeroes();
        addSecondEightFragments();
        fragmentPA2();

    }

    private void initViews() {
        spinMenu2 = (SpinMenu) findViewById(R.id.secondview_spin);
        spinMenu2.setHintTextStrList(heroesMenu2);
        spinMenu2.setHintTextColor(Color.parseColor("#FFFFFF"));
        spinMenu2.setHintTextSize(14);
        spinMenu2.setEnableGesture(true);
    }

    private void addHeroes() {
        heroesMenu2.add("CYBORG");
        heroesMenu2.add("DAREDEVIL");
        heroesMenu2.add("GREEN ARROW");
        heroesMenu2.add("GREEN LANTERN");
        heroesMenu2.add("HAWKEYE");
        heroesMenu2.add("HULK");
        heroesMenu2.add("SPIDERMAN");
        heroesMenu2.add("THE FLASH");
    }

    private void addSecondEightFragments() {
        fragmentList2.add(Cyborg.newInstance());
        fragmentList2.add(DareDevil.newInstance());
        fragmentList2.add(GreenArrow.newInstance());
        fragmentList2.add(GreenLantern.newInstance());
        fragmentList2.add(HawkEye.newInstance());
        fragmentList2.add(Hulk.newInstance());
        fragmentList2.add(Spiderman.newInstance());
        fragmentList2.add(TheFlash.newInstance());
    }

    private void fragmentPA2() {
        fragmentPagerAdapter2 = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList2.get(position);
            }
            @Override
            public int getCount() {
                return fragmentList2.size();
            }
        };
        setSpinMenu2(fragmentPagerAdapter2);
    }

    private void setSpinMenu2(FragmentPagerAdapter fragmentPagerAdapter2) {
        spinMenu2.setFragmentAdapter(fragmentPagerAdapter2);
        spinMenu2.setOnSpinMenuStateChangeListener(new OnSpinMenuStateChangeListener() {
            @Override
            public void onMenuOpened() {
            }
            @Override
            public void onMenuClosed() {
            }
        });
    }
}
