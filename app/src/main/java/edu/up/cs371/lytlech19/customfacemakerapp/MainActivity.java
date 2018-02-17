package edu.up.cs371.lytlech19.customfacemakerapp;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Sets views to instance variables
    public Spinner hairSpinner;
    public SeekBar redSeek;
    public SeekBar greenSeek;
    public SeekBar blueSeek;
    public RadioButton hairRB;
    public RadioButton eyeRB;
    public RadioButton skinRB;
    public TextView colorsText;
    public RadioGroup facialRadioGroup;
    public Face faceSurfaceView;
    public Button randButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set Views
        hairSpinner = (Spinner) findViewById(R.id.HairStyleSpinner);
        redSeek = (SeekBar) findViewById(R.id.RedSeekBar);
        greenSeek = (SeekBar) findViewById(R.id.GreenSeekBar);
        blueSeek = (SeekBar) findViewById(R.id.BlueSeekBar);
        hairRB = (RadioButton) findViewById(R.id.HairRadioButton);
        eyeRB = (RadioButton) findViewById(R.id.EyesRadioButton);
        skinRB = (RadioButton) findViewById(R.id.SkinRadioButton);
        colorsText = (TextView) findViewById(R.id.ColorValueTextDisplay);
        facialRadioGroup = (RadioGroup) findViewById(R.id.RadioGroupID);
        faceSurfaceView = (Face) findViewById(R.id.DrawingSurfaceViewID);
        randButton = (Button) findViewById(R.id.RandomButton);
        // Make Array List
        RadioButton[] radioButtons = {hairRB, eyeRB, skinRB};
        SeekBar[] seekBars = {redSeek, greenSeek, blueSeek};
        // Set Hair Style Spinner Adaptor
        String[] hairNames = {"Spiked", "Pointy", "Bold"};
        ArrayAdapter<String> hairAdapter =
                new ArrayAdapter<String> (this,
                        R.layout.support_simple_spinner_dropdown_item, hairNames);
        hairSpinner.setAdapter(hairAdapter);
        // Set SeekBar & RadioButton ChangeListeners
        ColorChangeListener colorListener =
                new ColorChangeListener(seekBars, colorsText, facialRadioGroup, faceSurfaceView);
        redSeek.setOnSeekBarChangeListener(colorListener);
        greenSeek.setOnSeekBarChangeListener(colorListener);
        blueSeek.setOnSeekBarChangeListener(colorListener);
        faceSurfaceView.setSeekBarsList(seekBars);
        // Set RadioGroup CheckedListener
        hairRB.setChecked(true);
        ColorChangeListener facialRBListener =
                new ColorChangeListener(seekBars, colorsText, facialRadioGroup, faceSurfaceView);
        facialRadioGroup.setOnCheckedChangeListener(facialRBListener);
        // Set RandomButton onClick Listener
        RandomButtonClick buttonClick =
                new RandomButtonClick(faceSurfaceView, seekBars, colorsText, hairSpinner);
        randButton.setOnClickListener(buttonClick);
    }
}
