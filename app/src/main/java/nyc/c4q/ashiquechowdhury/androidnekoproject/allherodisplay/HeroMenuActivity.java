package nyc.c4q.ashiquechowdhury.androidnekoproject.allherodisplay;

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
import nyc.c4q.ashiquechowdhury.androidnekoproject.herofragments.Aquaman;
import nyc.c4q.ashiquechowdhury.androidnekoproject.herofragments.Batman;
import nyc.c4q.ashiquechowdhury.androidnekoproject.herofragments.BlackWidow;
import nyc.c4q.ashiquechowdhury.androidnekoproject.herofragments.CaptainAmerica;
import nyc.c4q.ashiquechowdhury.androidnekoproject.herofragments.IronMan;
import nyc.c4q.ashiquechowdhury.androidnekoproject.herofragments.Superman;
import nyc.c4q.ashiquechowdhury.androidnekoproject.herofragments.Thor;
import nyc.c4q.ashiquechowdhury.androidnekoproject.herofragments.WonderWoman;

/**
 * Created by Hyun on 12/17/16.
 */
public class HeroMenuActivity extends AppCompatActivity {

    private SpinMenu spinMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heromenu);

        spinMenu = (SpinMenu) findViewById(R.id.spin_menu);

        List<String> heroesMenu = new ArrayList<>();
        heroesMenu.add("AQUAMAN");
        heroesMenu.add("BATMAN");
        heroesMenu.add("BLACK WIDOW");
        heroesMenu.add("CAPTAIN AMERICA");
        heroesMenu.add("WONDER WOMAN");
        heroesMenu.add("IRON MAN");
        heroesMenu.add("THOR");
        heroesMenu.add("SUPERMAN");


        spinMenu.setHintTextStrList(heroesMenu);
        spinMenu.setHintTextColor(Color.parseColor("#FFFFFF"));
        spinMenu.setHintTextSize(14);
        spinMenu.setEnableGesture(true);

        final List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(Aquaman.newInstance());
        fragmentList.add(Batman.newInstance());
        fragmentList.add(BlackWidow.newInstance());
        fragmentList.add(CaptainAmerica.newInstance());
        fragmentList.add(WonderWoman.newInstance());
        fragmentList.add(IronMan.newInstance());
        fragmentList.add(Thor.newInstance());
        fragmentList.add(Superman.newInstance());


        FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        };
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
