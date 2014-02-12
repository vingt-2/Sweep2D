package com.sweep2d.GameObjects;

import com.sweep2d.Game.MainGame;
import com.sweep2d.GameComponants.ObjectRenderer;
import com.sweep2d.GameComponants.RigidBody;
import com.sweep2d.GameComponants.Transform;
import com.sweep2d.Maths.Vector2;


public class GameChar extends GameObject 
{
	public Transform transform;
	public RigidBody rigidBody;
	public ObjectRenderer objectRenderer;
	
	public GameChar()
	{
		transform 		= new Transform();
		objectRenderer 	= new ObjectRenderer(this);
		rigidBody 		= new RigidBody(this);
	}
	
	public GameChar(Vector2 position)
	{
		transform 		= new Transform(position);
		objectRenderer 	= new ObjectRenderer(this);
		rigidBody 		= new RigidBody(this);
	}
	
	public void Update()
	{
		if(!isDeleted)		// Makes sure we're not about trying to use smthign about to be garbage collected
		{
			//Update Components
			transform.UpdateTransform();
			rigidBody.Update();
		
			// Do shit
			//WrapPositionAroundScreen();
		}
	}
	
	private void WrapPositionAroundScreen()
	{
		
		if(transform.position.x > MainGame.Screen_Size.x/2)
		{
			rigidBody.SetPosition(new Vector2(-MainGame.Screen_Size.x/2,transform.position.y));
		}
		if(transform.position.x < -MainGame.Screen_Size.x/2)
		{
			rigidBody.SetPosition(new Vector2(MainGame.Screen_Size.x/2,transform.position.y));
		}
		if(transform.position.y > MainGame.Screen_Size.y/2)
		{
			rigidBody.SetPosition(new Vector2(transform.position.x,-MainGame.Screen_Size.y/2));
		}		
		if(transform.position.y < -MainGame.Screen_Size.y/2)
		{
			rigidBody.SetPosition(new Vector2(transform.position.x,MainGame.Screen_Size.y/2));
		}
	}
	
	@Override
	public void Delete()
	{
		isDeleted		= true;
		
		MainGame.singleton.renderer.renderVector.remove(objectRenderer);
		transform 		= null;
		objectRenderer 	= null;
		rigidBody 		= null;
	}
	
}
