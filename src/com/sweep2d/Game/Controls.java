package com.sweep2d.Game;

import com.sweep2d.Maths.Vector2;
import android.util.SparseArray;

public class Controls
{
	public SparseArray<Vector2> inputVector;
	
	public Controls() 
	{
		inputVector = new SparseArray<Vector2>();
	}
	
	public void flush()
	{
		inputVector.clear();
	}
	
	
	

}
