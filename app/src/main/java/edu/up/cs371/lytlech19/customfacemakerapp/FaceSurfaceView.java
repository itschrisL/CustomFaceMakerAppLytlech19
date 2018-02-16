package edu.up.cs371.lytlech19.customfacemakerapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by lytle on 2/11/2018.
 */

public class FaceSurfaceView extends SurfaceView {

    // Instance Variables
    private Bitmap bmp;
    private SurfaceHolder holder;
    private int eyeColor;
    private int faceColor;
    private int hairColor;
    private int hairStyle; // Index of hair style
    private float faceRadius = (float) 550.0;
    private int yOffset = 75;
    private int xOffset = 0; // Never used so maybe delete

    public FaceSurfaceView(Context context){
        super(context);
        generalInit();
        holder = getHolder();
    }

    public FaceSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        generalInit();
    }

    public FaceSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        generalInit();
    }

    private void generalInit(){
        setWillNotDraw(false);
    }

    /**
     * Sets Eye Color
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
     * Set hair Color
     * @param color
     */
    public void setHairColor(int color){
        this.hairColor = color;
    }

    /**
     * Set Hair Style
     * @param index
     */
    public void setHairStyle(int index){
        this.hairStyle = index;
    }

    /**
     * Draws face and Neck
     * @param canvas
     */
    public void drawFace(Canvas canvas){
        Paint greenBody = new Paint();
        greenBody.setColor(Color.GREEN);
    }

    /**
     * Draw Eyes
     * @param canvas
     */
    public void drawEyes(Canvas canvas, float xCenter, float yCenter){
        int numOfLashes = 50;
        double a = 0.0; // angle
        double angleChange = 180/numOfLashes;
        int x1, y1, x2, y2;
        Paint whitePaint = new Paint();
        whitePaint.setColor(Color.BLUE);

        canvas.drawCircle((float) xCenter,(float) yCenter, 100.0f, whitePaint);


        /**
        // Draws a BasicEye
        // Draw white eye background
        RectF whiteOval(
        canvas.drawOval((float), (float)), (float)), (float)));
                //(int)(cx - d0/2), (int)(cy - d0/2), d0, d0);

        //Draw black eye border
        canvas.setColor(this.blackColor);
        canvas.drawOval((int)(cx - d0/2), (int)(cy - d0/2), d0, d0);
        //Draw eye with random eye color
        canvas.setColor(this.eyeColor);
        canvas.fillOval((int)(cx - d1/2), (int)(cy - d1/2), d1, d1);
        //Draw black Pupil
        canvas.setColor(this.blackColor);
        canvas.fillOval((int)(cx - d2/2), (int)(cy - d2/2), d2, d2);

        // Draws the lashes
        for(int i = 0; i <= numOfLashes || a < 180.0; i++){
            x1 = (int)(this.cx + (this.d0/2)*Math.cos(Math.toRadians(a)));
            y1 = (int)(this.cy - (this.d0/2)*Math.sin(Math.toRadians(a)));

            x2 = (int)(x1 + (lashLength)*Math.cos(Math.toRadians(a)));
            y2 = (int)(y1 - (lashLength)*Math.sin(Math.toRadians(a)));

            canvas.drawLine(x1, y1, x2, y2);

            a = a + angleChange;
        }
         **/

    }

    /**
     * Overrides the on draw method
     * @param canvas
     */
    @Override
    public void onDraw(Canvas canvas){
        Paint whitePaint = new Paint();
        whitePaint.setColor(Color.WHITE);
        canvas.drawCircle((float)(canvas.getWidth()/2),(float)((canvas.getHeight()/2) - yOffset),
                faceRadius, whitePaint);

        drawEyes(canvas, (float)(canvas.getWidth()/2), (float)((canvas.getHeight()/2) - yOffset));
    }
}
