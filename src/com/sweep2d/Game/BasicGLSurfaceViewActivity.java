package com.sweep2d.Game;




import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;

import java.io.File;


public class BasicGLSurfaceViewActivity extends Activity 
{

    private BasicGLSurfaceView mView;

    @Override
    protected void onCreate(Bundle icicle) 
    {
        super.onCreate(icicle);
        mView = new BasicGLSurfaceView(getApplication());
        setContentView(mView);
    }

    @Override
    protected void onPause() 
    {
        super.onPause();
        mView.onPause();
    }

    @Override
    protected void onResume() 
    {
        super.onResume();
        mView.onResume();
    }
}
