package nyc.c4q.ashiquechowdhury.androidnekoproject.herospins;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import nyc.c4q.ashiquechowdhury.androidnekoproject.R;

/**
 * Created by ashiquechowdhury on 12/16/16.
 */

public class SpinnerDialogFragment extends DialogFragment {
    private static final String RANDOMNUM = "nyc.c4q.ashiquechowdhury.RANDOMNUM";
    private static final String HERODIALOG_IMAGE_URL = "https://marvelheroes.com/sites/default/files/slider/images/banner-000.png";
    @BindView(R.id.hero_dialog_image) ImageView heroDialogImageView;
    @BindView(R.id.spins_TV) TextView spinsEarnedView;
    private SpinnerDialogListener mListener;

    public static SpinnerDialogFragment newInstance(int number) {
        SpinnerDialogFragment frag = new SpinnerDialogFragment();
        Bundle args = new Bundle();
        args.putInt(RANDOMNUM, number);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View dialogView = createDialogView();
        ButterKnife.bind(this, dialogView);

        int randomNumber2to10 = getArguments().getInt(RANDOMNUM);
        setImageWithPicasso(heroDialogImageView, dialogView.getContext(), HERODIALOG_IMAGE_URL);

        spinsEarnedView.setText(String.valueOf(randomNumber2to10) + " SPINS!");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(dialogView)
                .setMessage("You've Earned")
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

        AlertDialog myAlertDialog = builder.create();
        return myAlertDialog;
    }

    private View createDialogView() {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        return inflater.inflate(R.layout.dialogfragment_spinner, null);
    }

    public void setImageWithPicasso(ImageView herodialogImageView, Context context, String imageURL) {
        Picasso.with(context)
                .load(imageURL)
                .fit()
                .into(herodialogImageView);
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

    @Override
    public void onDismiss(DialogInterface dialog) {
        getActivity().finish();
    }
}
