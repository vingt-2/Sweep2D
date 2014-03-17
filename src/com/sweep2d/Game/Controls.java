package com.sweep2d.Game;

import com.sweep2d.Maths.Vector2;
import android.util.SparseArray;

public class Controls
{
	public SparseArray<Vector2> inputVector;
	
	public boolean[] inputArrows;
	
	public Controls() 
	{
		inputVector = new SparseArray<Vector2>();
		inputArrows = new boolean[4];
	}
	
	public void flush()
	{
		inputVector.clear();
	}
	
	public void pressArrow(int arrow)
	{
		inputArrows[arrow] = true;
	}
	
	public void flushArrows()
	{
		for(int i = 0; i<inputArrows.length;i++)
		{
			inputArrows[i] = false;
		}
	}
	
	

}
