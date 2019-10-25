package com.example.myasd;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.myasd.KatzFragment.Continence;
import com.example.myasd.KatzFragment.Manger;
import com.example.myasd.KatzFragment.Resume;
import com.example.myasd.KatzFragment.SeLaver;
import com.example.myasd.KatzFragment.Shabiller;
import com.example.myasd.KatzFragment.Toilette;
import com.example.myasd.KatzFragment.Transfert;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            SeLaver katzFragment = new SeLaver();
            Bundle bundle = new Bundle();
            katzFragment.setArguments(bundle);
            return katzFragment;
        } else if (position == 1) {
            Shabiller katzFragment = new Shabiller();
            Bundle bundle = new Bundle();
            katzFragment.setArguments(bundle);
            return katzFragment;
        } else if (position == 2) {
            Transfert katzFragment = new Transfert();
            Bundle bundle = new Bundle();
            katzFragment.setArguments(bundle);
            return katzFragment;
        } else if (position == 3) {
            Toilette katzFragment = new Toilette();
            Bundle bundle = new Bundle();
            katzFragment.setArguments(bundle);
            return katzFragment;
        } else if (position == 4) {
            Continence katzFragment = new Continence();
            Bundle bundle = new Bundle();
            katzFragment.setArguments(bundle);
            return katzFragment;
        } else if (position == 5) {
            Manger katzFragment = new Manger();
            Bundle bundle = new Bundle();
            katzFragment.setArguments(bundle);
            return katzFragment;
        } else if (position == 6) {
            Resume katzFragment = new Resume();
            Bundle bundle = new Bundle();
            katzFragment.setArguments(bundle);
            return katzFragment;
        } else {
            return null;
        }
    }

    @Override
    public int getCount() {
        return 7;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String[] titleTab = {"SE LAVER", "S'HABILLER", "TRANSFERT & DÉPLACEMENT", "ALLER À LA TOILETTE", "CONTINENCE", "MANGER", "RESUMÉ"};
        return titleTab[position];
    }
}
