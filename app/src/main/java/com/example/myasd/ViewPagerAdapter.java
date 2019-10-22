package com.example.myasd;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.CheckBox;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        KatzFragment katzFragment = new KatzFragment();
        position = position+1;
        Bundle bundle = new Bundle();
        bundle.putString("message", "Fragment :" + position);
        katzFragment.setArguments(bundle);
        return katzFragment;
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String[] titleTab = {"SE LAVER", "S'HABILLER", "TRANSFERT & DÉPLACEMENT", "ALLER À LA TOILETTE", "CONTINENCE", "MANGER"};
        return titleTab[position];
    }
}
