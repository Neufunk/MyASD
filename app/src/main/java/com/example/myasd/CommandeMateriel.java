package com.example.myasd;

import android.content.Intent;
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

    EditText inputName, inputSurname, inputSchool, editText1, editText2, editText3, editText4, editText5;
    TextView textViewQ1, textViewQ2, textViewQ3, textViewQ4, textViewQ5, textViewQ6, textViewQ7, textViewQ8, textViewQ9, textViewQ10;
    MenuItem item;
    String message;
    Spinner spinner, inputSection;

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

    private boolean checkEmpty(){
        return true;
    }

    private void setMessage() {

    }

    private void sendMail() {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        String mail = "accueil@asd-namur.be";
        i.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{mail});
        i.putExtra(Intent.EXTRA_SUBJECT, "Évaluation Stagiaire : " + inputName.getText().toString() + " " + inputSurname.getText().toString() + " - " + new SimpleDateFormat("MM/yyyy").format(new Date()));
        i.putExtra(android.content.Intent.EXTRA_TEXT, "NOUVELLE DEMANDE DE MATÉRIEL - " + inputSurname + " " + inputName +"\n"

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
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        editText5 = findViewById(R.id.editText5);
    }



}