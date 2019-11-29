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
import com.example.myasd.tools.CheckboxControl;


/**
 * A simple {@link Fragment} subclass.
 */
public class Shabiller extends Fragment {

    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    CheckBox checkBox4;
    CheckBox checkBox5;
    CheckBox checkBox6;
    CheckBox checkBox7;
    CheckBox checkBox8;
    SendScore SS;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.s_habiller, container, false);
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

        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox1.isChecked()) {
                    CheckboxControl.setDisabled(checkBox3, checkBox8);
                } else {
                    CheckboxControl.setEnabled(checkBox3, checkBox8);
                }
                calculateScore();
            }
        });
        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox2.isChecked()) {
                    CheckboxControl.setDisabled(checkBox4, checkBox8);
                } else {
                    CheckboxControl.setEnabled(checkBox3, checkBox8);
                }
                calculateScore();
            }
        });
        checkBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox3.isChecked()) {
                    CheckboxControl.setDisabled(checkBox1, checkBox8);
                } else {
                    CheckboxControl.setEnabled(checkBox1, checkBox8);
                }
                calculateScore();
            }
        });
        checkBox4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox4.isChecked()) {
                    CheckboxControl.setDisabled(checkBox2, checkBox8);
                } else {
                    CheckboxControl.setEnabled(checkBox2, checkBox8);
                }
                calculateScore();
            }
        });
        checkBox5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox5.isChecked()) {
                    CheckboxControl.setDisabled(checkBox8);
                } else {
                    CheckboxControl.setEnabled(checkBox8);
                }
                calculateScore();
            }
        });
        checkBox6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox6.isChecked()) {
                    CheckboxControl.setDisabled(checkBox8);
                } else {
                    CheckboxControl.setEnabled(checkBox8);
                }
                calculateScore();
            }
        });
        checkBox7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox6.isChecked()) {
                    CheckboxControl.setDisabled(checkBox8);
                } else {
                    CheckboxControl.setEnabled(checkBox8);
                }
                calculateScore();
            }
        });
        checkBox8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox8.isChecked()) {
                    CheckboxControl.setDisabled(checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7);
                } else {
                    CheckboxControl.setEnabled(checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7);
                }
                calculateScore();
            }
        });
    }

    private void calculateScore() {
        if (checkBox8.isChecked()) {
            SS.sendScoreShabiller("4");
        } else if (checkBox7.isChecked() || checkBox6.isChecked()) {
            SS.sendScoreShabiller("3");
        } else if (checkBox3.isChecked() && checkBox4.isChecked() && checkBox5.isChecked()) {
            SS.sendScoreShabiller("3");
        } else if (checkBox1.isChecked() && checkBox2.isChecked() && checkBox5.isChecked()) {
            SS.sendScoreShabiller("2");
        } else if (checkBox1.isChecked() && checkBox4.isChecked() && checkBox5.isChecked()) {
            SS.sendScoreShabiller("2");
        } else if (checkBox2.isChecked() && checkBox3.isChecked() && checkBox5.isChecked()) {
            SS.sendScoreShabiller("2");
        } else if (checkBox1.isChecked() && checkBox2.isChecked()) {
            SS.sendScoreShabiller("1");
        } else if (checkBox1.isChecked() && checkBox5.isChecked()) {
            SS.sendScoreShabiller("2");
        } else if (checkBox2.isChecked() && checkBox5.isChecked()) {
            SS.sendScoreShabiller("2");
        } else if (checkBox3.isChecked() && checkBox5.isChecked()) {
            SS.sendScoreShabiller("2");
        } else if (checkBox4.isChecked() && checkBox5.isChecked()) {
            SS.sendScoreShabiller("2");
        } else if (checkBox1.isChecked() && checkBox4.isChecked()) {
            SS.sendScoreShabiller("2");
        } else if (checkBox2.isChecked() && checkBox3.isChecked()) {
            SS.sendScoreShabiller("2");
        } else if (checkBox3.isChecked() && checkBox4.isChecked()) {
            SS.sendScoreShabiller("3");
        } else if (checkBox5.isChecked() && checkBox6.isChecked()) {
            SS.sendScoreShabiller("3");
        } else if (checkBox1.isChecked()) {
            SS.sendScoreShabiller("1");
        } else if (checkBox2.isChecked()) {
            SS.sendScoreShabiller("1");
        } else if (checkBox3.isChecked()) {
            SS.sendScoreShabiller("2");
        } else if (checkBox4.isChecked()) {
            SS.sendScoreShabiller("2");
        } else if (checkBox5.isChecked()) {
            SS.sendScoreShabiller("2");
        } else {
            SS.sendScoreShabiller("NO_SCORE");
        }
    }

    public interface SendScore{
        void sendScoreShabiller(String Score);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            SS = (Shabiller.SendScore) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("Error in retrieving data from S_HABILLER. Please try again");
        }
    }


}
