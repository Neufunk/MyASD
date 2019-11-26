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

import com.example.myasd.KatzFragment.Continence;
import com.example.myasd.KatzFragment.Manger;
import com.example.myasd.KatzFragment.Resume;
import com.example.myasd.KatzFragment.SeLaver;
import com.example.myasd.KatzFragment.Shabiller;
import com.example.myasd.KatzFragment.Toilette;
import com.example.myasd.KatzFragment.Transfert;

public class EchelleKatz extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        SeLaver.SendScore,
        Shabiller.SendScore,
        Transfert.SendScore,
        Toilette.SendScore,
        Continence.SendScore,
        Manger.SendScore {

    String message;
    String name;

    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    int clickedMenu = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_katz);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setOffscreenPageLimit(8);
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
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close){
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                Intent i;
                switch (clickedMenu) {
                    case 1:
                        i = new Intent(EchelleKatz.this, MainActivity.class);
                        startActivity(i);
                        break;
                    case 2:
                        i = new Intent(EchelleKatz.this, Applicar.class);
                        startActivity(i);
                        break;
                    case 3:
                        i = new Intent(EchelleKatz.this, EvaluationStagiaires.class);
                        startActivity(i);
                        break;
                    default:
                        i = new Intent(EchelleKatz.this, MainActivity.class);
                        startActivity(i);
                }
            }
        };
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
            clickedMenu = 1;
        } else if (id == R.id.nav_applicar) {
            Intent i = new Intent(this, Applicar.class);
            clickedMenu = 2;
        } else if (id == R.id.nav_stagiaires) {
            clickedMenu = 3;
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

    @Override
    public void sendScoreShabiller(String score) {
        String tag = "android:switcher:" + R.id.viewPager + ":" + 6;
        Resume resume = (Resume) getSupportFragmentManager().findFragmentByTag(tag);
        resume.setScore_2(score);
    }

    @Override
    public void sendTransfertScore(String score) {
        String tag = "android:switcher:" + R.id.viewPager + ":" + 6;
        Resume resume = (Resume) getSupportFragmentManager().findFragmentByTag(tag);
        resume.setScore_3(score);
    }

    @Override
    public void sendScoretoilette(String score) {
        String tag = "android:switcher:" + R.id.viewPager + ":" + 6;
        Resume resume = (Resume) getSupportFragmentManager().findFragmentByTag(tag);
        resume.setScore_4(score);
    }

    @Override
    public void sendScoreContinence(String score) {
        String tag = "android:switcher:" + R.id.viewPager + ":" + 6;
        Resume resume = (Resume) getSupportFragmentManager().findFragmentByTag(tag);
        resume.setScore_5(score);
    }

    @Override
    public void sendScoreManger(String score) {
        String tag = "android:switcher:" + R.id.viewPager + ":" + 6;
        Resume resume = (Resume) getSupportFragmentManager().findFragmentByTag(tag);
        resume.setScore_6(score);
    }
}
