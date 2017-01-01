package nyc.c4q.ashiquechowdhury.androidnekoproject.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import nyc.c4q.ashiquechowdhury.androidnekoproject.sqlitedatabase.model.Heroes;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by Hyun on 12/30/16.
 */

public class HeroDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "heroes.db";
    private static final int DATABASE_VERSION = 1;
    private static HeroDatabaseHelper instance;

    public static synchronized HeroDatabaseHelper getInstance(Context context) {
        if (instance == null) {
            instance = new HeroDatabaseHelper(context.getApplicationContext());
        }
        return instance;
    }

    private HeroDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    static {
        cupboard().register(Heroes.class);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        cupboard().withDatabase(db).createTables();
        // add indexes and other database tweaks in this method if you want
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        cupboard().withDatabase(db).upgradeTables();
        if(newVersion == 2){
            ContentValues cv = new ContentValues();
            cv.put("superpower","flying");
            cupboard().withDatabase(db).update(Heroes.class,cv);
        }
    }
}

