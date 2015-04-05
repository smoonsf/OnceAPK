package com.onceteam.once;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;
import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.onceteam.adapter.ListViewAdapter;
import com.onceteam.adapter.NoticeListAdapter;
import com.onceteam.adapter.myPagerAdapter;
import com.onceteam.api.EventService;
import com.onceteam.api.ListDeserializer;
import com.onceteam.api.NoticeService;
import com.onceteam.model.Event;
import com.onceteam.model.Notice;
import com.sinchontycoon.once.R;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.widget.DrawerLayout;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;


public class MainActivity extends Activity implements
		NavigationDrawerFragment.NavigationDrawerCallbacks {
	/**
	 * Fragment managing the behaviors, interactions and presentation of the
	 * navigation drawer.
	 */
	private NavigationDrawerFragment mNavigationDrawerFragment;

	/**
	 * Used to store the last screen title. For use in
	 * {@link #restoreActionBar()}.
	 */
	private CharSequence mTitle;

	Integer mCurrentPosition = null;
	
    
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
		getActionBar().setDisplayHomeAsUpEnabled(true);
	    getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayShowHomeEnabled(false);
		getActionBar().setDisplayShowCustomEnabled(true);
		// Splash이미지 띄
		startActivity(new Intent(this, SplashActivity.class));
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		
		
		mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager()
				.findFragmentById(R.id.navigation_drawer);
		mTitle = getTitle();

		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));
		
	}

	@Override
	public void onNavigationDrawerItemSelected(int position) {
		// update the main content by replacing fragments
		FragmentManager fragmentManager = getFragmentManager();
		if(mCurrentPosition == null || position != mCurrentPosition){
			switch (position) {
			case 0:
				
				fragmentManager
						.beginTransaction()
						.replace(R.id.container,
								PlaceholderFragment.newInstance(position + 1))
						.commit();
				mCurrentPosition = position;
				break;
			case 1:
				
				fragmentManager
						.beginTransaction()
						.replace(R.id.container,
								PlaceholderFragment.newInstance(position + 1))
						.commit();
				mCurrentPosition = position;
				break;
			case 2:
				fragmentManager
						.beginTransaction()
						.replace(R.id.container,
								PlaceholderFragment.newInstance(position + 1))
						.commit();
				mCurrentPosition = position;
				break;
			case 3:
				fragmentManager
						.beginTransaction()
						.replace(R.id.container,
								PlaceholderFragment.newInstance(position + 1))
						.commit();
				mCurrentPosition = position;
				break;
			case 4:
				fragmentManager
						.beginTransaction()
						.replace(R.id.container,
								PlaceholderFragment.newInstance(position + 1))
						.commit();
				mCurrentPosition = position;
				break;
			case 5:
				fragmentManager
						.beginTransaction()
						.replace(R.id.container,
								PlaceholderFragment.newInstance(position + 1))
						.commit();
				mCurrentPosition = position;
				break;
			case 6:
				fragmentManager
						.beginTransaction()
						.replace(R.id.container,
								PlaceholderFragment.newInstance(position + 1))
						.commit();
				mCurrentPosition = position;
				break;
			case 7:
				Context mContext;
	            mContext =  getApplicationContext();
//				Intent intent = new Intent(mContext, WebViewActivity.class);
//				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//				mContext.startActivity(intent);
	            Toast toast = Toast.makeText(mContext, "구현중인 기능 입니다",Toast.LENGTH_SHORT);
	            toast.show();
				mCurrentPosition = position;
				break;
			case 8:
				fragmentManager
						.beginTransaction()
						.replace(R.id.container,
								PlaceholderFragment.newInstance(position + 1))
						.commit();
				mCurrentPosition = position;
				break;
			}
		}

	}

	public void onSectionAttached(int number) {
		mTitle = "";
	}

	public void restoreActionBar() {
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setDisplayShowCustomEnabled(true);
		actionBar.setTitle(mTitle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			// Only show items in the action bar relevant to this screen
			// if the drawer is not showing. Otherwise, let the drawer
			// decide what to show in the action bar.
			getMenuInflater().inflate(R.menu.main, menu);
			restoreActionBar();
			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		
		if (item.getItemId() == R.id.action_search) {
            Context mContext;
            mContext =  getApplicationContext();
//			Intent intent = new Intent(mContext, SearchActivity.class);
//			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//			mContext.startActivity(intent);
            Toast toast = Toast.makeText(mContext, "구현중인 기능 입니다",Toast.LENGTH_SHORT);
            toast.show();
            return true;
        }

		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		private static final String ARG_SECTION_NUMBER = "section_number";
		private static int sectionN;
		List<Event> eventlist;
		

		/**
		 * Returns a new instance of this fragment for the given section number.
		 */
		public static PlaceholderFragment newInstance(int sectionNumber) {
			sectionN = sectionNumber;
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			int section = sectionN;
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
						
			
			switch (section) {
			case 1:
				rootView = inflater.inflate(R.layout.fragment_main, container,
						false);
				new getEventList(0, inflater.getContext(), rootView).execute();
				break;
			case 2:
				rootView = inflater.inflate(R.layout.fragment_cat1, container,
						false);
				new getEventList(1, inflater.getContext(), rootView).execute();
				break;
			case 3:
				rootView = inflater.inflate(R.layout.fragment_cat2, container,
						false);
				new getEventList(2, inflater.getContext(), rootView).execute();
				break;
			case 4:
				rootView = inflater.inflate(R.layout.fragment_cat3, container,
						false);
				new getEventList(3, inflater.getContext(), rootView).execute();
				break;
			case 5:
				rootView = inflater.inflate(R.layout.fragment_cat4, container,
						false);
				new getEventList(4, inflater.getContext(), rootView).execute();
				break;
			case 6:
				rootView = inflater.inflate(R.layout.fragment_cat5, container,
						false);
				new getEventList(5, inflater.getContext(), rootView).execute();
				break;
			case 7:
				rootView = inflater.inflate(R.layout.fragment_notice,
						container, false);
				new getNoticeList(inflater.getContext(), rootView).execute();
				break;
			case 9:
				rootView = inflater.inflate(R.layout.fragment_contactus, container,
						false);
				break;
			}

			return rootView;
		}

		@Override
		public void onAttach(Activity activity) {
			super.onAttach(activity);
			((MainActivity) activity).onSectionAttached(getArguments().getInt(
					ARG_SECTION_NUMBER));
		}
		
		
	}

	

}


