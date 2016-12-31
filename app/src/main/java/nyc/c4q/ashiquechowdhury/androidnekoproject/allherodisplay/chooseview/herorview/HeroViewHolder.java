package nyc.c4q.ashiquechowdhury.androidnekoproject.allherodisplay.chooseview.herorview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import nyc.c4q.ashiquechowdhury.androidnekoproject.R;
import nyc.c4q.ashiquechowdhury.androidnekoproject.usehero.model.Hero;
import nyc.c4q.ashiquechowdhury.androidnekoproject.util.MySharedPreferences;

/**
 * Created by Hyun on 12/29/16.
 */
public class HeroViewHolder extends RecyclerView.ViewHolder {
    MySharedPreferences sharedPrefs;
    private ImageView heroImageView;
    private TextView heroTextView;

    public HeroViewHolder(View itemView) {
        super(itemView);
        heroTextView = (TextView) itemView.findViewById(R.id.hero_rview_text);
        heroImageView = (ImageView) itemView.findViewById(R.id.hero_rview_image);

        sharedPrefs = MySharedPreferences.getInstance(itemView.getContext());
    }

    public void setIcons(Hero hero) {
        heroImageView.setBackgroundResource(hero.getDrawable());
        int heroCount = sharedPrefs.getHeroCount(hero.getName());
        heroTextView.setText(String.valueOf(heroCount));
    }
}
