package com.example.myasd.KatzFragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.example.myasd.R;

public class Toilette extends Fragment {

    CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6;
    SendScore SS;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.toilette, container, false);
        checkBoxManipulation(view);
        return view;
    }

    private void checkBoxManipulation(final View view) {
        checkBox1 = view.findViewById(R.id.checkBox1);
        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox1.isChecked()) {
                    checkBox4.setEnabled(false);
                    checkBox4.setChecked(false);
                } else {
                    checkBox4.setEnabled(true);
                }
                calculateScore();
            }
        });
        checkBox2 = view.findViewById(R.id.checkBox2);
        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox2.isChecked()) {
                    checkBox5.setChecked(false);
                    checkBox5.setEnabled(false);
                } else {
                    checkBox5.setEnabled(true);
                }
                calculateScore();
            }
        });
        checkBox3 = view.findViewById(R.id.checkBox3);
        checkBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox3.isChecked()) {
                    checkBox6.setChecked(false);
                    checkBox6.setEnabled(false);
                } else {
                    checkBox6.setEnabled(true);
                }
                calculateScore();
            }
        });
        checkBox4 = view.findViewById(R.id.checkBox4);
        checkBox4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox4.isChecked()) {
                    checkBox1.setEnabled(false);
                    checkBox1.setChecked(false);
                } else {
                    checkBox1.setEnabled(true);
                }
                calculateScore();
            }
        });
        checkBox5 = view.findViewById(R.id.checkBox5);
        checkBox5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox5.isChecked()) {
                    checkBox2.setChecked(false);
                    checkBox2.setEnabled(false);
                } else {
                    checkBox2.setEnabled(true);
                }
                calculateScore();
            }
        });
        checkBox6 = view.findViewById(R.id.checkBox6);
        checkBox6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox6.isChecked()) {
                    checkBox3.setChecked(false);
                    checkBox3.setEnabled(false);
                } else {
                    checkBox3.setEnabled(true);
                }
                calculateScore();
            }
        });
    }

    private void calculateScore(){
        if (checkBox1.isChecked() && checkBox2.isChecked() && checkBox3.isChecked()) {
            SS.sendScoretoilette("1");
        } else if (checkBox1.isChecked() && checkBox2.isChecked() && checkBox6.isChecked()) {
            SS.sendScoretoilette("2");
        } else if (checkBox1.isChecked() && checkBox3.isChecked() && checkBox5.isChecked()) {
            SS.sendScoretoilette("2");
        } else if (checkBox2.isChecked() && checkBox3.isChecked() && checkBox4.isChecked()) {
            SS.sendScoretoilette("2");
        } else if (checkBox1.isChecked() && checkBox5.isChecked() && checkBox6.isChecked()) {
            SS.sendScoretoilette("3");
        } else if (checkBox2.isChecked() && checkBox4.isChecked() && checkBox6.isChecked()) {
            SS.sendScoretoilette("3");
        } else if (checkBox2.isChecked() && checkBox4.isChecked() && checkBox5.isChecked()) {
            SS.sendScoretoilette("3");
        } else if (checkBox4.isChecked() && checkBox5.isChecked() && checkBox6.isChecked()) {
            SS.sendScoretoilette("4");
        } else {
            SS.sendScoretoilette("NO_SCORE");
        }
    }

    public interface SendScore {
        void sendScoretoilette(String score);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            SS = (Toilette.SendScore) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("Error in retrieving data from TOILETTE. Please try again");
        }
    }
}
