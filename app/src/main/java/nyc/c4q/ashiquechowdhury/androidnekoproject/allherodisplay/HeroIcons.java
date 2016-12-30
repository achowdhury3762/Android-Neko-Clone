package nyc.c4q.ashiquechowdhury.androidnekoproject.allherodisplay;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.ashiquechowdhury.androidnekoproject.R;

/**
 * Created by Hyun on 12/29/16.
 */
public class HeroIcons {

    private static List<Integer> listOfDrawables = new ArrayList<>();;

    public HeroIcons(){
        listOfDrawables.add(R.drawable.aquaman_icon);
        listOfDrawables.add(R.drawable.batman_icon);
        listOfDrawables.add(R.drawable.blackwidow_icon);
        listOfDrawables.add(R.drawable.captainamerica_icon);
        listOfDrawables.add(R.drawable.cyborg_icon);
        listOfDrawables.add(R.drawable.daredevil_icon);
        listOfDrawables.add(R.drawable.flash_icon);
        listOfDrawables.add(R.drawable.greenarrow_icon);
        listOfDrawables.add(R.drawable.greenlantern_icon);
        listOfDrawables.add(R.drawable.hawkeye_icon);
        listOfDrawables.add(R.drawable.hulk_icon);
        listOfDrawables.add(R.drawable.ironman_icon);
        listOfDrawables.add(R.drawable.spiderman_icon);
        listOfDrawables.add(R.drawable.superman_icon);
        listOfDrawables.add(R.drawable.thor_icon);
        listOfDrawables.add(R.drawable.wonderwoman_icon);
    }

    public static List<Integer> getListOfDrawables() {
        HeroIcons icons = new HeroIcons();
        return listOfDrawables;
    }
}
