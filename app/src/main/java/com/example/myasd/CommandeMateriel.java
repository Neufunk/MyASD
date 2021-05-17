package com.example.myasd;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.myasd.tools.MenuSelection;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommandeMateriel extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    EditText inputName, inputSurname, inputSchool, editText1, editText2, editText3, editText4, editText5,
            editText6, editText7, editText8, editText9, editText10, editText11, editText12, editText13, editText14,
            editText15, editText16, editText17, editText18, editText19, editText20, editText21, editText22, editText23,
            editText24, editText25, editText26, editText27, editText28, editText29, editText30, editText31, editText32,
            editText33, editText34, editText35, editText36, editText37, editText38, editText39, editText40, editText41,
            editText42, editText43, editText44, editText45, editText46, editText47, editText48, editText49, editText50,
            editText51, editText52, editText53, editText54;
    TextView textViewQ1, textViewQ2, textViewQ3, textViewQ4, textViewQ5, textViewQ6, textViewQ7,
            textViewQ8, textViewQ9, textViewQ10, textViewQ11, textViewQ12, textViewQ13, textViewQ14,
            textViewQ15, textViewQ16, textViewQ17, textViewQ18, textViewQ19, textViewQ20, textViewQ21,
            textViewQ22, textViewQ23, textViewQ24, textViewQ25, textViewQ26, textViewQ27, textViewQ28, textViewQ29, textViewQ30,
            textViewQ31, textViewQ32, textViewQ33, textViewQ34, textViewQ35, textViewQ36, textViewQ37, textViewQ38,
            textViewQ39, textViewQ40, textViewQ41, textViewQ42, textViewQ43, textViewQ44, textViewQ45, textViewQ46,
            textViewQ47, textViewQ48, textViewQ49, textViewQ50, textViewQ51, textViewQ52, textViewQ53, textViewQ54;
    MenuItem item;
    String message;
    Spinner spinner, inputSection;
    SimpleDateFormat currentDate = new SimpleDateFormat("MM/yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commande_materiel);
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
                    Intent selectedActivity = MenuSelection.launchSelectedItem(CommandeMateriel.this);
                    startActivity(selectedActivity);
                }
            }
        };
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(4).setChecked(true);
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
        MenuSelection.onItemSelected(item, CommandeMateriel.this);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private Boolean checkEmpty() {
        if (TextUtils.isEmpty(inputName.getText())) {
            inputName.setError("Ne peut être vide");
            return false;
        } else if (TextUtils.isEmpty(inputSurname.getText())) {
            inputSurname.setError("Ne peut être vide");
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

    private String[] setCenter() {
        String[] emailArray = new String[1];
        switch (spinner.getSelectedItemPosition()) {
            case 1:
                emailArray = new String[]{"centre.philippeville@asd-namur.be"};
                break;
            case 2:
                emailArray = new String[]{"centre.ciney@asd-namur.be"};
                break;
            case 3:
                emailArray = new String[]{"centre.gedinne@asd-namur.be"};
                break;
            case 4:
                emailArray = new String[]{"accueil@asd-namur.be"};
                break;
            case 5:
                emailArray = new String[]{"accueil@asd-namur.be"};
                break;
        }
        return emailArray;
    }

    private void setMessage() {
        TextView[] materiel_name = {textViewQ1, textViewQ2, textViewQ3, textViewQ4, textViewQ5,
                textViewQ6, textViewQ7, textViewQ8, textViewQ9, textViewQ10, textViewQ11, textViewQ12,
                textViewQ13, textViewQ14, textViewQ15, textViewQ16, textViewQ17, textViewQ18, textViewQ19,
                textViewQ20, textViewQ21, textViewQ22};
        EditText[] material_number = {editText1, editText2, editText3, editText4, editText5, editText6,
                editText7, editText8, editText9, editText10, editText11, editText12, editText13,
                editText14, editText15, editText16, editText17, editText18, editText19, editText20,
                editText21, editText22};

        message = "PRENOM : " + inputSurname.getText().toString() + "\n";
        message = message + "NOM : " + inputName.getText().toString() + "\n\n";

        for (int i = 0; i < material_number.length; i++) {
            if (TextUtils.isEmpty(material_number[i].getText()) || Integer.parseInt(material_number[i].getText().toString()) == 0) {
                // Du coup euh... Bah rien :D.
            } else {
                message = message + materiel_name[i].getText().toString() + " : " + material_number[i].getText().toString() + "\n";
            }
        }
        message = message + "Merci beaucoup !";
    }

    private void sendMail() {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        String[] mails = setCenter();
        i.putExtra(android.content.Intent.EXTRA_EMAIL, mails);
        i.putExtra(Intent.EXTRA_SUBJECT, "Demande de matériel - " + inputName.getText().toString() + " " + inputSurname.getText().toString() + " - " + currentDate.format(new Date()));
        i.putExtra(android.content.Intent.EXTRA_TEXT, "NOUVELLE DEMANDE DE MATÉRIEL" + "\n"

                + System.getProperty("line.separator")
                + message
        );
        startActivity(Intent.createChooser(i, "Choisissez l'application \"Email\" pour envoyer votre demande :"));
    }

    private void assignFields() {
        inputName = findViewById(R.id.inputNom);
        inputSurname = findViewById(R.id.inputPrenom);
        inputSchool = findViewById(R.id.inputSchool);
        inputSection = findViewById(R.id.inputSection);
        spinner = findViewById(R.id.center_spinner);

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
        textViewQ11 = findViewById(R.id.textViewQ11);
        textViewQ12 = findViewById(R.id.textViewQ12);
        textViewQ13 = findViewById(R.id.textViewQ13);
        textViewQ14 = findViewById(R.id.textViewQ14);
        textViewQ15 = findViewById(R.id.textViewQ15);
        textViewQ16 = findViewById(R.id.textViewQ16);
        textViewQ17 = findViewById(R.id.textViewQ17);
        textViewQ18 = findViewById(R.id.textViewQ18);
        textViewQ19 = findViewById(R.id.textViewQ19);
        textViewQ20 = findViewById(R.id.textViewQ20);
        textViewQ21 = findViewById(R.id.textViewQ21);
        textViewQ22 = findViewById(R.id.textViewQ22);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        editText5 = findViewById(R.id.editText5);
        editText6 = findViewById(R.id.editText6);
        editText7 = findViewById(R.id.editText7);
        editText8 = findViewById(R.id.editText8);
        editText9 = findViewById(R.id.editText9);
        editText10 = findViewById(R.id.editText10);
        editText11 = findViewById(R.id.editText11);
        editText12 = findViewById(R.id.editText12);
        editText13 = findViewById(R.id.editText13);
        editText14 = findViewById(R.id.editText14);
        editText15 = findViewById(R.id.editText15);
        editText16 = findViewById(R.id.editText16);
        editText17 = findViewById(R.id.editText17);
        editText18 = findViewById(R.id.editText18);
        editText19 = findViewById(R.id.editText19);
        editText20 = findViewById(R.id.editText20);
        editText21 = findViewById(R.id.editText21);
        editText22 = findViewById(R.id.editText22);
    }


}