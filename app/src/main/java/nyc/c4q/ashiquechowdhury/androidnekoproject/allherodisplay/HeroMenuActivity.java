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

import butterknife.BindView;
import butterknife.ButterKnife;
import nyc.c4q.ashiquechowdhury.androidnekoproject.R;
import nyc.c4q.ashiquechowdhury.androidnekoproject.allherodisplay.chooseview.herorview.HeroAdapter;
import nyc.c4q.ashiquechowdhury.androidnekoproject.allherodisplay.chooseview.herorview.util.HeroIcons;
import nyc.c4q.ashiquechowdhury.androidnekoproject.allherodisplay.chooseview.spinmenuview.MyHeroesOne;
import nyc.c4q.ashiquechowdhury.androidnekoproject.allherodisplay.chooseview.spinmenuview.MyHeroesTwo;

/**
 * Created by Hyun on 12/17/16.
 */
public class HeroMenuActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.herobtn1) Button heroPageOneBtn;
    @BindView(R.id.herobtn2) Button heroPageTwoBtn;
    @BindView(R.id.heromenu_RV) RecyclerView heroRecycler;
    private List<Integer> heroIcons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heromenu);
        initView();
        startRecycler();
    }

    private void initView() {
        ButterKnife.bind(this);
        heroPageOneBtn.setOnClickListener(this);
        heroPageTwoBtn.setOnClickListener(this);
    }

    private void startRecycler() {
        HeroIcons myIcons = HeroIcons.getInstance();
        heroIcons = myIcons.getListOfDrawables();
        heroRecycler.setLayoutManager(new GridLayoutManager(HeroMenuActivity.this,4));
        heroRecycler.setAdapter(new HeroAdapter(heroIcons));
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