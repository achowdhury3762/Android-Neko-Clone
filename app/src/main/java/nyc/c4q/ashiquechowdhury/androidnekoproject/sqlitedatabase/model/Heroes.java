package nyc.c4q.ashiquechowdhury.androidnekoproject.sqlitedatabase.model;

import java.util.Calendar;

import nl.qbusict.cupboard.annotation.Column;

/**
 * Created by Hyun on 12/30/16.
 */

public class Heroes {

    private Long _id;
    private String name;
    @Column("last_earned")
    private Long lastEarned;

    public Heroes() {
        this.name = "Unknown";
        this.lastEarned = Calendar.getInstance().getTimeInMillis();
    }

    public void setLastFed(Long lastEarned) {
        this.lastEarned = lastEarned;
    }

    public Heroes(String name, Long lastEarned) {
        this.name = name;
        this.lastEarned = lastEarned;
    }

    public Long getId() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLastEarned() {
        return lastEarned;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

}
