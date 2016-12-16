package nyc.c4q.ashiquechowdhury.androidnekoproject;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import java.util.Random;

/**
 * Created by ashiquechowdhury on 12/12/16.
 */

public class AnimalsNotificationService extends IntentService{
    private static final String BASE_IMAGE_URL = "http://imgur.com/";
    private static final String THOR = "";
    private static final String BATMAN = "kwhwqzp.png";
    private static final String FLASH = "";
    private static final String GREEN_ARROW = "";
    private static final String WONDER_WOMAN = "";
    private static final String CYBORG = "";
    private static final String SUPERMAN = "";
    private static final String BEARDMAN = "";
    private static final String GREENLANTERN = "";
    private static final String SPIDERMAN = "";
    private static final String HORNMAN = "";
    private static final String IRONMAN = "";
    private static final String CAPTAINAMERICA = "";
    private static final String HULK = "";
    private static final String HAWKEYE = "";
    private static final String EYEPATCH = "";
    private static final String REDHEAD = "";
    private static final String HERMES = "";


    public AnimalsNotificationService() {
        super("notification-service");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        int requestId = (int) System.currentTimeMillis();
        Intent myIntent = new Intent(this, AnimalClickActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, requestId, myIntent, PendingIntent.FLAG_CANCEL_CURRENT);
        Notification notification = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.blackstar)
                .setContentTitle("Surprise Event!")
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(555, notification);
    }

    public int randomHeroPicture(){
        Random random = new Random();
        int number = random.nextInt(1);
        switch(number){
            case 0:
                return R.drawable.blackstar;
        }
        return 1;
    }
}
