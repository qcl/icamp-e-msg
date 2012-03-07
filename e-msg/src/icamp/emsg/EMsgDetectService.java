package icamp.emsg;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class EMsgDetectService extends Service {

	private static final String DBG_TAG = "EMsgDetcetService";
	
	private EMsgApplication mEMsg;
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.d(DBG_TAG, "onDestroy");
		mEMsg.setIsDetectServiceRunning(false);
		//FIXME TODO
		//Add some method that this service never stop!?
		
		//TODO
		//when stop service, stop detect function.
	}

	@Override
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);
		mEMsg = (EMsgApplication)getApplication();
		Log.d(DBG_TAG, "onStart");
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		super.onStartCommand(intent, flags, startId);
		Log.d(DBG_TAG, "onStartCommand");
		mEMsg.setIsDetectServiceRunning(true);
		//TODO
		//start detect function.
		return START_STICKY;
	}

	
}
