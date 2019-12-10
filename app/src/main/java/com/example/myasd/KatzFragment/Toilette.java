package com.example.myasd.KatzFragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.myasd.R;
import com.example.myasd.tools.CheckboxControl;

public class Toilette extends Fragment {

    CheckboxControl checkboxControl = new CheckboxControl();
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6;
    SendScore SS;
    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.toilette, container, false);
        checkBoxManipulation(view);
        textView = view.findViewById(R.id.textView);
        checkboxControl.checkCriteria(textView, 3);
        return view;
    }

    private void checkBoxManipulation(final View view) {
        checkBox1 = view.findViewById(R.id.checkBox1);
        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox1.isChecked()) {
                    checkboxControl.setDisabled(checkBox4);
                } else {
                    checkboxControl.setEnabled(checkBox4);
                }
                calculateScore();
            }
        });
        checkBox2 = view.findViewById(R.id.checkBox2);
        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox2.isChecked()) {
                    checkboxControl.setDisabled(checkBox5);
                } else {
                    checkboxControl.setEnabled(checkBox5);
                }
                calculateScore();
            }
        });
        checkBox3 = view.findViewById(R.id.checkBox3);
        checkBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox3.isChecked()) {
                    checkboxControl.setDisabled(checkBox6);
                } else {
                    checkboxControl.setEnabled(checkBox6);
                }
                calculateScore();
            }
        });
        checkBox4 = view.findViewById(R.id.checkBox4);
        checkBox4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox4.isChecked()) {
                    checkboxControl.setDisabled(checkBox1);
                } else {
                    checkboxControl.setEnabled(checkBox1);
                }
                calculateScore();
            }
        });
        checkBox5 = view.findViewById(R.id.checkBox5);
        checkBox5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox5.isChecked()) {
                    checkboxControl.setDisabled(checkBox2);
                } else {
                    checkboxControl.setEnabled(checkBox2);
                }
                calculateScore();
            }
        });
        checkBox6 = view.findViewById(R.id.checkBox6);
        checkBox6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox6.isChecked()) {
                    checkboxControl.setDisabled(checkBox3);
                } else {
                    checkboxControl.setEnabled(checkBox3);
                }
                calculateScore();
            }
        });
    }

    private void calculateScore() {
        checkboxControl.checkCriteria(textView, 3);
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
        } else if (checkBox3.isChecked() && checkBox4.isChecked() && checkBox5.isChecked()) {
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
