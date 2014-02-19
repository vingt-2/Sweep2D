package com.sweep2d.GameComponants;

import java.util.ArrayList;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.FloatBuffer;

import com.sweep2d.GLHelpers.GLVertexArrayObject;
import com.sweep2d.Game.MainGame;
import com.sweep2d.GameObjects.GameChar;
import com.sweep2d.Maths.Vector2;

import com.sweep2d.Maths.*;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.util.Log;

public class ObjectRenderer 
{
	public int renderType = GLES20.GL_TRIANGLES;
	
	public Shape shape;
	
	private final int FLOAT_SIZE_BYTES = 4;
	private final String UNIFORM_TEX_SAMPLER = "sTexture";
	private final String UNIFORM_MATRIX_MVP = "uMVPMatrix";
	private final String DEBUG_TAG = "[ObjectRenderer]";
	
	private int vertexArraySize = Shape.Triangle.verticeData.length;

	private GameChar parent;
	private int textureID;
	private int programID;
	
	private int mvpLocation;
	private int opacityLocation;
	private int textureSamplerLocation;
	
	private ArrayList<GLVertexArrayObject> vertexArrayList;
	
	public float opacity = 1;

	public ObjectRenderer(GameChar parent)
	{
		MainGame.singleton.renderer.renderVector.add(this);
		
		this.parent = parent;
		
		textureID = 0;
		programID = 0;
		
		
		vertexArrayList = new ArrayList<GLVertexArrayObject>();
	}
	
	public boolean AssignShaderProgram(String materialName)
	{
		programID = MainGame.singleton.sharedResources.GetShaderProgram(materialName);
		Log.w("Lol","programID: "+ programID);
		mvpLocation = GLES20.glGetUniformLocation(programID, UNIFORM_MATRIX_MVP);
		opacityLocation = GLES20.glGetUniformLocation(programID,"opacity");
		Log.w("lol","MVP " + mvpLocation);
		textureSamplerLocation = GLES20.glGetUniformLocation(programID, UNIFORM_TEX_SAMPLER);
		Log.w("lol","texSampler "+ textureSamplerLocation);
		return (programID != 0);
	}
	
	public void CleanUpVBOs()
	{
		// Java GC !
	}
	
	public void CleanUp()
	{
		// Java GC !
	}
	
	public void GenerateVertexArray(float[] arrayBuffer,int bufferSize, int valuesPerElement,int attributeNumber)
	{
		FloatBuffer.allocate(arrayBuffer.length);
        FloatBuffer bufferData = ByteBuffer.allocateDirect(bufferSize).order(ByteOrder.nativeOrder()).asFloatBuffer();
        bufferData.put(arrayBuffer).position(0);
        
		IntBuffer bufferID = (IntBuffer.allocate(1));
		bufferID.position(0);
		
		GLES20.glGenBuffers(1, bufferID);
		GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER,bufferID.get(0));
		GLES20.glBufferData(GLES20.GL_ARRAY_BUFFER, bufferSize, bufferData, GLES20.GL_STATIC_DRAW);
		
		GLES20.glVertexAttribPointer
		(
			attributeNumber,                      // attribute
			valuesPerElement,                     // size
			GLES20.GL_FLOAT,                      // type
			false,                                // normalized?
			valuesPerElement*FLOAT_SIZE_BYTES,    // stride
			0				                      // array buffer offset
		);
		
		vertexArrayList.add(new GLVertexArrayObject(bufferID.get(),attributeNumber,valuesPerElement));	
	}
	
	public void LoadShape()
	{
		int aPositionHandle = GLES20.glGetAttribLocation(programID, "aPosition");
		GenerateVertexArray(shape.verticeData, shape.verticeData.length*FLOAT_SIZE_BYTES, 3, aPositionHandle);
		int aUVHandle 		= GLES20.glGetAttribLocation(programID, "aTextureCoord");
		GenerateVertexArray(shape.UVData, shape.UVData.length*FLOAT_SIZE_BYTES,2, aUVHandle);
	}
	
	public boolean Draw(Matrix4 projectionMatrix, Matrix4 viewMatrix)
	{
		GLES20.glUseProgram(programID);
				
		Matrix4 mvp = Matrix4.Multiply(projectionMatrix, Matrix4.Multiply(viewMatrix,parent.transform.transformMatrix));
		
		float[] mvpArray = mvp.GetOneDimensionalArray();

		GLES20.glUniformMatrix4fv(mvpLocation, 1, false, mvpArray,0);
		
		GLES20.glUniform1f(opacityLocation, opacity);
		
        GLES20.glActiveTexture(GLES20.GL_TEXTURE0);
        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, textureID);
        
        GLES20.glUniform1i(textureSamplerLocation, 0);
		
        //Log.i(DEBUG_TAG,"Enabling " + vertexArrayList.size() + " attribs");
        
		for(GLVertexArrayObject element : vertexArrayList)
		{
			GLES20.glEnableVertexAttribArray(element.attributeNumber);
		}
		
		GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, vertexArraySize);
		
		for(GLVertexArrayObject element : vertexArrayList)
		{
			GLES20.glDisableVertexAttribArray(element.attributeNumber);
		}
		return true;
	}

	public boolean SetTexture(String name)
	{
		textureID = MainGame.singleton.sharedResources.GetTexture(name);
		return (textureID != 0);
	}

	public enum Shape
	{
		Triangle
		( 
							 
				new float[] {
				            // X, Y, Z
				            -5f, -5f, 0f,
				            5.0f, -5f, 0f,
				            -5f,  5f, 0f,
				            -5f, 5f, 0f,
				            5f, -5f, 0f,
				            5f,  5f, 0f
							},
				new float[] { 
								1f, 1f,
								0f, 1f,
								1f, 0f,
								1f, 0f,
								0f, 1f,
								0f, 0f
							}
		);

		float[] verticeData;
		float[] UVData;

		Shape(float[] vertices, float[] UVs)
		{
			this.verticeData = vertices;
			this.UVData = UVs;
		}

	}

}
