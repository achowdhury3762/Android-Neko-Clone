package nyc.c4q.ashiquechowdhury.androidnekoproject.herodialog;

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
import nyc.c4q.ashiquechowdhury.androidnekoproject.util.MySharedPreferences;
import nyc.c4q.ashiquechowdhury.androidnekoproject.util.RandomNumberChooser;

/**
 * Created by ashiquechowdhury on 12/16/16.
 */

public class HeroDialogFragment extends DialogFragment {

    private static final String HERO_DIALOG_IMAGE_URL = "https://marvelheroes.com/sites/default/files/slider/images/banner-000.png";
    @BindView(R.id.hero_dialog_image)
    ImageView heroDialogImageView;
    @BindView(R.id.spins_TV)
    TextView spinsEarnedView;

    private SpinnerDialogListener mListener;
    private MySharedPreferences sharedPreferences;
    private AlertDialog.Builder builder;
    private AlertDialog myAlertDialog;

    public static HeroDialogFragment newInstance() {
        return new HeroDialogFragment();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        sharedPreferences = MySharedPreferences.getInstance(getActivity().getApplicationContext());
        final View dialogView = createDialogView();
        ButterKnife.bind(this, dialogView);
        setImageWithPicasso(heroDialogImageView, dialogView.getContext(), HERO_DIALOG_IMAGE_URL);

        int heroesEarned = getUserEarnedHeroes();
        spinsEarnedView.setText(String.valueOf(heroesEarned) + " HEROES!");

        builder = new AlertDialog.Builder(getActivity());
        return alertBuilder(builder);
    }

    private AlertDialog alertBuilder(AlertDialog.Builder builder) {
        builder.setMessage("You've Earned")
                .setPositiveButton(R.string.use_spinner, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mListener.onDialogPositiveClick(HeroDialogFragment.this);
                    }
                })
                .setNeutralButton(R.string.recyclerview_heroes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mListener.onDialogNeutralClick(HeroDialogFragment.this);
                    }
                });

        myAlertDialog = builder.create();
        return myAlertDialog;
    }

    private int getUserEarnedHeroes() {
        int spinsGiven = RandomNumberChooser.chooseRandomNumber(8) + 2;
        sharedPreferences.increaseTotalHeroCount(spinsGiven);
        return spinsGiven;
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
