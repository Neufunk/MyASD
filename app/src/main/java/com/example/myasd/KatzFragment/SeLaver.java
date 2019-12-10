package com.example.myasd.KatzFragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.myasd.R;
import com.example.myasd.tools.CheckboxControl;

public class SeLaver extends Fragment {

    CheckboxControl checkboxControl = new CheckboxControl();
    SendScore SS;
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, checkBox8, checkBox9;
    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(
                R.layout.se_laver, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = view.findViewById(R.id.textView);
        checkBoxManipulation(view);
        checkboxControl.checkCriteria(textView, 1);
    }

    private void checkBoxManipulation(View view) {

        checkBox1 = view.findViewById(R.id.checkBox1);
        checkBox2 = view.findViewById(R.id.checkBox2);
        checkBox3 = view.findViewById(R.id.checkBox3);
        checkBox4 = view.findViewById(R.id.checkBox4);
        checkBox5 = view.findViewById(R.id.checkBox5);
        checkBox6 = view.findViewById(R.id.checkBox6);
        checkBox7 = view.findViewById(R.id.checkBox7);
        checkBox8 = view.findViewById(R.id.checkBox8);
        checkBox9 = view.findViewById(R.id.checkBox9);

        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox1.isChecked()) {
                    checkboxControl.setDisabled(checkBox3, checkBox9);
                } else {
                    checkboxControl.setEnabled(checkBox3, checkBox9);
                }
                calculateScore();
            }
        });
        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox2.isChecked()) {
                    checkboxControl.setDisabled(checkBox4, checkBox9);
                } else {
                    checkboxControl.setEnabled(checkBox4, checkBox9);
                }
                calculateScore();
            }
        });
        checkBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox3.isChecked()) {
                    checkboxControl.setDisabled(checkBox1, checkBox9);
                } else {
                    checkboxControl.setEnabled(checkBox1, checkBox9);
                }
                calculateScore();
            }
        });
        checkBox4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox4.isChecked()) {
                    checkboxControl.setDisabled(checkBox2, checkBox9);
                } else {
                    checkboxControl.setEnabled(checkBox2, checkBox9);
                }
                calculateScore();
            }
        });
        checkBox5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox5.isChecked()) {
                    checkboxControl.setDisabled(checkBox9);
                } else {
                    checkboxControl.setEnabled(checkBox9);
                }
                calculateScore();
            }
        });
        checkBox6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox6.isChecked()) {
                    checkboxControl.setDisabled(checkBox9);
                } else {
                    checkboxControl.setEnabled(checkBox9);
                }
                calculateScore();
            }
        });
        checkBox7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox7.isChecked()) {
                    checkboxControl.setDisabled(checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox8, checkBox9);
                } else {
                    checkboxControl.setEnabled(checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox8, checkBox9);
                }
                calculateScore();
            }
        });
        checkBox8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox8.isChecked()) {
                    checkboxControl.setDisabled(checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, checkBox9);
                } else {
                    checkboxControl.setEnabled(checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, checkBox9);
                }
                calculateScore();
            }
        });
        checkBox9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox9.isChecked()) {
                    checkboxControl.setDisabled(checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, checkBox8);
                } else {
                    checkboxControl.setEnabled(checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, checkBox8);
                }
                calculateScore();
            }
        });
    }

    private void calculateScore() {
        checkboxControl.checkCriteria(textView, 1);
        if (checkBox6.isChecked()) {
            SS.sendScoreSeLaver("3");
        } else if (checkBox3.isChecked() && checkBox4.isChecked() && checkBox5.isChecked()) {
            SS.sendScoreSeLaver("3");
        } else if (checkBox5.isChecked()) {
            SS.sendScoreSeLaver("2");
        } else if (checkBox3.isChecked() && checkBox4.isChecked()) {
            SS.sendScoreSeLaver("3");
        } else if (checkBox1.isChecked() && checkBox4.isChecked()) {
            SS.sendScoreSeLaver("2");
        } else if (checkBox2.isChecked() && checkBox3.isChecked()) {
            SS.sendScoreSeLaver("2");
        } else if (checkBox1.isChecked() && checkBox2.isChecked()) {
            SS.sendScoreSeLaver("1");
        } else if (checkBox1.isChecked()) {
            SS.sendScoreSeLaver("1");
        } else if (checkBox2.isChecked()) {
            SS.sendScoreSeLaver("1");
        } else if (checkBox3.isChecked()) {
            SS.sendScoreSeLaver("2");
        } else if (checkBox4.isChecked()) {
            SS.sendScoreSeLaver("2");
        } else if (checkBox7.isChecked()) {
            SS.sendScoreSeLaver("2");
        } else if (checkBox8.isChecked()) {
            SS.sendScoreSeLaver("3");
        } else if (checkBox9.isChecked()) {
            SS.sendScoreSeLaver("4");
        } else {
            SS.sendScoreSeLaver("NO_SCORE");
        }
    }

    public interface SendScore {
        void sendScoreSeLaver(String score);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            SS = (SendScore) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("Error in retrieving data from SE_LAVER. Please try again");
        }
    }
}




