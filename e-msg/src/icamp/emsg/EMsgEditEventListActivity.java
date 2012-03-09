package icamp.emsg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class EMsgEditEventListActivity extends Activity {
	private static final String DBG_TAG = "EMsgEditEventListActivity";
	private EMsgApplication mEMsg;
	
	private ListView eventList;
	private String events[] = {"救我","老師要點名啦！"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_event_list_layout);
		
		mEMsg = (EMsgApplication)getApplication();
		
		eventList = (ListView)findViewById(R.id.eventList);
		eventList.setAdapter(
			new ArrayAdapter<String>(
				this,android.R.layout.simple_list_item_1 ,
				events
			)
		);
		
		Button btn_add = (Button)findViewById(R.id.btn_add);
		btn_add.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(EMsgEditEventListActivity.this,EMsgEditEventActivity.class));
			}
		});
		
	}

}
