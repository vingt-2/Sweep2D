package com.sweep2d.GameObjects;

//import java.awt.event.KeyEvent;
import android.util.Log;

import com.sweep2d.Game.MainGame;
import com.sweep2d.GameComponants.ObjectRenderer.Shape;
import com.sweep2d.GameComponants.RigidBody.ForceMode;
import com.sweep2d.Helpers.Color;
import com.sweep2d.Maths.Vector2;


public class Player extends GameChar 
{
	
	ParticleEffects effect = new ParticleEffects(transform,2000);
	long lastTime = 0;
	final static long effectTimeThreshold = 1000; // wait 000ms to toggle effect
	
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
		effect.Update();
		PlayerControls();
		
		
		//Vector2 charFrontInWorldCoordinates = transform.LocalDirectionToWorld(new Vector2(0,1)).Normalized();
		//		MainGame.debug.DrawLine(transform.position,charFrontInWorldCoordinates,100,Color.Blue);
		
	}
	
	private void PlayerControls()
	{
		Vector2 input = MainGame.singleton.controls.inputVector;
		if(input.x != 0 || input.y != 0)
		{
			rigidBody.PushForce(Vector2.Scale(100,Vector2.Add(input,transform.position.negate())), ForceMode.Impulse);
			 MainGame.singleton.controls.inputVector = new Vector2(0);
		}
	}
	
}
