package com.example.ad_eclipse2;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity implements OnClickListener,
		OnTouchListener, OnCompletionListener, OnBufferingUpdateListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		// forget password link
		TextView forgetPassword = (TextView) findViewById(R.id.txtFrogetPassword);
		forgetPassword.setMovementMethod(LinkMovementMethod.getInstance());

		Button btnLogIn = (Button) findViewById(R.id.btnLogIn);
		btnLogIn.setOnClickListener(this);

	}

	@Override
	public void onBufferingUpdate(MediaPlayer mp, int percent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onCompletion(MediaPlayer mp) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onClick(View arg0) {
		if (arg0.getId() == R.id.btnLogIn) {
			// TODO Auto-generated method stub
			// display in short period of time
			Toast.makeText(getApplicationContext(), "msg msg",
					Toast.LENGTH_SHORT).show();
		}
	}

}
