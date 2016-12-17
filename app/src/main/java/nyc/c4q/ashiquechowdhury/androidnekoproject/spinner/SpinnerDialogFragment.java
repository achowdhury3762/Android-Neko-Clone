package nyc.c4q.ashiquechowdhury.androidnekoproject.spinner;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;

import nyc.c4q.ashiquechowdhury.androidnekoproject.R;

/**
 * Created by ashiquechowdhury on 12/16/16.
 */

public class SpinnerDialogFragment extends DialogFragment {
    private SpinnerDialogListener mListener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.activity_spinner, null))
                .setPositiveButton(R.string.use_spinner, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mListener.onDialogPositiveClick(SpinnerDialogFragment.this);
                    }
                })
                .setNegativeButton(R.string.hero_overview, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mListener.onDialogNegativeClick(SpinnerDialogFragment.this);
                    }
                });
        return builder.create();
    }

    public interface SpinnerDialogListener {
        void onDialogPositiveClick(DialogFragment dialog);
        void onDialogNegativeClick(DialogFragment dialog);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (SpinnerDialogListener) context;
    }
}
