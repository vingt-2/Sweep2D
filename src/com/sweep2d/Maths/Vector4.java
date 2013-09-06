package com.sweep2d.Maths;

public class Vector4
{
	public float x;
	public float y;
	public float z;
	public float w;
	
	public Vector4(float x, float y, float z,float w)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	
	public Vector4(Vector3 vector, float lastEntrie)
	{
		this.x = vector.x;
		this.y = vector.y;
		this.z = vector.z;
		this.w = lastEntrie;
	}
	
	public Vector4(float[] array)
	{
		if(array.length != 4)
		{
			x=0; y=0; w=0; z=0;
		}
		else
		{
			x = array[0]; y=array[1]; z=array[2]; w=array[3];
		}
	}
	
	public float GetLength()
	{
		return (float)Math.sqrt((x*x)+(y*y)+(z*z)+(w*w));
	}
	
	public String toString(){
		return "("+x+","+y+","+z+","+w+", length: "+this.GetLength()+")";
	}
	
	public Vector4 Normalized()
	{
		float length = this.GetLength();
		float newX =  x / length;
		float newY =  y / length;
		float newZ =  z / length;
		float newW =  w / length;
		
		return new Vector4(newX,newY,newZ,newW);
	} 

	public boolean Normalize()
	{
		float length = this.GetLength();
		this.x = this.x/length;
		this.y = this.y/length;
		this.z = this.z/length;
		this.w = this.w/length;
		return true;
	}
	
	public static Vector4 Add(Vector4 vec1, Vector4 vec2)
	{
		return new Vector4 (vec1.x+vec2.x,vec1.y+vec2.y,vec1.z+vec2.z,vec1.w+vec2.w);
	}
	
	public static float Dot(Vector4 vec1, Vector4 vec2)
	{
		return vec1.x * vec2.x + vec1.y*vec2.y + vec1.z*vec2.z + vec1.w*vec2.w ;
	}
	
	public static Vector4 Scale(Vector4 vec1, float scalar)
	{
		return new Vector4(scalar * vec1.x, scalar * vec1.y, scalar * vec1.z, scalar * vec1.w);
	}
	
	public Vector3 GetVec3()
	{
		return new Vector3(this.x,this.y,this.w);
	}
	
	public float[] GetArray()
	{
		return new float[] {x,y,z,w};
	}
	
	public Vector4 Zero()
	{
		return new Vector4(0,0,0,0);
	}

}
