package com.creation.tiagocv.cvss;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

/**
 * Created by tcver on 20/03/2017.
 */

public class PromocoesAdapter extends BaseAdapter {

    private int lastPosition = -1;

    FirebaseStorage storage = FirebaseStorage.getInstance();
    private Context mContext;
    private ArrayList<String[]> mList;

    public PromocoesAdapter(Context c, ArrayList<String[]> s) {
        mContext = c;
        mList = s;
    }

    public int getCount() {
        return mList.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new CardView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        View cardView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            cardView =  View.inflate( parent.getContext(), R.layout.card_view_promocoes, null);

            TextView textViewTitle = (TextView) cardView.findViewById(R.id.card_view_promocoes_title);
            TextView textViewDescription = (TextView) cardView.findViewById(R.id.card_view_promocoes_description);
            ImageView imageView = (ImageView) cardView.findViewById(R.id.card_view_promocoes_image) ;

            textViewTitle.setText(mList.get(position)[0]);
            textViewDescription.setText(mList.get(position)[1]);

            StorageReference httpsReference = storage.getReferenceFromUrl(mList.get(position)[2]);

            // Load the image using Glide
            Glide.with( mContext /* context */)
                    .using(new FirebaseImageLoader())
                    .load(httpsReference)
                    .crossFade()
                    .into(imageView);

            Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
            cardView.startAnimation(animation);
            lastPosition = position;


        } else {
            cardView =  convertView;
        }


        return cardView;
    }
}
