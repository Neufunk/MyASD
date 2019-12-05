package com.example.myasd.tools;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.MenuItem;

import com.example.myasd.Applicar;
import com.example.myasd.EchelleKatz;
import com.example.myasd.EvaluationStagiaires;
import com.example.myasd.MainActivity;
import com.example.myasd.R;

public class MenuSelection {

    static private int clickedMenu = 0;

     static public void onItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.nav_home) {
            clickedMenu = 1;
        } else if (id == R.id.nav_applicar) {
            clickedMenu = 2;
        } else if (id == R.id.nav_stagiaires) {
            clickedMenu = 3;
        } else if (id == R.id.nav_katz) {
            clickedMenu = 4;
        }
    }

     static public Intent launchSelectedItem(Activity fromActivity) {
        Intent intent = null;
        final String TAG = MenuSelection.class.getSimpleName();
         Log.i(TAG, "SELECTED MENU: " + clickedMenu);
        switch (clickedMenu) {
            case 1:
                intent = new Intent(fromActivity, MainActivity.class);
                break;
            case 2:
                intent = new Intent(fromActivity, Applicar.class);
                break;
            case 3:
                intent = new Intent(fromActivity, EvaluationStagiaires.class);
                break;
            case 4:
                intent = new Intent(fromActivity, EchelleKatz.class);
                break;
            default:
                break;
        }
        return intent;
    }
}
