package nyc.c4q.ashiquechowdhury.androidnekoproject.allherodisplay.chooseview.spinmenuview.herofragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nyc.c4q.ashiquechowdhury.androidnekoproject.R;

/**
 * Created by Hyun on 12/17/16.
 */
public class HawkEye extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.hawkeye, container, false);
        return view;
    }
    public static HawkEye newInstance(){
        HawkEye hawkEye = new HawkEye();
        return hawkEye;
    }
}