class getEventList extends AsyncTask<Void, Void, Void> {
	
	Type type;
    Gson gson;
	EventService eventService;
	RestAdapter restAdapter;
	
	List<Event> events;
	List<Event> events_premium;
	Integer category;
	
	Boolean mLockListView;
	Boolean END_FLAG = false;
    
    ListViewAdapter lvadapter;
    myPagerAdapter pvadapter;
	ListView listview_main;
	AutoScrollViewPager viewpager_premium; 
	LinearLayout pageMark;
	int mPrevPosition;
	
	View rootView;
	Context context;

	public getEventList(Integer cat, Context ctx, View rv){
		rootView = rv;
		listview_main = (ListView) rootView.findViewById(R.id.listview_main);
		viewpager_premium = (AutoScrollViewPager) rootView.findViewById(R.id.pager_premium);
		pageMark = (LinearLayout) rootView.findViewById(R.id.pagemark);
		events = new ArrayList<Event>();
		events_premium = new ArrayList<Event>();
		context = ctx;
		category = cat;
	}
	
	@Override
	protected void onPreExecute(){
		super.onPreExecute();
		
		
		type = new TypeToken<List<Event>>(){}.getType();
        gson = new GsonBuilder()
                        .registerTypeAdapter(type, new ListDeserializer<Object>())
                        .create();

        restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://54.92.64.176/api/once")
                //.setLogLevel(RestAdapter.LogLevel.FULL)
                .setConverter(new GsonConverter(gson))
                .build();
        eventService = restAdapter.create(EventService.class);
		

	}

	@Override
	protected Void doInBackground(Void... params) {
		mLockListView = true;
		
		
		if(category == 0){
	        eventService.getEventList(events.size(), new Callback<List<Event>>(){
	
	            @Override
	            public void success(List<Event> event1, Response not_using_response) {
	            	events.addAll(event1);
	            	lvadapter.notifyDataSetChanged();
	            	if(event1.size() == 0)
	            		END_FLAG = true;
	            	mLockListView = false;
	            }
	
	            @Override
	            public void failure(RetrofitError retrofitError) {
	                Log.d("retro3",retrofitError.getLocalizedMessage());
	            }
	
				
	        });
		}
		else{
			eventService.getCatEventList(category, events.size(), "date", new Callback<List<Event>>(){
				
	            @Override
	            public void success(List<Event> event1, Response not_using_response) {
	            	events.addAll(event1);
	            	lvadapter.notifyDataSetChanged();
	            	if(event1.size() == 0)
	            		END_FLAG = true;
	            	mLockListView = false;
	            }
	
	            @Override
	            public void failure(RetrofitError retrofitError) {
	                Log.d("retro3",retrofitError.getLocalizedMessage());
	            }
	
				
	        });
		}
        
        eventService.getPremiumEventList(new Callback<List<Event>>(){

			@Override
			public void failure(RetrofitError retrofitError) {
				Log.d("retro3",retrofitError.getLocalizedMessage());
			}

			@Override
			public void success(List<Event> pvevent, Response arg1) {
				events_premium.addAll(pvevent);
				pvadapter.notifyDataSetChanged();
				initPageMark();
			}
        	
        });

		
		return null;
	}
	
