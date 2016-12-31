package nyc.c4q.ashiquechowdhury.androidnekoproject.allherodisplay.chooseview.herorview.util;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.ashiquechowdhury.androidnekoproject.R;
import nyc.c4q.ashiquechowdhury.androidnekoproject.usehero.model.Hero;

/**
 * Created by Hyun on 12/29/16.
 */
public class HeroIcons {
    private static HeroIcons instance;
    private List<Hero> myHeroes = new ArrayList<>();;

    private HeroIcons(){
        myHeroes.add(new Hero("AQUAMAN", R.drawable.aquaman_icon));
        myHeroes.add(new Hero("BATMAN", R.drawable.batman_icon));
        myHeroes.add(new Hero("BLACKWIDOW", R.drawable.blackwidow_icon));
        myHeroes.add(new Hero("CAPTAINAMERICA", R.drawable.captainamerica_icon));
        myHeroes.add(new Hero("CYBORG", R.drawable.cyborg_icon));
        myHeroes.add(new Hero("DAREDEVIL", R.drawable.daredevil_icon));
        myHeroes.add(new Hero("HAWKEYE", R.drawable.hawkeye_icon));
        myHeroes.add(new Hero("GREENLANTERN", R.drawable.greenlantern_icon));
        myHeroes.add(new Hero("FLASH", R.drawable.flash_icon));
        myHeroes.add(new Hero("IRON MAN", R.drawable.ironman_icon));
        myHeroes.add(new Hero("WONDERWOMAN", R.drawable.wonderwoman_icon));
        myHeroes.add(new Hero("THOR", R.drawable.thor_icon));
        myHeroes.add(new Hero("SUPERMAN", R.drawable.superman_icon));
        myHeroes.add(new Hero("SPIDERMAN", R.drawable.spiderman_icon));
        myHeroes.add(new Hero("GREENARROW", R.drawable.greenarrow_icon));
        myHeroes.add(new Hero("HULK", R.drawable.hulk_icon));
    }

    public static HeroIcons getInstance(){
        if(instance == null){
            instance = new HeroIcons();
        }
        return instance;
    }

    public List<Hero> getListOfHeroes() {
        return myHeroes;
    }
}
