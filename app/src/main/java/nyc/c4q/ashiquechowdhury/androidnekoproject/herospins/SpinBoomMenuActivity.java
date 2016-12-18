package nyc.c4q.ashiquechowdhury.androidnekoproject.herospins;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.nightonke.boommenu.BoomButtons.TextInsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.OnBoomListenerAdapter;

import nyc.c4q.ashiquechowdhury.androidnekoproject.R;
import nyc.c4q.ashiquechowdhury.androidnekoproject.util.MySharedPreferences;

/**
 * Created by ashiquechowdhury on 12/17/16.
 */

public class SpinBoomMenuActivity extends AppCompatActivity {
    MySharedPreferences sharedPrefs;
    TextView topTextView;
    BoomMenuButton bmb;
    BoomMenuButton bmb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boommenu_spinner);


        topTextView = (TextView) findViewById(R.id.total_spin_tView);
        BoomMenuButton bmb = (BoomMenuButton) findViewById(R.id.bmb);
        BoomMenuButton bmb2 = (BoomMenuButton) findViewById(R.id.bmb2);

        sharedPrefs = MySharedPreferences.getInstance(getApplicationContext());

        setText(topTextView);

        for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++) {
            TextInsideCircleButton.Builder builder = new TextInsideCircleButton.Builder()
                    .normalImageRes(R.drawable.ic_face_black_24dp)
                    .buttonRadius(100)
                    .normalText("Butter Doesn't fly!");
            bmb.addBuilder(builder);
        }

        for (int i = 0; i < bmb2.getPiecePlaceEnum().pieceNumber(); i++) {
            TextInsideCircleButton.Builder builder = new TextInsideCircleButton.Builder()
                    .normalImageRes(R.drawable.ic_face_black_24dp)
                    .normalText("Butter Doesn't fly!");
            bmb2.addBuilder(builder);
        }

        bmb.setOnBoomListener(new OnBoomListenerAdapter() {
            @Override
            public void onBoomWillShow() {
                super.onBoomWillShow();
                // logic here
                Toast.makeText(SpinBoomMenuActivity.this, "boomshow", Toast.LENGTH_LONG).show();
            }
        });

        bmb2.setOnBoomListener(new OnBoomListenerAdapter() {
            @Override
            public void onBoomWillShow() {
                super.onBoomWillShow();
                // logic herep[
            }
        });
    }

    private void setText(TextView myTextView) {
        String totalSpinCount = String.valueOf(
                sharedPrefs.getSpinCount()
        );
        myTextView.setText(totalSpinCount + " SPINS");
    }
}