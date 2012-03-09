package icamp.emsg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class EMsgMainActivity extends Activity {

	private static final String DBG_TAG = "EMsgMainActivity";
	private EMsgApplication mEMsg;
	private ListView eventList;
	private String events[] = {"救我","老師要點名啦！"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		mEMsg = (EMsgApplication)getApplication();
		
		eventList = (ListView)findViewById(R.id.eventList);
		eventList.setAdapter(
			new ArrayAdapter<String>(
				this,android.R.layout.simple_list_item_1 ,
				events
			)
		);
		
		eventList.setOnItemLongClickListener(new OnItemLongClickListener() {

			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				mEMsg.sendEMsg("In app on Long click", "test");
				return false;
			}
		});
		
		Button btn_add = (Button)findViewById(R.id.btn_add);
		btn_add.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(EMsgMainActivity.this,EMsgEditEventActivity.class));
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.menu, menu);		
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		super.onOptionsItemSelected(item);
		switch(item.getItemId()){
			case R.id.editList:
				startActivity(new Intent(EMsgMainActivity.this,EMsgEditEventListActivity.class));
				break;
			case R.id.targetGroup:
				startActivity(new Intent(EMsgMainActivity.this,EMsgEditReceiverGroupListActivity.class));
				break;
			case R.id.detectService:
				startService(new Intent(EMsgMainActivity.this,EMsgDetectService.class));
				break;
			default:
				break;
		}
		return true;
	}
	
	

}
