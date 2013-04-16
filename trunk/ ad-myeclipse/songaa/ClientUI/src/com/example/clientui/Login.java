package com.example.clientui;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.clientui.util.RequestMethod;
import com.example.clientui.util.RestClient;

public class Login extends Activity {

	private EditText txtLoginEmail;
	private EditText txtLoginPassword;
	private Button btnLogIn;
	private TextView forgetPassword;
	private EditText txtRegisterName;
	private EditText txtRegisterMailId;
	private EditText txtRegisterMailIdReenter;
	private EditText txtRegisterPassword;
	private Button btnRegister;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		initView();
		registerEvents();

	}

	private void registerEvents() {
		// TODO Auto-generated method stub
		btnLogIn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				loginClicked(v);
			}
		});
		btnRegister.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				registerClicked(v);
			}
		});
	}

	private void initView() {
		forgetPassword = (TextView) findViewById(R.id.txtFrogetPassword);
		txtLoginEmail = (EditText) findViewById(R.id.txtLoginMailId);
		txtLoginPassword = (EditText) findViewById(R.id.txtLoginPassword);
		btnLogIn = (Button) findViewById(R.id.btnLogIn);

		forgetPassword.setMovementMethod(LinkMovementMethod.getInstance());

		txtRegisterName = (EditText) findViewById(R.id.txtRegisterName);
		txtRegisterMailId = (EditText) findViewById(R.id.txtRegisterMailId);
		txtRegisterMailIdReenter = (EditText) findViewById(R.id.txtRegisterMailIdReenter);
		txtRegisterPassword = (EditText) findViewById(R.id.txtRegisterPassword);

		btnRegister = (Button) findViewById(R.id.btnRegister);
	}

	public void loginClicked(View v) {
		if (checkEmail(txtLoginEmail.getText().toString()) == false) {
			Toast.makeText(getApplicationContext(),
					R.string.msg_login_invalid_email, Toast.LENGTH_SHORT)
					.show();
			return;
		}
		if (txtLoginPassword.getText().toString().trim().equals("")) {
			Toast.makeText(getApplicationContext(),
					R.string.msg_login_blank_password, Toast.LENGTH_SHORT)
					.show();
			return;
		}
		LoginAsyncTask task = new LoginAsyncTask();
		task.applicationContext = Login.this;
		task.execute();
		btnLogIn.setClickable(false);
	}

	public void registerClicked(View v) {
		if (txtRegisterName.getText().toString().trim().equals("")) {
			Toast.makeText(getApplicationContext(),
					R.string.msg_login_reg_blank_name, Toast.LENGTH_SHORT)
					.show();
			return;
		}
		if (checkEmail(txtRegisterMailId.getText().toString()) == false) {
			Toast.makeText(getApplicationContext(),
					R.string.msg_login_invalid_email, Toast.LENGTH_SHORT)
					.show();
			return;
		}
		if (txtRegisterMailId.getText().toString()
				.equals(txtRegisterMailIdReenter.getText().toString()) == false) {
			Toast.makeText(getApplicationContext(),
					R.string.msg_login_email_reemail_same, Toast.LENGTH_SHORT)
					.show();
			return;
		}
		if (txtLoginPassword.getText().toString().trim().equals("")) {
			Toast.makeText(getApplicationContext(),
					R.string.msg_login_blank_password, Toast.LENGTH_SHORT)
					.show();
			return;
		}
		RegisterAsyncTask task = new RegisterAsyncTask();
		task.applicationContext = Login.this;
		task.execute();
		btnRegister.setClickable(false);
	}

	private Boolean checkEmail(String email) {
		Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
		Matcher m = p.matcher(email);
		boolean matchFound = m.matches();

		if (matchFound) {
			return true;
		} else {
			return false;
		}
	}

	public class LoginAsyncTask extends AsyncTask<String, Void, String> {
		private ProgressDialog dialog;
		protected Context applicationContext;

		protected void onPreExecute() {
			this.dialog = ProgressDialog.show(applicationContext, "Calling",
					"Please wait...", true);
		}

		@Override
		protected String doInBackground(String... params) {
			// return Login.getLoginResponse();
			// http://10.0.2.2:8080/Server/resources/profile/authenticate/%s/%s/deviceid
			String responseString;
			String url = String.format(getString(R.string.url_login),
					txtLoginEmail.getText().toString(), txtLoginPassword
							.getText().toString(), "deviceid");
			Log.d("songaa", url);
			RestClient client = new RestClient(url);
			try {
				client.Execute(RequestMethod.GET);
			} catch (Exception e) {
				e.printStackTrace();
			}

			responseString = client.getResponse();

			return responseString;
		}

		protected void onPostExecute(String result) {
			btnLogIn.setClickable(true);
			Log.d("songaa", "result: " + result);
			this.dialog.cancel();

			JSONObject json = null;

			try {
				json = new JSONObject(result);

				if (json.has("error")) {
					String error = json.getString("error");
					Toast.makeText(getApplicationContext(), error,
							Toast.LENGTH_SHORT).show();
					return;
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Toast.makeText(getApplicationContext(), e.getMessage(),
						Toast.LENGTH_SHORT).show();
			}

			Intent intent = new Intent(Login.this, Main.class);
			intent.putExtra("Value1", result);
			final int returnResult = 1;
			startActivityForResult(intent, returnResult);
		}

	}

	public class RegisterAsyncTask extends AsyncTask<String, Void, String> {
		private ProgressDialog dialog;
		protected Context applicationContext;

		protected void onPreExecute() {
			this.dialog = ProgressDialog.show(applicationContext, "Calling",
					"Please wait...", true);
		}

		@Override
		protected String doInBackground(String... params) {
			// return Login.getLoginResponse();
			// http://10.0.2.2:8080/Server/resources/profile/authenticate/%s/%s/deviceid
			String responseString;
			String url = String.format(getString(R.string.url_register),
					txtRegisterMailId.getText().toString(), txtRegisterPassword
							.getText().toString(), txtRegisterName.getText()
							.toString());
			Log.d("songaa", url);
			RestClient client = new RestClient(url);
			try {
				client.Execute(RequestMethod.GET);
			} catch (Exception e) {
				e.printStackTrace();
			}

			responseString = client.getResponse();

			return responseString;
		}

		protected void onPostExecute(String result) {
			btnRegister.setClickable(true);
			Log.d("songaa", "result: " + result);
			this.dialog.cancel();

			JSONObject json = null;

			try {
				json = new JSONObject(result);

				if (json.has("error")) {
					String error = json.getString("error");
					Toast.makeText(getApplicationContext(), error,
							Toast.LENGTH_SHORT).show();
					return;
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Toast.makeText(getApplicationContext(), e.getMessage(),
						Toast.LENGTH_SHORT).show();
			}

			Intent intent = new Intent(Login.this, Main.class);
			intent.putExtra("Value1", result);
			final int returnResult = 1;
			startActivityForResult(intent, returnResult);
		}

	}
}
