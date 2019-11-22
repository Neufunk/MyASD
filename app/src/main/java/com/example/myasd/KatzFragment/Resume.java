package com.example.myasd.KatzFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.myasd.R;

public class Resume extends Fragment {

    EditText inputNom;
    EditText inputSurname;
    EditText inputNiss;
    EditText inputScore_1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.resume, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        inputScore_1 = (EditText)view.findViewById(R.id.inputScore1);
    }

    public void setScore_1(String score) {
        inputScore_1.setText(score);
    }

}
