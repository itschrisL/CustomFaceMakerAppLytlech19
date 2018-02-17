package edu.up.cs371.lytlech19.customfacemakerapp;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by lytle on 2/15/2018.
 */

public class ColorChangeListener implements SeekBar.OnSeekBarChangeListener,
        RadioGroup.OnCheckedChangeListener {

    /**
     * External Citation
     * Date: 13 February 2018
     * Problem: Was trying to implement RadioButton.OnCheckedChangListener and couldn't get the
     * RadioButtons to change together.
     * Resource: Searched online for "RadioButton OnCheckedChangeListener examples" and found the
     * link link bellow.  It said to us a RadioGroup instead and with a few changes it worked.
     * https://examples.javacodegeeks.com/android/core/ui/radiogroup/android-radiogroup-example/
     */

    // Instance Variables
    private RadioGroup radioGroup;
    private RadioButton[] buttonsList = new RadioButton[3];
    private int buttonCheckIndex;
    private int[][] RGBValues = new int[3][3];
    private Face face;
    private SeekBar[] seekBars = new SeekBar[3];
    private int redVal;
    private int greenVal;
    private int blueVal;
    private TextView textView;

    /**
     * Constructor for ColorChangeListener
     *
     * @param sb
     * @param tv
     * @param RBGroup
     */
    public ColorChangeListener(SeekBar[] sb, TextView tv, RadioGroup RBGroup, Face f) {
        this.seekBars = sb;
        this.textView = tv;
        this.radioGroup = RBGroup;
        this.face = f;
        generalInit();
    }

    /**
     * General Initial Setup stuff
     */
    private void generalInit() {
        buttonCheckIndex = 0;
        for (SeekBar bar : seekBars) {
            if (bar.getId() == R.id.RedSeekBar) {
                this.redVal = bar.getProgress();
                RGBValues[0][0] = redVal;
            } else if (bar.getId() == R.id.GreenSeekBar) {
                this.greenVal = bar.getProgress();
                RGBValues[0][1] = greenVal;
            } else if (bar.getId() == R.id.BlueSeekBar) {
                this.blueVal = bar.getProgress();
                RGBValues[0][2] = blueVal;
            }
        }
        int i;
        for (i = 0; i < radioGroup.getChildCount(); i++) {
            buttonsList[i] = (RadioButton) radioGroup.getChildAt(i);
        }
        face.random();
    }

    /**
     * Overrides onProgressChange
     * Updates red, greed, blue values accordingly
     *
     * @param seekBar
     * @param progress
     * @param fromUser
     */
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        for (SeekBar bar : seekBars) {
            if (bar.getId() == R.id.RedSeekBar) {
                this.redVal = bar.getProgress();
                RGBValues[buttonCheckIndex][0] = redVal;
            } else if (bar.getId() == R.id.GreenSeekBar) {
                this.greenVal = bar.getProgress();
                RGBValues[buttonCheckIndex][1] = greenVal;
            } else if (bar.getId() == R.id.BlueSeekBar) {
                this.blueVal = bar.getProgress();
                RGBValues[buttonCheckIndex][2] = blueVal;
            }
        }

        String displayText = ("R: " + redVal + ", G: " + greenVal + ", B: " + blueVal);
        textView.setText(displayText);
    }

    /**
     * Overrides onStartTrackingTouch
     * NOTHING
     *
     * @param seekBar
     */
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //Nothing, don't use event
    }

    /**
     * Overrides onStopTrackingTouch
     * NOTHING
     *
     * @param seekBar
     */
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //Nothing, don't use event
    }

    /**
     * Overrides onCheckedChange
     *
     * @param radioGroup
     * @param checkedID
     */
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedID) {
        int i, j;

        for (i = 0; i < buttonsList.length; i++) {
            if (buttonsList[i].getId() == checkedID) {
                buttonCheckIndex = i;
                for (j = 0; j < seekBars.length; j++) {
                    seekBars[j].setProgress(RGBValues[i][j]);

                }
            }
        }
    }
}
