package com.sweep2d.GameObjects;

import java.util.Random;

import com.sweep2d.GameComponants.Transform;
import com.sweep2d.GameComponants.ObjectRenderer.Shape;
import com.sweep2d.GameComponants.RigidBody.ForceMode;
import com.sweep2d.Maths.Vector2;


public class ParticleEffects extends GameObject
{
	public int spawnRate;
	public boolean isTurnedOn;
	public Transform transform;
	private Particles[] particleArray;
	
	private long lastTime;
	

	public ParticleEffects(Transform transform,int maxParticles,int spawnRate)
	{
		this.transform = transform;
		this.spawnRate = spawnRate;
		this.particleArray = new Particles[maxParticles];
		this.isTurnedOn = false;
		lastTime = System.currentTimeMillis();
	}

	public void Update()
	{
		long currentTime = System.currentTimeMillis();
		
		Random ran = new Random();
		Vector2 back = transform.LocalDirectionToWorld(new Vector2(0,-1)).Normalized();

		int timeElapsed = (int) (currentTime - lastTime);
		boolean newSpawn = timeElapsed > (1000 / spawnRate);
		if( newSpawn )
		{
			if( isTurnedOn )
			{	
				int indexInArray = -1;
				for( int i = 0; i < particleArray.length; i++)
				{
					if( particleArray[i] == null)
					{
						indexInArray = i;
					}
				}
				if( indexInArray != -1)
				{
					particleArray[indexInArray] = new Particles(ran.nextInt(1500)+3000,new Vector2(transform.position.x,transform.position.y));
					particleArray[indexInArray].objectRenderer.shape= Shape.Triangle;
					particleArray[indexInArray].objectRenderer.AssignShaderProgram("simpleShader");
					particleArray[indexInArray].objectRenderer.SetTexture("smoke");
					particleArray[indexInArray].objectRenderer.LoadShape();
					particleArray[indexInArray].rigidBody.SetPosition(Vector2.Add(transform.position, Vector2.Scale(10, back)));
					particleArray[indexInArray].rigidBody.frictionCoefficient = 0.01f;
					particleArray[indexInArray].rigidBody.PushForce(Vector2.Scale(100,new Vector2((ran.nextInt(20))*1*back.x,(ran.nextInt(20))*5*back.y)),ForceMode.Impulse);
					particleArray[indexInArray].transform.size = new Vector2(10*((1+ran.nextInt(2)) - 0.075f*ran.nextInt(50)));
					particleArray[indexInArray].rigidBody.PushTorque((ran.nextInt(20) -10) * 10, ForceMode.Impulse);
					particleArray[indexInArray].objectRenderer.opacity = 0.8f;
				}
			}
			lastTime = currentTime;
		}
		
		for(int i=0; i < particleArray.length; i++)
		{
			if( particleArray[i] != null )
			{
				if( particleArray[i].TimeToDie() )
				{
					particleArray[i].Delete();
					particleArray[i] = null;
				}
				else
				{
					particleArray[i].Update();
				}
			}
		}
	}

	public void TurnOn()
	{
		if( !isTurnedOn )
		{
			isTurnedOn = true;
		}
	}

	public void TurnOff()
	{
		if( isTurnedOn )
		{
			isTurnedOn = false;
		}
	}


}
