package nyc.c4q.ashiquechowdhury.androidnekoproject.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import nyc.c4q.ashiquechowdhury.androidnekoproject.model.Hero;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by ashiquechowdhury on 12/18/16.
 */

public class HeroDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "hero.db";
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
        cupboard().register(Hero.class);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        cupboard().withDatabase(db).createTables();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        cupboard().withDatabase(db).upgradeTables();
    }
}