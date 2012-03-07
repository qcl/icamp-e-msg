package icamp.emsg;

import android.app.Activity;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;

public class EMsgWidgetLockActivity extends Activity {

private static final String DBG_TAG = "EMsgWidgetLockActivity";
	
	private int mAppWidgetId;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		super.onCreate(savedInstanceState);
		
		//setContentView(R.layout.main);
		
		Intent intent = getIntent();
		Bundle extras = intent.getExtras();
		final Context context = EMsgWidgetLockActivity.this;
		String clickedBtn = "";
		
		if(extras!=null){
			mAppWidgetId = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
			clickedBtn   = extras.getString(EMsgAppWidgetProvider.ON_CLICK_BTN);
		}
		
		if (mAppWidgetId == AppWidgetManager.INVALID_APPWIDGET_ID || clickedBtn == "") {
			Log.d(DBG_TAG, "no appWidget id or clickedBtn = null");
            finish();
        }
		
		AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
		
		RemoteViews views;
		views = new RemoteViews(context.getPackageName(),R.layout.widget_layout_open);
		//PendingIntent pendingIntent;
		/*
		if(clickedBtn == EMsgAppWidgetProvider.BTN_SEND_MSG){
			Log.d(DBG_TAG, "sendMsg");
			views = new RemoteViews(context.getPackageName(),R.layout.widget_layout);
			
		}else if(clickedBtn == EMsgAppWidgetProvider.BTN_CLOSE_LOCK){
			Log.d(DBG_TAG, "closeLock");
			views = new RemoteViews(context.getPackageName(),R.layout.widget_layout);
			
			//Intent i = new Intent(context,EMsgWidgetLockActivity.class);
			//i.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,mAppWidgetId);
			//i.putExtra(EMsgAppWidgetProvider.ON_CLICK_BTN, EMsgAppWidgetProvider.BTN_OPEN_LOCK);
			//i.setData(Uri.parse(i.toUri(Intent.URI_INTENT_SCHEME)));	
			//pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);			
			//views.setOnClickPendingIntent(R.id.widget_btn_open_lock, pendingIntent);
			
		}else if(clickedBtn == EMsgAppWidgetProvider.BTN_OPEN_LOCK){
			Log.d(DBG_TAG, "openLock");
			views = new RemoteViews(context.getPackageName(),R.layout.widget_layout_open);
			
			//Intent i = new Intent(context,EMsgWidgetLockActivity.class);
			//i.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,mAppWidgetId);
			//i.putExtra(EMsgAppWidgetProvider.ON_CLICK_BTN, EMsgAppWidgetProvider.BTN_CLOSE_LOCK);
			//i.setData(Uri.parse(i.toUri(Intent.URI_INTENT_SCHEME)));	
			//pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);			
			//views.setOnClickPendingIntent(R.id.widget_btn_close_lock, pendingIntent);
			
			
		}else{
			//ERROR
			Log.wtf(DBG_TAG, "WTF");
			views = null;
			finish();
		}
		*/
		appWidgetManager.updateAppWidget(mAppWidgetId, views);
		
		Intent resultValue = new Intent();
		resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, mAppWidgetId);
		setResult(RESULT_OK, resultValue);
		finish();
				
	}

}
