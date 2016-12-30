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
import nyc.c4q.ashiquechowdhury.androidnekoproject.allherodisplay.chooseview.spinmenuview.herofragments.Aquaman;
import nyc.c4q.ashiquechowdhury.androidnekoproject.allherodisplay.chooseview.spinmenuview.herofragments.Batman;
import nyc.c4q.ashiquechowdhury.androidnekoproject.allherodisplay.chooseview.spinmenuview.herofragments.BlackWidow;
import nyc.c4q.ashiquechowdhury.androidnekoproject.allherodisplay.chooseview.spinmenuview.herofragments.CaptainAmerica;
import nyc.c4q.ashiquechowdhury.androidnekoproject.allherodisplay.chooseview.spinmenuview.herofragments.IronMan;
import nyc.c4q.ashiquechowdhury.androidnekoproject.allherodisplay.chooseview.spinmenuview.herofragments.Superman;
import nyc.c4q.ashiquechowdhury.androidnekoproject.allherodisplay.chooseview.spinmenuview.herofragments.Thor;
import nyc.c4q.ashiquechowdhury.androidnekoproject.allherodisplay.chooseview.spinmenuview.herofragments.WonderWoman;

/**
 * Created by Hyun on 12/29/16.
 */
public class MyHeroesOne extends AppCompatActivity {

    private SpinMenu spinMenu;
    private FragmentPagerAdapter fragmentPagerAdapter;
    private List<String> heroesMenu = new ArrayList<>();
    private final List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstview_layout);

        initViews();
        addHeroes();
        addFirstEightFragments();
        fragmentPA();

    }
    private void initViews() {
        spinMenu = (SpinMenu) findViewById(R.id.firstview_spin);
        spinMenu.setHintTextStrList(heroesMenu);
        spinMenu.setHintTextColor(Color.parseColor("#FFFFFF"));
        spinMenu.setHintTextSize(14);
        spinMenu.setEnableGesture(true);
    }

    private void addHeroes() {
        heroesMenu.add("AQUAMAN");
        heroesMenu.add("BATMAN");
        heroesMenu.add("BLACK WIDOW");
        heroesMenu.add("CAPTAIN AMERICA");
        heroesMenu.add("IRON MAN");
        heroesMenu.add("THOR");
        heroesMenu.add("SUPERMAN");
        heroesMenu.add("WONDER WOMAN");
    }

    private void addFirstEightFragments() {
        fragmentList.add(Aquaman.newInstance());
        fragmentList.add(Batman.newInstance());
        fragmentList.add(BlackWidow.newInstance());
        fragmentList.add(CaptainAmerica.newInstance());
        fragmentList.add(WonderWoman.newInstance());
        fragmentList.add(IronMan.newInstance());
        fragmentList.add(Thor.newInstance());
        fragmentList.add(Superman.newInstance());
    }

    private void fragmentPA() {
        fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }
            @Override
            public int getCount() {
                return fragmentList.size();
            }
        };
        setSpinMenu(fragmentPagerAdapter);
    }

    private void setSpinMenu(FragmentPagerAdapter fragmentPagerAdapter) {
        spinMenu.setFragmentAdapter(fragmentPagerAdapter);
        spinMenu.setOnSpinMenuStateChangeListener(new OnSpinMenuStateChangeListener() {
            @Override
            public void onMenuOpened() {
            }
            @Override
            public void onMenuClosed() {
            }
        });
    }
}
