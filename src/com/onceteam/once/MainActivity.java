package com.onceteam.once;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.onceteam.json.JSONfunctions;
import com.onceteam.json.ListViewAdapter;
import com.onceteam.json.myPagerAdapter;



import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.widget.ListView;

public class MainActivity extends Activity implements
		NavigationDrawerFragment.NavigationDrawerCallbacks {

	
	final public static String ID = "id";
	final public static String SUBTITLE = "subtitle";
	final public static String DATE = "date";
	final public static String POSTER = "poster";
	
	

	
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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
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
		switch (position) {
		case 0:
			
			fragmentManager
					.beginTransaction()
					.replace(R.id.container,
							PlaceholderFragment.newInstance(position + 1))
					.commit();
			break;
		case 2:
			fragmentManager
					.beginTransaction()
					.replace(R.id.container,
							PlaceholderFragment.newInstance(position + 1))
					.commit();
			break;
		case 3:
			fragmentManager
					.beginTransaction()
					.replace(R.id.container,
							PlaceholderFragment.newInstance(position + 1))
					.commit();
			break;
		case 4:
			fragmentManager
					.beginTransaction()
					.replace(R.id.container,
							PlaceholderFragment.newInstance(position + 1))
					.commit();
			break;
		case 5:
			fragmentManager
					.beginTransaction()
					.replace(R.id.container,
							PlaceholderFragment.newInstance(position + 1))
					.commit();
			break;
		case 6:
			Context mContext;
            mContext =  getApplicationContext();
			Intent intent = new Intent(mContext, WebViewActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			mContext.startActivity(intent);
			break;
		case 7:
			fragmentManager
					.beginTransaction()
					.replace(R.id.container,
							PlaceholderFragment.newInstance(position + 1))
					.commit();
			break;
		}

	}

	public void onSectionAttached(int number) {
		switch (number) {
		case 1:
			mTitle = getString(R.string.title_section1);
			break;
		case 2:
			mTitle = getString(R.string.title_section2);
			break;
		case 3:
			mTitle = getString(R.string.title_section3);
			break;
		}
	}

	public void restoreActionBar() {
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
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
		int id = item.getItemId();

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
				ListView lv = (ListView) rootView.findViewById(R.id.listview_main);
				ViewPager vp = (ViewPager) rootView.findViewById(R.id.pager_premium);
				
				new DownloadMain(inflater.getContext(), lv, vp).execute();
				
				break;
			case 6:
				rootView = inflater.inflate(R.layout.fragment_notice,
						container, false);
				break;
			case 8:
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

class DownloadMain extends AsyncTask<Void, Void, Void> {
	
	Context ctx;
	ArrayList<HashMap<String, String>> arraylist;
	ArrayList<HashMap<String, String>> pvalist;
	ProgressDialog mProgressDialog;
	JSONObject jsonobject;
	JSONArray jsonarray;
	ListView listview;
	ViewPager premiumview;
	
	public DownloadMain(Context context, ListView lv, ViewPager vp){
		pvalist = new ArrayList<HashMap<String, String>>();
		arraylist = new ArrayList<HashMap<String, String>>();
		ctx = context;
		listview = lv;
		premiumview = vp;
	}
		
	
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		// Create a progressdialog
		mProgressDialog = new ProgressDialog(ctx);
		// Set progressdialog title
		mProgressDialog.setTitle("행사정보를 수신 중입니다");
		// Set progressdialog message
		mProgressDialog.setMessage("Loading...");
		mProgressDialog.setIndeterminate(false);
		// Show progressdialog
		mProgressDialog.show();
	}

	@Override
	protected Void doInBackground(Void... params) {
		
		

		try {
			// Locate the array name in JSON
			
			jsonarray = new JSONArray(
					JSONfunctions
							.GET("http://once-server.herokuapp.com/api/events"));
			
			

			for (int i = 0; i < jsonarray.length(); i++) {
				HashMap<String, String> map = new HashMap<String, String>();
				jsonobject = jsonarray.getJSONObject(i);
				// Retrive JSON Objects
				map.put("id", jsonobject.getString("id"));
				map.put("poster",
						jsonobject.getString("poster"));
				map.put("subtitle",
						jsonobject.getString("subtitle"));
				map.put("date",
						jsonobject.getString("date"));
				
				// Set the JSON Objects into the array
				arraylist.add(map);
				
				if(jsonobject.getString("advanced")=="true"){
					pvalist.add(map);
				}
					
			}
		} catch (JSONException e) {
			Log.e("Error", e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected void onPostExecute(Void args) {
		ListViewAdapter LVa = new ListViewAdapter(ctx,arraylist);
		listview.setAdapter(LVa);
		myPagerAdapter mPa = new myPagerAdapter(ctx,pvalist);
		premiumview.setAdapter(mPa);
		
		mProgressDialog.dismiss();
	}
}