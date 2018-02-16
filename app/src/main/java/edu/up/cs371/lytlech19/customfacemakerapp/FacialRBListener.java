package edu.up.cs371.lytlech19.customfacemakerapp;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;

/**
 * Created by lytle on 2/15/2018.
 */

public class FacialRBListener implements RadioGroup.OnCheckedChangeListener{

    public int ID;
    public RadioGroup radioGroup;
    public RadioButton checkedButton;
    public RadioButton[] buttonsList;
    public int[][] RGBValues = new int[3][3];
    public SeekBar[] RGBSeekBars;

    public FacialRBListener(RadioGroup group, RadioButton[] buttons, SeekBar[] RGBBars){
        this.radioGroup = group;
        this.ID = radioGroup.getCheckedRadioButtonId();
        this.buttonsList = buttons;
        this.RGBSeekBars = RGBBars;

        int i, j;
        for(i = 0; i < buttons.length; i++){
            for(j = 0; j < RGBSeekBars.length; j++){
                RGBValues[i][j] = RGBSeekBars[j].getProgress();
            }
        }
        if(RGBBars.length == 3){
            this.RGBSeekBars = RGBBars;
        }

        RGBValues[0][0] = 50;
        RGBValues[0][1] = 50;
        RGBValues[0][2] = 50;
        RGBValues[1][0] = 123;
        RGBValues[1][1] = 124;
        RGBValues[1][2] = 121;
        RGBValues[2][1] = 255;
        RGBValues[2][2] = 255;
        RGBValues[2][0] = 255;

        for(i = 0; i < RGBSeekBars.length; i++){
            RGBSeekBars[i].setProgress(RGBValues[0][i]);
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedID){
        int i, j;

        for(i = 0; i < buttonsList.length; i++){
            if(buttonsList[i].getId() == checkedID){
                for(j = 0; j < RGBSeekBars.length; j++){
                    RGBSeekBars[j].setProgress(RGBValues[i][j]);
                }
            }
        }

        /**
         * DELETE BEFORE FINAL
        for(int y = 0; y < buttonsList.length; y++){
            int temp = radioGroup.getCheckedRadioButtonId();
            if(temp == checkedID){
                for(int x = 0; x < RGBSeekBars.length; x++){
                    RGBValues[y][x] = RGBSeekBars[x].getProgress();
                }
            }
        }
        if(radioGroup.getCheckedRadioButtonId() != checkedID){
            radioGroup.check(checkedID);
            for(int i = 0; i < buttonsList.length; i++){
                if(radioGroup.getCheckedRadioButtonId() == buttonsList[i].getId()){
                    for(int j = 0; j < RGBSeekBars.length; j++){
                        RGBSeekBars[j].setProgress(RGBValues[i][j]);
                    }
                }
            }
        }
         **/
    }
}
