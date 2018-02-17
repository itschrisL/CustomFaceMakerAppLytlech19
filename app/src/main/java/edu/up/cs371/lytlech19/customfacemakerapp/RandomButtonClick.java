package edu.up.cs371.lytlech19.customfacemakerapp;

import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by lytle on 2/16/2018.
 */

public class RandomButtonClick implements Button.OnClickListener {

    private Face face;
    private SeekBar[] seekBars;
    private TextView RGBTextView;
    private Spinner hairStyleSpinner;

    public RandomButtonClick(Face f, SeekBar[] bars, TextView tv, Spinner spinner){
        this.face = f;
        this.seekBars = bars;
        this.RGBTextView = tv;
        this.hairStyleSpinner = spinner;
        updateDisplay();
    }

    public void initUpdateText(){
        String displayText = ("R: " + seekBars[0].getProgress() + ", G: " +
                seekBars[1].getProgress() + ", B: " + seekBars[2].getProgress());
        RGBTextView.setText(displayText);
    }

    public void updateDisplay(){
        int[] temp = face.randomRGB();
        int i;
        for(i = 0; i < temp.length; i++){
            seekBars[i].setProgress(temp[i]);
        }
        String displayText = ("R: " + seekBars[0].getProgress() + ", G: " +
                seekBars[1].getProgress() + ", B: " + seekBars[2].getProgress());
        RGBTextView.setText(displayText);
    }

    /**
     * Overrides onClick Listener
     * Sets face to random hair and color values
     * @param view
     */
    @Override
    public void onClick(View view){
        face.random();
        int[] temp = face.randomRGB();
        updateDisplay();
    }
}
