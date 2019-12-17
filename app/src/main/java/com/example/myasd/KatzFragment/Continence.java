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

public class Continence extends Fragment {

    TextView textView;
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, checkBox8,
            checkBox9, checkBox10, checkBox11, checkBox12, checkBox13, checkBox14, checkBox15, checkBox16;
    SendScore SS;
    CheckboxControl checkboxControl = new CheckboxControl();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.continence, container, false);
        textView = view.findViewById(R.id.textView);
        checkBoxManipulation(view);
        checkboxControl.checkCriteria(textView, 1);
        return view;
    }

    private void checkBoxManipulation(final View view) {
        checkBox1 = view.findViewById(R.id.checkBox1);
        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox1.isChecked()) {
                    checkboxControl.setDisabled(checkBox3, checkBox4, checkBox5, checkBox6, checkBox10, checkBox11, checkBox12, checkBox14, checkBox15);
                } else {
                    checkboxControl.setEnabled(checkBox3, checkBox4, checkBox5, checkBox6, checkBox10, checkBox11, checkBox12, checkBox14, checkBox15);
                }
                calculateScore();
            }
        });
        checkBox2 = view.findViewById(R.id.checkBox2);
        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox2.isChecked()) {
                    checkboxControl.setDisabled(checkBox7, checkBox8, checkBox9, checkBox13, checkBox16);
                } else {
                    checkboxControl.setEnabled(checkBox7, checkBox8, checkBox9, checkBox13, checkBox16);
                }
                calculateScore();
            }
        });
        checkBox3 = view.findViewById(R.id.checkBox3);
        checkBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox3.isChecked()) {
                    checkboxControl.setDisabled(checkBox1, checkBox5);
                } else {
                    checkboxControl.setEnabled(checkBox1, checkBox5);
                }
                calculateScore();
            }
        });
        checkBox4 = view.findViewById(R.id.checkBox4);
        checkBox4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox4.isChecked()) {
                    checkboxControl.setDisabled(checkBox1, checkBox6);
                } else {
                    checkboxControl.setEnabled(checkBox1, checkBox6);
                }
                calculateScore();
            }
        });
        checkBox5 = view.findViewById(R.id.checkBox5);
        checkBox5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox5.isChecked()) {
                    checkboxControl.setDisabled(checkBox1, checkBox3);
                } else {
                    checkboxControl.setEnabled(checkBox1, checkBox3);
                }
                calculateScore();
            }
        });
        checkBox6 = view.findViewById(R.id.checkBox6);
        checkBox6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox6.isChecked()) {
                    checkboxControl.setDisabled(checkBox1, checkBox4);
                } else {
                    checkboxControl.setEnabled(checkBox1, checkBox4);
                }
                calculateScore();
            }
        });
        checkBox7 = view.findViewById(R.id.checkBox7);
        checkBox7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox7.isChecked()) {
                    checkboxControl.setDisabled(checkBox2, checkBox8);
                } else {
                    checkboxControl.setEnabled(checkBox2, checkBox8);
                }
                calculateScore();
            }
        });
        checkBox8 = view.findViewById(R.id.checkBox8);
        checkBox8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox8.isChecked()) {
                    checkboxControl.setDisabled(checkBox2, checkBox7);
                } else {
                    checkboxControl.setEnabled(checkBox2, checkBox7);
                }
                calculateScore();
            }
        });
        checkBox9 = view.findViewById(R.id.checkBox9);
        checkBox9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox9.isChecked()) {
                    checkboxControl.setDisabled(checkBox1);
                } else {
                    checkboxControl.setEnabled(checkBox1);
                }
                calculateScore();
            }
        });
        checkBox10 = view.findViewById(R.id.checkBox10);
        checkBox10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox10.isChecked()) {
                    checkboxControl.setDisabled(checkBox1);
                } else {
                    checkboxControl.setEnabled(checkBox1);
                }
                calculateScore();
            }
        });
        checkBox11 = view.findViewById(R.id.checkBox11);
        checkBox11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox11.isChecked()) {
                    checkboxControl.setDisabled(checkBox1);
                } else {
                    checkboxControl.setEnabled(checkBox1);
                }
                calculateScore();
            }
        });
        checkBox12 = view.findViewById(R.id.checkBox12);
        checkBox12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox12.isChecked()) {
                    checkboxControl.setDisabled(checkBox2);
                } else {
                    checkboxControl.setEnabled(checkBox2);
                }
                calculateScore();
            }
        });
        checkBox13 = view.findViewById(R.id.checkBox13);
        checkBox13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox13.isChecked()) {
                    checkboxControl.setDisabled(checkBox2);
                } else {
                    checkboxControl.setEnabled(checkBox2);
                }
                calculateScore();
            }
        });
        checkBox14 = view.findViewById(R.id.checkBox14);
        checkBox14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox14.isChecked()) {
                    checkboxControl.setDisabled(checkBox1);
                } else {
                    checkboxControl.setEnabled(checkBox1);
                }
                calculateScore();
            }
        });
        checkBox15 = view.findViewById(R.id.checkBox15);
        checkBox15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox15.isChecked()) {
                    checkboxControl.setDisabled(checkBox1);
                } else {
                    checkboxControl.setEnabled(checkBox1);
                }
                calculateScore();
            }
        });
        checkBox16 = view.findViewById(R.id.checkBox16);
        checkBox16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox16.isChecked()) {
                    checkboxControl.setDisabled(checkBox2);
                } else {
                    checkboxControl.setEnabled(checkBox2);
                }
                calculateScore();
            }
        });
    }

    private void calculateScore() {
        checkboxControl.checkCriteria(textView, 1);
        checkT7Combination();
        if (checkBox15.isChecked() && checkBox16.isChecked()) {
            SS.sendScoreContinence("4");
        } else if (checkBox5.isChecked() && checkBox6.isChecked() && checkBox8.isChecked()) {
            SS.sendScoreContinence("4");
        } else if (checkBox15.isChecked() || checkBox16.isChecked() || checkBox14.isChecked() || checkBox13.isChecked()) {
            SS.sendScoreContinence("3");
        } else if (checkBox5.isChecked() && checkBox6.isChecked()) {
            SS.sendScoreContinence("3");
        } else if (checkBox8.isChecked()) {
            SS.sendScoreContinence("3");
        } else if (checkBox3.isChecked() || checkBox4.isChecked() || checkBox5.isChecked() || checkBox6.isChecked() || checkBox7.isChecked() || checkBox9.isChecked() || checkBox10.isChecked() ||checkBox11.isChecked() || checkBox12.isChecked()) {
            SS.sendScoreContinence("2");
        } else if (checkBox2.isChecked() || checkBox1.isChecked()) {
            SS.sendScoreContinence("1");
        } else {
            SS.sendScoreContinence("NO_SCORE");
        }
    }

    private void checkT7Combination() {
        Boolean t7_combination = checkBox3.isChecked() && checkBox6.isChecked();
        SS.sendT7Combination(t7_combination);
    }

    public interface SendScore {
        void sendScoreContinence(String score);
        void sendT7Combination(Boolean bool);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            SS = (Continence.SendScore) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("Error in retrieving data from CONTINENCE. Please try again");
        }
    }
}
