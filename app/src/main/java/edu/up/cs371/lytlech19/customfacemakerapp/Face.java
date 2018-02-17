package edu.up.cs371.lytlech19.customfacemakerapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.Random;

/**
 External Citation
 Date: 13 February 2018
 Problem:
 Resource:
 */

/**
 * Created by Chris Lytle on 2/16/2018.
 *
 * Face extends SurfaceView and draws the face on the screen.
 */
public class Face extends SurfaceView {

    // Index Variables
    private int eyeColor;
    private int faceColor;
    private int hairColor;
    private int hairStyle; // Index of hair style
    private float faceRadius = (float) 550.0;
    private float faceRadiusX = (float) 550.0;
    private float faceRadiusY = (float) 750.0;
    private float yFaceCenter;
    private float xFaceCenter;
    private int yOffset = 75;
    private int xOffset = 0; // Never used so maybe delete
    private int[][] RGBValues = new int[3][3];
    private SeekBar[] barsListRGB = new SeekBar[3];
    private float ratio;

    /**
     * Face Class Constructor
     * @param context
     */
    public Face(Context context){
        super(context);
        generalInit();
    }

    /**
     * External Citation
     * Date: 13 February 2018
     * Problem: Had problems implementing Face
     * Resource: Nuxoll's moodle page had a notes on how to create a new SurfaceView Class.
     * I realized that I hadn't added these two constructors.
     */

     /**
     * Face Class Constructor
     * @param context
     * @param attrs
     */
    public Face(Context context, AttributeSet attrs) {
        super(context, attrs);
        generalInit();
    }

    /**
     * Face Class Constructor
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public Face(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        generalInit();
    }

    /**
     * Set Eye Color
     * @param color
     */
    public void setEyeColor(int color){
        this.eyeColor = color;
    }

    /**
     * Set Face Color
     * @param color
     */
    public void setFaceColor(int color){
        this.faceColor = color;
    }

    /**
     * Set Hair Color
     * @param color
     */
    public void setHairColor(int color){
        this.hairColor = color;
    }

    /**
     * Set Hair Color
     * @param style
     */
    public void setHairStyle(int style){
        this.hairStyle = style;
    }

    /**
     * Set Seek Bars List
     * @param bars
     */
    public void setSeekBarsList(SeekBar[] bars){
        this.barsListRGB = bars;
    }

    /**
     * Get Eye Color
     * @return  int color
     */
    public int getEyeColor(){
        return eyeColor;
    }

    /**
     * Get Face Color
     * @return  int color
     */
    public int getFaceColor(){return faceColor;}

    /**
     * Get Hair Style
     * @return  int index
     */
    public int getHairStyle(){return hairStyle;}

    /**
     * Get Hair Color
     * @return  int color
     */
    public int getHairColor(){return hairColor;}

    /**
     * Returns a rondom int Value for a RGB vaue
     * Random between 0 to 255
     * @return
     */
    public int randomRGBValue(){
        Random rando = new Random();
        return rando.nextInt(255);
    }

    /**
     * Returns a random RGB value List
     * @return
     */
    public int[] randomRGB(){
        Random rando = new Random();
        int[] returnList = new int[3];
        int i;
        for(i = 0; i < returnList.length; i++){
            returnList[i] = randomRGBValue();
        }
        return returnList;
    }

    /**
     * Randomly Set RGB variables
     */
    public void random(){
        int redColorInt, greenColorInt, blueColorInt, i;
        for(i = 0; i < RGBValues[0].length; i++){
            RGBValues[i] = randomRGB();
        }

    }

    /**
     * General Initial Setup of Face,
     * Set Colors To all facial features and RGB values
     * Make surface drawable
     */
    private void generalInit() {
        setWillNotDraw(false);
        setEyeColor(Color.BLUE);
        setFaceColor(Color.GREEN);
        setHairColor(Color.RED);
        setHairStyle(0);
        int[] tempList = {20, 30, 60};
        setRGBValues(tempList, 0);
        this.ratio = faceRadius/5;
        random();
    }

    /**
     * Sets RGB values of selected facial feature
     * @param values
     * @param facialIndex
     */
    public void setRGBValues(int[] values, int facialIndex){
        int i;
        //Condition to make sure values is correct length
        //Not important/needed for this assignment but good for
        //Unix Testing Practice if a method were to need it
        if(values.length == 3){
            for(i = 0; i < values.length; i++){
                RGBValues[facialIndex][i] = 0;
            }
        }

    }

