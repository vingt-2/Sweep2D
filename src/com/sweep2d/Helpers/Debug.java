package com.sweep2d.Helpers;

//import javax.media.opengl.GL2;

import com.sweep2d.Game.MainGame;

import com.sweep2d.GameObjects.GameChar;
import com.sweep2d.Maths.Vector2;


public class Debug 
{
	
//	public void DrawRay(Vector2 origin,Vector2 end)
//	{
//		GameChar debugChar = new GameChar();
//		
//		debugChar.
//		
//	//	MainGame.singleton.renderer.debugRenderVector
//	}
//	
//	public void DrawRay(Vector2 origin,Vector2 end,Color color)
//	{
//		GL2 gl = MainGame.render.externDrawable.getGL().getGL2();
//		gl.glColor3f(color.r,color.g,color.b);
//		
//		gl.glBegin(GL2.GL_LINES);
//			gl.glVertex2f(origin.x, origin.y);
//			gl.glVertex2f(end.x,end.y);
//		gl.glEnd();
//	}
//
//	public void DrawLine(Vector2 origin,Vector2 direction,float length)
//	{
//		GL2 gl = MainGame.render.externDrawable.getGL().getGL2();
//		
//		gl.glColor3f(1f,0,0);;
//		
//		Vector2 normalDir = direction.Normalized();
//		
//		float a = origin.x + length*normalDir.x;
//		float b = origin.y + length*normalDir.y;
//		
//		gl.glBegin(GL2.GL_LINES);
//			gl.glVertex2f(origin.x, origin.y);
//			gl.glVertex2f(a,b);
//		gl.glEnd();
//	}
//	
//	public void DrawLine(Vector2 origin,Vector2 direction,float length,Color color)
//	{
//		GL2 gl = MainGame.render.externDrawable.getGL().getGL2();
//		
//		gl.glColor3f(color.r,color.g,color.b);
//		
//		
//		Vector2 normalDir = direction.Normalized();
//		
//		float a = origin.x + length*normalDir.x;
//		float b = origin.y + length*normalDir.y;
//		
//		gl.glBegin(GL2.GL_LINES);
//			gl.glVertex2f(origin.x, origin.y);
//			gl.glVertex2f(a,b);
//		gl.glEnd();
//	}
//	
//	public void DrawShape(CollisionShape shape,Transform transform,Color color)
//	{
//		GL2 gl = MainGame.render.externDrawable.getGL().getGL2();
//		
//		gl.glBegin(GL2.GL_LINES);
//		for(int i = 0; i<shape.vertices.length; i++)
//		{
//			Vector2 vertexToDraw = Matrix3.Multiply(transform.transformMatrix,new Vector3(shape.vertices[i],1f)).GetVec2();
//			gl.glColor3f(color.r,color.g,color.b);
//			gl.glVertex2f(vertexToDraw.x,vertexToDraw.y);
//		}
//		gl.glEnd();
//	}


}
