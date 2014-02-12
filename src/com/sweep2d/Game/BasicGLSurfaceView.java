package com.sweep2d.Game;

import com.sweep2d.Maths.Vector2;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;

class BasicGLSurfaceView extends GLSurfaceView 
{
    public BasicGLSurfaceView(Context context) 
    {
        super(context);
        setEGLContextClientVersion(2);
        setRenderer(new com.sweep2d.Engine.Renderer(context));
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
    	if(MainGame.singleton.controls != null)
    	{
    		MainGame.singleton.controls.inputVector = new Vector2
    											(event.getAxisValue(MotionEvent.AXIS_X),event.getAxisValue(MotionEvent.AXIS_Y));
    	}
    	return super.onTouchEvent(event);
    }
    
}

