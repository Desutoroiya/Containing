package com.example.containingmonitor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class Client extends Activity{
	
	
	public void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		
	}
	public void BarGraphHandler(View view){
		
		/*
		 * Creates the bar graph when the button is pressed in the beginscreen.
		 */
		
		BarGraph bar = new BarGraph();
		Intent lineIntent = bar.intent(this);
		startActivity(lineIntent);
		
	}
	

}
