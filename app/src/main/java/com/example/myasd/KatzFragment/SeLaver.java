package com.example.myasd.KatzFragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.example.myasd.R;

public class SeLaver extends Fragment  {

    SendScore SS;

    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    CheckBox checkBox4;
    CheckBox checkBox5;
    CheckBox checkBox6;
    CheckBox checkBox7;
    CheckBox checkBox8;
    CheckBox checkBox9;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(
                R.layout.se_laver, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        checkBoxManipulation(view);
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
                    checkBox3.setEnabled(false);
                    checkBox9.setEnabled(false);
                } else {
                    checkBox3.setEnabled(true);
                    checkBox9.setEnabled(true);
                }
                calculateScore();
            }
        });
        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox2.isChecked()) {
                    checkBox4.setEnabled(false);
                    checkBox9.setEnabled(false);
                } else {
                    checkBox4.setEnabled(true);
                    checkBox9.setEnabled(true);
                }
                calculateScore();
            }
        });
        checkBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox3.isChecked()) {
                    checkBox1.setEnabled(false);
                    checkBox9.setEnabled(false);
                } else {
                    checkBox1.setEnabled(true);
                    checkBox9.setEnabled(true);
                }
                calculateScore();
            }
        });
        checkBox4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox4.isChecked()) {
                    checkBox2.setEnabled(false);
                    checkBox9.setEnabled(false);
                } else {
                    checkBox2.setEnabled(true);
                    checkBox9.setEnabled(true);
                }
                calculateScore();
            }
        });
        checkBox5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox5.isChecked()) {
                    checkBox9.setEnabled(false);
                } else {
                    checkBox9.setEnabled(true);
                }
                calculateScore();
            }
        });
        checkBox6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox6.isChecked()) {
                    checkBox9.setEnabled(false);
                } else {
                    checkBox9.setEnabled(true);
                }
                calculateScore();
            }
        });
        checkBox7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox7.isChecked()) {
                    checkBox1.setEnabled(false);
                    checkBox2.setEnabled(false);
                    checkBox3.setEnabled(false);
                    checkBox4.setEnabled(false);
                    checkBox5.setEnabled(false);
                    checkBox6.setEnabled(false);
                    checkBox8.setEnabled(false);
                    checkBox9.setEnabled(false);
                } else {
                    checkBox1.setEnabled(true);
                    checkBox2.setEnabled(true);
                    checkBox3.setEnabled(true);
                    checkBox4.setEnabled(true);
                    checkBox5.setEnabled(true);
                    checkBox6.setEnabled(true);
                    checkBox8.setEnabled(true);
                    checkBox9.setEnabled(true);
                }
                calculateScore();
            }
        });
        checkBox8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox8.isChecked()) {
                    checkBox1.setEnabled(false);
                    checkBox2.setEnabled(false);
                    checkBox3.setEnabled(false);
                    checkBox4.setEnabled(false);
                    checkBox5.setEnabled(false);
                    checkBox6.setEnabled(false);
                    checkBox7.setEnabled(false);
                    checkBox9.setEnabled(false);
                } else {
                    checkBox1.setEnabled(true);
                    checkBox2.setEnabled(true);
                    checkBox3.setEnabled(true);
                    checkBox4.setEnabled(true);
                    checkBox5.setEnabled(true);
                    checkBox6.setEnabled(true);
                    checkBox7.setEnabled(true);
                    checkBox9.setEnabled(true);
                }
                calculateScore();
            }
        });
        checkBox9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox9.isChecked()) {
                    checkBox1.setEnabled(false);
                    checkBox2.setEnabled(false);
                    checkBox3.setEnabled(false);
                    checkBox4.setEnabled(false);
                    checkBox5.setEnabled(false);
                    checkBox6.setEnabled(false);
                    checkBox7.setEnabled(false);
                    checkBox8.setEnabled(false);
                    checkBox1.setChecked(false);
                    checkBox2.setChecked(false);
                    checkBox3.setChecked(false);
                    checkBox4.setChecked(false);
                    checkBox5.setChecked(false);
                    checkBox6.setChecked(false);
                    checkBox8.setChecked(false);
                } else {
                    checkBox1.setEnabled(true);
                    checkBox2.setEnabled(true);
                    checkBox3.setEnabled(true);
                    checkBox4.setEnabled(true);
                    checkBox5.setEnabled(true);
                    checkBox6.setEnabled(true);
                    checkBox7.setEnabled(true);
                    checkBox8.setEnabled(true);
                }
                calculateScore();
            }
        });
    }

    private void calculateScore() {
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
        }  else if (checkBox8.isChecked()) {
            SS.sendScoreSeLaver("3");
        }  else if (checkBox9.isChecked()) {
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




