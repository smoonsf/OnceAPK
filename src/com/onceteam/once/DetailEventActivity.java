package com.onceteam.once;

import java.util.GregorianCalendar;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

import com.nhn.android.maps.NMapActivity;
import com.nhn.android.maps.NMapController;
import com.nhn.android.maps.NMapOverlay;
import com.nhn.android.maps.NMapOverlayItem;
import com.nhn.android.maps.NMapView;
import com.nhn.android.maps.NMapView.OnMapStateChangeListener;
import com.nhn.android.maps.NMapView.OnMapViewTouchEventListener;
import com.nhn.android.maps.maplib.NGeoPoint;
import com.nhn.android.maps.nmapmodel.NMapError;
import com.nhn.android.maps.overlay.NMapPOIdata;
import com.nhn.android.mapviewer.overlay.NMapCalloutOverlay;
import com.nhn.android.mapviewer.overlay.NMapOverlayManager;
import com.nhn.android.mapviewer.overlay.NMapOverlayManager.OnCalloutOverlayListener;
import com.nhn.android.mapviewer.overlay.NMapPOIdataOverlay;
import com.nhn.android.mapviewer.overlay.NMapPOIdataOverlay.OnStateChangeListener;
import com.onceteam.adapter.DetailViewPagerAdapter;
import com.onceteam.api.EventService;
import com.onceteam.model.Event;
import com.onceteam.navermap.NMapCalloutBasicOverlay;
import com.onceteam.navermap.NMapPOIflagType;
import com.onceteam.navermap.NMapViewerResourceProvider;
import com.sinchontycoon.once.R;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;
import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

public class DetailEventActivity extends NMapActivity {
	
	private static final String NMAP_API_KEY = "c8ca351e48bf636fb60ab325a73737c3";

	Integer id;
	
	Event event;

	Context mContext;
	AutoScrollViewPager vp_image;
	DetailViewPagerAdapter vp_adapter;
	LinearLayout pagemark;
	ScrollView scrollview;
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
	
	private NMapView mMapView;
	private NMapController mMapController;
	private NMapViewerResourceProvider mMapViewerResourceProvider = null;
	private NMapOverlayManager mOverlayManager;
	private OnStateChangeListener onPOIdataStateChangeListener = null;
	
	private int mPrevPosition;
	
	@Override    
	 public boolean onKeyDown(int keyCode, KeyEvent event) {     
	     if(keyCode == KeyEvent.KEYCODE_BACK) { 
	                finish();
	     } 
	     return false;     
	 }
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
	    getActionBar().hide();
	    setContentView(R.layout.activity_detailevent);
	    Intent intent = getIntent();
	    id = intent.getIntExtra("id",0);
	    Log.d("eventid", id+" ");
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
	    mMapView = (NMapView)findViewById(R.id.mapView);
	    mMapView.setScalingFactor((float) 2.5);
		// use map controller to zoom in/out, pan and set map center, zoom level etc.
		mMapController = mMapView.getMapController();
		mMapController.setZoomLevelConstraint(8, 11);
		
		
		mMapViewerResourceProvider = new NMapViewerResourceProvider(this);
		mOverlayManager = new NMapOverlayManager(this, mMapView, mMapViewerResourceProvider);
		final NMapPOIdata poiData = new NMapPOIdata(1, mMapViewerResourceProvider);
		
		
		
		
		
		
		
	    scrollview = (ScrollView) findViewById(R.id.scrollview);
	    
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
			public void success(final Event event1, Response arg1) {
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
				
				mMapView.setOnMapStateChangeListener(new OnMapStateChangeListener(){

					@Override
					public void onAnimationStateChange(NMapView arg0, int arg1, int arg2) {}
					@Override
					public void onMapCenterChange(NMapView arg0, NGeoPoint arg1) {}
					@Override
					public void onMapCenterChangeFine(NMapView arg0) {}
					@Override
					public void onMapInitHandler(NMapView mapview, NMapError errorInfo) {
						if (errorInfo == null) { // success
							mMapController.setMapCenter(
									new NGeoPoint(event1.getLong(),event1.getLat()), 11);
						} else { // fail
							android.util.Log.e("NMAP", "onMapInitHandler: error=" 
											+ errorInfo.toString());
						}
					}
					@Override
					public void onZoomLevelChange(NMapView arg0, int arg1) {}
					
				});
				
				mMapView.setOnMapViewTouchEventListener(new OnMapViewTouchEventListener(){

					@Override
					public void onLongPress(NMapView arg0, MotionEvent arg1) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onLongPressCanceled(NMapView arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onScroll(NMapView arg0, MotionEvent arg1,
							MotionEvent arg2) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onSingleTapUp(NMapView arg0, MotionEvent arg1) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onTouchDown(NMapView arg0, MotionEvent arg1) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onTouchUp(NMapView arg0, MotionEvent arg1) {
						// TODO Auto-generated method stub
						
					}
					
				});
				

				int markerId = NMapPOIflagType.PIN;
				
				poiData.beginPOIdata(1);
				
				poiData.addPOIitem(event1.getLong(), event1.getLat(), event1.getLocation(), markerId, 0);

				poiData.endPOIdata();
				
				NMapPOIdataOverlay poiDataOverlay= mOverlayManager.createPOIdataOverlay(poiData, null);
				poiDataOverlay.showAllPOIdata(0);
				poiDataOverlay.setOnStateChangeListener(onPOIdataStateChangeListener); 
				mOverlayManager.setOnCalloutOverlayListener(new OnCalloutOverlayListener(){

					@Override
					public NMapCalloutOverlay onCreateCalloutOverlay(NMapOverlay arg0,
							NMapOverlayItem arg1, Rect arg2) {
						
						return new NMapCalloutBasicOverlay(arg0, arg1, arg2);
					}
					
				}); 
				
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
	    
	    btn_like.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Toast toast = Toast.makeText(mContext, "구현중인 기능 입니다",Toast.LENGTH_SHORT);
	            toast.show();
			}
	    	
	    });
	    btn_share.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Toast toast = Toast.makeText(mContext, "구현중인 기능 입니다",Toast.LENGTH_SHORT);
	            toast.show();
			}
	    	
	    });
	    btn_reply.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Toast toast = Toast.makeText(mContext, "구현중인 기능 입니다",Toast.LENGTH_SHORT);
	            toast.show();
			}
	    	
	    });
	    
	    
	    
	 // set a registered API key for Open MapViewer Library
		mMapView.setApiKey(NMAP_API_KEY);

		// initialize map view
		mMapView.setClickable(true);
		mMapView.setEnabled(true);
		mMapView.setFocusable(true);
		mMapView.setFocusableInTouchMode(true);

		// use built in zoom controls
		NMapView.LayoutParams lp = new NMapView.LayoutParams(LayoutParams.WRAP_CONTENT,
			LayoutParams.WRAP_CONTENT, NMapView.LayoutParams.BOTTOM_RIGHT);
		mMapView.setBuiltInZoomControls(true, lp);
		
		
		mMapView.setOnTouchListener(new OnTouchListener(){

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				scrollview.setEnabled(false);
				
				v.getParent().requestDisallowInterceptTouchEvent(true);

				return false;
			}
			
		});
	}
	
	@Override
	protected void onRestart(){
		super.onRestart();
		Intent intent = getIntent();
	    id = intent.getIntExtra("id",0);
	}
	
	@Override
	protected void onResume(){
		super.onResume();
		Intent intent = getIntent();
	    id = intent.getIntExtra("id",0);
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
