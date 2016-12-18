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
import nyc.c4q.ashiquechowdhury.androidnekoproject.spinner.herofragmentlist.HawkEye;
import nyc.c4q.ashiquechowdhury.androidnekoproject.spinner.herofragmentlist.Thor;

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

        List<String> spinnerMenu = new ArrayList<>();
        spinnerMenu.add("THOR");
        spinnerMenu.add("HAWKEYE");

        spinMenu.setHintTextStrList(spinnerMenu);
        spinMenu.setHintTextColor(Color.parseColor("#FFFFFF"));
        spinMenu.setHintTextSize(14);
        spinMenu.setEnableGesture(true);

        final List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(Thor.newInstance());
        fragmentList.add(HawkEye.newInstance());

        FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount()
            {
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
}
