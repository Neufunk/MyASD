package com.example.myasd;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.myasd.tools.MenuSelection;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EvaluationStagiaires extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    EditText inputName, inputSurname, inputSchool, inputSection;
    RadioGroup radioGroup1, radioGroup2, radioGroup3, radioGroup4, radioGroup5, radioGroup6, radioGroup7, radioGroup8, radioGroup9, radioGroup10;
    TextView textViewQ1, textViewQ2, textViewQ3, textViewQ4, textViewQ5, textViewQ6, textViewQ7, textViewQ8, textViewQ9, textViewQ10;
    MenuItem item;
    RadioButton radioButton;
    String message;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluation_stagiaires);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        assignFields();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkEmpty()) {
                    setMessage();
                    sendMail();
                } else {
                    Snackbar.make(view, "Veuillez corriger les erreurs", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }

        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                if (item != null) {
                    super.onDrawerClosed(drawerView);
                    Intent selectedActivity = MenuSelection.launchSelectedItem(EvaluationStagiaires.this);
                    startActivity(selectedActivity);
                }
            }
        };
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(2).setChecked(true);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.evaluation_stagiaires, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        this.item = item;
        MenuSelection.onItemSelected(item, EvaluationStagiaires.this);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setMessage() {
        TextView[] textViews = {textViewQ1, textViewQ2, textViewQ3, textViewQ4, textViewQ5, textViewQ6, textViewQ7, textViewQ8, textViewQ9, textViewQ10};
        RadioGroup[] radioGroups = {radioGroup1, radioGroup2, radioGroup3, radioGroup4, radioGroup5, radioGroup6, radioGroup7, radioGroup8, radioGroup9, radioGroup10};
        message = "--------------------------------- \n\n";
        message = message + "NOM DE L'ÉTUDIANT : " + inputName.getText().toString() + "\n";
        message = message + "PRÉNOM DE L'ÉTUDIANT : " + inputSurname.getText().toString() + "\n";
        message = message + "ÉCOLE : " + inputSchool.getText().toString() + "\n";
        message = message + "SECTION : " + inputSection.getText().toString() + "\n\n";
        for (int i = 0; i < radioGroups.length; i++) {
            try {
                radioButton = findViewById(radioGroups[i].getCheckedRadioButtonId());
                message = message + " • " + textViews[i].getText().toString() + " : " + radioButton.getText() + "\n";
            } catch (Exception e) {
                message = message + " • " + textViews[i].getText().toString() + " : N/A \n";
            }

        }
    }

    private void sendMail() {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        String mail = setCenter();
        i.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{mail});
        i.putExtra(Intent.EXTRA_SUBJECT, "Évaluation Stagiaire : " + inputName.getText().toString() + " " + inputSurname.getText().toString() + " - " + new SimpleDateFormat("MM/yyyy").format(new Date()));
        i.putExtra(android.content.Intent.EXTRA_TEXT, "NOUVELLE ÉVALUATION DE STAGE POUR ASD\n"

                + System.getProperty("line.separator")
                + message
        );
        startActivity(Intent.createChooser(i, "Choisissez l'application \"Email\" pour envoyer votre demande :"));
    }

    private String setCenter() {
        String email = "gestion.stagiaires@asd-namur.be";
        switch (spinner.getSelectedItemPosition()) {
            case 1:
                email = "delphine.veys@asd-namur.be";
                break;
            case 2:
                email = "infirmieres.ciney@asd-namur.be";
                break;
            case 3:
                email = "severine.vermersch@asd-namur.be";
                break;
            case 4:
                email = "gestion.stagiaires@asd-namur.be";
                break;
            case 5:
                email = "gestion.stagiaires@asd-namur.be";
                break;
        }
        return email;
    }

    private void assignFields() {
        inputName = findViewById(R.id.inputNom);
        inputSurname = findViewById(R.id.inputPrenom);
        inputSchool = findViewById(R.id.inputSchool);
        inputSection = findViewById(R.id.inputSection);
        textViewQ1 = findViewById(R.id.textViewQ1);
        textViewQ2 = findViewById(R.id.textViewQ2);
        textViewQ3 = findViewById(R.id.textViewQ3);
        textViewQ4 = findViewById(R.id.textViewQ4);
        textViewQ5 = findViewById(R.id.textViewQ5);
        textViewQ6 = findViewById(R.id.textViewQ6);
        textViewQ7 = findViewById(R.id.textViewQ7);
        textViewQ8 = findViewById(R.id.textViewQ8);
        textViewQ9 = findViewById(R.id.textViewQ9);
        textViewQ10 = findViewById(R.id.textViewQ10);
        spinner = findViewById(R.id.center_spinner);
        radioGroup1 = findViewById(R.id.radio_group_1);
        radioGroup2 = findViewById(R.id.radio_group_2);
        radioGroup3 = findViewById(R.id.radio_group_3);
        radioGroup4 = findViewById(R.id.radio_group_4);
        radioGroup5 = findViewById(R.id.radio_group_5);
        radioGroup6 = findViewById(R.id.radio_group_6);
        radioGroup7 = findViewById(R.id.radio_group_7);
        radioGroup8 = findViewById(R.id.radio_group_8);
        radioGroup9 = findViewById(R.id.radio_group_9);
        radioGroup10 = findViewById(R.id.radio_group_10);
    }

    private Boolean checkEmpty() {
        if (TextUtils.isEmpty(inputName.getText())) {
            inputName.setError("Ne peut être vide");
            return false;
        } else if (TextUtils.isEmpty(inputSurname.getText())) {
            inputSurname.setError("Ne peut être vide");
            return false;
        } else if (TextUtils.isEmpty(inputSchool.getText())) {
            inputSchool.setError("Ne peut être vide");
            return false;
        } else if (TextUtils.isEmpty(inputSection.getText())) {
            inputSection.setError("Ne peut être vide");
            return false;
        } else if (spinner.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) spinner.getSelectedView();
            errorText.setError("");
            errorText.setTextColor(Color.RED);
            errorText.setText("Ne peut être vide");
            return false;
        }
        return true;
    }
}
