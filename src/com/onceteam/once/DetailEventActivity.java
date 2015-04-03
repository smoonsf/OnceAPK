package com.onceteam.once;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

import com.nhn.android.maps.NMapActivity;
import com.nhn.android.maps.NMapView;
import com.onceteam.adapter.DetailViewPagerAdapter;
import com.onceteam.api.EventService;
import com.onceteam.model.Event;
import com.sinchontycoon.once.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;
import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

public class DetailEventActivity extends Activity {
	
	private static final String NMAP_API_KEY = "c8ca351e48bf636fb60ab325a73737c3";

	Integer id;
	
	Event event;

	Context mContext;
	AutoScrollViewPager vp_image;
	DetailViewPagerAdapter vp_adapter;
	LinearLayout pagemark;
	TextView title;
	TextView subtitle;
	TextView date;
	TextView dday;
	TextView like;
	TextView content;
	Button btn_like;
	Button btn_share;
	Button btn_reply;
	Button btn_homepage;
	String homepage = null;
	
	private int mPrevPosition;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
	    getActionBar().hide();
	    setContentView(R.layout.activity_detailevent);
	    Intent intent = getIntent();
	    id = intent.getIntExtra("id",0);
	    mContext = this;
	    
	    
	    vp_image = (AutoScrollViewPager) findViewById(R.id.viewpager_image);
	    pagemark = (LinearLayout) findViewById(R.id.pagemark);
	    title = (TextView) findViewById(R.id.title);
	    date = (TextView) findViewById(R.id.date);
	    dday = (TextView) findViewById(R.id.dday);
	    like = (TextView) findViewById(R.id.like);
	    content = (TextView) findViewById(R.id.content);
	    btn_like = (Button) findViewById(R.id.btn_like);
	    btn_share = (Button) findViewById(R.id.btn_share);
	    btn_reply = (Button) findViewById(R.id.btn_reply);
	    btn_homepage = (Button) findViewById(R.id.btn_homepage);
	    
	    
	    RestAdapter restAdapter = new RestAdapter.Builder()
        .setEndpoint("http://54.92.64.176/api/once")
        //.setLogLevel(RestAdapter.LogLevel.FULL)
        //.setConverter(new GsonConverter(gson))
        .build();

	    EventService eventService = restAdapter.create(EventService.class);
	    eventService.getEvent(id, new Callback<Event>(){

			@Override
			public void failure(RetrofitError retrofitError) {
				finish();
				Log.d("retro-error", retrofitError.getLocalizedMessage());
			}

			@Override
			public void success(Event event1, Response arg1) {
				event = event1;
				vp_adapter = new DetailViewPagerAdapter(mContext,event);
				vp_image.setAdapter(vp_adapter);
				initPageMark();
				title.setText(event.getTitle());
				date.setText(event.getDate().substring(0, 10));
				if(Dday(event.getDate().substring(0, 10))>0){
					dday.setText("D - "+ Dday(event.getDate().substring(0, 10)));
				} else if(Dday(event.getDate().substring(0, 10))==0){
					dday.setText("D - day");
				} else{
					dday.setText("D + "+ -Dday(event.getDate().substring(0, 10)));
				}
				
				like.setText("♥");
				content.setText(event.getContent());
				homepage = event.getHomepage();
				
			}
	    	
	    });
	    
	    
	    
	    vp_image.setOnPageChangeListener(new OnPageChangeListener(){

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onPageSelected(int position) {
				pagemark.getChildAt(mPrevPosition).setBackgroundResource(
						R.drawable.page_not);
				pagemark.getChildAt(position).setBackgroundResource(
						R.drawable.page_select);
				mPrevPosition = position;
			}
	    	
	    });
	    btn_homepage.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				if(homepage != null){
					Intent i = new Intent(Intent.ACTION_VIEW);
					Uri u = Uri.parse(homepage);
					i.setData(u);
					startActivity(i);
				}
				
			}
	    	
	    });
	}
	
	void initPageMark() {
		for (int i = 0; i < event.getEventimage().size(); i++) {
			ImageView iv = new ImageView(mContext);
			iv.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
					LayoutParams.WRAP_CONTENT));
			if (i == 0)
				iv.setBackgroundResource(R.drawable.page_select);
			else
				iv.setBackgroundResource(R.drawable.page_not);
			iv.setPadding(0, 0, 0, 0);
			
			pagemark.addView(iv);
		}
		pagemark.bringToFront();
		mPrevPosition = 0;
	}
	
	long Dday(String mday) {
        if (mday == null )
            return 0;
        mday = mday.trim();
        int first = mday.indexOf("-");
        int last = mday.lastIndexOf("-");
        int year = Integer.parseInt(mday.substring(0 , first ));
        int month = Integer.parseInt(mday.substring(first + 1 , last ));
        int day = Integer.parseInt(mday.substring( last + 1 , mday.length()));

        GregorianCalendar cal = new GregorianCalendar();  
        long currentTime = cal.getTimeInMillis() / (1000*60*60*24);       
        cal.set(year,month - 1 , day);      
        long birthTime = cal.getTimeInMillis() / (1000*60*60*24); 
        int interval = (int)( birthTime - currentTime );     

        return interval;        
    }

}
