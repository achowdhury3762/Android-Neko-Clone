package nyc.c4q.ashiquechowdhury.androidnekoproject.allherodisplay.herofragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nyc.c4q.ashiquechowdhury.androidnekoproject.R;

/**
 * Created by Hyun on 12/18/16.
 */
public class TheFlash extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.theflash, container, false);
        return view;
    }
    public static TheFlash newInstance(){
        TheFlash theFlash = new TheFlash();
        return theFlash;
    }
}
