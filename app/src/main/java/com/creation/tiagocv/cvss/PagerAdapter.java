package com.creation.tiagocv.cvss;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.animation.Animation;

/**
 * Created by tcver on 19/03/2017.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs = 3;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                PromocoesFragment tab1 = new PromocoesFragment();
                return tab1;
            case 1:
                AnimaisFragment tab2 = new AnimaisFragment();
                return tab2;
            case 2:
                EventosFragment tab3 = new EventosFragment();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
