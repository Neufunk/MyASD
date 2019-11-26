package com.example.myasd.tools;

import android.widget.CheckBox;

public class CheckboxControl {

    static public void setEnabled(CheckBox...checkBoxes) {
        for (CheckBox checkBox : checkBoxes) {
            checkBox.setEnabled(true);
        }
    }

    static public void setDisabled(CheckBox...checkBoxes) {
        for (CheckBox chk:checkBoxes) {
            chk.setEnabled(false);
            chk.setChecked(false);
        }
    }

}
