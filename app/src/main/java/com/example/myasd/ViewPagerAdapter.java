package com.example.myasd;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.myasd.KatzFragment.Shabiller;
import com.example.myasd.KatzFragment.SeLaver;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            SeLaver katzFragment = new SeLaver();
            position = position + 1;
            Bundle bundle = new Bundle();
            katzFragment.setArguments(bundle);
            return katzFragment;
        } else {
            Shabiller katzFragment = new Shabiller();
            position = position + 1;
            Bundle bundle = new Bundle();
            katzFragment.setArguments(bundle);
            return katzFragment;
        }
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