    /**
     * Draw Spiked Hair
     */
    public void drawSpikedHair(){

    }

    /**
     * Draw Pointy Hair
     */
    public void drawPointyHair(){}

    /**
     * Draws Nose Given Canvas
     * @param canvas
     */
    public void drawNose(Canvas canvas){
        Paint blackPaint = new Paint();
        blackPaint.setColor(Color.BLACK);
        blackPaint.setStrokeWidth(5.0f);
        float ratio = faceRadius/5;
        float[] pointsX = {xFaceCenter, xFaceCenter + (ratio*1), xFaceCenter};
        float[] pointsY = {yFaceCenter - (ratio*1), yFaceCenter + (ratio*0.5f),
                yFaceCenter + (ratio*1)};
        canvas.drawLine(pointsX[0], pointsY[0], pointsX[1], pointsY[1], blackPaint);
        canvas.drawLine(pointsX[1], pointsY[1], pointsX[2], pointsY[2], blackPaint);

    }

    /**
     * Draw Face Given Canvas
     * @param canvas
     */
    public void drawFace(Canvas canvas){
        Paint whitePaint = new Paint();
        whitePaint.setColor(faceColor);
        canvas.drawCircle(xFaceCenter, yFaceCenter, faceRadius, whitePaint);
    }

    /**
     * Draw Mouth Given Canvas
     * @param canvas
     */
    public void drawMouth(Canvas canvas){
        Paint blackPaint = new Paint();
        blackPaint.setColor(Color.BLACK);
        blackPaint.setStrokeWidth(5.0f);
        float ratio = faceRadius/5;
        float[] pointsX = {xFaceCenter + (ratio*3), xFaceCenter, xFaceCenter - (ratio*3)};
        float[] pointsY = {yFaceCenter + (ratio*2), yFaceCenter + (ratio*4),
                yFaceCenter + (ratio*2)};
        canvas.drawLine(pointsX[0], pointsY[0], pointsX[1], pointsY[1], blackPaint);
        canvas.drawLine(pointsX[1], pointsY[1], pointsX[2], pointsY[2], blackPaint);
        canvas.drawLine(pointsX[2], pointsY[2], pointsX[0], pointsY[0], blackPaint);

    }

    /**
     * Draws eyes on given Canvas
     * @param canvas
     */
    public void drawEye(Canvas canvas, float x, float y){
        // Set Instance Variables
        // Variables to draw Lashes on eyes
        int numOfLashes = 50;
        double a = 0.0; // angle
        float eyeRadius = ratio;
        float pupulRadius = ratio*0.5f;

        Paint whitePaint = new Paint();
        whitePaint.setColor(Color.WHITE);

        Paint blackPaint = new Paint();
        blackPaint.setColor(Color.BLACK);
        blackPaint.setStrokeWidth(5.0f);

        Paint bluePaint = new Paint();
        blackPaint.setColor(Color.BLUE);

        canvas.drawCircle(x, y, eyeRadius, whitePaint);
        //canvas.drawCircle(x, y, eyeRadius, blackPaint);
        //canvas.drawCircle(x, y, pupulRadius, bluePaint);


    }

    /**
     * Overrides the on draw method
     * Draws
     *  - Face
     *  - Eyes
     *  - Mouth
     *  - Nose
     *  - Hair
     * @param canvas
     */
    @Override
    public void onDraw(Canvas canvas) {
        // Set Instance Variables from canvas height and width
        xFaceCenter = (float)(canvas.getWidth()/2);
        yFaceCenter = (float)(canvas.getHeight()/2 - yOffset);
        float ratio = faceRadius/5;

        float faceLeft = (float)(xFaceCenter - (faceRadiusX/2));
        float faceTop = (float) (yFaceCenter - (faceRadiusY/2) - yOffset);
        float faceRight = (float) (xFaceCenter + (faceRadiusX/2));
        float faceBottom = (float) (yFaceCenter + (faceRadiusY/2) - yOffset);

        // Draw Facial Feature Methods
        drawFace(canvas);
        drawMouth(canvas);
        drawEye(canvas, xFaceCenter + (ratio*2), yFaceCenter - (ratio));
        drawEye(canvas, xFaceCenter - (ratio*2), yFaceCenter - (ratio));
        drawNose(canvas);
    }
}
