package com.onceteam.json;

import java.util.ArrayList;
import java.util.HashMap;

import com.onceteam.once.DetailViewActivity;
import com.onceteam.once.MainActivity;
import com.onceteam.once.R;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class myPagerAdapter extends PagerAdapter {

	private LayoutInflater mInflater;
	
	Context context;
	ArrayList<HashMap<String, String>> data;
	ImageLoader imageLoader;
	HashMap<String, String> resultp = new HashMap<String, String>();
	
	public myPagerAdapter(Context c, ArrayList<HashMap<String, String>> pl){
		context = c;
		mInflater = LayoutInflater.from(context);
		data = pl;
		imageLoader = new ImageLoader(context);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public boolean isViewFromObject(View v, Object obj) {
		// TODO Auto-generated method stub
		return v == obj;
	}
	
	public int getItemPosition(Object object){
	     return POSITION_NONE;
	}
 
	
	public Object instantiateItem(View pager, final int position) {
		View v = null;
		int resId = R.layout.item_pvlist;
		v = mInflater.inflate(resId, null);
		
		TextView id = (TextView) v.findViewById(R.id.id);
		TextView subtitle = (TextView) v.findViewById(R.id.subtitle);
		TextView date = (TextView) v.findViewById(R.id.date);
		ImageView poster = (ImageView) v.findViewById(R.id.poster);
		
		resultp = data.get(position);
		
		id.setText(resultp.get(MainActivity.ID));
		subtitle.setText(resultp.get(MainActivity.SUBTITLE));
		date.setText(resultp.get(MainActivity.DATE));
		
		imageLoader.DisplayImage(resultp.get(MainActivity.POSTER), poster);
		
		v.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// Get the position
				resultp = data.get(position);
				Intent intent = new Intent(context, DetailViewActivity.class);
				// Pass all data id
				intent.putExtra("id", resultp.get(MainActivity.ID));
				// Pass all data subtitle
				intent.putExtra("subtitle", resultp.get(MainActivity.SUBTITLE));
				// Pass all data date
				intent.putExtra("date", resultp.get(MainActivity.DATE));
				// Pass all data poster
				intent.putExtra("poster", resultp.get(MainActivity.POSTER));
				// Start SingleItemView Class
				context.startActivity(intent);

			}
		});
		
		
		switch (position) {
		case 0:
			
		case 1:
		case 2:
		case 3:
		case 4:
		
		}
		
		((ViewPager) pager).addView(v, null);
		
		return v;
	}
	
	public void destroyItem(View pager, int position, Object view) {
		((ViewPager) pager).removeView((View) view);
	}
}
