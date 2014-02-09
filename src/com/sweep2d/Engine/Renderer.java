package com.sweep2d.Engine;

//Graphics specific imports


import com.sweep2d.Maths.*;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.util.Log;

import java.util.ArrayList;
////

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import com.sweep2d.GLHelpers.GLAlgebra;
import com.sweep2d.Game.Controls;
import com.sweep2d.Game.MainGame;
import com.sweep2d.GameComponants.ObjectRenderer;
import com.sweep2d.Maths.Vector2;

public class Renderer implements GLSurfaceView.Renderer
{	
	public static final int RERFRESH_RATE = 60 ; // Refresh rate fixed at (1/60)hz, leading to 60frame/s
	public static final String DEBUG_TAG = "[Renderer]";
	
	public static Context renderContext;
	public Vector2 renderSize;

	public MainGame mainGame ;
	public ArrayList<ObjectRenderer> renderVector;

	public Matrix4 projection;
	public Matrix4 view;
	
	public Renderer(Context context)
	{
		renderContext = context;
		renderVector = new ArrayList<ObjectRenderer>();
		renderSize = new Vector2(100,100);
		projection = new Matrix4(1f);
		view = new Matrix4(1f);
	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) 
	{

		gl.glClearColor(0.1f, 0.1f, 0.1f, 0.0f);
		
		mainGame = new MainGame(renderContext,this);
		mainGame.init();
	}

	private void render() 
	{
		
		GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);

		for(int i =0; i<renderVector.size();i++)
		{
			Log.i(DEBUG_TAG,"Drawing "+ renderVector.size()+ " items.");
			renderVector.get(i).Draw(projection,view);
		}

	}
	
	@Override
	public void onDrawFrame(GL10 gl) 
	{
		this.render();
		mainGame.Update();
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) 
	{
		GLES20.glViewport(0, 0, width, height);
		float ratio = (float) width / height;
		projection = GLAlgebra.orthographicProjection(0f, width, height, 0f, 1f, 1f);
	}


}