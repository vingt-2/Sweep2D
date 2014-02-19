package com.sweep2d.Maths;

public class Matrix4
{

	public float[][] array;
	
	public Matrix4(float diagonalEntries)
	{
		float[][] array = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		array[0][0] = diagonalEntries;
		array[1][1] = diagonalEntries;
		array[2][2] = diagonalEntries;
		array[3][3] = diagonalEntries;
		this.array = array;
	}
	
	public Matrix4(float[][] array)
	{
		this.array = array;
	}
	
	public Matrix4(Vector4 diagonalEntries)
	{
		float[][] array = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		array[0][0] = diagonalEntries.x;
		array[1][1] = diagonalEntries.y;
		array[2][2] = diagonalEntries.z;
		array[3][3] = diagonalEntries.w;
		this.array = array;
	}
	
	public Matrix4(Vector4 col1, Vector4 col2, Vector4 col3, Vector4 col4 )
	{
		float[][]array = {{col1.x,col1.y,col1.z,col1.w},{col2.x,col2.y,col2.z,col2.w},{col3.x,col3.y,col3.z,col3.w},{col4.x,col4.y,col4.z,col4.w}};
		this.array=array;
	}
	
	public Vector4[] ToVectors()
	{
		Vector4[] columns = { new Vector4(array[0][0],array[0][1],array[0][2],array[0][3]), 
								new Vector4(array[1][0],array[1][1],array[1][2],array[1][3]),
									new Vector4(array[2][0],array[2][1],array[2][2],array[2][3]),
										new Vector4(array[3][0],array[3][1],array[3][2],array[3][3])
							};
		return columns;	
	}
	
	public static Matrix4 Add(Matrix4 mat1, Matrix4 mat2)
	{
		Vector4[] cols1 = mat1.ToVectors();
		Vector4[] cols2 = mat2.ToVectors();
		return new Matrix4(Vector4.Add(cols1[0], cols2[0]), Vector4.Add(cols1[1],cols2[1]), Vector4.Add(cols1[2],cols2[2]),Vector4.Add(cols1[3],cols2[3])); 
	}
	
	public static Matrix4 Multiply(Matrix4 mat1, Matrix4 mat2)
	{
		float[][] newMatArray = new float[4][4];
		
		for(int n=0; n<4 ; n++)
		{
			for(int m = 0; m<4; m++)
			{
				float value = 0;
				for(int i = 0; i<4; i++)
				{
					value += mat1.array[i][m]*mat2.array[n][i];
				}
				newMatArray[n][m] = value;
			}
		}
		return new Matrix4(newMatArray);
	}

	public String toString()
	{
		String outputString = "{ ";
		for(int i = 0; i<4; i++)
		{
			outputString+="{ ";
			for(int j = 0; j<4 ; j++)
			{
				outputString+= array[i][j] + ",";
			}
			outputString+= "}\n ";
		}
		outputString += "}";
		return outputString;
	}
	
	public static Vector4 Multiply(Matrix4 matrix, Vector4 vector)
	{
		float[] vecArray = vector.GetArray();
		float[] newVec = new float[4];
		for(int i=0; i<4; i++)
		{
			float newEntrie = 0;
			for(int j=0 ; j<4; j++)
			{
				newEntrie += matrix.array[j][i] * vecArray[j];
			}
			newVec[i] = newEntrie;
		}
		return new Vector4(newVec);
	}
	
	public float[] GetOneDimensionalArray()
	{
		float[] newArray = new float[16];
		int i=0;
		for(int m = 0; m<4; m++)
		{
			for(int n = 0; n<4; n++)
			{
				newArray[i] = array[m][n];
				i++;
			}
		}
		return newArray;
	}
	
}
