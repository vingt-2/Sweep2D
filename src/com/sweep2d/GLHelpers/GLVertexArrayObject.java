package com.sweep2d.GLHelpers;

public class GLVertexArrayObject
{
	public int vertexArrayID;
	public int attributeNumber;
	public int valuesPerElement;

	public GLVertexArrayObject(int b, int a, int n)
	{
		vertexArrayID = b;
		attributeNumber = a;
		valuesPerElement = n;
	}
}
