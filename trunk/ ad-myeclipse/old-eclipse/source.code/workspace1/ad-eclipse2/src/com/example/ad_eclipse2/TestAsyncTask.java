package com.example.ad_eclipse2;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TestAsyncTask extends Activity {

	TextView txtTime;

	public TextView getTxtTime() {
		return txtTime;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_testasynctask);

		// src folder/Start.java paste the code below right after setContentView

		// keep the handle to the textview for later
		this.txtTime = (TextView) findViewById(R.id.txtTime);

		// add a click event handler for the button
		final Button btnCallWebService = (Button) findViewById(R.id.btnCallWebService);
		btnCallWebService.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				CallWebServiceTask task = new CallWebServiceTask();
				task.applicationContext = TestAsyncTask.this;
				task.execute();
			}
		});
	}

	// src folder/Start.java paste the code below within the body of the
	// Start.java class

	public static String UnixTimeStampToDateTime(String unixTimeStamp) {

		long tiemstamp = Long.parseLong(unixTimeStamp);
		String dateStr = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
				.format(new java.util.Date(tiemstamp * 1000));

		return dateStr;
	}

	public static String parseJSONResponse(String jsonResponse) {
		String timestamp = "";

		JSONObject json;
		try {
			json = new JSONObject(jsonResponse);
			JSONObject result = json.getJSONObject("Result");
			timestamp = result.getString("Timestamp");

		} catch (JSONException e) {

			e.printStackTrace();
		}

		return timestamp;
	}

	public static String getTimeStampFromYahooService() {

		String responseString = null;

		String baseurlString = "http://developer.yahooapis.com/TimeService/V1/getTime";
		//baseurlString = "http://10.0.2.2:8080/restdemo/resources/profile/authenticate/a@a.com/apwd/nameasasasasasasas";
		RestClient client = new RestClient(baseurlString);
		// client.AddParam("appid", "YahooDemo");
		// client.AddParam("output", "json");

		try {
			client.Execute(RequestMethod.GET);
		} catch (Exception e) {
			e.printStackTrace();
		}

		responseString = client.getResponse();

		return responseString;
	}

	public class CallWebServiceTask extends AsyncTask<String, Void, String> {
		private ProgressDialog dialog;
		protected Context applicationContext;

		protected void onPreExecute() {
			this.dialog = ProgressDialog.show(applicationContext, "Calling",
					"Time Service...", true);
		}

		@Override
		protected String doInBackground(String... params) {
			return TestAsyncTask.getTimeStampFromYahooService();
		}

		protected void onPostExecute(String result) {
			this.dialog.cancel();
			Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT)
					.show();
			// String timestamp = TestAsyncTask.parseJSONResponse(result);
			// timestamp = TestAsyncTask.UnixTimeStampToDateTime(timestamp);
			// TestAsyncTask.this.getTxtTime().setText(timestamp);
			// Toast.makeText(getApplicationContext(),
			// timestamp,Toast.LENGTH_SHORT).show();

		}

	}
}
