package com.example.clientui;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.clientui.util.ImageLoader;
import com.example.clientui.util.RequestMethod;
import com.example.clientui.util.RestClient;

public class Main extends Activity implements OnClickListener{

	// All static variables
	// static final String URL = "http://api.androidhive.info/music/music.xml";

	static final String URL2 = "http://117.218.27.85:8080/Server/resources/song/updates/1";
	// XML node keys
	static final String KEY_SONG_URL = "song_url"; // parent node
	static final String KEY_USERNAME = "username";
	static final String KEY_DESCRIPTION = "description";
	static final String KEY_IMAGE_URL = "image_url";
	static final String KEY_TS = "ts";

	ListView mylist;
	MyCustomBaseAdapter adapter;

	// -----------------------------------------
	private ImageButton buttonPlayPause;
	private SeekBar seekBarProgress;
	public EditText editTextSongURL;

	private MediaPlayer mediaPlayer;
	private int mediaFileLengthInMilliseconds; // this value contains the song
												// duration in milliseconds.
												// Look at getDuration() method
												// in MediaPlayer class

	private final Handler handler = new Handler();
	// private static ArrayList<SearchResults> searchArrayList;
	private TextView t;
	private ImageView imageView1;
	private ImageView imageView2;
	private ImageView imageView3;
	private ImageView imageView4;
	private ImageView imageView5;
	private ImageView imageView6;
	private ImageView imageView7;
	private ImageView[] imageViewList = new ImageView[10];

	ListView list;
	MyCustomBaseAdapter myCustomBaseAdapter;
	private ImageButton playImageButton;
	private String[] array_songURL;
	private String[] array_Username;
	private String[] array_ImageURL;
	private String[] array_ts;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 
		//
//		GetUpdatesAsyncTask task = new GetUpdatesAsyncTask();
//		task.applicationContext = Main.this;
//		task.execute();
		
