package nyc.c4q.ashiquechowdhury.androidnekoproject.allherodisplay.chooseview.herorview;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Hyun on 12/29/16.
 */
public class HeroViewHolder extends RecyclerView.ViewHolder {

    public HeroViewHolder(View itemView) {
        super(itemView);
    }

    public void setIcons(Integer integer) {
        itemView.setBackgroundResource(integer);
    }
}
