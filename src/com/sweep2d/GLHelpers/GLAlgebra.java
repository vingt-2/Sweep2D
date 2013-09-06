package com.sweep2d.GLHelpers;

import com.sweep2d.Maths.Matrix4;

public class GLAlgebra
{
	public static Matrix4 orthographicProjection(float left, float right,
			float bottom, float top, float zNear, float zFar)
	{
		Matrix4 Result = new Matrix4(1);
		Result.array[0][0] = 2f / (right - left);
		Result.array[1][1] = 2f / (top - bottom);
		Result.array[2][2] = -2f / (zFar - zNear);
		Result.array[3][0] = -(right + left) / (right - left);
		Result.array[3][1] = -(top + bottom) / (top - bottom);
		Result.array[3][2] = -(zFar + zNear) / (zFar - zNear);
		return Result;
	}
}
