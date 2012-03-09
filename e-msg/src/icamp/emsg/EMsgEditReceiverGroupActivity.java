package icamp.emsg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class EMsgEditReceiverGroupActivity extends Activity {
	private static final String DBG_TAG = "EMsgEditReceiverGroupListActivity";
	private EMsgApplication mEMsg;
	
	private ListView eventList;
	private String events[] = {"聯絡人A","聯絡人B","聯絡人C","聯絡人D"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_receiver_group_layout);
		
		mEMsg = (EMsgApplication)getApplication();
		
		eventList = (ListView)findViewById(R.id.eventList);
		eventList.setAdapter(
			new ArrayAdapter<String>(
				this,android.R.layout.simple_list_item_1 ,
				events
			)
		);
		
		
		
	}

}
