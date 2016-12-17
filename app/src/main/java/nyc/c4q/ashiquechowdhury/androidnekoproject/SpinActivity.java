package nyc.c4q.ashiquechowdhury.androidnekoproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by ashiquechowdhury on 12/12/16.
 */
public class SpinActivity extends AppCompatActivity {
    SharedPreferences HeroSharedPref;
    private static final String HEROCOUNT = "nyc.c4q.ashiquechowdhury.HEROCOUNT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_spinner);

        Toast.makeText(this, "Im toasting", Toast.LENGTH_LONG).show();

        HeroSharedPref = getPreferences(Context.MODE_PRIVATE);
        int totalHeroCount = HeroSharedPref.getInt(HEROCOUNT, 0);
        Toast.makeText(this, String.valueOf(totalHeroCount), Toast.LENGTH_LONG).show();

//            int spinsEarned = intent.getIntExtra(HeroNotificationService.SPINSEARNED, 0);
//            SharedPreferences.Editor editor = HeroSharedPref.edit();
//            editor.putInt(HEROCOUNT, spinsEarned + totalHeroCount);
//            editor.commit();
//            Toast.makeText(this, "intent+" + String.valueOf(totalHeroCount), Toast.LENGTH_LONG).show();
    }
}

