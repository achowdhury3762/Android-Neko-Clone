package nyc.c4q.ashiquechowdhury.androidnekoproject.model;

/**
 * Created by ashiquechowdhury on 12/16/16.
 */

public class HeroSpinCountModel {
    public static int totalHeroCount = 0;

    public static void increaseHeroCount(){
        totalHeroCount++;
    }

    public static void decreaseHeroCount() {
        totalHeroCount--;
    }

    public static void decreaseHeroCount(int decreaseBy){
        totalHeroCount -= decreaseBy;
    }

    public static void increaseHeroCount(int increaseBy){
        totalHeroCount+=increaseBy;
    }
}