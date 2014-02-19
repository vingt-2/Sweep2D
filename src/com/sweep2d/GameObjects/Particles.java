package com.sweep2d.GameObjects;

import com.sweep2d.Game.MainGame;
import com.sweep2d.GameComponants.RigidBody.ForceMode;
import com.sweep2d.Maths.Vector2;


public class Particles extends GameChar
{
	long creationTime;
	long lastTime;
	long lifeTime;

	public Particles(int lifetime,Vector2 position)
	{
		super(position);
		lifeTime = lifetime;

		creationTime = System.currentTimeMillis();
	}

	public void Update()
	{  
		long currentTime = System.currentTimeMillis();
		if(currentTime - lastTime > (1000 * 1f/60f))
		{
			super.Update();
			long timeLived = currentTime - creationTime;
			
			objectRenderer.opacity = 1f - (float) timeLived/lifeTime;
			
			Vector2 toPlayer = Vector2.Add(MainGame.player.transform.position,transform.position.negate());
	
			//MainGame.debug.DrawLine(transform.position,toPlayer,toPlayer.GetLength());
	
			if(toPlayer.GetLength() < 200)
			{
				objectRenderer.opacity *= toPlayer.GetLength()/200;
				if(toPlayer.GetLength() < 100)
				{
					rigidBody.PushForce(toPlayer.Normalized().Scaled(-130*MainGame.player.rigidBody.velocity.GetLength()), ForceMode.Impulse);
				}
			}
			lastTime = currentTime;
		}
	}

	public boolean TimeToDie()
	{
		long currentTime = System.currentTimeMillis();

		if(currentTime - creationTime > lifeTime)
		{
			return true;
		}

		return false;
	}

}
