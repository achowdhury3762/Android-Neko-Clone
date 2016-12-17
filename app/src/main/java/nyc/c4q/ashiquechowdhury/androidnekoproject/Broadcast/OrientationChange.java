package nyc.c4q.ashiquechowdhury.androidnekoproject.Broadcast;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;

/**
 * Created by Hyun on 12/16/16.
 */

public class OrientationChange extends WakefulBroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent startIntent = new Intent(context, OrientationService.class);
        startWakefulService(context,startIntent);
    }
}