		MainAsyncTask task1 = new MainAsyncTask();
		task1.applicationContext = Main.this;
		task1.execute();
		 
		 
	}

	public class GetUpdatesAsyncTask extends AsyncTask<String, Void, String> {
		private ProgressDialog dialog;
		protected Context applicationContext;

		@Override
		protected void onPreExecute() {
			this.dialog = ProgressDialog.show(applicationContext, "Calling",
					"Please wait...", true);
		}

		@Override
		protected String doInBackground(String... params) {
			// return Login.getLoginResponse();
			// http://10.0.2.2:8080/Server/resources/profile/authenticate/%s/%s/deviceid
			String responseString;
			String url = String.format(getString(R.string.url_updates), "1");
			Log.d("songaa", url);
			// responseString = url;
			RestClient client = new RestClient(url);
			try {
				client.Execute(RequestMethod.GET);
			} catch (Exception e) {
				e.printStackTrace();
			}

			responseString = client.getResponse();
			System.out.println(responseString);
			return responseString;
		}

		@Override
		protected void onPostExecute(String result) {
			if (result == null)
				System.out.println("null found");
			else
				System.out.println(result);

			this.dialog.cancel();
			//
			// // TODO Auto-generated method stub
			// //String text = null;
			ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();
			//
			try {
				JSONObject json = new JSONObject();

				// text = XMLParser.getResponseGET(URL2);
				JSONObject jObj = new JSONObject(result);
				Log.d("songaa", result);
				JSONObject jTable = (JSONObject) jObj.get("table");
				System.out.println(jTable.toString());
				JSONArray jRows = jTable.getJSONArray("rows");

				for (int i = 0; i < jRows.length(); i++) {
					// creating new HashMap
					HashMap<String, String> map = new HashMap<String, String>();

					JSONObject jRow = (JSONObject) jRows.get(i);

					System.out.println(i + "--" + jRow.getString("song_url"));

					map.put(KEY_SONG_URL, jRow.getString("song_url"));
					map.put(KEY_USERNAME, jRow.getString("username"));
					map.put(KEY_DESCRIPTION, jRow.getString("description"));
					map.put(KEY_IMAGE_URL, jRow.getString("image_url"));
					map.put(KEY_TS, jRow.getString("ts"));

					System.out.println(i + "--" + jRow.getString("song_url"));

					// array_songURL[i] = song_url;
					// array_Username[i] = username;
					// array_Username[i] = image_url;
					// array_Username[i] = ts;

					// adding HashList to ArrayList
					songsList.add(map);

				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			list = (ListView) findViewById(R.id.list);

			// Getting adapter by passing xml data ArrayList
			adapter = new MyCustomBaseAdapter(Main.this, songsList);
			list.setAdapter(adapter);

			// Click event for single list row
			list.setOnItemClickListener(new OnItemClickListener() {

				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					Toast.makeText(getApplicationContext(),
							"Clicked" + position, Toast.LENGTH_LONG).show();

				}
			});
		}

	}

	 
	public class MainAsyncTask extends AsyncTask<String, Void, String> {
		private ProgressDialog dialog;
		protected Context applicationContext;
		private String[] array;
		private String[] song_urls;
		private String[] ts;

		@Override
		protected void onPreExecute() {
			this.dialog = ProgressDialog.show(applicationContext, "Calling",
					"Please wait...", true);
		}

		@Override
		protected String doInBackground(String... params) {
			// return Login.getLoginResponse();
			// http://10.0.2.2:8080/Server/resources/profile/authenticate/%s/%s/deviceid
			String responseString;
			String url = String.format(getString(R.string.url_fav), 1,
					"deviceid");
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

		@Override
		protected void onPostExecute(String result) {
			uploadImageData(result);
			// uploadSongDetails(result);

		}

		public void uploadImageData(String result) {
			// TODO Auto-generated method stub
			Log.d("Results :-", "result: " + result);
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

			JSONObject jObj = null;

			try {

				// Toast.makeText(getApplicationContext(), "Result" + result,
				// Toast.LENGTH_SHORT).show();
				result = result.replace(" ", "");
				jObj = new JSONObject(result);

				JSONObject jTable = (JSONObject) jObj.get("table");
				System.out.println(jTable.toString());
				JSONArray jRows = jTable.getJSONArray("rows");
				array = new String[jRows.length()];
				song_urls = new String[jRows.length()];
				ts = new String[jRows.length()];
				for (int i = 0; i < jRows.length(); i++) {

					JSONObject jRow = (JSONObject) jRows.get(i);

					System.out.println(i + "--" + jRow.getString("image_url"));

					String image_url = jRow.getString("image_url");
					String song_url = jRow.getString("song_url");
					String tsString = jRow.getString("ts");
					// Toast.makeText(getApplicationContext(),"image_url : "+image_url,Toast.LENGTH_SHORT).show();
					
					System.out.println(i + "--" + jRow.getString("image_url"));

					array[i] = image_url;
					song_urls[i] = song_url;
					ts[i] = tsString;
					// Toast.makeText(getApplicationContext(),"image_url : "+array[i],Toast.LENGTH_SHORT).show();

				}

				int loader = R.drawable.loader;
				ImageLoader imgLoader = new ImageLoader(getApplicationContext());
				for (int iImage = 0; iImage < array.length; iImage++) {
					String URL = array[iImage];
					
					imgLoader.DisplayImage(URL, loader, imageViewList[iImage]);
				}

				// Create an object for subclass of AsyncTask
				// GetXMLTask task = new GetXMLTask();
				// // Execute the task
				// task.execute(new String[] { URL, URL2, URL3, URL4, URL5,
				// URL6,URL7,URL8,URL9 });

//				ListView listView = (ListView) findViewById(R.id.list);
//				ArrayList<String> arrayAdapter = new ArrayList<String>();
//				if (song_urls.length != 0) {
//					for (int i1 = 0; i1 < song_urls.length; i1++) {
//						// array[i1] = array[i];
//						arrayAdapter.add(song_urls[i1]);
//						arrayAdapter.add(ts[i1]);
//						arrayAdapter.add(array[i1]);
//						ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//								Main.this,
//								android.R.layout.simple_spinner_item,
//								arrayAdapter);
//
//						adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//						listView.setAdapter(adapter);
//						listView.setOnItemClickListener(new OnItemClickListener() {
//
//							public void onItemClick(AdapterView<?> arg0,
//									View view, int position, long id) {
//								// TODO Auto-generated method stub
//
//								Toast.makeText(
//										getApplicationContext(),
//										"Clicked : "
//												+ ((TextView) view).getText(),
//										Toast.LENGTH_SHORT).show();
//
//							}
//
//						});
//					}
//				}

				// ListView listView = (ListView) findViewById(R.id.list);
				// ArrayList<String> arrayAdapter = new ArrayList<String>();
				// if (song_urls.length != 0) {
				// for (int i1 = 0; i1 < song_urls.length; i1++) {
				// //array[i1] = array[i];
				// arrayAdapter.add(song_urls[i1]);
				//
				// ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				// Main.this,
				// android.R.layout.simple_spinner_item,
				// arrayAdapter);
				//
				// adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				// listView.setAdapter(adapter);
				// listView.setOnItemClickListener(new OnItemClickListener() {
				//
				// public void onItemClick(AdapterView<?> arg0,
				// View view, int position, long id) {
				// // TODO Auto-generated method stub
				//
				// Toast.makeText(getApplicationContext(),"Clicked : "+
				// ((TextView) view)
				// .getText(),Toast.LENGTH_SHORT).show();
				//
				// }
				//
				// });
				// }
				// }

			} catch (Exception ex) {
				// errorTextView.setText(ex.getMessage());
			}

		}
	}
	private void initView() {
		t = (TextView) findViewById(R.id.textView1);
		imageViewList[0] = (ImageView) findViewById(R.id.image1);
		imageViewList[1] = (ImageView) findViewById(R.id.image2);
		imageViewList[2] = (ImageView) findViewById(R.id.image3);
		imageViewList[3] = (ImageView) findViewById(R.id.image4);
		imageViewList[4] = (ImageView) findViewById(R.id.image5);
		imageViewList[5] = (ImageView) findViewById(R.id.image6);
		imageViewList[6] = (ImageView) findViewById(R.id.image7);
		imageViewList[7] = (ImageView) findViewById(R.id.image8);
		imageViewList[8] = (ImageView) findViewById(R.id.image9);

		playImageButton = (ImageButton) findViewById(R.id.playImageButton);
		//
		 imageViewList[0].setOnClickListener(this);
		 imageViewList[1].setOnClickListener(this);
		 imageViewList[2].setOnClickListener(this);
		 imageViewList[3].setOnClickListener(this);
		 imageViewList[4].setOnClickListener(this);
		 imageViewList[5].setOnClickListener(this);
		 imageViewList[6].setOnClickListener(this);
		 imageViewList[7].setOnClickListener(this);
		 imageViewList[8].setOnClickListener(this);
	}

	private void registerEvents() {
		// TODO Auto-generated method stub
		// playImageButton.setOnClickListener(new OnClickListener() {
		//
		// public void onClick(View v) {
		// // TODO Auto-generated method stub
		// playButtonOnclick(v);
		// }
		// });
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}
