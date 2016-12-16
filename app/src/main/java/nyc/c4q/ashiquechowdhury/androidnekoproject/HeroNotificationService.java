package nyc.c4q.ashiquechowdhury.androidnekoproject;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;

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

        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_face_black_24dp);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, requestId, myIntent, PendingIntent.FLAG_CANCEL_CURRENT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.blackstar)
                .setContentTitle("Spins Obtained!")
                .setContentText("Lets use your spins")
                .setLargeIcon(largeIcon)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setColor(Color.RED);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }
}
