package com.onceteam.once;

import com.onceteam.json.ImageLoader;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailViewActivity extends Activity {

	// Declare Variables
	String id;
	String subtitle;
	String date;
	String poster;
	String position;
	ImageLoader imageLoader = new ImageLoader(this);
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	 // Get the view from singleitemview.xml
		setContentView(R.layout.item_singleview);
		
		ActionBar actionBar = getActionBar();
        actionBar.hide();

		Intent i = getIntent();
		// Get the result of id
		id = i.getStringExtra("id");
		// Get the result of subtitle
		subtitle = i.getStringExtra("subtitle");
		// Get the result of date
		date = i.getStringExtra("date");
		// Get the result of poster
		poster = i.getStringExtra("poster");
		
		
 		// Locate the TextViews in singleitemview.xml
		TextView txtid = (TextView) findViewById(R.id.id_sv);
		TextView txtsubtitle = (TextView) findViewById(R.id.subtitle_sv);
		TextView txtdate = (TextView) findViewById(R.id.date_sv);
		
		
 		// Locate the ImageView in singleitemview.xml
		ImageView imgposter = (ImageView) findViewById(R.id.poster_sv);
		
		
 		// Set results to the TextViews
		txtid.setText(id);
		txtsubtitle.setText(subtitle);
		txtdate.setText(date);
		
		
 		// Capture position and set results to the ImageView
		// Passes poster images URL into ImageLoader.class
		imageLoader.DisplayImage(poster, imgposter);

	}

}
