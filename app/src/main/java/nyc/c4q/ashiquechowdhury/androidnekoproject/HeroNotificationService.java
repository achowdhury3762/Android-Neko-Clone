package nyc.c4q.ashiquechowdhury.androidnekoproject;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import nyc.c4q.ashiquechowdhury.androidnekoproject.herospins.SpinActivity;

/**
 * Created by ashiquechowdhury on 12/12/16.
 */

public class HeroNotificationService extends IntentService{

    int NOTIFICATION_ID = 555;

    public HeroNotificationService() {
        super("notification-service");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        int requestId = (int) System.currentTimeMillis();
        Intent myIntent = new Intent(this, SpinActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, requestId, myIntent, PendingIntent.FLAG_CANCEL_CURRENT);
        Notification notification = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.blackstar)
                .setContentTitle("Surprise Event!")
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, notification);

    }
}
