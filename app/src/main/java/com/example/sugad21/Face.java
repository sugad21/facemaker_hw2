package com.example.sugad21.facemaker_hw2;

/*
 *
 * @author Dylan Suga
 * @date 1 October 2018
 *
 *
 *
 */
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;


public class Face {


    public static String[] hairPicks = {"Default Hair", "Mohawk", "Afro"};

    private int skinColor;

    private int eyeColor;

    private int hairColor;

    private int hairStyle;

    private Paint eyePaint = new Paint();
    private Paint skinPaint = new Paint();
    private Paint defHair = new Paint();
    private Paint moHair = new Paint();
    private Paint afroHair1 = new Paint();

    public Face() {

        randomize();

    }
    public void randomize() {
        /**
         * External Citation:
         * Date: 1 October 2018
         * Problem: Did not know how to randomize
         *
         * Resource:https://stackoverflow.com/questions/6741100/random-numbers-in-java-when-working-with-android
         * Solution: I used the code as an example and applied it
         */

        skinColor = Color.rgb((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
        hairColor = Color.rgb((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
        eyeColor = Color.rgb((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));

        hairStyle = (int) (Math.random() * 3);

        return;
    }
    public void onDraw(Canvas canvas) {

        skinDraw(canvas);
        eyeDraw(canvas);
        drawHair(canvas);
    }
    /*
        @parameters
        int color - 0-255 int value for the specific part of an RGB color
        int type - 0: Hair 1: Skin 2: Eyes
        int colorType - 0:Red 1:Green 2:Blue
     */
    public void setColor(int color, int type, int colorType) {
        if (type == 0) {
            if (colorType == 0) {
                eyeColor = Color.rgb(color, Color.green(eyeColor), Color.blue(eyeColor));
            } else if (colorType == 1) {
                eyeColor = Color.rgb(Color.red(eyeColor), color, Color.blue(eyeColor));
            } else if (colorType == 2) {
                eyeColor = Color.rgb(Color.red(eyeColor), Color.green(eyeColor), color);
            }
        } else if (type == 1) {
            if (colorType == 0) {
                hairColor = Color.rgb(color, Color.green(hairColor), Color.blue(hairColor));
            } else if (colorType == 1) {
                hairColor = Color.rgb(Color.red(hairColor), color, Color.blue(hairColor));
            } else if (colorType == 2) {
                hairColor = Color.rgb(Color.red(hairColor), Color.green(hairColor), color);
            }
        } else if (type == 2) {
            if (colorType == 0) {
                skinColor = Color.rgb(color, Color.green(skinColor), Color.blue(skinColor));
            } else if (colorType == 1) {
                skinColor = Color.rgb(Color.red(skinColor), color, Color.blue(skinColor));
            } else if (colorType == 2) {
                skinColor = Color.rgb(Color.red(skinColor), Color.green(skinColor), color);
            }
        }
    }

    public void setHairPick(int i) {
        if (i >= 0 && i < hairPicks.length)
            hairStyle = i;
        }
        public int getEyesColor () {
            return eyeColor;
        }
        public int getHairColor () {
            return hairColor;
        }
        public int getSkinColor () {
            return skinColor;
        }
        public int getHairStyle () {
            return hairStyle;
        }

    public void skinDraw(Canvas canvas) {
        canvas.drawCircle(370, 280, 150, skinPaint);
    }
    public void eyeDraw(Canvas canvas) {
        eyePaint.setColor(eyeColor);
        canvas.drawCircle(320, 250, 60, eyePaint);
        canvas.drawCircle(420, 250, 60, eyePaint);
    }
    public void drawHair(Canvas canvas) {
        if (hairStyle == 0) {
            RectF oval = new RectF();
            oval.set(250, 90, 480, 250);
            canvas.drawArc(oval, 0, -180, true, defHair);
        } else if (hairStyle == 1) {
            /**
            *External Citations
             * Date: 1 October 2018
             * Problem: draw the hair on head using curvature of head
             *
             * Resource:https://stackoverflow.com/questions/5012685/draw-an-oval-shape-around-the-text-on-canvas
             * Solution: I used the syntax to help me understand relation of oval and rectF
             */

            RectF oval = new RectF();
            oval.set(300, 20, 430, 250);
            canvas.drawArc(oval, 0, -180, true, moHair);

        } else if (hairStyle == 2) {

            RectF oval = new RectF();
            oval.set(250, 10, 480, 250);
            canvas.drawArc(oval, 0, -180, true, afroHair1);

        }


    }

}