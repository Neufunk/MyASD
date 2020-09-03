package com.example.myasd;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.myasd.tools.MenuSelection;

import java.util.Calendar;

public class Applicar extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    EditText plaque, kilometersArea, adressEdit, dateEdit1, dateEdit2, dateEdit3, commentArea;
    TextView adresseTitle;
    CheckBox homeVehicleCheckBox, keyLocationCheckBox;
    Spinner dateSpinner1, dateSpinner2, dateSpinner3, problemTypeSpinner;
    MenuItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applicar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkEmpty()) {
                    sendMail();
                } else {
                    Snackbar.make(view, "Veuillez corriger les erreurs", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

        dateEdit1 = findViewById(R.id.date_edit_1);
        dateEdit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDatePickerDialog(v);
            }
        });
        dateEdit2 = findViewById(R.id.date_edit_2);
        dateEdit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDatePickerDialog(v);
            }
        });
        dateEdit3 = findViewById(R.id.date_edit_3);
        dateEdit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDatePickerDialog(v);
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
                    Intent selectedActivity = MenuSelection.launchSelectedItem(Applicar.this);
                    startActivity(selectedActivity);
                }
            }
        };
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(1).setChecked(true);
        assignFields();
        plaqueEditOperations();
        enableAdressArea();
    }

    private void assignFields() {
        plaque = findViewById(R.id.plaqueEdit);
        kilometersArea = findViewById(R.id.kilometrageEdit);
        homeVehicleCheckBox = findViewById(R.id.CheckBox1);
        adresseTitle = findViewById(R.id.adresse);
        adressEdit = findViewById(R.id.adressEdit);
        dateSpinner1 = findViewById(R.id.spinner2);
        dateSpinner2 = findViewById(R.id.spinner1);
        dateSpinner3 = findViewById(R.id.spinner3);
        problemTypeSpinner = findViewById(R.id.spinner);
        keyLocationCheckBox = findViewById(R.id.checkBox2);
        commentArea = findViewById(R.id.remarque_edit);
    }

    private void plaqueEditOperations() {
        plaque.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        plaque.append("1-");
        final int[] charCounter = new int[1];
        plaque.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                charCounter[0] = plaque.getText().length();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (plaque.getText().length() == 5 && charCounter[0] <= 4) {
                    plaque.append("-");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void enableAdressArea() {
        homeVehicleCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    adressEdit.setEnabled(false);
                    adresseTitle.setAlpha(0.0f);
                } else {
                    adressEdit.setEnabled(true);
                    adresseTitle.setAlpha(1);
                }
            }
        });
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
        getMenuInflater().inflate(R.menu.main, menu);
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
        MenuSelection.onItemSelected(item, Applicar.this);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private Boolean checkEmpty() {
        if (plaque.getText().length() != 9) {
            plaque.setError("Erreur dans la plaque");
            return false;
        } else if (TextUtils.isEmpty(kilometersArea.getText())) {
            kilometersArea.setError("Ne peut être vide");
            return false;
        } else if (TextUtils.isEmpty(dateEdit1.getText())) {
            dateEdit1.setError("Ne peut être vide");
            return false;
        } else if (TextUtils.isEmpty(dateEdit2.getText())) {
            dateEdit2.setError("Ne peut être vide");
            return false;
        } else if (TextUtils.isEmpty(dateEdit3.getText())) {
            dateEdit3.setError("Ne peut être vide");
            return false;
        }
        return true;
    }

    public void openDatePickerDialog(final View v) {
        Calendar cal = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String selectedDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                        switch (v.getId()) {
                            case R.id.date_edit_1:
                                ((EditText) v).setText(selectedDate);
                                break;
                            case R.id.date_edit_2:
                                ((EditText) v).setText(selectedDate);
                                break;
                            case R.id.date_edit_3:
                                ((EditText) v).setText(selectedDate);
                                break;
                        }
                    }
                }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    private void sendMail() {
        String numeroPlaque = plaque.getText().toString();
        String typeIntervention = problemTypeSpinner.getSelectedItem().toString();
        String domicile;
        String doubleCle;

        if (homeVehicleCheckBox.isChecked()) {
            domicile = "La voiture se trouvera au domicile.";
        } else {
            domicile = "Adresse où se trouvera la voiture : ";
        }
        if (keyLocationCheckBox.isChecked()) {
            doubleCle = "Le double de clé se trouve au centre.";
        } else {
            doubleCle = "Le double de clé se trouve au domicile.";
        }

        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"annie.bouchoms@asd-namur.be", "logistique@asd-namur.be"});
        i.putExtra(Intent.EXTRA_SUBJECT, "AppliCar - Demande [" + typeIntervention + "] pour " + numeroPlaque);
        i.putExtra(android.content.Intent.EXTRA_TEXT, "Demande d'intervention d'un chauffeur-logisticien"

                + System.getProperty("line.separator")
                + System.getProperty("line.separator")
                + "Type d'intervention souhaitée : " + typeIntervention
                + System.getProperty("line.separator")
                + "Plaque : " + numeroPlaque
                + System.getProperty("line.separator")
                + "Kilométrage : " + kilometersArea.getText()
                + System.getProperty("line.separator")
                + domicile + adressEdit.getText().toString()
                + System.getProperty("line.separator")
                + doubleCle
                + System.getProperty("line.separator")
                + System.getProperty("line.separator")
                + "Dates de disponibilités :"
                + System.getProperty("line.separator")
                + dateEdit1.getText() + " " + dateSpinner1.getSelectedItem().toString()
                + System.getProperty("line.separator")
                + dateEdit2.getText() + " " + dateSpinner2.getSelectedItem().toString()
                + System.getProperty("line.separator")
                + dateEdit3.getText() + " " + dateSpinner3.getSelectedItem().toString()
                + System.getProperty("line.separator")
                + System.getProperty("line.separator")
                + "Remarques : "
                + System.getProperty("line.separator")
                + commentArea.getText()
                + System.getProperty("line.separator")
        );
        startActivity(Intent.createChooser(i, "Choisissez l'application \"Email\" pour envoyer votre demande :"));
    }
}
