package nyc.c4q.ashiquechowdhury.androidnekoproject.herospins;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nightonke.boommenu.BoomButtons.TextInsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;

import nyc.c4q.ashiquechowdhury.androidnekoproject.R;

/**
 * Created by ashiquechowdhury on 12/17/16.
 */

public class SpinBoomMenu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boommenu_spinner);

        setTopTitle();

        BoomMenuButton bmb = (BoomMenuButton) findViewById(R.id.bmb);
        BoomMenuButton bmb2 = (BoomMenuButton) findViewById(R.id.bmb2);

        for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++) {
            TextInsideCircleButton.Builder builder = new TextInsideCircleButton.Builder()
                    .normalImageRes(R.drawable.shape_oval_normal)
                    .normalText("Butter Doesn't fly!");
            bmb.addBuilder(builder);
        }

        for (int i = 0; i < bmb2.getPiecePlaceEnum().pieceNumber(); i++) {
            TextInsideCircleButton.Builder builder = new TextInsideCircleButton.Builder()
                    .normalImageRes(R.drawable.ic_face_black_24dp)
                    .normalText("Butter Doesn't fly!");
            bmb2.addBuilder(builder);
        }

    }

    private void setTopTitle() {

    }
}
