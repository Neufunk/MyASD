package com.example.myasd.KatzFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myasd.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Toilette extends Fragment {


    public Toilette() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.toilette, container, false);
        return view;
    }
}
