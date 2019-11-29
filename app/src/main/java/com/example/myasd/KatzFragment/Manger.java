package com.example.myasd.KatzFragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.example.myasd.R;
import com.example.myasd.tools.CheckboxControl;


/**
 * A simple {@link Fragment} subclass.
 */
public class Manger extends Fragment {

    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    CheckBox checkBox4;
    CheckBox checkBox5;
    CheckBox checkBox6;
    CheckBox checkBox7;
    CheckBox checkBox8;
    CheckBox checkBox9;
    CheckBox checkBox10;
    CheckBox checkBox11;
    SendScore SS;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.manger, container, false);
        checkBoxManipulation(view);
        return view;
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
        checkBox10 = view.findViewById(R.id.checkBox10);
        checkBox11 = view.findViewById(R.id.checkBox11);

        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox1.isChecked()) {
                    CheckboxControl.setDisabled(checkBox3, checkBox5, checkBox6, checkBox7, checkBox8, checkBox9, checkBox10);
                } else {
                    CheckboxControl.setEnabled(checkBox3, checkBox5, checkBox6, checkBox7, checkBox8, checkBox9, checkBox10);
                }
                calculateScore();
            }
        });
        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox2.isChecked()) {
                    CheckboxControl.setDisabled(checkBox4);
                } else {
                    CheckboxControl.setEnabled(checkBox4);
                }
                calculateScore();
            }
        });
        checkBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox3.isChecked()) {

                } else {

                }
                calculateScore();
            }
        });
        checkBox4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox4.isChecked()) {

                } else {

                }
                calculateScore();
            }
        });
        checkBox5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox5.isChecked()) {

                } else {

                }
                calculateScore();
            }
        });
        checkBox6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox6.isChecked()) {

                } else {

                }
                calculateScore();
            }
        });
        checkBox7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox6.isChecked()) {

                } else {

                }
                calculateScore();
            }
        });
        checkBox8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox8.isChecked()) {

                } else {

                }
                calculateScore();
            }
        });
        checkBox9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox9.isChecked()) {

                } else {

                }
                calculateScore();
            }
        });
        checkBox10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox10.isChecked()) {
                    CheckboxControl.setDisabled(checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, checkBox8, checkBox9, checkBox11);
                } else {
                    CheckboxControl.setEnabled(checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, checkBox8, checkBox9, checkBox11);
                }
                calculateScore();
            }
        });
        checkBox11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox11.isChecked()) {

                } else {

                }
                calculateScore();
            }
        });

    }

    private void calculateScore() {
        if (checkBox11.isChecked() || checkBox10.isChecked()) {
            SS.sendScoreManger("4");
        } else if (checkBox9.isChecked() || checkBox8.isChecked()) {
            SS.sendScoreManger("3");
        } else if (checkBox7.isChecked() || checkBox6.isChecked() || checkBox5.isChecked() || checkBox4.isChecked() || checkBox3.isChecked()) {
            SS.sendScoreManger("2");
        } else if (checkBox2.isChecked() || checkBox1.isChecked()) {
            SS.sendScoreManger("1");
        } else {
            SS.sendScoreManger("NO_SCORE");
        }
    }

    public interface SendScore {
        void sendScoreManger(String score);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            SS = (Manger.SendScore) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("Error in retrieving data from MANGER. Please try again");
        }
    }
}
