package com.example.winify.cvsi;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;

/**
 * Created by diana on 7/1/16.
 */
public class CurrencySpinner extends Activity implements AdapterView.OnItemSelectedListener {

    public void onItemSelected(AdapterView<?> parent, View view,
                               int position, long id) {
        // parent.getItemAtPosition(position)
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}
