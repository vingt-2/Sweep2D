package com.sweep2d.Maths;

public class Vector2 
{
		public float x;
		public float y;

		
		public Vector2(float x, float y)
		{
			this.x = x;
			this.y = y;
		}
		
		public Vector2(float entries)
		{
			x=entries;
			y=entries;
		}
		
		public Vector2(float[] array)
		{
			if(array.length != 2)
			{
				x=0; y=0;
			}
			else
			{
				x = array[0]; y=array[1];
			}
		}
		
		public Vector2(Vector2 vector)
		{
			this.x = vector.x;
			this.y = vector.y;
		}
		
		public float GetLength()
		{
			return (float)Math.sqrt((this.x*this.x)+(this.y*this.y));
		}

		public void Rotate(double argument)
		{
			float a=x;
			float b=y;
			this.x= (float) (a*Math.cos(argument) + b*Math.sin(argument));
			this.y= (float) ((-1)*a*Math.sin(argument) + b*Math.cos(argument));
		}
		
		public Vector2 Rotationned(double argument)
		{
			float a=x;
			float b=y;
			float newX = (float) (a*Math.cos(argument) + b*Math.sin(argument));
			float newY = (float) ((-1)*a*Math.sin(argument) + b*Math.cos(argument));
			return new Vector2(newX,newY);
		}
		
		public String toString(){
			return "("+x+","+y+",length: "+this.GetLength()+")";
		}
		
		public Vector2 Normalized()
		{
			float length = (float) Math.sqrt(this.x * this.x + this.y * this.y);
			float newX =  x / length;
			float newY =  y / length;
			
			return new Vector2(newX,newY);
		} 
		
		public Vector2 Scaled(float scalar)
		{
			return new Vector2(scalar * x, scalar * y);
		}
	
		public boolean Normalize()
		{
			float length = this.GetLength();
			this.x = this.x/length;
			this.y = this.y/length;
			return true;
		}
		
		public Vector2 negate()
		{
			return new Vector2(-x,-y);
		}
		
		public static Vector2 Add(Vector2 vec1, Vector2 vec2)
		{
			return new Vector2(vec1.x+vec2.x,vec1.y+vec2.y);
		}
		
		public static float Dot(Vector2 vec1, Vector2 vec2)
		{
			return (vec1.x * vec2.x + vec1.y*vec2.y);
		}
		
		public static Vector2 Scale(float scalar,Vector2 vec1)
		{
			return new Vector2(scalar * vec1.x, scalar * vec1.y);
		}
		
		public static Vector2 zero() 
		{
			return new Vector2(0);
		}
		
		public float[] GetArray()
		{
			return new float[] {x,y};
		}

}

