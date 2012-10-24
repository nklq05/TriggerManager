package com.ubhave.triggermanager.triggers.active;

import java.util.Timer;

import android.content.Context;

import com.ubhave.sensormanager.SensorDataListener;
import com.ubhave.sensormanager.data.SensorData;
import com.ubhave.triggermanager.TriggerReceiver;
import com.ubhave.triggermanager.triggers.Trigger;

public abstract class ActiveTrigger extends Trigger implements SensorDataListener
{	
	
	protected Timer surveyTimer;
	
	public ActiveTrigger(Context context, TriggerReceiver listener)
	{
		super(context, listener);
		this.surveyTimer = new Timer();
	}
	
	protected abstract void sampleForSurvey();
	
	@Override
	public abstract void onDataSensed(SensorData sensorData);
	
	public void kill()
	{
		if (surveyTimer != null)
		{
			surveyTimer.cancel();
			surveyTimer = null;
		}
	}
	
}
