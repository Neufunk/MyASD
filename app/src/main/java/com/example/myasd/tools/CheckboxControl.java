package com.example.myasd.tools;

import android.graphics.Color;
import android.widget.CheckBox;
import android.widget.TextView;

public class CheckboxControl {

    private int criteria = 0;

    public void setEnabled(CheckBox...checkBoxes) {
        criteria-=1;
        for (CheckBox checkBox:checkBoxes) {
            checkBox.setEnabled(true);
        }
    }

    public void setDisabled(CheckBox...checkBoxes) {
        criteria+=1;
        for (CheckBox chk:checkBoxes) {
            chk.setEnabled(false);
            if(chk.isChecked()) {
                criteria-=1;
                chk.setChecked(false);
            }
        }
    }

    public void checkCriteria(TextView textView, int minimum) {
        int current = minimum - criteria;
        if(current >= 0) {
            textView.setText("ENCORE " + current + " CRITÈRE(S)");
            if (current >= 1) {
                textView.setBackgroundColor(Color.RED);
            } else {
                textView.setBackgroundColor(Color.rgb(150, 187, 55));
            }
        }
    }
}
