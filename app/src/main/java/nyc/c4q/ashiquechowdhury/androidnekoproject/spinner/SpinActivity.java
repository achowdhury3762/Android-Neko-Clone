package nyc.c4q.ashiquechowdhury.androidnekoproject.spinner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

/**
 * Created by ashiquechowdhury on 12/12/16.
 */
public class SpinActivity extends FragmentActivity implements SpinnerDialogFragment.SpinnerDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showSpinnerDialog();
    }
    public void showSpinnerDialog() {
        DialogFragment dialog = new SpinnerDialogFragment();
        dialog.show(getSupportFragmentManager(), "SpinnerDialogFragment");
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        Toast.makeText(this, "Use Spinner", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        Intent intent = new Intent(this, HeroMenuActivity.class);
        startActivity(intent);
        Toast.makeText(this, "View My Heroes", Toast.LENGTH_LONG).show();
    }

}
