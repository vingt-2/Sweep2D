package com.sweep2d.Engine;

import com.sweep2d.Engine.SharedResources.ResourceType;

public class Resource
{
	public ResourceType type;
	public String name;
	public String[] filePaths;
	
	public Resource(String name, String[] filePaths,ResourceType type)
	{
		this.type = type;
		this.name = name;
		this.filePaths = filePaths;
	}
	
}