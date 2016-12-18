package nyc.c4q.ashiquechowdhury.androidnekoproject.model;

/**
 * Created by ashiquechowdhury on 12/16/16.
 */

public class Hero {
    private Long _id;

    private int count;

    private String name;

    public Hero(String name){
        this.name = name;
        count = 0;
    }

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
