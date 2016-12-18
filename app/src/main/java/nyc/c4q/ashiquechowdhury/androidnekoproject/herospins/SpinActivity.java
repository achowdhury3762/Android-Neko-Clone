package nyc.c4q.ashiquechowdhury.androidnekoproject.herospins;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import nyc.c4q.ashiquechowdhury.androidnekoproject.util.RandomNumberChooser;

/**
 * Created by ashiquechowdhury on 12/12/16.
 */
public class SpinActivity extends FragmentActivity implements SpinnerDialogFragment.SpinnerDialogListener {
    private int randomNumber2to10;
    SharedPreferences sharedPreferences;
    private static final String RANDNUM = "nyc.c4q.ashiquechowdhry.RANDOMNUM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        randomNumber2to10 = RandomNumberChooser.chooseRandomNumber(8) + 2;
        sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        int savedRandNumber = sharedPreferences.getInt(RANDNUM, 0);
        editor.putInt(RANDNUM, savedRandNumber + randomNumber2to10);
        Toast.makeText(this, String.valueOf(savedRandNumber), Toast.LENGTH_LONG).show();
        showSpinnerDialog();
    }

    public void showSpinnerDialog() {
        DialogFragment dialog = SpinnerDialogFragment.newInstance(randomNumber2to10);
        dialog.show(getSupportFragmentManager(), "SpinnerDialogFragment");
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        Toast.makeText(this, "Use Spinner", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, SpinBoomMenu.class);
        intent.putExtra("nyc.c4q.ashiquechowdhury.RANDNUM", randomNumber2to10);
        startActivity(intent);
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        Toast.makeText(this, "View My Heroes", Toast.LENGTH_LONG).show();
    }
}