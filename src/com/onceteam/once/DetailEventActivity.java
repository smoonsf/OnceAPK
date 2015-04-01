package com.onceteam.once;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

import com.onceteam.api.EventService;
import com.onceteam.model.Event;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

public class DetailEventActivity extends Activity {

	Integer id;

	Context mContext;
	AutoScrollViewPager vp_image;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
	    getActionBar().hide();
	    setContentView(R.layout.activity_detailevent);
	    Intent intent = getIntent();
	    id = intent.getIntExtra("id",0);
	    
	    mContext = this;
	    
	    RestAdapter restAdapter = new RestAdapter.Builder()
        .setEndpoint("http://dev.hobbytic.com/api/open")
        //.setLogLevel(RestAdapter.LogLevel.FULL)
        //.setConverter(new GsonConverter(gson))
        .build();

	    EventService eventService = restAdapter.create(EventService.class);
	    eventService.getEvent(id, new Callback<Event>(){

			@Override
			public void failure(RetrofitError retrofitError) {
				Log.d("retro-error", retrofitError.getLocalizedMessage());
			}

			@Override
			public void success(Event event, Response arg1) {
				
			}
	    	
	    });
	    
	}

}
