package nyc.c4q.ashiquechowdhury.androidnekoproject;

import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        scheduleAlarm();




        int NOTIFICATION_ID = 555;

        ImageView myImage = (ImageView) findViewById(R.id.superheroImageView);
        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_face_black_24dp);

        Picasso.with(MainActivity.this).load("http://i.imgur.com/q1tokaJ.png").fit().into(myImage);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.blackstar)
                .setContentTitle("Spins Obtained!")
                .setContentText("Lets use your spins")
                .setLargeIcon(largeIcon)
                .setColor(Color.RED);


// Get the notification manager system service
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // Setting a notification ID allows you to update the notification later on.
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }

//    private void scheduleAlarm() {
//        Intent intent = new Intent(getApplicationContext(), )
//    }
}
