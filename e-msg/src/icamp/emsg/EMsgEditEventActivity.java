package icamp.emsg;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class EMsgEditEventActivity extends Activity {
	private static final String DBG_TAG = "EMsgEditEventActivity";
	private EMsgApplication mEMsg;	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_event_layout);
		
		mEMsg = (EMsgApplication)getApplication();
		
		Spinner spinner = (Spinner)findViewById(R.id.rG);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,new String[]{"家人","同學","朋友"});
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		
		Button btn_save = (Button)findViewById(R.id.btn_save);
		btn_save.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				finish();
			}
		});
		
		Button btn_trigger = (Button)findViewById(R.id.btn_trigger);
		btn_trigger.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				finish();
			}
		});
		
	}

}
