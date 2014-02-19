package com.sweep2d.GameObjects;

//import java.awt.event.KeyEvent;
import java.util.List;

import android.util.Log;
import android.util.SparseArray;

import com.sweep2d.Game.MainGame;
import com.sweep2d.GameComponants.ObjectRenderer.Shape;
import com.sweep2d.GameComponants.RigidBody.ForceMode;
import com.sweep2d.Helpers.Color;
import com.sweep2d.Maths.Vector2;


public class Player extends GameChar 
{
	
	ParticleEffects effect = new ParticleEffects(transform,200);
	long lastTime = 0;
	final static long effectTimeThreshold = 1000; // wait 000ms to toggle effect
	
	public Player()
	{
		super();
		objectRenderer.shape= Shape.Triangle;
		objectRenderer.AssignShaderProgram("simpleShader");
		objectRenderer.SetTexture("rocket_ship");
		objectRenderer.LoadShape();
		effect.transform = this.transform;
		effect.isTurnedOn = false;
	}
	
	public void Update()
	{
		super.Update();
		
		// Player Stuff
		effect.Update();
		PlayerControls();
		
		
		//		Vector2 charFrontInWorldCoordinates = transform.LocalDirectionToWorld(new Vector2(0,1)).Normalized();
		//		MainGame.debug.DrawLine(transform.position,charFrontInWorldCoordinates,100,Color.Blue);
		
	}
	
	private void PlayerControls()
	{
		SparseArray<Vector2> inputs = MainGame.singleton.controls.inputVector;

		effect.isTurnedOn = false;
		if(inputs.size() > 0)
		{
			if(inputs.size() == 1)
			{
				int a = -1;
				
				for(int i=0; i < inputs.size(); i++)
				{
					if(inputs.get(i) != null)
						a = i;
				}
				
				if(a != -1)
				{
					int sign = (inputs.get(a).x < MainGame.Screen_Size.x / 2) ? -1 : 1;

					rigidBody.PushTorque(sign*10, ForceMode.Impulse);
				}
			}	
			else
			{
				rigidBody.PushForce(transform.LocalDirectionToWorld(new Vector2(0,50)), ForceMode.Impulse);
				effect.isTurnedOn = true;
			}
		}
	}
	
}
