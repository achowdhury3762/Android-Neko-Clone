package nyc.c4q.ashiquechowdhury.androidnekoproject.util;

import java.util.Random;

/**
 * Created by ashiquechowdhury on 12/16/16.
 */

public class RandomNumberChooser {
    final static Random random = new Random();

    public static int chooseRandomNumber(int lastValue){
        return random.nextInt(lastValue + 1);
    }
}
