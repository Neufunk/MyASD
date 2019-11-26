package com.example.myasd.KatzFragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.example.myasd.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Transfert extends Fragment {

    CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, checkBox8, checkBox9, checkBox10, checkBox11, checkBox12, checkBox13;
    SendScore SS;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.transfert, container, false);
        checkBoxManipulation(view);
        return view;
    }

    private void checkBoxManipulation(final View view) {
        checkBox1 = view.findViewById(R.id.checkBox1);
        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox1.isChecked()) {
                    checkBox3.setEnabled(false);
                    checkBox13.setEnabled(false);
                } else {
                    checkBox3.setEnabled(true);
                    checkBox13.setEnabled(true);
                }
                calculateScore();
            }
        });
        checkBox2 = view.findViewById(R.id.checkBox2);
        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox2.isChecked()) {
                    checkBox4.setChecked(false);
                } else {
                    checkBox4.setChecked(true);
                }
                calculateScore();
            }
        });
        checkBox2 = view.findViewById(R.id.checkBox2);
        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox2.isChecked()) {

                } else {

                }
                calculateScore();
            }
        });
        checkBox3 = view.findViewById(R.id.checkBox3);
        checkBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox3.isChecked()) {

                } else {

                }
                calculateScore();
            }
        });
        checkBox4 = view.findViewById(R.id.checkBox4);
        checkBox4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox4.isChecked()) {

                } else {

                }
                calculateScore();
            }
        });
        checkBox5 = view.findViewById(R.id.checkBox5);
        checkBox5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox5.isChecked()) {

                } else {

                }
                calculateScore();
            }
        });
        checkBox6 = view.findViewById(R.id.checkBox6);
        checkBox6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox6.isChecked()) {

                } else {

                }
                calculateScore();
            }
        });
        checkBox7 = view.findViewById(R.id.checkBox7);
        checkBox7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox7.isChecked()) {

                } else {

                }
                calculateScore();
            }
        });
        checkBox8 = view.findViewById(R.id.checkBox8);
        checkBox8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox8.isChecked()) {

                } else {

                }
                calculateScore();
            }
        });
        checkBox9 = view.findViewById(R.id.checkBox9);
        checkBox9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox9.isChecked()) {

                } else {

                }
                calculateScore();
            }
        });
        checkBox10 = view.findViewById(R.id.checkBox10);
        checkBox10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox10.isChecked()) {

                } else {

                }
                calculateScore();
            }
        });
        checkBox11 = view.findViewById(R.id.checkBox11);
        checkBox11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox11.isChecked()) {

                } else {

                }
                calculateScore();
            }
        });
        checkBox12 = view.findViewById(R.id.checkBox12);
        checkBox12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox12.isChecked()) {

                } else {

                }
                calculateScore();
            }
        });
        checkBox13 = view.findViewById(R.id.checkBox13);
        checkBox13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox13.isChecked()) {

                } else {

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
