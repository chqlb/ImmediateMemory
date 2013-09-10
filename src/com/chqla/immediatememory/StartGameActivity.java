package com.chqla.immediatememory;

import com.chqla.immediatememory.data.Constants;
import com.chqla.immediatememory.data.SettingData;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.view.View;
//import android.widget.Toast;

public class StartGameActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nine_btn);
		
		SettingData sd = getIntent().getExtras().getParcelable(Constants.SETTING_DATA);

		GridView gridview = (GridView) findViewById(R.id.gridview);
		gridview.setNumColumns(sd.colNumber);
		gridview.setAdapter(new ButtonAdapter(this, sd.colNumber*sd.colNumber, sd.time, this));

		gridview.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.nine_btn, menu);
		return true;
	}

}
