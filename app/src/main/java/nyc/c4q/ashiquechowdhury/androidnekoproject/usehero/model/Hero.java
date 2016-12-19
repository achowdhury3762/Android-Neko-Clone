package nyc.c4q.ashiquechowdhury.androidnekoproject.usehero.model;

/**
 * Created by ashiquechowdhury on 12/18/16.
 */

public class Hero {
    private String name;
    private int drawable;

    public Hero(String name, int drawable){
        this.name = name;
        this.drawable = drawable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }
}
