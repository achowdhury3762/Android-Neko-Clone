package nyc.c4q.ashiquechowdhury.androidnekoproject.allherodisplay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.ashiquechowdhury.androidnekoproject.R;
import nyc.c4q.ashiquechowdhury.androidnekoproject.allherodisplay.chooseview.HeroAdapter;

/**
 * Created by Hyun on 12/17/16.
 */
public class HeroMenuActivity extends AppCompatActivity implements View.OnClickListener {

    private Button herobtnOne, herobtnTwo;

    private RecyclerView mRecycler;
    private List<Integer> heroIcons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heromenu);
        initView();
        startRecycler();
    }

    private void initView() {
        herobtnOne = (Button) findViewById(R.id.herobtn1);
        herobtnTwo = (Button) findViewById(R.id.herobtn2);
        herobtnOne.setOnClickListener(this);
        herobtnTwo.setOnClickListener(this);
    }

    private void startRecycler() {
        heroIcons = HeroIcons.getListOfDrawables();
        mRecycler = (RecyclerView) findViewById(R.id.heromenu_RV);
        mRecycler.setLayoutManager(new GridLayoutManager(HeroMenuActivity.this,4));
        mRecycler.setAdapter(new HeroAdapter(heroIcons));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.herobtn1:
            case R.id.herobtn2:
                Toast.makeText(getParent(), "button clicked", Toast.LENGTH_LONG).show();
        }
    }
}
