package icamp.emsg;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class EMsgWidgetService extends Service {

	private static final String DBG_TAG = "EMsgWidgetService";
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		Log.d(DBG_TAG,"onCreate");
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d(DBG_TAG, "onDestroy");
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		super.onStartCommand(intent, flags, startId);
		Log.d(DBG_TAG, "onStartCommand");
		Log.d(DBG_TAG, intent.getStringExtra(EMsgAppWidgetProvider.ON_CLICK_BTN));
		return START_STICKY;
	}

	

}
