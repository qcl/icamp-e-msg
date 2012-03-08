package icamp.emsg;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.util.Log;

public class EMsgDetectService extends Service implements SensorEventListener{



	private static final String DBG_TAG = "EMsgDetcetService";
	
	private EMsgApplication mEMsg;
	
	private NotificationManager mNotificationManager;
	private Notification mNotification;
	
	private SensorManager mSensorManager;
	private Sensor mSensor;
	
	private int count = 0;
	private float max = 0;
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.d(DBG_TAG, "onDestroy");
		mEMsg.setIsDetectServiceRunning(false);
		this.mSensorManager.unregisterListener(this);
		this.count = 0;
		//FIXME TODO
		//Add some method that this service never stop!?
		
		//TODO
		//when stop service, stop detect function.
	}

	@Override
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);
		mEMsg = (EMsgApplication)getApplication();
		
		this.mNotificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		this.mNotification = new Notification(android.R.drawable.stat_notify_sync,"",0);
		
		this.mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
		this.mSensor = this.mSensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
		
		this.mSensorManager.registerListener(this, this.mSensor, SensorManager.SENSOR_DELAY_UI);
		
		this.count = 0;
		this.max = 0;
		
		Log.d(DBG_TAG, "onStart");
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		super.onStartCommand(intent, flags, startId);
		Log.d(DBG_TAG, "onStartCommand");
		mEMsg.setIsDetectServiceRunning(true);
		
		PendingIntent pendingIntent = PendingIntent.getActivity(this, -1, new Intent(this,EMsgMainActivity.class), 0);
		this.mNotification.when = System.currentTimeMillis();
		
		CharSequence notificationTitle = "緊急通報 alpha";
		CharSequence notificationSummary = "自動偵測已啟動";
		this.mNotification.setLatestEventInfo(this,notificationTitle , notificationSummary, pendingIntent);
		this.mNotificationManager.notify(0, this.mNotification);
		
		//TODO
		//start detect function.
		
		return START_STICKY;
	}

	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}

	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		
		//PendingIntent pendingIntent = PendingIntent.getActivity(this, -1, new Intent(this,EMsgMainActivity.class), 0);
		float g = event.values[1];
		/*	
		this.mNotification.when = System.currentTimeMillis();
		//this.mNotification.flags |= Notification.FL
		CharSequence notificationTitle = "E-Msg";
		CharSequence notificationSummary = " "+g;
		this.mNotification.setLatestEventInfo(this,notificationTitle , notificationSummary, pendingIntent);
		this.mNotificationManager.notify(0, this.mNotification);
		*/
		if(g>13.5){
			count+=10;
		}else{
			if(count>0){
				count--;
			}
		}
		
		if(count>100){
			count = 0;
			this.onEvent();
		}
		
		/*
		if(g>max){
			max = g;
			Log.d(DBG_TAG, "max="+max);
		}
		*/
		
	}
	
	private void onEvent(){
		Log.d(DBG_TAG, "onEvent");
		this.mEMsg.sendEMsg("AutoDetectEvent","qcl");
	}

	
}
