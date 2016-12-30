package nyc.c4q.ashiquechowdhury.androidnekoproject.allherodisplay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.ashiquechowdhury.androidnekoproject.R;
import nyc.c4q.ashiquechowdhury.androidnekoproject.allherodisplay.chooseview.herorview.HeroAdapter;
import nyc.c4q.ashiquechowdhury.androidnekoproject.allherodisplay.chooseview.herorview.util.HeroIcons;
import nyc.c4q.ashiquechowdhury.androidnekoproject.allherodisplay.chooseview.spinmenuview.MyHeroesOne;
import nyc.c4q.ashiquechowdhury.androidnekoproject.allherodisplay.chooseview.spinmenuview.MyHeroesTwo;

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
        HeroIcons myIcons = HeroIcons.getInstance();
        heroIcons = myIcons.getListOfDrawables();
        mRecycler = (RecyclerView) findViewById(R.id.heromenu_RV);
        mRecycler.setLayoutManager(new GridLayoutManager(HeroMenuActivity.this,4));
        mRecycler.setAdapter(new HeroAdapter(heroIcons));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.herobtn1:
                Intent intentOne = new Intent(this, MyHeroesOne.class);
                startActivity(intentOne);
                break;
            case R.id.herobtn2:
                Intent intentTwo = new Intent(this, MyHeroesTwo.class);
                startActivity(intentTwo);
                break;
        }
    }
}
