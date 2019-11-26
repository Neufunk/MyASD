package com.example.myasd.KatzFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.myasd.R;

public class Resume extends Fragment {

    EditText inputNom;
    EditText inputSurname;
    EditText inputNiss;
    EditText inputScore_1, inputScore_2, inputScore_3, inputScore_4, inputScore_5, inputScore_6, inputScoreForfait;
    int score_1, score_2, score_3, score_4, score_5, score_6, total = 0;
    CheckBox checkBox;

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

        inputScore_1 = view.findViewById(R.id.inputScore1);
        inputScore_2 = view.findViewById(R.id.inputScore2);
        inputScore_3 = view.findViewById(R.id.inputScore3);
        inputScore_4 = view.findViewById(R.id.inputScore4);
        inputScore_5 = view.findViewById(R.id.inputScore5);
        inputScore_6 = view.findViewById(R.id.inputScore6);
        inputScoreForfait = view.findViewById(R.id.forfaitScore);
        checkBox = view.findViewById(R.id.checkBox);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateForfait();
            }
        });
    }

    private void calculateForfait() {
        if (checkEmpty()) {
            if (total >= 23) {
                inputScoreForfait.setText("FORFAIT C");
            } else if (total >= 18) {
                inputScoreForfait.setText("FORFAIT B");
            } else if (score_1 >= 3 && score_2 >= 3 && (score_3 >= 3 || score_4 >= 3)) {
                inputScoreForfait.setText("FORFAIT A");
            } else if (score_1 >= 2 && score_2 >= 2 && score_5 >= 2 || checkBox.isChecked() && score_1 >= 2 && score_2 >= 2) {
                inputScoreForfait.setText("NOMENCLATURE T7");
            } else if (score_1 >= 2) {
                inputScoreForfait.setText("NOMENCLATURE T2");
            } else {
                inputScoreForfait.setText("SCORED_WITH_ERROR");
            }
        } else {
            inputScoreForfait.setText("NO_SCORE");
        }
    }


    public void setScore_1(String score) {
        total -= score_1;
        inputScore_1.setText(score);
        if (isNumeric(score)) {
            score_1 = Integer.parseInt(score);
            total += score_1;
            calculateForfait();
        } else {
            inputScoreForfait.setText("NO_SCORE");
        }
    }

    public void setScore_2(String score) {
        total -= score_2;
        inputScore_2.setText(score);
        if (isNumeric(score)) {
            score_2 = Integer.parseInt(score);
            total += score_2;
            calculateForfait();
        } else {
            inputScoreForfait.setText("NO_SCORE");
        }
    }

    public void setScore_3(String score) {
        total -= score_3;
        inputScore_3.setText(score);
        if (isNumeric(score)) {
            score_3 = Integer.parseInt(score);
            total += score_3;
            calculateForfait();
        } else {
            inputScoreForfait.setText("NO_SCORE");
        }
    }

    public void setScore_4(String score) {
        total -= score_4;
        inputScore_4.setText(score);
        if (isNumeric(score)) {
            score_4 = Integer.parseInt(score);
            total += score_4;
            calculateForfait();
        } else {
            inputScoreForfait.setText("NO_SCORE");
        }
    }

    public void setScore_5(String score) {
        total -= score_5;
        inputScore_5.setText(score);
        if (isNumeric(score)) {
            score_5 = Integer.parseInt(score);
            total += score_5;
            calculateForfait();
        } else {
            inputScoreForfait.setText("NO_SCORE");
        }
    }

    public void setScore_6(String score) {
        total -= score_6;
        inputScore_6.setText(score);
        if (isNumeric(score)) {
            score_6 = Integer.parseInt(score);
            total += score_6;
            calculateForfait();
        } else {
            inputScoreForfait.setText("NO_SCORE");
        }
    }

    private Boolean checkEmpty() {
        if (score_1 == 0 || score_2 == 0 || score_3 == 0 || score_4 == 0 || score_5 == 0 || score_6 == 0) {
            return false;
        } else {
            return true;
        }
    }

    private boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
