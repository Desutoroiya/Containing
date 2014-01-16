package com.example.containingmonitor;

import java.util.Arrays;

import org.achartengine.ChartFactory;
import org.achartengine.chart.BarChart.Type;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Paint.Align;
import android.os.Bundle;

public class BarGraph {
	
	public Intent intent(Context context){
		
	
		int y[] = {440,3000,600,500,1242,480,454,2544,756,567};
		Arrays.sort(y);
		int yMax = y[y.length - 1];
		
		CategorySeries series = new CategorySeries("Totaal");
			for(int i=y.length-1; i>=0; i--){
				
				series.add("Bar" + (i+1),y[i]);
			}

		XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
		dataset.addSeries(series.toXYSeries());
		
		XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();
		XYSeriesRenderer renderer = new XYSeriesRenderer();
		
		renderer.setDisplayChartValues(true);
		renderer.setChartValuesTextSize(36);
		renderer.setChartValuesTextAlign(Align.RIGHT);
		renderer.setColor(Color.WHITE);
		
		
		for(int i = 0; i < y.length;i++){
			
			mRenderer.addXTextLabel(i+1, "Containers");	
			
		}
		
		mRenderer.addSeriesRenderer(renderer);
		mRenderer.setXLabels(0);
		mRenderer.setXLabelsAngle(270f);
		mRenderer.setXLabelsAlign(Align.LEFT);
		mRenderer.setXLabelsColor(Color.BLACK);
		mRenderer.setBarSpacing(0.2f);
		mRenderer.setPanEnabled(false, false);
		mRenderer.setXAxisMin(0);
		mRenderer.setXAxisMax(y.length +1);
		mRenderer.setYAxisMin(0);
		mRenderer.setYAxisMax(yMax + (yMax/10));
		mRenderer.setShowLegend(false);
		mRenderer.setLabelsTextSize(30);
		mRenderer.setYLabels(0);
		mRenderer.setZoomEnabled(false, false);
		mRenderer.setAxesColor(Color.BLACK);
		
		
		
		Intent intent = ChartFactory.getBarChartIntent(context, dataset, mRenderer, Type.DEFAULT);
		return intent;
	}
}
