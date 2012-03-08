package icamp.emsg;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.util.ByteArrayBuffer;

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
	
	protected void sendEMsg(String from, String to){
		Log.d(DBG_TAG, "send MSG!!!!");
		
		if(from==""||from==null||from.equals("")){
			from     = "mobile";
		}
		
		if(to==""||to==null||to.equals("")){
			to = "testWebsite";
		}
		
		String msg      = "HelloWorld!";
		String location = "25N,121E";
		
		String url      = "http://qcl.tw/alpha/icamp/add.php?from="+from+"&to="+to+"&msg="+msg+"&location="+location;
		
		try {
			
            URL msgURL = new URL(url);
            URLConnection conn = msgURL.openConnection();
            InputStream is = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            ByteArrayBuffer baf = new ByteArrayBuffer(50);
            
            int current = 0;
            while((current = bis.read()) != -1){
               baf.append((byte)current);
            }

            Log.d(DBG_TAG, "DONE:"+url);
        } catch (Exception e) {
        	
        }
		
		
	}
	
}
