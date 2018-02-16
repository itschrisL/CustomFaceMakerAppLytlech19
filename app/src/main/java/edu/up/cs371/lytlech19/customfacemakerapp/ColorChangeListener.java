package edu.up.cs371.lytlech19.customfacemakerapp;

import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by lytle on 2/15/2018.
 */

public class ColorChangeListener implements SeekBar.OnSeekBarChangeListener {

    private SeekBar[] seekBars = new SeekBar[3];
    private int redVal;
    private int greenVal;
    private int blueVal;
    private TextView textView;

    public ColorChangeListener(SeekBar[] sb, TextView tv){
        this.seekBars = sb;
        this.textView = tv;
        for(SeekBar bar : seekBars){
            if(bar.getId() == R.id.RedSeekBar){
                this.redVal = bar.getProgress();
            }
            else if(bar.getId() == R.id.GreenSeekBar){
                this.greenVal = bar.getProgress();
            }
            else if(bar.getId() == R.id.BlueSeekBar){
                this.blueVal = bar.getProgress();
            }
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){

        for(SeekBar bar : seekBars){
            if(bar.getId() == R.id.RedSeekBar){
                this.redVal = bar.getProgress();
            }
            else if(bar.getId() == R.id.GreenSeekBar){
                this.greenVal = bar.getProgress();
            }
            else if(bar.getId() == R.id.BlueSeekBar){
                this.blueVal = bar.getProgress();
            }
        }

        String displayText = ("R: " + redVal + ", G: " + greenVal + ", B: " + blueVal);
        textView.setText(displayText);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar){
        //Nothing, don't use event
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar){
        //Nothing, don't use event
    }
}
