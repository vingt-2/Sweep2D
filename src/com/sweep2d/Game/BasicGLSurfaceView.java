package com.sweep2d.Game;

import android.content.Context;
import android.opengl.GLSurfaceView;

class BasicGLSurfaceView extends GLSurfaceView {
    public BasicGLSurfaceView(Context context) {
        super(context);
        setEGLContextClientVersion(2);
        setRenderer(new com.sweep2d.Engine.Renderer(context));
        //setRenderer(new GLES20TriangleRenderer(context));
    }
}

