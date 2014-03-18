package com.sweep2d.Game;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class Sweep2DLauncherViewActivity extends Activity 
{

    private Sweep2DLauncherView mView;

    @Override
    protected void onCreate(Bundle icicle) 
    {
        super.onCreate(icicle);
        mView = new Sweep2DLauncherView(getApplication());
        requestWindowFeature(Window.FEATURE_NO_TITLE);
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
