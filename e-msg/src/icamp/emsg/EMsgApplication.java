package icamp.emsg;

import android.app.Application;
import android.content.Intent;
import android.util.Log;

public class EMsgApplication extends Application {

	private static final String DBG_TAG = "EMsgApplication";
	
	private static boolean isDetectServiceRunning = false;
	
	@Override
	public void onCreate() {
		super.onCreate();
		Log.d(DBG_TAG,"onCreate");
		//start detect service
		startService(new Intent(EMsgApplication.this,EMsgDetectService.class));
	}
	
	protected boolean getIsDetectServiceRunning(){
		return this.isDetectServiceRunning;
	}
	
	protected void setIsDetectServiceRunning(boolean isRunning){
		this.isDetectServiceRunning = isRunning;		
	}

	@Override
	public void onLowMemory() {
		super.onLowMemory();
		Log.d(DBG_TAG, "onLowMemory");
	}

	@Override
	public void onTerminate() {
		super.onTerminate();
		Log.d(DBG_TAG, "onTerminate");
	}
	
	protected void sendEMsg(){
		Log.d(DBG_TAG, "send MSG!!!!");
	}
	
}
