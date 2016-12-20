package nyc.c4q.ashiquechowdhury.androidnekoproject.startofftodialog;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by ashiquechowdhury on 12/16/16.
 */
public class MyAlarmReceiver extends BroadcastReceiver{
    public static final int REQUEST_CODE = 12345;

    @Override
    public void onReceive(Context context, Intent intent){
        Intent i = new Intent(context, HeroNotificationService.class);
        context.startService(i);
    }
}
