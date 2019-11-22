package com.example.myasd;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.myasd.KatzFragment.Resume;
import com.example.myasd.KatzFragment.SeLaver;

public class EchelleKatz extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, SeLaver.SendScore {

    String message;
    String name;

    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_katz);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setOffscreenPageLimit(10);
        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

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

        FloatingActionButton fab_calculate = findViewById(R.id.fab_calcultate);
        fab_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "PAS ENCORE IMPL", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }

        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(3).setChecked(true);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_applicar) {
            Intent i = new Intent(this, Applicar.class);
            startActivity(i);
        } else if (id == R.id.nav_stagiaires) {

        } else if (id == R.id.nav_katz) {

            //} else if (id == R.id.nav_share) {

            //} else if (id == R.id.nav_send) {

        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private Boolean checkEmpty() {
        return true;
    }

    private void setMessage() {
        message = "NOM DU PATIENT : " + name + "\n";
        message = message + "PRENOM DU PATIENT : " + "\n";
        message = message + "NISS DU PATIENT : " + "\n\n";
        message = message + "SE LAVER \n ----------------\n";
    }

    private void sendMail() {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"informatique@asd-namur.be"});
        i.putExtra(Intent.EXTRA_SUBJECT, "Nouvelle Échelle de Katz");
        i.putExtra(android.content.Intent.EXTRA_TEXT, "NOUVELLE ÉCHELLE DE KATZ\n"

                + System.getProperty("line.separator")
                + message
        );
        startActivity(Intent.createChooser(i, "Choisissez l'application \"Email\" pour envoyer votre demande :"));
    }

    @Override
    public void sendScoreSeLaver(String score) {
        String tag = "android:switcher:" + R.id.viewPager + ":" + 6;
        Resume resume = (Resume) getSupportFragmentManager().findFragmentByTag(tag);
        resume.setScore_1(score);
    }
}
