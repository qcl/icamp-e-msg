package icamp.emsg;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.RemoteViews;

public class EMsgWidgetService extends Service {

	private static final String DBG_TAG = "EMsgWidgetService";
	
	private EMsgApplication mEMsg;
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		mEMsg = (EMsgApplication)getApplication();
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
		
		/*
		String clickedBtn = intent.getStringExtra(EMsgAppWidgetProvider.ON_CLICK_BTN);
		
		if(clickedBtn==null||clickedBtn==""){
			//Error
			Log.d(DBG_TAG, "Null string");
		}else if(clickedBtn==EMsgAppWidgetProvider.BTN_OPEN_LOCK){
			//RemoteViews view = new RemoteViews(,R.layout.widget_layout_open);
			
		}else if(clickedBtn==EMsgAppWidgetProvider.BTN_SEND_MSG){
			
		}else{
			//Error
		}
		*/
		
		// send default e-msg
		mEMsg.sendEMsg();
		
		return START_STICKY;
	}

	

}
