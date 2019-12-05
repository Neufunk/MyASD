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

public class Transfert extends Fragment {

    TextView textView;
    CheckboxControl checkboxControl = new CheckboxControl();
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, checkBox8, checkBox9, checkBox10, checkBox11, checkBox12, checkBox13;
    SendScore SS;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.transfert, container, false);
        textView = view.findViewById(R.id.textView);
        checkBoxManipulation(view);
        checkboxControl.checkCriteria(textView, 2);
        return view;
    }

    private void checkBoxManipulation(final View view) {
        checkBox1 = view.findViewById(R.id.checkBox1);
        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox1.isChecked()) {
                    checkboxControl.setDisabled(checkBox3, checkBox6, checkBox7, checkBox8, checkBox9, checkBox11, checkBox12, checkBox13);
                } else {
                    checkboxControl.setEnabled(checkBox3, checkBox6, checkBox7, checkBox8, checkBox9, checkBox11, checkBox12, checkBox13);
                }
                checkboxControl.checkCriteria(textView, 2);
                calculateScore();
            }
        });
        checkBox2 = view.findViewById(R.id.checkBox2);
        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox2.isChecked()) {
                    checkboxControl.setDisabled(checkBox4, checkBox10, checkBox11, checkBox12, checkBox13);
                } else {
                    checkboxControl.setEnabled(checkBox4, checkBox10, checkBox11, checkBox12, checkBox13);
                }
                checkboxControl.checkCriteria(textView, 2);
                calculateScore();
            }
        });
        checkBox3 = view.findViewById(R.id.checkBox3);
        checkBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox3.isChecked()) {
                    checkboxControl.setDisabled(checkBox1, checkBox11, checkBox12, checkBox13);
                } else {
                    checkboxControl.setEnabled(checkBox1, checkBox11, checkBox12, checkBox13);
                }
                checkboxControl.checkCriteria(textView, 2);
                calculateScore();
            }
        });
        checkBox4 = view.findViewById(R.id.checkBox4);
        checkBox4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox4.isChecked()) {
                    checkboxControl.setDisabled(checkBox2, checkBox11, checkBox12, checkBox13);
                } else {
                    checkboxControl.setEnabled(checkBox2, checkBox11, checkBox12, checkBox13);
                }
                checkboxControl.checkCriteria(textView, 2);
                calculateScore();
            }
        });
        checkBox5 = view.findViewById(R.id.checkBox5);
        checkBox5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox5.isChecked()) {
                    checkboxControl.setDisabled(checkBox11, checkBox12, checkBox13);
                } else {
                    checkboxControl.setEnabled(checkBox11, checkBox12, checkBox13);
                }
                checkboxControl.checkCriteria(textView, 2);
                calculateScore();
            }
        });
        checkBox6 = view.findViewById(R.id.checkBox6);
        checkBox6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox6.isChecked()) {
                    checkboxControl.setDisabled(checkBox11, checkBox12, checkBox13);
                } else {
                    checkboxControl.setEnabled(checkBox11, checkBox12, checkBox13);
                }
                checkboxControl.checkCriteria(textView, 2);
                calculateScore();
            }
        });
        checkBox7 = view.findViewById(R.id.checkBox7);
        checkBox7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox7.isChecked()) {
                    checkboxControl.setDisabled(checkBox11, checkBox12, checkBox13);
                } else {
                    checkboxControl.setEnabled(checkBox11, checkBox12, checkBox13);
                }
                checkboxControl.checkCriteria(textView, 2);
                calculateScore();
            }
        });
        checkBox8 = view.findViewById(R.id.checkBox8);
        checkBox8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox8.isChecked()) {
                    checkboxControl.setDisabled(checkBox11, checkBox12, checkBox13);
                } else {
                    checkboxControl.setEnabled(checkBox11, checkBox12, checkBox13);
                }
                checkboxControl.checkCriteria(textView, 2);
                calculateScore();
            }
        });
        checkBox9 = view.findViewById(R.id.checkBox9);
        checkBox9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox9.isChecked()) {
                    checkboxControl.setDisabled(checkBox11, checkBox12, checkBox13);
                } else {
                    checkboxControl.setEnabled(checkBox11, checkBox12, checkBox13);
                }
                checkboxControl.checkCriteria(textView, 2);
                calculateScore();
            }
        });
        checkBox10 = view.findViewById(R.id.checkBox10);
        checkBox10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox10.isChecked()) {
                    checkboxControl.setDisabled(checkBox11, checkBox12, checkBox13);
                } else {
                    checkboxControl.setEnabled(checkBox11, checkBox12, checkBox13);
                }
                checkboxControl.checkCriteria(textView, 2);
                calculateScore();
            }
        });
        checkBox11 = view.findViewById(R.id.checkBox11);
        checkBox11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox11.isChecked()) {
                    checkboxControl.setDisabled(checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, checkBox8, checkBox9, checkBox10, checkBox12, checkBox13);
                    checkboxControl.checkCriteria(textView, 1);
                } else {
                    checkboxControl.setEnabled(checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, checkBox8, checkBox9, checkBox10, checkBox12, checkBox13);
                    checkboxControl.checkCriteria(textView, 2);
                }
                calculateScore();
            }
        });
        checkBox12 = view.findViewById(R.id.checkBox12);
        checkBox12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox12.isChecked()) {
                    checkboxControl.setDisabled(checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, checkBox8, checkBox9, checkBox10, checkBox11, checkBox13);
                    checkboxControl.checkCriteria(textView, 1);
                } else {
                    checkboxControl.setEnabled(checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, checkBox8, checkBox9, checkBox10, checkBox11, checkBox13);
                    checkboxControl.checkCriteria(textView, 2);
                }
                calculateScore();
            }
        });
        checkBox13 = view.findViewById(R.id.checkBox13);
        checkBox13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox13.isChecked()) {
                    checkboxControl.setDisabled(checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, checkBox8, checkBox9, checkBox10, checkBox11, checkBox12);
                    checkboxControl.checkCriteria(textView, 1);
                } else {
                    checkboxControl.setEnabled(checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, checkBox8, checkBox9, checkBox10, checkBox11, checkBox12);
                    checkboxControl.checkCriteria(textView, 2);
                }
                calculateScore();
            }
        });
    }

    private void calculateScore() {
        if (checkBox13.isChecked() || checkBox12.isChecked() || checkBox11.isChecked()){
            SS.sendTransfertScore("4");
        } else if (checkBox6.isChecked() || checkBox7.isChecked() || checkBox8.isChecked() || checkBox9.isChecked() ||checkBox10.isChecked()) {
            SS.sendTransfertScore("3");
        } else if (checkBox4.isChecked() || checkBox5.isChecked() || checkBox3.isChecked()) {
            SS.sendTransfertScore("2");
        } else if (checkBox2.isChecked() || checkBox1.isChecked()) {
            SS.sendTransfertScore("1");
        } else {
            SS.sendTransfertScore("NO_SCORE");
        }
    }

    public interface SendScore {
        void sendTransfertScore(String score);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            SS = (Transfert.SendScore) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("Error in retrieving data from TRANSFERT. Please try again");
        }
    }

}
