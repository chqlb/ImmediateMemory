package com.chqla.immediatememory;

import com.chqla.immediatememory.data.Constants;
import com.chqla.immediatememory.data.SettingData;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class SettingActivity extends Activity implements OnItemSelectedListener {

	private SettingData settingData = new SettingData();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Spinner spinner = (Spinner) findViewById(R.id.number_spnr);
		spinner.setOnItemSelectedListener(this);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.number_array, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);
		spinner.setSelection(1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, 
            int pos, long id) {
		// TODO Auto-generated method stub
		Object item = parent.getItemAtPosition(pos);
		settingData.colNumber = Integer.parseInt((String) item);
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void onStart(View view) {
		EditText editText = (EditText) findViewById(R.id.time_txt);
		String text = editText.getText().toString();
		
		if (text.equals("")) {
			// TODO Alert input time
		}
		else {
			// TODO start game
			settingData.time = Double.parseDouble(text);
			Intent intent = new Intent(this, StartGameActivity.class).putExtra(Constants.SETTING_DATA, settingData);
			startActivity(intent);
		}
	}

}
