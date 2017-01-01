package nyc.c4q.ashiquechowdhury.androidnekoproject.herodialog;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;

import nyc.c4q.ashiquechowdhury.androidnekoproject.R;
import nyc.c4q.ashiquechowdhury.androidnekoproject.allherodisplay.HeroMenuActivity;
import nyc.c4q.ashiquechowdhury.androidnekoproject.usehero.UseHeroesActivity;


/**
 * Created by ashiquechowdhury on 12/12/16.
 */
public class HeroDialogChoiceActivity extends FragmentActivity implements HeroDialogFragment.SpinnerDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showSpinnerDialog();
    }

    public void showSpinnerDialog() {
        DialogFragment dialog = HeroDialogFragment.newInstance();
        dialog.show(getSupportFragmentManager(), "HeroDialogFragment");
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        Intent intent = new Intent(this, UseHeroesActivity.class);
        startActivity(intent);
    }

    @Override
    public void onDialogNeutralClick(DialogFragment dialog) {
        Intent intent = new Intent(this, HeroMenuActivity.class);
        startActivity(intent);
    }
}
