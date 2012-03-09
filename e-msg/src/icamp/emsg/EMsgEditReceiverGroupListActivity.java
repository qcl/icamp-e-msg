package icamp.emsg;

import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class EMsgEditReceiverGroupListActivity extends Activity {
	private static final String DBG_TAG = "EMsgEditReceiverGroupListActivity";
	private EMsgApplication mEMsg;
	
	private ListView eventList;
	private String events[] = {"家人","同學","朋友"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_receiver_group_list_layout);
		
		mEMsg = (EMsgApplication)getApplication();
		
		eventList = (ListView)findViewById(R.id.eventList);
		eventList.setAdapter(
			new ArrayAdapter<String>(
				this,android.R.layout.simple_list_item_1 ,
				events
			)
		);
		
		eventList.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				startActivity(new Intent(EMsgEditReceiverGroupListActivity.this,EMsgEditReceiverGroupActivity.class));
			}
		});
		
		
		
	}

}
