package nyc.c4q.ashiquechowdhury.androidnekoproject.herospins;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;

import nyc.c4q.ashiquechowdhury.androidnekoproject.allherodisplay.HeroMenuActivity;
import nyc.c4q.ashiquechowdhury.androidnekoproject.util.MySharedPreferences;
import nyc.c4q.ashiquechowdhury.androidnekoproject.util.RandomNumberChooser;


/**
 * Created by ashiquechowdhury on 12/12/16.
 */
public class SpinActivity extends FragmentActivity implements SpinnerDialogFragment.SpinnerDialogListener {
    private int randomNumber2to10;
    MySharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        randomNumber2to10 = RandomNumberChooser.chooseRandomNumber(8) + 2;

        sharedPreferences = MySharedPreferences.getInstance(getApplicationContext());
        sharedPreferences.increaseSpinCount(randomNumber2to10);

        showSpinnerDialog();
    }

    public void showSpinnerDialog() {
        DialogFragment dialog = SpinnerDialogFragment.newInstance(randomNumber2to10);
        dialog.show(getSupportFragmentManager(), "SpinnerDialogFragment");
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        Intent intent = new Intent(this, SpinBoomMenuActivity.class);
        startActivity(intent);
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        Intent intent = new Intent(this, HeroMenuActivity.class);
        startActivity(intent);
    }
}
