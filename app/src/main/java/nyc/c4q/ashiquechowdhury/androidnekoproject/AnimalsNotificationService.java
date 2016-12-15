package nyc.c4q.ashiquechowdhury.androidnekoproject;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;

import java.util.Random;

/**
 * Created by ashiquechowdhury on 12/12/16.
 */

public class AnimalsNotificationService extends IntentService{

    public AnimalsNotificationService() {
        super("notification-service");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        int requestId = (int) System.currentTimeMillis();
        Intent myIntent = new Intent(this, AnimalClickActivity.class);

        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.blackstar);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, requestId, myIntent, PendingIntent.FLAG_CANCEL_CURRENT);
        Notification notification = new NotificationCompat.Builder(this)
                .setLargeIcon(largeIcon)
                .setContentTitle("Surprise Event!")
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(555, notification);
    }

    public int randomAnimalDrawable(){
        Random random = new Random();
        int number = random.nextInt(1);
        switch(number){
            case 0:
                return R.drawable.blackstar;
        }
        return 1;
    }
}