	@Override
	protected void onPostExecute(Void args){
		lvadapter = new ListViewAdapter(events);
		listview_main.setAdapter(lvadapter);
		listview_main.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent(context, DetailEventActivity.class);
				intent.putExtra("id", events.get(position).getId());
				context.startActivity(intent);
			}
			
		});
		
		listview_main.setOnScrollListener(new OnScrollListener(){
			@Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                int count = totalItemCount - visibleItemCount;

                if(firstVisibleItem >= count && totalItemCount != 0 && !mLockListView
                        && !END_FLAG)
                {
                	mLockListView = true;
                	if(category == 0){
                		eventService.getEventList(events.size(), new Callback<List<Event>>(){

                            @Override
                            public void success(List<Event> event1, Response not_using_response) {
                            	events.addAll(event1);
                            	lvadapter.notifyDataSetChanged();
                            	if(event1.size() == 0)
                            		END_FLAG = true;
                            	mLockListView = false;
                            }

                            @Override
                            public void failure(RetrofitError retrofitError) {
                                Log.d("retro3",retrofitError.getLocalizedMessage());
                            }
                        });
                	}
                	else {
                		eventService.getCatEventList(category, events.size(), "date", new Callback<List<Event>>(){

                            @Override
                            public void success(List<Event> event1, Response not_using_response) {
                            	events.addAll(event1);
                            	lvadapter.notifyDataSetChanged();
                            	if(event1.size() == 0)
                            		END_FLAG = true;
                            	mLockListView = false;
                            }

                            @Override
                            public void failure(RetrofitError retrofitError) {
                                Log.d("retro3",retrofitError.getLocalizedMessage());
                            }
                        });
                	}
                }
            }
		});
		
		
		pvadapter = new myPagerAdapter(context, events_premium);
		viewpager_premium.setAdapter(pvadapter);
		
		viewpager_premium.setOnPageChangeListener(new OnPageChangeListener(){

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
				pageMark.getChildAt(mPrevPosition).setBackgroundResource(
						R.drawable.page_not);
				pageMark.getChildAt(position).setBackgroundResource(
						R.drawable.page_select);
				mPrevPosition = position;
			}
			
		});
		
		
		
			
		viewpager_premium.setInterval(10000);
		viewpager_premium.startAutoScroll();
		
		
		
	}
	
	void initPageMark() {
		for (int i = 0; i < events_premium.size(); i++) {
			ImageView iv = new ImageView(context);
			iv.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
					LayoutParams.WRAP_CONTENT));
			if (i == 0)
				iv.setBackgroundResource(R.drawable.page_select);
			else
				iv.setBackgroundResource(R.drawable.page_not);
			iv.setPadding(0, 0, 0, 0);
			
			pageMark.addView(iv);
		}
		pageMark.bringToFront();
		mPrevPosition = 0;
	}
}



class getNoticeList extends AsyncTask<Void, Void, Void> {
	
	Type type;
    Gson gson;
	NoticeService noticeService;
	RestAdapter restAdapter;
	
	List<Notice> notices;
	
	Boolean mLockListView;
	Boolean END_FLAG = false;
    
    NoticeListAdapter nladapter;
	ExpandableListView listview_notice;
	
	View rootView;
	Context context;

	public getNoticeList(Context ctx, View rv){
		rootView = rv;
		listview_notice = (ExpandableListView) rootView.findViewById(R.id.listview_notice);
		notices = new ArrayList<Notice>();
		context = ctx;
	}
	
	@Override
	protected void onPreExecute(){
		super.onPreExecute();
		type = new TypeToken<List<Notice>>(){}.getType();
        gson = new GsonBuilder()
                        .registerTypeAdapter(type, new ListDeserializer<Object>())
                        .create();

        restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://54.92.64.176/api/once")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setConverter(new GsonConverter(gson))
                .build();
        noticeService = restAdapter.create(NoticeService.class);
	}

	@Override
	protected Void doInBackground(Void... params) {
		mLockListView = true;
		
        noticeService.getNoticeList(notices.size(), new Callback<List<Notice>>(){

            @Override
            public void success(List<Notice> notice1, Response not_using_response) {
            	notices.addAll(notice1);
            	nladapter.notifyDataSetChanged();
            	if(notice1.size() == 0)
            		END_FLAG = true;
            	mLockListView = false;
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                Log.d("retro3",retrofitError.getLocalizedMessage());
            }

			
        });

		return null;
	}
	
	@Override
	protected void onPostExecute(Void args){
		nladapter = new NoticeListAdapter(notices);
		listview_notice.setAdapter(nladapter);
		listview_notice.setOnScrollListener(new OnScrollListener(){

			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				
			}

			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
				int count = totalItemCount - visibleItemCount;

                if(firstVisibleItem >= count && totalItemCount != 0 && !mLockListView
                        && !END_FLAG)
                {
                	mLockListView = true;
                	
                	noticeService.getNoticeList(notices.size(), new Callback<List<Notice>>(){

                        @Override
                        public void success(List<Notice> notice1, Response not_using_response) {
                        	notices.addAll(notice1);
                        	nladapter.notifyDataSetChanged();
                        	if(notice1.size() == 0)
                        		END_FLAG = true;
                        	mLockListView = false;
                        }

                        @Override
                        public void failure(RetrofitError retrofitError) {
                            Log.d("retro3",retrofitError.getLocalizedMessage());
                        }

            			
                    });
                }
			}
			
		});
		
		
	}
	
}
