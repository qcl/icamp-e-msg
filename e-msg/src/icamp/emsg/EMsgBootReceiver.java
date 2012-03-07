package icamp.emsg;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class EMsgBootReceiver extends BroadcastReceiver {

	private static final String DBG_TAG = "EMsgBootReceiver";
	
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Log.d(DBG_TAG, "onReceive");

	}

}
