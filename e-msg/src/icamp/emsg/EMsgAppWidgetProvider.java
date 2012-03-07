package icamp.emsg;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;

public class EMsgAppWidgetProvider extends AppWidgetProvider {

	private static final String DBG_TAG = "EMsgAppWidgetProvider";
	protected static final String ON_CLICK_BTN = "onClickBtn";
	protected static final String BTN_OPEN_LOCK = "btnOpenLock";
	protected static final String BTN_SEND_MSG = "btnSendMsg";
	
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		// TODO Auto-generated method stub
		//super.onUpdate(context, appWidgetManager, appWidgetIds);
		
		final int N = appWidgetIds.length;
		
		for(int i=0;i<N;i++){
			int appWidgetId = appWidgetIds[i];
			
			Intent intent = new Intent(context,EMsgWidgetService.class);
			intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,appWidgetId);
			intent.putExtra(ON_CLICK_BTN, BTN_OPEN_LOCK);
			intent.setData(Uri.parse(intent.toUri(Intent.URI_INTENT_SCHEME)));
			PendingIntent pendingIntent = PendingIntent.getService(context, 0, intent, 0);
			
			RemoteViews views = new RemoteViews(context.getPackageName(),R.layout.widget_layout);
			views.setOnClickPendingIntent(R.id.widget_btn_open_lock, pendingIntent);
			
			appWidgetManager.updateAppWidget(appWidgetId, views);
		}
	}
	
	
}
