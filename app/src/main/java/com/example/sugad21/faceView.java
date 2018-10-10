package com.example.sugad21.facemaker_hw2;
/*
 *
 * @author Dylan Suga
 * @date 1 October 2018
 *
 *
 *
 */
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceHolder;

import android.view.SurfaceView;

public class faceView extends SurfaceView {
    Face faceObject;

    private Canvas c = null;

    private SurfaceHolder sh;

    /**
     * External Citation:
     * Date: 1 October 2018
     * Problem: Why all three constructors of SurfaceView needed?
     *
     * Resource:https://stackoverflow.com/questions/8113621/which-constructor-to-be-called-for-view
     *Solution: Gave me the ones I needed and helped comprehension of concept
     */

    public faceView(Context context) {
        super(context);

        generalInit();
    }

    public faceView(Context context, AttributeSet attrs) {
        super(context, attrs);

        generalInit();
    }

    public faceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        generalInit();
    }

    public void generalInit(){

        faceObject = new Face();
        setWillNotDraw(false);
    }

    public Face getFace(){

        return faceObject;

    }
    @Override
    public void onDraw(Canvas canvas){

        if( c == null ) {
            c = canvas;
        }
        faceObject.onDraw(canvas);

    }
    public void update(){
        invalidate();
        postInvalidate();
        /**
         * External Citation:
         * Date: 1 October 2018
         * Problem: Did not know how to use invalidate, post invalidate, and update methods
         *
         * Resource: https://stackoverflow.com/questions/18607335/how-to-update-a-surfaceview
         * Solution: Explained concepts better -> applied it
        */
    }




}

