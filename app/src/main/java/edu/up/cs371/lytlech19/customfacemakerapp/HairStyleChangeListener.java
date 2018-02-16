package edu.up.cs371.lytlech19.customfacemakerapp;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

/**
 * Created by lytle on 2/16/2018.
 */

public class HairStyleChangeListener extends Activity implements AdapterView.OnItemSelectedListener {

    // Instance Variables
    private Face face;

    public HairStyleChangeListener(Face f){
        this.face = f;
    }

    @Override
    public void onItemSelected(AdapterView adapterView, View view, int pos, long id){
        face.setHairStyle(pos);
    }

    @Override
    public void onNothingSelected(AdapterView adapterView){
        // Nothing
    }
}
