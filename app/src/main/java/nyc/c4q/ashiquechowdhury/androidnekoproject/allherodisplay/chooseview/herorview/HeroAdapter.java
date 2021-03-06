package nyc.c4q.ashiquechowdhury.androidnekoproject.allherodisplay.chooseview.herorview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.ashiquechowdhury.androidnekoproject.R;
import nyc.c4q.ashiquechowdhury.androidnekoproject.usehero.model.Hero;

/**
 * Created by Hyun on 12/29/16.
 */
public class HeroAdapter extends RecyclerView.Adapter<HeroViewHolder> {

    private List<Hero> heroView;

    public HeroAdapter(List<Hero> heroView) {
        this.heroView = heroView;
    }

    @Override
    public HeroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.hero_viewholder,parent,false);
        return new HeroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HeroViewHolder holder, int position) {
        holder.setIcons(heroView.get(position));
    }

    @Override
    public int getItemCount() {
        return heroView.size();
    }
}
