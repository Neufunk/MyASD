package com.example.myasd;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
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
import android.view.ViewGroup;

import com.example.myasd.KatzFragment.Continence;
import com.example.myasd.KatzFragment.Manger;
import com.example.myasd.KatzFragment.Resume;
import com.example.myasd.KatzFragment.SeLaver;
import com.example.myasd.KatzFragment.Shabiller;
import com.example.myasd.KatzFragment.Toilette;
import com.example.myasd.KatzFragment.Transfert;
import com.example.myasd.tools.MenuSelection;

public class EchelleKatz extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        SeLaver.SendScore,
        Shabiller.SendScore,
        Transfert.SendScore,
        Toilette.SendScore,
        Continence.SendScore,
        Manger.SendScore {

    MenuItem item;
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_katz);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setOffscreenPageLimit(10);
        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close){
            @Override
            public void onDrawerClosed(View drawerView) {
                if(item != null) {
                    super.onDrawerClosed(drawerView);
                    startActivity(new Intent(MenuSelection.launchSelectedItem(EchelleKatz.this)));
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        this.item = item;
        final ViewGroup viewGroup = findViewById(R.id.mainGroup);
        viewGroup.removeAllViews();
        viewGroup.addView(View.inflate(this, R.layout.loading_screen, null));
        MenuSelection.onItemSelected(item);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void sendScoreSeLaver(String score) {
        String tag = "android:switcher:" + R.id.viewPager + ":" + 6;
        Resume resume = (Resume) getSupportFragmentManager().findFragmentByTag(tag);
        assert resume != null;
        resume.setScore_1(score);
    }

    @Override
    public void sendScoreShabiller(String score) {
        String tag = "android:switcher:" + R.id.viewPager + ":" + 6;
        Resume resume = (Resume) getSupportFragmentManager().findFragmentByTag(tag);
        assert resume != null;
        resume.setScore_2(score);
    }

    @Override
    public void sendTransfertScore(String score) {
        String tag = "android:switcher:" + R.id.viewPager + ":" + 6;
        Resume resume = (Resume) getSupportFragmentManager().findFragmentByTag(tag);
        assert resume != null;
        resume.setScore_3(score);
    }

    @Override
    public void sendScoretoilette(String score) {
        String tag = "android:switcher:" + R.id.viewPager + ":" + 6;
        Resume resume = (Resume) getSupportFragmentManager().findFragmentByTag(tag);
        assert resume != null;
        resume.setScore_4(score);
    }

    @Override
    public void sendScoreContinence(String score) {
        String tag = "android:switcher:" + R.id.viewPager + ":" + 6;
        Resume resume = (Resume) getSupportFragmentManager().findFragmentByTag(tag);
        assert resume != null;
        resume.setScore_5(score);
    }

    @Override
    public void sendT7Combination(Boolean bool) {
        String tag = "android:switcher:" + R.id.viewPager + ":" + 6;
        Resume resume = (Resume) getSupportFragmentManager().findFragmentByTag(tag);
        assert resume != null;
        resume.checkT7Combination(bool);
    }

    @Override
    public void sendScoreManger(String score) {
        String tag = "android:switcher:" + R.id.viewPager + ":" + 6;
        Resume resume = (Resume) getSupportFragmentManager().findFragmentByTag(tag);
        assert resume != null;
        resume.setScore_6(score);
    }
}
