package com.sweep2d.Game;

//import java.awt.event.KeyEvent;
import java.util.ArrayList;

import android.content.Context;

import com.sweep2d.Engine.Renderer;
import com.sweep2d.Engine.Resource;
import com.sweep2d.Engine.SharedResources;
import com.sweep2d.Engine.SharedResources.ResourceType;
import com.sweep2d.GameComponants.RigidBody.ForceMode;
import com.sweep2d.GameObjects.GameChar;
import com.sweep2d.GameObjects.Player;
import com.sweep2d.Helpers.Debug;
import com.sweep2d.Maths.Vector2;

import com.sweep2d.Maths.*;
import com.sweep2d.Engine.*;

public class MainGame 
{
	//Main Parameters
	public static String Window_Name		= "Asteroids";
	public static Vector2 Screen_Size 		= new Vector2(1024,780);
	
	
	// Game singletons
	public static final Singleton singleton	= new Singleton();
	
	
	public MainGame(Context context, Renderer render)
	{
		singleton.sharedResources = new SharedResources(context);
		singleton.renderer = render;
		singleton.controls = new Controls();
	}

	
	ArrayList<GameChar> objectVector;
	public static Player player	;

	public void init()
	{
		singleton.sharedResources.Loadresources
		(new Resource[]
			{
				new Resource("rocket_ship",new String[]{"textures/rocket_ship.png"},ResourceType.Texture),
				new Resource("smoke",new String[]{"textures/SmokeParticle.png"},ResourceType.Texture),
				new Resource("simpleShader", new String[] {"shaders/simple_Vertex.glsl","shaders/simple_Fragment.glsl"}, ResourceType.ShaderProgram),
				new Resource("debugShader", new String[] {"shaders/debug_Vertex.glsl","shaders/debug_Fragment.glsl"}, ResourceType.ShaderProgram)
			}
		);

		player = new Player();
		player.transform.size = new Vector2(20,20);
		player.rigidBody.frictionCoefficient = 0.01f;
		//player.rigidBody.PushForce(new Vector2(100000,0),ForceMode.Impulse);
	}

	public void Update()
	{
		//Update player transform, physics, rendering etc...
		player.Update();
	}

	
}
