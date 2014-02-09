package com.sweep2d.GameObjects;

//import java.awt.event.KeyEvent;
import com.sweep2d.Game.MainGame;
import com.sweep2d.GameComponants.ObjectRenderer.Shape;
import com.sweep2d.GameComponants.RigidBody.ForceMode;
import com.sweep2d.Helpers.Color;
import com.sweep2d.Maths.Vector2;


public class Player extends GameChar 
{
	
	//ParticleEffects effect = new ParticleEffects(transform,2000);
	//long lastTime = 0;
	//final static long effectTimeThreshold = 1000; // wait 000ms to toggle effect
	
	public Player()
	{
		super();
		objectRenderer.shape= Shape.Triangle;
		objectRenderer.AssignShaderProgram("simpleShader");
		objectRenderer.SetTexture("rocket_ship");
		objectRenderer.LoadShape();
	}
	
	public void Update()
	{
		super.Update();
		
		// Player Stuff
		//effect.Update();
		PlayerControls();
		
		
		//Vector2 charFrontInWorldCoordinates = transform.LocalDirectionToWorld(new Vector2(0,1)).Normalized();
//		MainGame.debug.DrawLine(transform.position,charFrontInWorldCoordinates,100,Color.Blue);
		
	}
	
	private void PlayerControls()
	{
//		if(MainGame.controls.isPressed(KeyEvent.VK_RIGHT))
//		{
//			rigidBody.PushTorque(10,ForceMode.Impulse);
//		}
//		if(MainGame.controls.isPressed(KeyEvent.VK_LEFT))
//		{
//			rigidBody.PushTorque(-10,ForceMode.Impulse);
//		}
//		if(MainGame.controls.isPressed(KeyEvent.VK_UP))
		if(true)
		{
			Vector2 objectFrontInWorldCoordinates = transform.LocalDirectionToWorld(new Vector2(0,1));
			rigidBody.PushForce(Vector2.Scale(1000, objectFrontInWorldCoordinates),ForceMode.Impulse);
			//effect.TurnOn();
		}
		else
		{
			//effect.TurnOff();
		}
		
//		if(MainGame.controls.isPressed(KeyEvent.VK_SPACE))
		if(true)
		{
//			long time = System.currentTimeMillis();
//			if( time - lastTime >  effectTimeThreshold)
//			{
//				if(!effect.isTurnedOn)
//				{
//					effect.TurnOn();
//				}
//				else				
//				{
//					effect.TurnOff();
//				}
//				lastTime = time;
//			}
		}
	}
	
}
