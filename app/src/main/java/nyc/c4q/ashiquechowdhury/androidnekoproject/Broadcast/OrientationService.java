package nyc.c4q.ashiquechowdhury.androidnekoproject.Broadcast;

import android.app.IntentService;
import android.content.Intent;

import nyc.c4q.ashiquechowdhury.androidnekoproject.AnimalClickActivity;

/**
 * Created by Hyun on 12/16/16.
 */
public class OrientationService extends IntentService{

    private static final String SERVICE_NAME = "orientation-service";

    public OrientationService(){
        super(SERVICE_NAME);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        intent = new Intent(this, AnimalClickActivity.class);
        startActivity(intent);
    }
}
