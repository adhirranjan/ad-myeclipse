package com.example.clientui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Bundle extras = getIntent().getExtras();
		if (extras == null) {
			return;
		}
		// Get data via the key
		String value1 = extras.getString("Value1");

		Toast.makeText(getApplicationContext(), value1, Toast.LENGTH_SHORT)
				.show();

		TextView t = (TextView) findViewById(R.id.textView1);
		t.setText(value1);
	}

}
