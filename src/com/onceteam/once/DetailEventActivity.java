package com.onceteam.once;

import com.onceteam.model.Event;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

public class DetailEventActivity extends Activity {

	Integer id;

	Context mContext;
	AutoScrollViewPager vp_image;
	Event mEvent;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
	    getActionBar().hide();
	    setContentView(R.layout.activity_detailevent);
	    Intent intent = getIntent();
	    id = intent.getIntExtra("id",0);
	    
	    mContext = this;
	    
	    
	}

}
