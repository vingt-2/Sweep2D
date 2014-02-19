package com.sweep2d.GameComponants;

import android.util.Log;

import com.sweep2d.Maths.*;

public class Transform 
{
	public Vector2 size;
	public Vector2 position;
	public float rotation;
	
	public Matrix4 transformMatrix;
	
	public Transform()
	{
		size = new Vector2(1,1);
		position = new Vector2(0,0);
		rotation = 0;
		UpdateTransform();
	}
	
	public Transform(Vector2 position)
	{
		size = new Vector2(1,1);
		this.position = new Vector2(position.x,position.y);
		rotation = 0;
		UpdateTransform();
	}
	
	
	public void UpdateTransform()
	{
		Matrix4 translationMatrix = new Matrix4(1);
		float[] fourthEntrie = { position.x, position.y, 0, 1};
		translationMatrix.array[3] = fourthEntrie;
		
		Matrix4 rotationMatrix = 
				new Matrix4(
						new float[][]
						{
							{(float)Math.cos(rotation)	, (float) (-1 * Math.sin(rotation)),0f,0f	},
							{(float)Math.sin(rotation)	, (float) Math.cos(rotation),		0f,0f	},
							{	0f						, 0f,								1f,0f	},
							{	0f						, 0f,								0f,1f	},
						});
		
		Matrix4 sizeMatrix =
				new Matrix4
					(
						new float[][]
						{
								{size.x, 0, 0, 0},
								{0,	size.y,	0, 0},
								{0,	0,		1, 0},
								{0,	0,		0, 1}
						}
						);
		
		transformMatrix = Matrix4.Multiply(translationMatrix,Matrix4.Multiply(rotationMatrix, sizeMatrix));
	}
	
	public Vector2 LocalDirectionToWorld(Vector2 vector)
	{
		// Homogeneous coordinate to 0 so that it's left untouched by the translation (Direction)
		Vector4 homogeneous = new Vector4(vector.x,vector.y,0f,0f);
	
		Vector2 result = Matrix4.Multiply(transformMatrix,homogeneous).GetVec3().GetVec2();

		Log.i("Transform_Debug","LocalDirectionToWorld * " + vector.toString() + " = " + result.toString());
		
		return result;
	}
	
	public Vector2 LocalPositionToWorld(Vector2 vector)
	{
		// Homogeneous coordinate to 1 so that it's affected by the translation (Position)
		Vector4 homogeneous = new Vector4(vector.x,vector.y,0f,1f);
		return Matrix4.Multiply(transformMatrix,homogeneous).GetVec3().GetVec2();
	}
	
}
