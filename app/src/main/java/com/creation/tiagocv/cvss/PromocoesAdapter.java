package com.creation.tiagocv.cvss;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by tcver on 20/03/2017.
 */

public class PromocoesAdapter extends BaseAdapter {

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

            textViewTitle.setText(mList.get(position)[0]);
            textViewDescription.setText(mList.get(position)[1]);


        } else {
            cardView =  convertView;
        }


        return cardView;
    }
}
