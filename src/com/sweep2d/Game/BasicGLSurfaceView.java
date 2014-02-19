package com.sweep2d.Game;

import com.sweep2d.Maths.Vector2;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.Log;
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
		    // get pointer index from the event object
		    int pointerIndex = event.getActionIndex();

		    // get pointer ID
		    int pointerId = event.getPointerId(pointerIndex);

		    // get masked (not specific to a pointer) action
		    int maskedAction = event.getActionMasked();

		    switch (maskedAction) {

			    case MotionEvent.ACTION_DOWN:
			    case MotionEvent.ACTION_POINTER_DOWN: {
			      // We have a new pointer. Lets add it to the list of pointers
			    	Log.i("CONTROL","POINTER DOWN");

			      Vector2 f = new Vector2(0);
			      f.x = event.getX(pointerIndex);
			      f.y = event.getY(pointerIndex);
			      MainGame.singleton.controls.inputVector.put(pointerId,f);
			      break;
			    }
			    case MotionEvent.ACTION_MOVE: { // a pointer was moved
			      for (int size = event.getPointerCount(), i = 0; i < size; i++) {
			        Vector2 point = MainGame.singleton.controls.inputVector.get(event.getPointerId(i));
			        if (point != null) {
			          point.x = event.getX(i);
			          point.y = event.getY(i);
			        }
			      }
			      break;
			    }
			    case MotionEvent.ACTION_UP:{
			    	Log.i("CONTROL","POINTER Action UP");
			    	MainGame.singleton.controls.inputVector.remove(pointerId);
			    	break;
			    }
			    case MotionEvent.ACTION_POINTER_UP: {
			    	Log.i("CONTROL","POINTER UP");
			    	MainGame.singleton.controls.inputVector.remove(pointerId);
			    	break;
			    }
			    case MotionEvent.ACTION_CANCEL: {
			    	Log.i("CONTROL","POINTER CANCEL");
			    	MainGame.singleton.controls.inputVector.remove(pointerId);
			      break;
			    }
		    }
    	}
    	return true;
    }
    
}

