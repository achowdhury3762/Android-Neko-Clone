package nyc.c4q.ashiquechowdhury.androidnekoproject.spinner;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.hitomi.smlibrary.OnSpinMenuStateChangeListener;
import com.hitomi.smlibrary.SpinMenu;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.ashiquechowdhury.androidnekoproject.R;
import nyc.c4q.ashiquechowdhury.androidnekoproject.spinner.herofragmentlist.Aquaman;
import nyc.c4q.ashiquechowdhury.androidnekoproject.spinner.herofragmentlist.Batman;
import nyc.c4q.ashiquechowdhury.androidnekoproject.spinner.herofragmentlist.BlackWidow;
import nyc.c4q.ashiquechowdhury.androidnekoproject.spinner.herofragmentlist.CaptainAmerica;
import nyc.c4q.ashiquechowdhury.androidnekoproject.spinner.herofragmentlist.IronMan;
import nyc.c4q.ashiquechowdhury.androidnekoproject.spinner.herofragmentlist.Superman;
import nyc.c4q.ashiquechowdhury.androidnekoproject.spinner.herofragmentlist.Thor;
import nyc.c4q.ashiquechowdhury.androidnekoproject.spinner.herofragmentlist.WonderWoman;

/**
 * Created by Hyun on 12/17/16.
 */
public class HeroMenuActivity extends AppCompatActivity {

    private SpinMenu spinMenu;
    private FragmentPagerAdapter fragmentPagerAdapter;
    private List<String> heroesMenu = new ArrayList<>();
    private final List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heromenu);

        initViews();
        addHeroes();
        addFragments();

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
        spinMenu.setFragmentAdapter(fragmentPagerAdapter);
        spinMenu.setOnSpinMenuStateChangeListener(new OnSpinMenuStateChangeListener() {
            @Override
            public void onMenuOpened() {
                Toast.makeText(HeroMenuActivity.this, "SpinMenu opened", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onMenuClosed() {
                Toast.makeText(HeroMenuActivity.this, "SpinMenu closed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initViews() {
        spinMenu = (SpinMenu) findViewById(R.id.spin_menu);
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
        heroesMenu.add("WONDER WOMAN");
        heroesMenu.add("IRON MAN");
        heroesMenu.add("THOR");
        heroesMenu.add("SUPERMAN");
    }

    private void addFragments() {

        fragmentList.add(Aquaman.newInstance());
        fragmentList.add(Batman.newInstance());
        fragmentList.add(BlackWidow.newInstance());
        fragmentList.add(CaptainAmerica.newInstance());
        fragmentList.add(WonderWoman.newInstance());
        fragmentList.add(IronMan.newInstance());
        fragmentList.add(Thor.newInstance());
        fragmentList.add(Superman.newInstance());

    }

}
