package com.example.myasd.KatzFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.myasd.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Resume extends Fragment {

    EditText inputName, inputSurname, inputLocation;
    EditText inputScore_1, inputScore_2, inputScore_3, inputScore_4, inputScore_5, inputScore_6, inputScoreForfait, datePicker_1, datePicker_2;
    int score_1, score_2, score_3, score_4, score_5, score_6, total = 0;
    Boolean t7Combination = false;
    CheckBox checkBox;
    String message;
    Spinner spinner;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.resume, container, false);

        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkScoreNotEmpty() && checkNotEmpty()) {
                    setMessage();
                    sendMail();
                } else {
                    Snackbar.make(view, "Veuillez corriger les erreurs", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

        datePicker_1 = view.findViewById(R.id.date_picker_1);
        datePicker_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDatePickerDialog(v);
            }
        });

        datePicker_2 = view.findViewById(R.id.date_picker_2);
        datePicker_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDatePickerDialog(v);
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        inputName = view.findViewById(R.id.inputNom);
        inputSurname = view.findViewById(R.id.inputPrenom);
        inputLocation = view.findViewById(R.id.inputLocation);
        spinner = view.findViewById(R.id.spinner);
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
        if (checkScoreNotEmpty()) {
            if (score_1 == 4 && score_2 == 4 && score_3 == 4 && score_4 == 4 && ((score_5 >= 3 && score_6 == 4) || (score_5 == 4 && score_6 >= 3))) {
                inputScoreForfait.setText("FORFAIT C");
            } else if (score_1 >= 3 && score_2 >= 3 && score_3 >= 3 && score_4 >= 3 && (score_5 >= 3 || score_6 >= 3)) {
                inputScoreForfait.setText("FORFAIT B");
            } else if (score_1 >= 3 && score_2 >= 3 && (score_3 >= 3 || score_4 >= 3)) {
                inputScoreForfait.setText("FORFAIT A");
            } else if (score_1 >= 2 && score_2 >= 2 && score_5 >= 2 && t7Combination || checkBox.isChecked() && score_1 >= 2 && score_2 >= 2 || score_1 == 4 && score_2 == 4) {
                inputScoreForfait.setText("NOMENCLATURE T7");
            } else if (score_1 >= 2) {
                inputScoreForfait.setText("NOMENCLATURE T2");
            } else {
                inputScoreForfait.setText("COMBINAISON IMPOSSIBLE");
            }
        } else {
            inputScoreForfait.setText(" ");
        }
    }

    private String[] setCenter() {
        String[] emailArray = new String[2];
        switch (spinner.getSelectedItemPosition()) {
            case 1:
                emailArray = new String[]{"delphine.veys@asd-namur.be", "jean-christophe.groux@asd-namur.be"};
                break;
            case 2:
                emailArray = new String[]{"catherine.paquet@asd-namur.be", "jean-francois.viroux@asd-namur.be"};
                break;
            case 3:
                emailArray = new String[]{"severine.vermersch@asd-namur.be", " "};
                break;
            case 4:
                emailArray = new String[]{"caroline.sartori@asd-namur.be", "elise.verschooren@asd-namur.be"};
                break;
            case 5:
                emailArray = new String[]{"sandra.derop@asd-namur.be", "virginie.mathot@asd-namur.be"};
                break;
        }
        return emailArray;
    }

    private void setMessage() {
        message = "NOM DU PATIENT : " + inputName.getText().toString() + "\n";
        message = message + "PRÉNOM DU PATIENT : " + inputSurname.getText().toString() + "\n";
        message = message + "LOCALITÉ DU PATIENT : " + inputLocation.getText().toString() + "\n";
        message = message + "DATE D'ENVOI : " + new SimpleDateFormat("dd/MM/yyyy").format(new Date()) + "\n";
        message = message + "DATE DE VALIDITÉ : DU " + datePicker_1.getText().toString() + " AU " + datePicker_2.getText().toString() + "\n\n";
        message = message + "---------- SCORE ----------\n";
        message = message + "SE LAVER : " + score_1 + "\n";
        message = message + "S'HABILLER : " + score_2 + "\n";
        message = message + "TRANSFERT & DÉPLACEMENTS : " + score_3 + "\n";
        message = message + "TOILETTE : " + score_4 + "\n";
        message = message + "CONTINENCE : " + score_5 + "\n";
        message = message + "MANGER : " + score_6 + "\n" + "\n";
        message = message + "\bFORFAIT : " + inputScoreForfait.getText().toString();
    }

    private void sendMail() {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        String[] mails = setCenter();
        i.putExtra(android.content.Intent.EXTRA_EMAIL, mails);
        i.putExtra(Intent.EXTRA_SUBJECT, "Échelle de Katz - " + inputName.getText().toString() + " " + inputSurname.getText().toString() + " - " + new SimpleDateFormat("MM/yyyy").format(new Date()));
        i.putExtra(android.content.Intent.EXTRA_TEXT, "NOUVELLE ÉCHELLE DE KATZ\n"

                + System.getProperty("line.separator")
                + message
        );
        startActivity(Intent.createChooser(i, "Choisissez l'application \"Email\" pour envoyer votre demande :"));
    }

    public void openDatePickerDialog(final View v) {
        Calendar cal = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(Objects.requireNonNull(getActivity()),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String selectedDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                        switch (v.getId()) {
                            case R.id.date_picker_1:
                                ((EditText) v).setText(selectedDate);
                                break;
                            case R.id.date_picker_2:
                                ((EditText) v).setText(selectedDate);
                                break;
                        }
                    }
                }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
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
            inputScoreForfait.setText(" ");
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
            inputScoreForfait.setText(" ");
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
            inputScoreForfait.setText(" ");
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
            inputScoreForfait.setText(" ");
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
            inputScoreForfait.setText(" ");
        }
    }

    public void checkT7Combination(Boolean bool) {
        t7Combination = bool;
    }

    private Boolean checkScoreNotEmpty() {
        return score_1 != 0 && score_2 != 0 && score_3 != 0 && score_4 != 0 && score_5 != 0 && score_6 != 0;
    }

    private Boolean checkNotEmpty() {
        if (TextUtils.isEmpty(inputName.getText())) {
            inputName.setError("Ne peut être vide");
            return false;
        } else if (TextUtils.isEmpty(inputSurname.getText())) {
            inputSurname.setError("Ne peut être vide");
            return false;
        } else if (TextUtils.isEmpty(inputLocation.getText())) {
            inputLocation.setError("Ne peut être vide");
            return false;
        } else if (spinner.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) spinner.getSelectedView();
            errorText.setError("");
            errorText.setTextColor(Color.RED);
            errorText.setText("Ne peut être vide");
            return false;
        } else if (TextUtils.isEmpty(datePicker_1.getText())) {
            datePicker_1.setError("Ne peut être vide");
            return false;
        } else if (TextUtils.isEmpty(datePicker_2.getText())) {
            datePicker_2.setError("Ne peut être vide");
            return false;
        }
        return true;
    }

    private boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
