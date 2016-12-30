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
public class IronMan extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.ironman, container, false);
        return view;
    }
    public static IronMan newInstance(){
        IronMan ironMan = new IronMan();
        return ironMan;
    }
}