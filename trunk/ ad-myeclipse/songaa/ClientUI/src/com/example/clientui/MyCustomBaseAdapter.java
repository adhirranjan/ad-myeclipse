package com.example.clientui;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.clientui.R;
import com.example.clientui.R.id;
import com.example.clientui.R.layout;
import com.example.clientui.util.ImageLoader;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyCustomBaseAdapter extends BaseAdapter {

	 private Activity activity;
	    private ArrayList<HashMap<String, String>> data;
	    private static LayoutInflater inflater=null;
	    public ImageLoader imageLoader; 
	    
	    public MyCustomBaseAdapter(Activity a, ArrayList<HashMap<String, String>> d) {
	        activity = a;
	        data=d;
	        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	        imageLoader=new ImageLoader(activity.getApplicationContext());
	    }

	    public int getCount() {
	        return data.size();
	    }

	    public Object getItem(int position) {
	        return position;
	    }

	    public long getItemId(int position) {
	        return position;
	    }
	    
	    public View getView(int position, View convertView, ViewGroup parent) {
	        View vi=convertView;
	        if(convertView==null)
	            vi = inflater.inflate(R.layout.activity_listview, null);

	        TextView title = (TextView)vi.findViewById(R.id.titleTextView); // title
	        TextView time = (TextView)vi.findViewById(R.id.timeTextView); // artist name
	        TextView description = (TextView)vi.findViewById(R.id.descriptionTextView); // duration
	        
	        ImageView thumb_image=(ImageView)vi.findViewById(R.id.profileImageView); // thumb image
	        HashMap<String, String> song = new HashMap<String, String>();
	        song = data.get(position);
	        
	        // Setting all values in listview
	        imageLoader.DisplayImage(song.get(Main.KEY_IMAGE_URL),1 ,thumb_image);
	        title.setText(song.get(Main.KEY_USERNAME));
	        time.setText(song.get(Main.KEY_TS));
	        description.setText(song.get(Main.KEY_SONG_URL));
	        
	        return vi;
	    }
	 
	 }
